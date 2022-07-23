

package object paquete {

  case class Aeropuerto(Cod: String, X: Int, Y: Int, GMT: Int)

  case class Vuelo(Aln: String, Num: Int, Org: String, HS: Int, MS: Int, Dst: String, HL: Int, ML: Int, Esc: Int)
  
  val aeropuertos = List(
    Aeropuerto("ABQ", 195, 275, -800),
    Aeropuerto("ATL", 470, 280, -600),
    Aeropuerto("BNA", 430, 240, -700),
    Aeropuerto("BOS", 590, 100, -600),
    Aeropuerto("DCA", 540, 180, -600),
    Aeropuerto("DEN", 215, 205, -800),
    Aeropuerto("DFW", 310, 305, -700),
    Aeropuerto("DTW", 445, 140, -600),
    Aeropuerto("HOU", 330, 355, -700),
    Aeropuerto("JFK", 565, 130, -600),
    Aeropuerto("LAX", 55, 270, -900),
    Aeropuerto("MIA", 535, 390, -600),
    Aeropuerto("MSP", 340, 115, -700),
    Aeropuerto("MSY", 405, 345, -700),
    Aeropuerto("ORD", 410, 155, -700),
    Aeropuerto("PHL", 550, 155, -600),
    Aeropuerto("PHX", 120, 290, -800),
    Aeropuerto("PVD", 595, 122, -600),
    Aeropuerto("RDU", 530, 230, -600),
    Aeropuerto("SEA", 55, 45, -900),
    Aeropuerto("SFO", 10, 190, -900),
    Aeropuerto("STL", 380, 210, -700),
    Aeropuerto("TPA", 500, 360, -600)
  )

  val vuelosA1= List(
    Vuelo("4X", 373, "HOU", 13, 15, "MSY", 15, 10, 1),
    Vuelo("4X", 201, "MSY", 8, 35, "HOU", 12, 20, 2),
    Vuelo("4X", 372, "MSY", 11, 0, "HOU", 12, 55, 1),
    Vuelo("4X", 213, "MSY", 14, 0, "HOU", 17, 40, 3),
    Vuelo("4X", 374, "MSY", 16, 0, "HOU", 17, 55, 1),
    Vuelo("4X", 216, "HOU", 14, 30, "MSY", 18, 10, 3),
    Vuelo("4X", 370, "MSY", 6, 15, "HOU", 11, 0, 1),
    Vuelo("4X", 375, "HOU", 18, 20, "MSY", 10, 15, 1),
    Vuelo("4X", 214, "HOU", 9, 0, "MSY", 12, 40, 3),
    Vuelo("4X", 371, "HOU", 8, 35, "MSY", 10, 30, 1),
    Vuelo("AA", 324, "STL", 8, 30, "ORD", 14, 5, 0),
    Vuelo("AA", 828, "MSY", 17, 10, "BNA", 18, 37, 0),
    Vuelo("AA", 212, "DFW", 17, 21, "ORD", 19, 41, 0),
    Vuelo("AA", 673, "ORD", 21, 30, "SEA", 12, 7, 0),
    Vuelo("AA", 25, "DFW", 18, 37, "PHX", 10, 1, 0)
  )

  /*
  funcion itinerarios(a1, a2) que, dados dos aeropuertos, uno de salida y otro de llegada, devuelva la lista de itinerarios posibles para viajar entre
  esos dos aeropuertos. Un itinerario es una lista de vuelos, donde el primero parte del aeropuerto de salida, los otros parten del aeropuerto de
  llegada del vuelo anterior, y el  ultimo vuelo llega al aeropuerto de llegada
   */
  def itenerarios(a1:String,a2:String): Unit ={
    for (c<-vuelosA1   if( c.Org==a1 && c.Dst==a2))
      yield (c)
    /**
    val flags = (a1 zip a2).map { case (a1, a2) => a1 < a2 }.zipWithIndex // zip devuelve una secuencia de parejas de elementos de xs con
elementos de ys en la misma posicion
    val t = flags.map { case (a2, index) => if (a2 == true) flags.length - index - 1 else 0 }.sum
    val f = flags.map { case (a2, index) => if (a2 == false) flags.length - index - 1 else 0 }.sum
    t >= f
     */
  }

  /*
  Funcion itinerariosT iempo(a1, a2) que dados dos aeropuertos, uno de salida y otro de llegada, encuentre al menos tres itinerarios (si los hay) que
  correspondan a los menores tiempos de viaje (contando tiempo de vuelo y tiempo de 2 espera en tierra). Tenga en cuenta que las horas de llegada
  y salida estan dadas con respecto a la hora local
   */
  //Busca los intenierarios de menor tiempo , al menos 2
  def itinerariosTiempo(a1: String, a2:String ): Unit ={
    /**
     *
     */
  }

  /*
  funcion itinerariosCambios(a1, a2) que dados dos aeropuertos, uno de salida y otro de llegada, encuentre al menos tres itinerarios (si los hay) que
  hagan el menor numero de cambios de avion, sin tener en cuenta el tiempo total de viaje (podrıa ser mas rapido cambiar varias veces de avion, que
  esperar la salida de un vuelo que lo lleve al destino sin cambiar de avion).
   */
  //El menor cambio de avion de los itenerarios
  def itinerariosCambios(a1:String,a2:String): Unit ={
    /**
     *
     */
  }

  /*
  funcion itinerariosDistancia(a1, a2) que dados dos aeropuertos, uno de salida y otro de llegada, encuentre al menos tres itinerarios (si los hay) que
  minimicen el tiempo de vuelo, sin tener en cuenta el tiempo total de viaje (podrıa ser mejor un menor tiempo de vuelo, aunque haya mayores
  tiempos de espera en tierra).
   */
  //Itenerarios con menor  el tiempo de vuelo
  def itenerarioDistancia(a1:String,a2:String): Unit ={
    /**
     *
     */
  }
  /*
   funcion itinerariosSalida(a1, a2, h, m) que dados un aeropuerto destino a2 y una hora de la cita h:m determine el itinerario tal que la hora de salida
   de a1 sea la hora mas tarde posible para salir del aeropuerto a1 y llegar a tiempo a la cita (suponga que la cita es en el mismo aeropuerto).
  */
  //Optimizacion en horario de salida
  def itenerariosSalida(a1:String,a2:String,h:String,m:String): Unit ={
    /**
     *
     */
  }
}
