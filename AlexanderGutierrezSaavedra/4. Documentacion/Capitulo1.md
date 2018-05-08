**Trabajo de datos enlazados**


        Alexander Gutiérrez Saavedra.

        Mayo 2017.



# Capítulo 1.  Proceso de transformación

En este capítulo se detalla el proceso de transformación realizado para garantizar la correcta transformación de los datos; desde la selección, diseño; y publicación de los datos transformados. Siguiendo el aprendizaje del curso es necesario contar con los pasos del ciclo de vida de los datos enlazados: Especificación, Modelado, Generación, Enlazado, Publicación y Explotación. A continuación, se describe detalladamente cada uno de los pasos que aplica, ya que en este trabajo no llegaremos a la publicación

### Especificación

Para realizar el paso de especificación fue necesario partir esta tarea en dos: identificación y análisis de la fuente de datos y diseño de la URI.

Para la identificación de la información se determinó usar la fuente de datos expuesta por el Open data de la alcaldía de Medellín, la cual es una entidad que expone datos abiertos de manera asequible y gratuita sin restricción alguna. Estos datos cumplen las características de ser un escenario real, estar disponibles y accesibles sin restricción, son datos que pueden ser manipulados y procesados de manera automática y además el dominio de los datos, permite enlazarlos con otras entidades genéricas.

Los datos manejados bajo esta entidad contienen información de diferentes ámbitos enmarcados en la ciudad de Medellín Colombia tales como: hábitat y medio ambiente, infraestructura, ordenamiento territorial, movilidad, educación, cultura, educación, salud, seguridad, desarrollo económico y población.

Para este trabajo se tomaron los datos asociados a la movilidad vehicular con la subcategoría de accidentes de tránsito, registrados por la Secretaría de Movilidad de la Alcaldía de Medellín, desde enero 1 del año 2017 hasta el 31 de julio del mismo año.

Para entender la información de la data seleccionada, es necesario tener claridad en el concepto de accidente de tránsito como un evento, generalmente involuntario, causado mínimo por un vehículo en movimiento, el cual genera daños a personas y/o bienes, que afectan la circulación normal de los vehículos que se movilizan en la vía o vías cercanas a la generación del evento.

A nivel de licencia se identificó que no tiene un tipo de licencia de uso definida, pero si se declara en los términos de uso la usabilidad sin restricción1. También se identificó que el titular de los datos es Grupo SIG de la Alcaldía Medellín



Los datos fueron obtenidos en un archivo csv separado por comas, con la información de los eventos generados alrededor de un accidente (coordenadas de ubicación X, Y, fecha, hora, día, periodo, clase, dirección, tipo, gravedad, barrio, comuna y diseño).

El archivo contiene las siguientes características:

| **Nombre** | **Tamaño** | **Filas** | **Tema** |
| --- | --- | --- | --- |
| Accidentalidad\_2017 | 4.7 MB | 24.353 | Accidentes de tránsito registrados por la Secretaría de Movilidad de la Alcaldía de Medellín |

Analizando la fuente de datos se pudo detectar la información de la tabla 1:

Tabla 1. Estructura de la data de accidentalidad.

| Columna | Tipo | Comentario/rango | Problemas |
| --- | --- | --- | --- |
| OBJECTID | Long | Identificador único | Ninguno |
| X | Double | Coordenada x | Ninguno |
| Y | Double | Coordenada y | Ninguno |
| RADICADO | String (50) | 12 - 1577959 | Ninguno |
| FECHA | Date(8) | 2017/01/01-2017/07/31 | Ninguno |
| HORA | String(8) | Único | Ninguno |
| DIA | String(36) | Único | Ninguno |
| PERIODO | String(4) | Solo 2017 | Ninguno |
| CLASE | String(50) | Único | Ninguno |
| DIRECCION | String(100) | Único | Ninguno |
| DIRECCION\_ENC | String(500) | Único | Ninguno |
| TIPO\_GEOCOD | String(50) | Único | Ninguno |
| GRAVEDAD | String(50) | Único | Ninguno |
| BARRIO | String(50) | Único | Ninguno |
| COMUNA | String(50) | Único | Ninguno |
| DISENO | String(50) | Único | Ninguno |

Para la creación de la URI se constituyó a partir de:

1. Raíz de la URI: http://antioquia.opendata.co
2. Nombramiento de recursos: http://antioquia.opendata.co/&lt;nombre\_recurso&gt;/

### Modelado y Generación

Como definición de las ontologías a usar, se determinó crear una propia basada en la fuente de datos, dado que los datos que allí se maneja son muy propios de este problema y no se encontró un vocabulario adecuado para las necesidades requeridas. Para la creación de la propia ontología, se ejecutaron los siguientes pasos:

    a. Definir el dominio y el alcance

