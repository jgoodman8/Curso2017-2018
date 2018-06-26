# Transformación y explotación de datos históricos de la FIFA Word Cup

#### Javier Guzmán Figueira Domínguez - javier.figueira@posgrado.uimp.es

#### Web semántica y datos enlazados

##### Versión 0.0.1 (25-06-2018)

![picture alt](assets/uimp_aepia.png "UIMP - AEPIA")

<img src="http://www.goopen.no/wp-content/uploads/2016/11/CC-BY_icon.svg_.png" alt="CC BY 4.0" width=150/>

## Tabla de contenidos

1. [Introducción](#intro)

2. [Proceso de transformación](#transform)

    2.1. [Selección de la fuente de datos](#select)

    2.2. [Análisis de los datos](#analysis)
    
    2.3. [Estrategia de nombrado](#strategy)
    
    2.4. [Desarrollo de vocabulario](#vocabulary)
    
    2.5. [Proceso de transformación](#transformation)
    
    2.6. [Enlazado](#link)
    
    2.7. [Publicación](#publish)

3. [Aplicación y explotación](#application)

4. [Conclusiones](#conclusions)

5. [Bibliografía](#references)
---

## <a name="intro"/>1. Introducción</a>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;El objetivo final de la Web de datos es permitir que las computadoras realicen un trabajo más útil y desarrollar sistemas que puedan admitir interacciones confiables a través de la red. El término "Web Semántica" se refiere a la visión del W3C de la Web de datos enlazados. Las tecnologías de la Web semántica permiten crear almacenes de datos en la Web, vocabularios y generar reglas para manejar los datos. De esta forma, no solo se construye una red de datos abierta y global, sino que se enriquecen las relaciones entre los datos de forma semántica.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;En este documento, se recoge como se ha realizado un proceso de transformación de un conjunto de datos en formato *CSV*, desde su selección hasta su publicación, pasando por desarrollo del vocabulario y el proceso de transformación. Así mismo, se presentará un propotipo funcional que haga uso de los datos transformados a datos enlazados. Con este prototipo se podrá advertir el pontencial de explotación de los datos transformados.

## <a name="transform"/>2. Proceso de transformación</a>

### <a name="select"/>2.1. Selección de la fuente de datos</a>

[comment]: # (Selección de la fuente de datos, donde se explique el conjunto de datos que se ha seleccionado para transformar, especificando su origen.)
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Para la selección del conjunto de datos, se ha realizado una búsqueda en la colección de *datasets* de la plataforma *on-line* [Kaggle](https://www.kaggle.com/). Ésta es una plataforma que tanto alberga competiciones de minería de datos, como contiene soluciones de minería datos, debates en forma de foros y *datasets* públicos. Entre uno de estos conjuntos de datos públicos, se ha seleccionado el denominado por la plataforma como [FIFA World Cup](https://www.kaggle.com/abecklas/fifa-world-cup).

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Para la selección del conjunto de datos, se ha realizado una búsqueda en la colección de *datasets* de la plataforma *on-line* [Kaggle](https://www.kaggle.com/). Ésta es una plataforma que tanto alberga competiciones de minería de datos, como contiene soluciones de minería datos, debates en forma de foros y *datasets* públicos. Entre uno de estos conjuntos de datos públicos, se ha seleccionado el denominado por la plataforma como [FIFA World Cup](https://www.kaggle.com/abecklas/fifa-world-cup).

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Este conjunto de datos contiene información sobre los resultados, de las fases finales, de las copas del mundo de futbol (entre 1930 y 2014). Estos datos se presentan a través de tres ficheros en formato CSV, conteniendo datos genéricos de cada edición, datos de los jugadores que compitieron en cada una de las mismas y datos de los resultados que se produjeron en cada uno de los partidos disputados.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Haciendo un análisis preliminar del conjunto de datos, se puede observar como éstos contienen referencias a jugadores, fechas y localizaciones (con referencias a ciudades, estadios y países). Por consiguiente, estas potenciales referencias convierten a este conjunto de datos en un candidato idoneo para su transformación a datos enlazados.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Como indica la plataforma, estos datos han sido cedidos por cortería de la página web del [Archivo de la Copa del Mundo de la FIFA](https://www.fifa.com/fifa-tournaments/archive/index.html).

### <a name="analysis"/>2.2. Análisis de los datos</a>

[comment]: # (Análisis de los datos, explicando que tipo de datos se manejan, su formato, tipos de valores, y en general cualquier aspecto relevante para su transformación y explotación. Este análisis debe incluir la licencia de origen de los datos y la justificación de la licencia a usar en los datos transformados.)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tal y como se ha indicado en la subsección anterior, el conjunto de datos continene tres ficheros en formato CSV. Por consiguiente, el objetivo de esta sección consitirá en analizar el tipo de datos manejados en cada uno de los ficheros y sus características. Así mismo, se analizará la licencia bajo la que se han distribuido estos datos y se in justificará la licencia elegida en los datos aquí transformados.

#### Ediciones


#### Jugadores

#### Partidos

#### Licencia

El conjunto de datos se ha distribuido bajo la licencia [CC0 1.0 Universal](https://creativecommons.org/publicdomain/zero/1.0/). Este tipo de licencia permite:

- Uso privado
- Modificación
- Distribución U
- Uso comercial, tanto del propio conjunto de datos, como de sus derivados.

Tal y como se puede observar, la distribución por medio de este tipo de licencia se asemeja mucho a la *no licencia* (*Unlicense*).

Tanto la presente memoria, como los datos enlazados generados y la aplicación aqui presentada se comparten utilizando la licencia [CC BY 4.0](https://creativecommons.org/licenses/by/4.0/). Esta licencia permite:

- La libre distribución de la obra mediante cualquier formato o medio.
- La modificación o transformación total o parcial del material
- La disctribución con propósitos comerciales. 

Por el contrario, se debe de reconcer adecuadamente la autoría, proporcionar una licencia e indicar los cambios realizados. Se ah optado por este tipo de licencia, dado que es la modalidad menos estricta que obliga al reconocimiento de autoría.

### <a name="strategy"/>2.3. Estrategia de nombrado</a>

[comment]: # (Estrategia de nombrado, donde se explique cómo se van a nombrar los recursos tanto del vocabulario a desarrollar como de los datos a generar.)

### <a name="vocabulary"/>2.4. Desarrollo de vocabulario</a>

[comment]: # (Desarrollo del vocabulario, indicando el proceso de implementación del vocabulario y como este soporta los datos de origen. No se exige una ontología compleja, sino un vocabulario suficiente para describir los conceptos y propiedades de los datos a transformar.)

### <a name="transformation"/>2.5. Proceso de transformación</a>

[comment]: # (Proceso de transformación, justificando qué herramientas se han usado para la transformación de los datos y qué pasos se han seguido para su limpieza y adecuación al resultado esperado.)

### <a name="#link"/>2.6. Enlazado</a>

[comment]: # (Enlazado, donde se explique qué enlaces se han generado con fuentes externas y mediante qué herramientas.)

### <a name="#publish"/>2.7. Publicación</a>

[comment]: # (Publicación. Opcionalmente, si se ha llevado a cabo la  publicación de los datos, se valorará que se explique cómo se ha llevado a cabo.)

## <a name="publish"/>3. Aplicación y explotación</a>

[comment]: # (Aplicación y explotación, explicando qué funcionalidades aporta la solución desarrollada y cómo ésta hace uso de los datos y enlaces generados para aportar valor al usuario final. En este punto de deben explicar las queries SPARQL o el código en Jena usado para su implementación.)

## <a name="conclusions"/>4. Conclusiones</a>

## <a name="references"/>5. Bibliografía</a>
