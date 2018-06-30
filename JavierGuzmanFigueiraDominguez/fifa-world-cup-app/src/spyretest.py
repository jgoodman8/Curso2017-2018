from spyre import server
from repository import RdfRepository
import pandas as pd
import numpy as np


class SimpleApp(server.App):

    def __init__(self):
        # implements a simple caching mechanism to avoid multiple calls to the yahoo finance api
        self.data_cache = None
        self.params_cache = None

    title = "FIFA World Cup"

    inputs = []

    controls = []

    tabs = ["Table1", 'Table2']

    outputs = [
        {
            "type": "table",
            "id": "table_id_1",
            "tab": "Table",
            "on_page_load": True
        },
        {
            "type": "table",
            "id": "table_id_2",
            "tab": "Table"
        }
    ]

    def getData(self, params):
        # params.pop("output_id", None)  # caching layer
        # if self.params_cache != params:  # caching layer
        #     ticker = params['ticker']
        #     if ticker == 'empty':
        #         ticker = params['custom_ticker'].upper()
        #
        #     xchng = "NASD"
        #
        #     param = {
        #         'q': ticker,  # Stock symbol (ex: "AAPL")
        #         'i': "86400",  # Interval size in seconds ("86400" = 1 day intervals)
        #         'x': xchng,  # Stock exchange symbol on which stock is traded (ex: "NASD")
        #         'p': "3M"  # Period (Ex: "1Y" = 1 year)
        #     }
        #     # get price data (return pandas dataframe)
        #     df = pd.DataFrame(np.random.randint(0, 100, size=(100, 4)), columns=list('qixp'))
        #     df = df.drop(['Volume'], axis=1)
        #
        #     self.data_cache = df  # caching layer
        #     self.params_cache = params  # caching layer
        print(params)
        return pd.DataFrame(np.random.randint(0, 100, size=(100, 4)), columns=list('qixp'))


# rdf = RdfRepository()
# rdf.load_graph()
# edition_info = rdf.get_edition_info()

app = SimpleApp()
app.launch()
