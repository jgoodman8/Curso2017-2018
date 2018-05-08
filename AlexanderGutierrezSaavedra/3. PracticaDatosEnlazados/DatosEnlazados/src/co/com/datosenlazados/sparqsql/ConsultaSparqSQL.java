package co.com.datosenlazados.sparqsql;

import java.io.InputStream;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileManager;

public class ConsultaSparqSQL {
	
	/*Creación de variables estáticas iniciales */
	public static String ns = "http://somewhere#";
	public static String foafNS = "http://xmlns.com/foaf/0.1/";
	
	public static void main(String[] args) {
		String archivoRDF = "Accidentalidad-en-medellin-2017.rdf";
		
		// 1. Crear un modelo vacío
		Model modelo = ModelFactory.createDefaultModel();
				
		// 2. Cargar el archivo sobre el que se va a consultar
		InputStream archivoEntrada = FileManager.get().open(archivoRDF);

		if (archivoEntrada == null)
			throw new IllegalArgumentException("El archivo: "+archivoRDF+" no fue encontrado");

		// 3. Leer el archivo RDF
		modelo.read(archivoEntrada, null);
		
		//*************CONSULTAS*************//
		
		// 1. Consulta para encontrar los 10 primeros recursos Tipo Ubicacion (para esto buscamos los recursos que tengan la propiedad acc:X
		String []queryString = new String[4];
		queryString[0] = //queryStringUbicacion
				"PREFIX acc: <http://antioquia.opendata.co/accidentes#> " +
				"SELECT ?recurso "+
				"WHERE { ?recurso acc:X ?NombreRecurso.}  limit 10";
		// 2. Consulta para encontrar los 10 primeros recursos Tipo Nomenclatura (para esto buscamos los recursos que tengan la propiedad acc:barrio
		queryString[1] = //queryStringNomenclatura = 
				"PREFIX acc: <http://antioquia.opendata.co/accidentes#> " +
				"SELECT ?recurso "+
				"WHERE { ?recurso acc:barrio ?NombreRecurso.}  limit 10";
		// 3. Consulta para encontrar los 10 primeros recursos Tipo Accidente (para esto buscamos los recursos que tengan la propiedad acc:clase
		queryString[2] = //queryStringAccidente = 
				"PREFIX acc: <http://antioquia.opendata.co/accidentes#> " +
				"SELECT ?recurso "+
				"WHERE { ?recurso acc:clase ?NombreRecurso.}  limit 10";
		// 4. Consulta para encontrar los 10 primeros recursos Tipo Momento (para esto buscamos los recursos que tengan la propiedad acc:fecha
		queryString[3] = //queryStringMomento = 
				"PREFIX acc: <http://antioquia.opendata.co/accidentes#> " +
				"SELECT ?recurso "+
				"WHERE { ?recurso acc:fecha ?NombreRecurso.}  limit 10";
		
	
		// Mostrar todos los recurso por cada tipo a partir de los queries generados arriba del 1 al 4
		Query query;
		QueryExecution qexec;
		ResultSet results;
		
		System.out.println("/////////////////////////////////////////////INICIO - RECURSOS POR TIPO///////////////////////////////////////////////////////////////");
		for(int i=0;i<4;i++) {
			query = QueryFactory.create(queryString[i]);
			qexec = QueryExecutionFactory.create(query, modelo) ;
			results = qexec.execSelect() ;
	
			while (results.hasNext())
			{
				QuerySolution binding = results.nextSolution();
				Resource recurso = (Resource) binding.get("recurso");
			    System.out.println("Recurso: "+recurso.getURI());
			}
		}
		System.out.println("//////////////////////////////////////////////FIN - RECURSOS POR TIPO////////////////////////////////////////////////////////////////");
		
		System.out.println("///////////////////////////////////////////INICIO - ACCIDENTES POR CLASE/////////////////////////////////////////////////////////////");

		// Mostrar Información de los accidentes con clase= Incendio concatenando las variables clase, gravedad y radicado
		String queryStringChoque = "PREFIX acc: <http://antioquia.opendata.co/accidentes#> " +
				"SELECT * WHERE { "+
				" ?recurso acc:clase ?c . "+
				" ?recurso acc:gravedad ?g. "+
				" ?recurso acc:radicado ?r. "+
				" BIND(concat(\"la clase fue: \",?c,\" con gravedad: \",?g,\" para el radicado: \",?r) AS ?Acc) "+
				" FILTER(?c=\"Incendio\") "+
			    "}";
		query = QueryFactory.create(queryStringChoque);
		qexec = QueryExecutionFactory.create(query, modelo) ;
		results = qexec.execSelect() ;
		
		
		while (results.hasNext())
		{
			QuerySolution binding = results.nextSolution();
			Literal accidente =binding.getLiteral("Acc");
			System.out.println(accidente);
		}
		System.out.println("////////////////////////////////////////////FIN - ACCIDENTES POR CLASE///////////////////////////////////////////////////////////////");
	}
}