El dominio de la ontología está enmarcado con la información contenida en un accidente de tránsito, el cual se entiende como un evento, generalmente involuntario, causado mínimo por un vehículo en movimiento, el cual genera daños a personas y/o bienes, que afectan la circulación normal de los vehículos que se movilizan en la vía o vías cercanas a la generación del evento. Esta ontología nos ayudará a catalogar un accidente según el tipo, ubicación, gravedad del accidente y fecha de ocurrencia. La ontología nos ayudará a responder preguntas asociadas a los accidentes de tránsito exclusivamente, bajo la información delimitada explicada anteriormente. Esta ontología será usada sólo para temas de práctica, no tendrá un uso comercial ni de otro tipo.


    b. Términos importantes

Algunos de los términos importantes que se usarán en esta ontología son: accidente, ubicación, radicado, periodo, clase, dirección, gravedad, comuna, diseño, vehículo.

    c. Definición de clases y jerarquías

Se definieron algunas clases: Accidente, Ubicación, Dirección, Ocurrencia.

    d. Definición de propiedades

Para cada clase se definieron algunas propiedades. Para la clase Accidente se tiene: identificador, radicado, clase, gravedad

Para la clase Ubicación se tiene: coordenadaX, CoordenadaY

Para la clase Dirección se tiene: nomenclatura, barrio, comuna, diseño.

Para la clase Momento se tiene: hora, día, fecha, periodo.


    e. Implementacion

Se procede con la creación de la ontología, para lo cual se usó la herramienta Protégé sobre Windows. Allí se realizaron los siguientes pasos:

1. Creación de la URI, según lo definido en el estándar de esta ontología.
2. Se crearon las clases, como se ve en la figura 1.


![alt text][img1]

[img1]: https://github.com/alexandergusa/Curso2017-2018/blob/master/AlexanderGutierrezSaavedra/4.%20Documentacion/imagenes/image001.png "Figura 1. Clases de la ontología."
*Figura 1. Clases de la ontología.*

3.	Se definieron las propiedades a cada una de las clases. Ver figura 2.

![alt text][img2]

[img2]: https://github.com/alexandergusa/Curso2017-2018/blob/master/AlexanderGutierrezSaavedra/4.%20Documentacion/imagenes/image002.png "Figura 2. Propiedades de las clases de la ontología"
*Figura 2. Propiedades de las clases de la ontología.*

4.	Se asignaron las propiedades y tipo de dato a cada una de las clases. Ver figura 3.
 

![alt text][img3]

[img3]: https://github.com/alexandergusa/Curso2017-2018/blob/master/AlexanderGutierrezSaavedra/4.%20Documentacion/imagenes/image003.png "Figura 3. Propiedades de las clases de la ontología."
*Figura 3. Propiedades de las clases de la ontología.*

5.	Se crearon las relaciones y se asignaron las clases correspondientes a cada relación, ver figura 4.

![alt text][img4]

[img4]: https://github.com/alexandergusa/Curso2017-2018/blob/master/AlexanderGutierrezSaavedra/4.%20Documentacion/imagenes/image004.png "Figura 4. Relaciones y clases asociadas."
*Figura 4. Relaciones y clases asociadas.*

6.	Se crearon instancias de clases con data de ejemplo y tipos de datos, para ver la forma de las relaciones, ver figura 5 y 6.

![alt text][img5]

[img5]: https://github.com/alexandergusa/Curso2017-2018/blob/master/AlexanderGutierrezSaavedra/4.%20Documentacion/imagenes/image005.png "Figura 5. Ejemplos de clases dentro de la ontología."
*Figura 5. Ejemplos de clases dentro de la ontología.*


![alt text][img6]

[img6]: https://github.com/alexandergusa/Curso2017-2018/blob/master/AlexanderGutierrezSaavedra/4.%20Documentacion/imagenes/image006.png "Figura 6 Grafo de relaciones entre las clases de la ontología." 
*Figura 6. Grafo de relaciones entre las clases de la ontología.*



## Enlazado de datos
Para esta labor se utilizó el aplicativo LodRefine de la siguiente manera:
1.	Se crea un proyecto nuevo en la herramienta, con los datos del open data de la alcaldía de Medellín en formato csv. Ver figura 7 y 8.

![alt text][img7]

[img7]: https://github.com/alexandergusa/Curso2017-2018/blob/master/AlexanderGutierrezSaavedra/4.%20Documentacion/imagenes/image007.png "Figura 7. Creación del proyecto en LodRefine."
*Figura 7. Creación del proyecto en LodRefine.*


![alt text][img8]

[img8]: https://github.com/alexandergusa/Curso2017-2018/blob/master/AlexanderGutierrezSaavedra/4.%20Documentacion/imagenes/image008.png "Figura 8. Proyecto creado en LodRefine." 
*Figura 8. Proyecto creado en LodRefine.*


