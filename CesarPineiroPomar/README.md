### Web semántica y datos enlazados
##### César Piñeiro Pomar
##### cesar.pineiro@posgrado.uimp.es
[![Creative Commons License](https://i.creativecommons.org/l/by/4.0/88x31.png "Creative Commons License")](http://creativecommons.org/licenses/by/4.0/ "Creative Commons License")
------------

### 1. Introducción

La Web Semántica surge como una versión extendida de la Web con la intención de representar una amplia gama de ideas y tecnologías que intentan dar sentido a la gran cantidad de información disponible a través de la Web. El objetivo es proporcionar la información de forma estructurada de forma que tanto las personas como las maquinas pueden hacer uso de ella. 

Las Bases de la Web semántica son las ontologías y las anotaciones. Las ontologías, representadas con lenguajes como RDF Schema y OWL, describen de formalmente los datos y las relaciones entre ellos. Las anotaciones, normalmente representadas en formato RDF, permiten describir las instancias de las ontologías y asociarlas a los recursos de la web.

En este trabajo se pondrán en práctica los conocimientos adquiridos en los distintos módulos de la asignatura comenzando con la obtención de los datos hasta la explotación de los mismos.

### 2. Proceso de transformación

- Selección de la fuente de datos, donde se explique el conjunto de datos que se ha seleccionado para transformar, especificando su origen. La búsqueda de datos ha sido realizada en el web datos.gob.es, una plataforma que organiza y gestiona el catalogo Nacional de Datos Abiertos.

	 La web almacena un amplio conjunto de Datasets en distintos formatos junto con su autor y una licencia. El objetivo de esta práctica es la transformación de un conjunto de datos a datos enlazados, por esa razón en la búsqueda se ha filtrado por conjuntos de datos que no presenten entre los formatos disponibles, una estructura con los datos enlazados.

	 El [Dataset](http://datos.gob.es/es/catalogo/a07002862-registro-de-alojamientos-hoteleros2 "dataset") seleccionado almacena información acerca de un conjunto de alojamientos hoteleros de Castilla y León y ha sido publicado por la Junta de Castilla y León. Los datos están disponibles para descargar directamente sin necesidad de ponerse en contacto con el autor únicamente en formato .csv y con una licencia asociada.

- Análisis de los datos, explicando que tipo de datos se manejan, su formato, tipos de valores, y en general cualquier aspecto relevante para su transformación y explotación. Este análisis debe incluir la licencia de origen de los datos y la justificación de la licencia a usar en los datos transformados.

	Los datos manejados pertenecen al sector de turismo de la Junta de Castilla y León. La página web únicamente describe los datos como la relación de alojamientos hoteleros de Castilla y León, los datos están en castellano, fue creado en 2012 y con actualizaciones diarias, aunque parece que no ha vuelto a ser actualizado.

	El dataset solo esta disponible en formato csv(del inglés comma-separated values), como su nombre indica es un formato para almacenar tablas donde las columnas están separadas con comas y las filas por cambios de línea. Existe una variación del formato csv que hace uso de punto y coma en lugar de coma, esta variación es debido a que en algunos casos, existen columnas formadas por números decimales hacen uso de comas para separar la parte entera de la parte fraccional y es necesario especificar un separador de columnas distinto. Este dataset contiene 22 columnas separadas por puntos y coma y esta almacenado usando la codificación ISO-8859-1.

Nombre  |  Tipo  |  Valores Vacíos  |  Valores Repetidos  |  Valor Ejemplo  |  Descripción
:------------:  |  :------------:  |  :------------:  |  :------------:  |  :------------:  |  :------------
N.Registro | String | No | No | 05/000003 | Identificador único de cada alojamiento
Tipo | String | No | Si | Hostal | Nombre del tipo de alejamiento
Categoría | String | Si | Si | 1ª - 1 Estrella | Numero de estrellas del alojamiento
Especialidades | - | - | - | - | Columna vacía sin información
Nombre | String | No | No | EL RASTRO | Nombre del Alojamiento
Dirección | String | No | No | PLAZA DEL RASTRO, 1 | Dirección física del lugar en el que se encuentra el alojamiento
C.Postal | Integer | No | Si | 24430 | Código postal de lugar en el que se encuentra el alojamiento.
Provincia | String | No | Si | León | División territorial con carácter administrativo dentro de un estado. En este caso solo denota provincias dentro de Castilla y león
Municipio | String | No | Si | Crémenes | Entidades administrativas regidas bajo un mismo gobierno, por lo que pueden incluirse varias localidades en un mismo municipio
Localidad | String | No | Si | VALDORE | Una división administrativa o territorial formada por un núcleo de población, ya sea una aldea, pueblo, ciudad...
Nucleo | String | Si | Si | VALDORE | Conjunto de edificaciones, constituido por un mínimo de 25 viviendas o 250 habitantes, con ayuntamiento situado dentro del mismo conjunto, y que posee todos los servicios de alumbrado, agua, alcantarillado y teléfono
Teléfono 1 | String | Si | Si | 920352059 | Teléfono principal
Teléfono 2 | String | Si | No | 920352059 | Teléfono adicional
Teléfono 3 | String | Si | No | 600972360 | Teléfono adicional
Email | String | Si | Si | hotel@sanzoilo.com | Correo electrónico
Web | String | Si | Si | www.sanzoilo.com | Página web
Q Calidad | String | Si | Si | Si | Contiene 'Si' en todos los alojamientos que tienen La marca "Q" de Calidad Turística que aporta prestigio, diferenciación, fiabilidad, rigurosidad y promoción
Central Reservas | - | - | - | - | Columna vacía sin información
Plazas | Integer | No | Si | 26 | Número de habitaciones disponibles
GPS.Longitud | Float | Si | No | -4,056811 | Longitud GPS de la ubicación física
GPS.Latitud | Float | Si | No | 40,909942 | Latitud GPS de la ubicación física
accesibles a minusválidos | String | Si | Si | Si | Contiene  'Si'  en todos los alojamientos que son accesibles por personas minusválidas
