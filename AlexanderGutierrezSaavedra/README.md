
### Universidad Internacional Menéndez Pelayo
	Máster Universitario en Investigación en Inteligencia Artificial
    Web semántica y datos enlazados
    Alexander Gutiérrez Saavedra.
    Marzo 2017.

Licencia: [![CCBY](https://github.com/alexandergusa/Curso2017-2018/blob/master/AlexanderGutierrezSaavedra/4.%20Documentacion/imagenes/ccby.png)](https://creativecommons.org/licenses/by/3.0/)


# Introducción
Promover una fuente de datos enlazados, requiere conocer con más detalle el origen de los datos, desde su estructura hasta su dominio. Cuando tenemos la claridad suficiente de este detalle, es posible entender y diseñar la forma como se debe abordar un proyecto de datos enlazados, determinando si es necesario o no la construcción o reúso de ontologías que permitan exponer los datos a quien los requiera. Teniendo claridad en estos puntos se hace necesario explorar con profundidad la data que se desea enlazar, depurando las inconsistencias que no van de acuerdo con los requisitos definidos y mapeando las reglas allí contempladas, para finalmente generar nuestros datos enlazados. 
A continuación, se resume en dos capítulos el proceso a través del cual se construyeron los datos enlazados, para finalmente ser consumidos desde una aplicación Java. 

Este proyecto contiene la siguiente estructura:
1. FuenteDatos: este folder se encuentran los archivos originales con la información que se construyeron los datos enlazados.
2. OWL: en este folder están los archivos generados como datos enlazados en formato OWL, RDF y TTL.
3. PracticaDatosEnlazados: Este folder contiene un proyecto en JAVA con la clase ConsultaSparqSQL.java, la cual tiene el main y el llamado a los métodos que realizan las consultas sobre los datos enlazados en formado RDF.
4. Documentación: Este folder contiene las imágenes y archivos de extensión MD, para el manejo de la documentación del trabajo.

Para conocer el proceso realizado para la construccion de este trabajo, haga clic en el siguiente enlace. [Construcción de datos enlazados](https://github.com/alexandergusa/Curso2017-2018/blob/master/AlexanderGutierrezSaavedra/4.%20Documentacion/Capitulo1.md)