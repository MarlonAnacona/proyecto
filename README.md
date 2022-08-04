Proyecto final - Planificacion de vuelos

Marlon Andres Anacona (2023777)

Mayra Alejandra Sanchez (2040506)

Maria Paula Giraldo (2022411)


Uno de los problemas más frecuentes que encuentran los viajeros aéreos (por lo general delegan el encontrar su solución a una agencia de viajes) es el de organizar la ruta de viaje más adecuada para ir de un sitio a otro. Por adecuada se entiende que satisfaga los requerimientos del viajero:

Que en lo posible la ruta solo utilice un conjunto de aerolıneas de su gusto, que sea lo más corta posible, que solo utilice una aerolınea ası sea un poco más larga la ruta o un poco más demorado el viaje, que haga un número mınimo de escalas, que en el camino haga escalas en algunos sitios determinados, etc . . . .

El objetivo de este proyecto es construir unos programas de ayuda a la organización de la ruta de viaje más adecuada para un viajero aéreo.


Los archivos entregados en este proyecto se encuentran en la carpeta src/main/scala los cuales son los siguientes:


-Interfaz.scala
-PhotoCanvas.Scala
-package.scala
-vuelos.sc

Package.scala:

En este archivo se encuentra toda la funcionalidad del proyecto. En el cual se utilizo el lenguaje scala para programar de forma funcional y lograr el objetivo del proyecto. Así mismo, aqui se reservan los datos o bien mini base de datos de los aeropuertos y vuelos utilizados.

vuelos.sc:

Este archivo no tiene mucha incidencia en el proyecto pues ahi se encuentra algunos ejemplos a tomar y remplazar en package para ejecutar el programa


PhotoCanvas.scala:

En este archivo asocio la interfaz con la programación funcional, en el cual desde la interfaz mando a photocanvas y esta ultima llama la funcion de package que se necesita utilizar para que mande respuesta a la interfaz

Interfaz.scala:

Aqui solamente se hace la interfaz grafica y una serie de componentes para hacer mas facil la interacción del programa con el usuario.


COMO SE EJECUTA: 

1. Para ejecutar desde la interfaz se debe abrir dicho archivo. Y darle run al object scalaShop o bien a la funcion main.
2. Una vez dentro de la interfaz, al lado izquierdo se tendra un panel el cual arrojara los resultados de la busquedad, en la parte derecha se tendra el centro de control con unos botones, combobox y spinner. Así mismo en la parte inferior se verá visualizada la velocidad de ejecución
3. Para utilizar el programar se debe ingresar dos aeropuertos distintos de lo contrario dará error y se lanzará un mensaje el cual le solicita que ingrese dos aeropuertos distintos.
4. Una vez teniendo el origen y destino, se debe escoger la forma de ejecutar, ya sea paralela o secuencial y ademas de eso. La acción a realizar, ya sea busquedad por tiempo, distancia, etc. En el caso de tiempo salida, se debe ingresar con ayuda de los spinner, la hora y  minutos en la cual necesita llegar la persona al destino
5. Una vez ingresado estos datos se dará click en el boton buscar y al lado izquierdo de la interfaz se dará los resultados a su busquedad y en la parte inferior derecha el tiempo que tardo en ejecutar
