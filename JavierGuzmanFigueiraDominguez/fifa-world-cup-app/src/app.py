from rdflib import Graph


def load_graph_from_file():
    print('Loading data...')

    g = Graph()
    g.parse('../../data/target/word_cup.ttl', format='turtle')

    print('Data loaded')

    return g


def print_result(result):
    for i in result:
        print(i)


try:
    graph = load_graph_from_file()

    prefix = """
        PREFIX geo: <http://www.w3.org/2003/01/geo/wgs84_pos#>
        PREFIX schema: <http://schema.org/>
        PREFIX fwc: <http://linkeddata.fifawordcup.org/ontology/WordCup#>
        PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
        PREFIX owl: <http://www.w3.org/2002/07/owl#>
        PREFIX gn: <http://www.geonames.org/ontology#>
        PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>
        PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
        PREFIX event: <http://purl.org/NET/c4dm/event.owl#>
        PREFIX sport: <http://www.bbc.co.uk/ontologies/sport/>
        PREFIX foaf: <http://xmlns.com/foaf/0.1/>
    """

    # Info by edition (winner, country, totalAttendance)
    query = """        
        SELECT ?year ?winner ?place ?totalAttendance
        WHERE { 
            ?year fwc:isWinner ?winner .
            ?year event:place ?place .
            ?year fwc:totalAttendance ?totalAttendance .
        }
        ORDER BY ASC(?year)
    """

    # Matches info by year (time, city, attendance)
    year = "2010"
    query = """
        SELECT ?match ?time ?city ?attendance
        WHERE { 
            ?year sport:hasMatch ?match .
            ?match event:time ?time .
            ?match event:place ?stadium .
            ?stadium foaf:based_near ?city .
            ?match fwc:totalAttendance ?attendance .
            FILTER (?year = <http://linkeddata.fifawordcup.org/resources/Year/""" + year + """>)
        } 
        ORDER BY ASC(?time)
    """

    # All competitors identifiers
    query = """
        SELECT DISTINCT ?team ?code
        WHERE {
            { 
                ?match sport:homeCompetitor ?team . 
                ?team gn:countryCode ?code .
            } 
                UNION
            { 
                ?match sport:awayCompetitor ?team . 
                ?team gn:countryCode ?code .
            }
        }
        ORDER BY ASC(?team)
    """

    # Total goals by team
    query = """
        SELECT ?code (SUM(?goals) AS ?sum)
        WHERE {
            {
                ?match sport:homeCompetitor ?team .
                ?team gn:countryCode ?code .
                ?match fwc:homeGoals ?goals .
            }
                UNION
            {
                ?match sport:awayCompetitor ?team .
                ?team gn:countryCode ?code .
                ?match fwc:awayGoals ?goals .
            }
        }
        GROUP BY ?team
        ORDER BY DESC(?sum)
    """

    # Matches by player
    query = """
        SELECT ?playerName (COUNT(?playerName) AS ?count)
        WHERE {
            ?player fwc:fullName ?playerName
        }
        GROUP BY ?playerName
        ORDER BY DESC(?count)
        LIMIT 50
    """

    res = graph.query(prefix + query)

    print_result(res)

except Exception as err:
    print(err)
