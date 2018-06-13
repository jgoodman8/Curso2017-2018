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

#### 2.1 Selección de la fuente de datos
La búsqueda de datos ha sido realizada en el web [datos.gob.es](http://datos.gob.es "datos.gob.es"), una plataforma que organiza y gestiona el catalogo Nacional de Datos Abiertos. La web almacena un amplio conjunto de fuentes de datos en distintos formatos junto con su autor y una licencia. El objetivo de esta práctica es la transformación de un conjunto de datos a datos enlazados, por esa razón en la búsqueda se ha filtrado por conjuntos de datos que no presenten entre los formatos disponibles, una estructura con los datos enlazados.

El [dataset](http://datos.gob.es/es/catalogo/a07002862-registro-de-alojamientos-hoteleros2 "dataset") seleccionado almacena información acerca de un conjunto de alojamientos hoteleros de Castilla y León y ha sido publicado por la Junta de Castilla y León. Los datos están disponibles para descargar directamente, sin necesidad de ponerse en contacto con el autor, únicamente en formato .csv y con una licencia asociada.

#### 2.2 Análisis de los datos
Los datos manejados pertenecen al sector de turismo de la Junta de Castilla y León. La página web únicamente describe los datos como la relación de alojamientos hoteleros de Castilla y León, los datos están en castellano, fue creado en 2012 y con actualizaciones diarias, aunque parece que no ha vuelto a ser actualizado.

 El dataset solo esta disponible en formato csv(del inglés comma-separated values), como su nombre indica es un formato para almacenar tablas donde las columnas están separadas con comas y las filas por cambios de línea. Existe una variación del formato csv que hace uso de punto y coma en lugar de coma, esta variación es debido a que en algunos casos, existen columnas formadas por números decimales hacen uso de comas para separar la parte entera de la parte fraccional y es necesario especificar un separador de columnas distinto. Este dataset contiene 22 columnas separadas por puntos y coma y esta almacenado usando la codificación ISO-8859-1.

 La licencia de la fuente de datos esta accesible mediante un link en la propia web de descarga. La licencia indica las condiciones que debemos aceptar hacer una obra derivada, explotar los datos y si la misma lo permite, obtener un beneficio económico de ello. La fuente de datos usa la licencia [![Creative Commons License](https://i.creativecommons.org/l/by/3.0/80x15.png "Creative Commons License")](http://creativecommons.org/licenses/by/3.0/ "Creative Commons License") la cual tiene los siguientes derechos y obligaciones.

- **Reconocimiento**: Se debe dar a conocer adecuadamente la autoría de la obra, proporcionar un enlace a la licencia e indicar si se han realizado cambios.

- **Compartir**: Se permite copiar y redistribuir el material en cualquier medio o formato.

- **Transformación**: Se permite remezclar, transformar y crear a partir del material.

- **Obras Derivadas**: Se permiten obras derivadas y con una licencia diferente.

- **Comercial**: Se permite la explotación de la obra incluso para fines comerciales de los que se obtenga beneficio económico.

A continuacion se realizara el analisis de la fuente de datos columna por columna.

Nombre  |  Tipo  |  Valores Vacíos  |  Valores Repetidos  |  Valor Ejemplo  |  Descripción
:------------:  |  :------------:  |  :------------:  |  :------------:  |  :------------:  |  :------------
N.Registro | String | No | No | 05/000003 | Identificador único de cada alojamiento
Tipo | String | No | Si | Hostal | Nombre del tipo de alojamiento
Categoría | String | Si | Si | 1ª - 1 Estrella | Numero de estrellas del alojamiento
Especialidades | - | - | - | - | Columna vacía sin información
Nombre | String | No | No | EL RASTRO | Nombre del alojamiento
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
Q Calidad | String | Si | Si | Si | Contiene 'Si' en todos los alojamientos que tienen la marca "Q" de Calidad Turística que aporta prestigio, diferenciación, fiabilidad, rigurosidad y promoción
Central Reservas | - | - | - | - | Columna vacía sin información
Plazas | Integer | No | Si | 26 | Número de habitaciones disponibles
GPS.Longitud | Float | Si | No | -4,056811 | Longitud GPS de la ubicación física
GPS.Latitud | Float | Si | No | 40,909942 | Latitud GPS de la ubicación física
accesibles a minusválidos | String | Si | Si | Si | Contiene  'Si'  en todos los alojamientos que son accesibles por personas minusválidas

#### 2.3 Estrategia de nombrado

A continuación se pasa a describir la estrategia de nombrado donde se explica cómo se van a nombrar los recursos tanto del vocabulario a desarrollar como de los datos a generar.

- **Dominio**: El dominio elegido como base para la aplicación es http://alojamientoshoteleros.es
- **Formato**: Para definir el acceso a los recursos de nuestra aplicación necesario elegir el formato de URI a utilizar. En este caso, contamos con un conjunto amplio de datos que podría ser actualizado en el futuro con nuevos elementos, por esa razón los elementos serán direccionados por la barra inclinada " /".
- **Ruta**: Los elementos se accederán desde http://alojamientoshoteleros.es/alojamiento
- **Patrón**: Los elementos deben seguir el patrón http://alojamientoshoteleros.es/alojamiento/&lt;identificador>

#### 2.4 Desarrollo del vocabulario

##### 2.4.1 Deficion de los requisitos
Los requisitos en una aplicación pueden separarse en funcionales y no funcionales. Los requisitos funcionales. Los requisitos funcionales definen una función que debe implementar o dar soporte el sistema, mientras que los requisitos no funcionales son criterios o restricciones que debe cumplir el sistema.
**Requistios funcionales:**
- RF1: ¿Qué tipos de Alojamientos hay?
- RF2: ¿Qué alojamientos hay en una provincia?, ¿Y en una localidad?
- RF3: Datos de contacto (Teléfono, email y web) de un Alojamiento
- RF4: Dirección de un Alojamiento
- RF5: Categoría de un alojamiento
- RF6: Alojamientos adaptados para minusválidos

**Requistios no funcionales:**
- RNF1: Las ontologías usadas deben estar estandarizadas
- RNF2: Los datos deben estar enlazados con la dbpedia

##### 2.4.2 Extracción de los términos
Analizando cada uno de los requisitos funcionales se han extraído una lista de los términos necesarios para modelar el sistema.
- T1: 

##### 2.4.3 Identificacion y selección de Ontologias

#### 2.5 Proceso de Transformación