2.	Se definen las propiedades de importación de los datos (24.352 registros) y se procede a finalizar la creación del proyecto. Figura 9.

![alt text][img9]

[img9]: https://github.com/alexandergusa/Curso2017-2018/blob/master/AlexanderGutierrezSaavedra/4.%20Documentacion/imagenes/image009.png "Figura 9. Archivo csv importado correctamente en LodRefine." 
*Figura 9. Archivo csv importado correctamente en LodRefine.*

3.	Se procede con la transformación de los datos para que concuerden los tipos de datos con los ya identificados anteriormente. En la figura 10 se pueden ver las columnas trasformadas en color verde.

![alt text][img10]

[img10]: https://github.com/alexandergusa/Curso2017-2018/blob/master/AlexanderGutierrezSaavedra/4.%20Documentacion/imagenes/image010.png "Figura 10. Transformación de columnas en LodRefine." 
*Figura 10. Transformación de columnas en LodRefine.*


4.	Realizamos algunos cambios en la data para corregir valores con la ayuda de los Facet, que fueron cargados con error debido al uso de tildes y ñ. En la figura 11 se puede observar este cambio.

![alt text][img11]

[img11]: https://github.com/alexandergusa/Curso2017-2018/blob/master/AlexanderGutierrezSaavedra/4.%20Documentacion/imagenes/image0011.png "Figura 11. Corrección de data en LodRefine." 
*Figura 11. Corrección de data en LodRefine.*

5.	Se crearon las columnas CARRERA y CALLE a partir de la columna DIRECCIÓN para dar mayor claridad. Ver figura 12.

![alt text][img12]

[img12]: https://github.com/alexandergusa/Curso2017-2018/blob/master/AlexanderGutierrezSaavedra/4.%20Documentacion/imagenes/image012.png "Figura 12. Adición de columnas nuevas en LodRefine." 
*Figura 12. Adición de columnas nuevas en LodRefine.*

6.	Se eliminan las columnas DIRECCIÓN, DIRECCION_ENC, ya que estas fueron reemplazadas por CARRERA y CALLE. Ver figura 13.

![alt text][img13]

[img13]: https://github.com/alexandergusa/Curso2017-2018/blob/master/AlexanderGutierrezSaavedra/4.%20Documentacion/imagenes/image013.png "Figura 13. Eliminación de columnas en LodRefine."
*Figura 13. Eliminación de columnas en LodRefine.*

Una vez tenemos la data depura, procedemos a la definición del mapping entre el esquema de datos definido y la ontología creada en la primera parte. Para ello procedemos de la siguiente forma:

1.	Una vez se transformaron y corrigieron los datos, se procede a la definición del mapping. Para ello se carga la ontología creada en LodRefine como se ilustra en la figura 14.


![alt text][img14]

[img14]: https://github.com/alexandergusa/Curso2017-2018/blob/master/AlexanderGutierrezSaavedra/4.%20Documentacion/imagenes/image014.png "Figura 14. Carga de ontologías en LodRefine."
*Figura 14. Carga de ontologías en LodRefine.*




2.	Se define la URI base para los individuos como se ilustra en la figura 15.

![alt text][img15]

[img15]: https://github.com/alexandergusa/Curso2017-2018/blob/master/AlexanderGutierrezSaavedra/4.%20Documentacion/imagenes/image015.png "Figura 15. Modificación de la URI en LodRefine."
*Figura 15. Modificación de la URI en LodRefine.*


3.	Se crean las propiedades para cada tipo RDF añadido. Ver figura 16.


![alt text][img16]

[img16: https://github.com/alexandergusa/Curso2017-2018/blob/master/AlexanderGutierrezSaavedra/4.%20Documentacion/imagenes/image016.png "Figura 16. Adición de propiedades en LodRefine."
*Figura 16. Adición de propiedades en LodRefine.*




	
4.	Finalmente se exportan los datos en formato turtle. Ver figura 17.
	

![alt text][img17]

[img17]: https://github.com/alexandergusa/Curso2017-2018/blob/master/AlexanderGutierrezSaavedra/4.%20Documentacion/imagenes/image017.png "Figura 17. Export de data en formato turtle."
![alt text][img17]

[img17]: https://github.com/alexandergusa/Curso2017-2018/blob/master/AlexanderGutierrezSaavedra/4.%20Documentacion/imagenes/image018.png "Figura 17. Export de data en formato turtle."
*Figura 17. Export de data en formato turtle.*

[Capítulo 2](https://github.com/alexandergusa/Curso2017-2018/blob/master/AlexanderGutierrezSaavedra/4.%20Documentacion/Capitulo2.md)