import scala.collection.parallel.CollectionConverters._

package object paquete {

  class vuelosItinerarios {

    abstract class aero

    case class Aeropuerto(Cod: String, X: Int, Y: Int, GMT: Int) extends aero

    case class Vuelo(Aln: String, Num: Int, Org: String, HS: Int, MS: Int, Dst: String, HL: Int, ML: Int, Esc: Int) extends aero

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

    //________________________________________________________

    //longitud 15 vuelos

    val vuelosA1 = List(
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
      Vuelo("AA", 25, "DFW", 18, 37, "PHX", 10, 1, 0),
      Vuelo("AA", 35, "RDU", 14, 10, "MIA", 16, 21, 0),
      Vuelo("AA", 179, "ORD", 18, 30, "PHX", 11, 12, 0),
      Vuelo("AA", 580, "SFO", 12, 25, "ORD", 11, 5, 1),
      Vuelo("AA", 70, "SFO", 8, 8, "DFW", 13, 31, 0),
      Vuelo("AA", 835, "DTW", 17, 0, "ORD", 17, 13, 0),
      Vuelo("AA", 890, "PHX", 1, 40, "ORD", 15, 5, 0),
      Vuelo("AA", 784, "DFW", 10, 54, "ORD", 12, 56, 0),
      Vuelo("AA", 796, "DEN", 15, 7, "BNA", 18, 47, 0),
      Vuelo("AA", 89, "ORD", 18, 30, "LAX", 10, 35, 0),
      Vuelo("AA", 920, "MIA", 8, 44, "DCA", 11, 6, 0),
      Vuelo("AA", 728, "DFW", 6, 35, "BOS", 10, 58, 0),
      Vuelo("AA", 837, "ATL", 7, 25, "DFW", 13, 5, 0),
      Vuelo("AA", 203, "DFW", 8, 10, "SFO", 14, 7, 0),
      Vuelo("AA", 334, "RDU", 9, 0, "PVD", 10, 40, 0),
      Vuelo("AA", 709, "ATL", 8, 28, "MIA", 10, 15, 0)
    )


    type itn = List[Vuelo]

    /*
         funcion itinerarios(a1, a2) que, dados dos aeropuertos, uno de salida y otro de llegada, devuelva la lista de itinerarios posibles para viajar entre
         esos dos aeropuertos. Un itinerario es una lista de vuelos, donde el primero parte del aeropuerto de salida, los otros parten del aeropuerto de
         llegada del vuelo anterior, y el  ultimo vuelo llega al aeropuerto de llegada
      */
    def itinerario(a1: String, a2: String): List[itn] = {

      def filtroDirect(a: String, x: List[Vuelo]): List[Vuelo] = {
        for (c <- x if (c.Org == a)) yield c
      }

      def filtroEScalas(x: List[Vuelo], a3: String): List[Vuelo] = {
        for (c <- x if !(c.Org == a3 || c.Dst == a3)) yield c
      }

      def filtroFInal(x: List[itn]): List[itn] = {
        for (c <- x if (c.last.Dst == a2)) yield c
      }

      def itinerarioAuxiliar(xs: List[Vuelo], a2: String): List[itn] = {
        if (xs.isEmpty) {
          List(xs)
        } else {
          val vueloOrigen = (filtroDirect(a2, xs))
          val vueloEscala = for {
            i <- vueloOrigen
            m <- itinerarioAuxiliar(filtroEScalas(xs, a2), i.Dst)

          } yield i :: m
          vueloOrigen.map(r => List(r)) ++ vueloEscala
        }
      }

      filtroFInal(itinerarioAuxiliar(vuelosA1, a1));

    }

    /*
        Funcion itinerariosTiempo(a1, a2) que dados dos aeropuertos, uno de salida y otro de llegada, encuentre al menos tres itinerarios (si los hay) que
          correspondan a los menores tiempos de viaje (contando tiempo de vuelo y tiempo de 2 espera en tierra). Tenga en cuenta que las horas de llegada
          y salida estan dadas con respecto a la hora local
         */
    def itinerariosTiempo(a1: String, a2: String): List[itn] = {

      def tiempoAux(xs: itn): Int = {

        val diferenciaHorasSalida = for {
          i <- xs
        } yield (horaSalidaAuxiliar(i), horaLlegadaAuxiliar(i))

        if (diferenciaHorasSalida.length > 1) {
          horaDiferenciaEscalas(dia(diferenciaHorasSalida), diferenciaHorasSalida)
        } else {

          horadifenciaUnDia(diferenciaHorasSalida)

        }
      }

      def horaDiferenciaEscalas(dia: Int, horas: List[(Int, Int)]): Int = {
        horas.last._2 + ((24 * dia) - horas.head._1)
      }

      def horadifenciaUnDia(horas: List[(Int, Int)]): Int = {

        if (horas.head._2 < horas.head._1) {
          horas.head._2 + ((24) - horas.head._1)
        } else {
          val horafinal = horas.head._2 - horas.head._1
          horafinal
        }

      }

      def dia(xy: List[(Int, Int)]): Int = {

        if (xy.isEmpty) {
          0
        } else {
          if (xy.length == 1) {
            if (xy.head._1 > xy.head._2) {
              1 + dia(xy.tail)
            } else {
              0 + dia(xy.tail)
            }
          } else {
            if (xy.head._1 > xy.head._2) {
              1 + dia(xy.tail)
            } else {
              if (xy.head._2 > xy.tail.head._1) {
                1 + dia(xy.tail)
              } else {
                0 + dia(xy.tail)
              }
            }
          }
        }
      }

      itinerario(a1, a2).sortBy(r => tiempoAux(r)).take(3)

    }

    def horaSalidaAuxiliar(ls: (Vuelo)): Int = {

      val num = for (a <- aeropuertos if (ls.Org == a.Cod)) yield (a.GMT/100) + ls.HS
      var num2 = num.apply(0);

      if (num2 > 24) {
        num2 = num2 - 24;
        num2
      } else {
        if (num2 < 0) {
          num2 = num2 + 24;
          num2
        } else {
          num2
        }
      }
    }

    def horaLlegadaAuxiliar(ls: (Vuelo)): Int = {

      val num = for (a <- aeropuertos if (ls.Dst == a.Cod)) yield (a.GMT/100) + ls.HL
      var num2 = num.apply(0);

      if (num2 > 24) {
        num2 = num2 - 24;
        num2
      } else {
        if (num2 < 0) {
          num2 = num2 + 24;
          num2
        } else {
          num2
        }
      }
    }

    /*
      funcion itinerariosCambios(a1, a2) que dados dos aeropuertos, uno de salida y otro de llegada, encuentre al menos tres itinerarios (si los hay) que
      hagan el menor numero de cambios de avion, sin tener en cuenta el tiempo total de viaje (podrıa ser mas rapido cambiar varias veces de avion, que
      esperar la salida de un vuelo que lo lleve al destino sin cambiar de avion).
      */
    def itinerariosCambios(a1: String, a2: String): List[itn] = {

      def numeroEscalas(xs: itn): Int = {

        val numeroEscalasVuelo = for {
          i <- xs
        } yield i.Esc

        numeroEscalasVuelo.sum + (xs.length - 1)

      }

      itinerario(a1, a2).sortBy(r => (numeroEscalas(r))).take(3);
    }

    /*
     funcion itinerariosDistancia(a1, a2) que dados dos aeropuertos, uno de salida y otro de llegada, encuentre al menos tres itinerarios (si los hay) que
     minimicen el tiempo de vuelo, sin tener en cuenta el tiempo total de viaje (podrıa ser mejor un menor tiempo de vuelo, aunque haya mayores
     tiempos de espera en tierra).
     */
    def itinerarioDistancia(a1: String, a2: String): List[itn] = {

      def tiempoAux(xs: itn): Int = {

        val diferenciaHorasSalida = for {
          i <- xs
        } yield (horaSalidaAuxiliar(i), horaLlegadaAuxiliar(i))

        horadifenciaUnDia(diferenciaHorasSalida)

      }

      def horadifenciaUnDia(horas: List[(Int, Int)]): Int = {
        if (horas.isEmpty) {
          0
        } else {
          if (horas.head._2 < horas.head._1) {
            horas.head._2 + ((24) - horas.head._1) + horadifenciaUnDia(horas.tail)
          } else {
            horas.head._2 - horas.head._1 + horadifenciaUnDia(horas.tail)
          }
        }
      }

      itinerario(a1, a2).sortBy(r => tiempoAux(r)).take(3)

    }
    def horaLlegadaAuxiliarNecesaria(ls: (Vuelo), h: Int): Int = {

      val num = for (a <- aeropuertos if (ls.Dst == a.Cod)) yield (a.GMT/100) + h
      var num2 = num.apply(0);

      if (num2 > 24) {
        num2 = num2 - 24;
        num2
      } else {
        if (num2 < 0) {
          num2 = num2 + 24;
          num2
        } else {
          num2
        }
      }
    }


    /*
       funcion itinerariosSalida(a1, a2, h, m) que dados un aeropuerto destino a2 y una hora de la cita h:m determine el itinerario tal que la hora de salida
       de a1 sea la hora mas tarde posible para salir del aeropuerto a1 y llegar a tiempo a la cita (suponga que la cita es en el mismo aeropuerto).
       */
    def itinerariosSalida(a1: String, a2: String, h: Int, m: Int): List[itn] = {

      val ls = for (c <- itinerario(a1, a2) if (((horaLlegadaAuxiliarNecesaria(c.last, h) * 60) + m) >= ((horaLlegadaAuxiliar(c.last) * 60) + c.last.ML))) yield c

      if (ls.head.length == 1) {
        ls.sortBy(r => r.head.HS).reverse.take(1)

      } else {

        ls.sortBy(r => (r.head.HS, r.last.HS)).reverse.take(1)

      }
    }

    //. . . . . . . . . P A R A L E L I Z A R . . . . . . . . . .

    def itinerarioPar(a1: String, a2: String): List[itn] = {

      def itinerarioAuxiliar(xs: List[Vuelo], a2: String): List[itn] = {
        if (xs.isEmpty) {
          List(xs)
        } else {
          val vueloOrigen = xs.par.filter(r => r.Org == a2)
          val vueloEscala = for {
            i <- vueloOrigen
            m <- itinerarioAuxiliar(xs.par.filterNot(r => r.Org == a2 || r.Dst == a2).toList, i.Dst)

          } yield i :: m
          vueloOrigen.par.map(r => List(r)).toList ++ vueloEscala
        }
      }

      (itinerarioAuxiliar(vuelosA1, a1)).par.filter(r => r.last.Dst == a2).toList

    }


    //Busca los intenierarios de menor tiempo , al menos 3
    def itinerariosTiempoPar(a1: String, a2: String): List[itn] = {


      def tiempoAux(xs: itn): Int = {

        val diferenciaHorasSalida = for {
          i <- xs
        } yield (horaSalidaAuxiliar(i), horaLlegadaAuxiliar(i))


        if (diferenciaHorasSalida.length > 1) {
          horaDiferenciaEscalas(dia(diferenciaHorasSalida), diferenciaHorasSalida)
        } else {

          horadifenciaUnDia(diferenciaHorasSalida)

        }


      }

      def horaDiferenciaEscalas(dia: Int, horas: List[(Int, Int)]): Int = {
        horas.last._2 + ((24 * dia) - horas.head._1)
      }

      def horadifenciaUnDia(horas: List[(Int, Int)]): Int = {

        if (horas.head._2 < horas.head._1) {
          horas.head._2 + ((24) - horas.head._1)
        } else {
          val horafinal = horas.head._2 - horas.head._1
          horafinal
        }

      }


      def dia(xy: List[(Int, Int)]): Int = {

        if (xy.isEmpty) {
          0
        } else {
          if (xy.length == 1) {
            if (xy.head._1 > xy.head._2) {
              1 + dia(xy.tail)
            } else {
              0 + dia(xy.tail)
            }
          } else {
            if (xy.head._1 > xy.head._2) {
              1 + dia(xy.tail)
            } else {
              if (xy.head._2 > xy.tail.head._1) {
                1 + dia(xy.tail)
              } else {
                0 + dia(xy.tail)
              }
            }
          }
        }
      }

      itinerarioPar(a1, a2).sortBy(r => tiempoAux(r)).take(3).par.toList

    }

    def horaSalidaAuxiliarPar(ls: (Vuelo)): Int = {

      val num = for (a <- aeropuertos if (ls.Org == a.Cod)) yield (a.GMT/100) + ls.HS
      var num2 = num.apply(0);

      if (num2 > 24) {
        num2 = num2 - 24;
        num2
      } else {
        if (num2 < 0) {
          num2 = num2 + 24;
          num2
        } else {
          num2
        }
      }
    }

    def horaLlegadaAuxiliarPar(ls: (Vuelo)): Int = {

      val num = for (a <- aeropuertos if (ls.Dst == a.Cod)) yield (a.GMT/100) + ls.HL

      var num2 = num.apply(0);

      if (num2 > 24) {
        num2 = num2 - 24;
        num2
      } else {
        if (num2 < 0) {
          num2 = num2 + 24;
          num2
        } else {
          num2
        }
      }
    }

    def itinerariosCambiosPar(a1: String, a2: String): List[itn] = {

      def numeroEscalas(xs: itn): Int = {

        val numeroEscalasVuelo = for {
          i <- xs
        } yield i.Esc

        numeroEscalasVuelo.sum + (xs.length - 1)

      }

      itinerarioPar(a1, a2).sortBy(r => (numeroEscalas(r))).take(3).par.toList;
    }

    def itinerarioDistanciaPar(a1: String, a2: String): List[itn] = {

      def tiempoAux(xs: itn): Int = {

        val diferenciaHorasSalida = for {
          i <- xs
        } yield (horaSalidaAuxiliar(i), horaLlegadaAuxiliar(i))

        horadifenciaUnDia(diferenciaHorasSalida)

      }

      def horadifenciaUnDia(horas: List[(Int, Int)]): Int = {
        if (horas.isEmpty) {
          0
        } else {
          if (horas.head._2 < horas.head._1) {
            horas.head._2 + ((24) - horas.head._1) + horadifenciaUnDia(horas.tail)
          } else {
            horas.head._2 - horas.head._1 + horadifenciaUnDia(horas.tail)
          }
        }
      }

      itinerarioPar(a1, a2).sortBy(r => tiempoAux(r)).par.toList.take(3)

    }

    def horaLlegadaAuxiliarNecesariaPar(ls: (Vuelo), h: Int): Int = {

      val num = for (a <- aeropuertos if (ls.Dst == a.Cod)) yield (a.GMT/100) + h
      var num2 = num.apply(0);

      if (num2 > 24) {
        num2 = num2 - 24;
        num2
      } else {
        if (num2 < 0) {
          num2 = num2 + 24;
          num2
        } else {
          num2
        }
      }
    }

    def itinerariosSalidaPar(a1: String, a2: String, h: Int, m: Int): List[itn] = {

      val ls = for (c <- itinerarioPar(a1, a2) if (((horaLlegadaAuxiliarNecesaria(c.last, h) * 60) + m) >= ((horaLlegadaAuxiliar(c.last) * 60) + c.last.ML))) yield c
      if (ls.head.length == 1) {
        ls.sortBy(r => r.head.HS).reverse.take(1).par.toList

      } else {

        ls.sortBy(r => (r.head.HS, r.last.HS)).reverse.take(1).par.toList

      }
    }
  }
}
import org.scalameter._

object ItinerariosRunner {
  val standardConfig = config(
    Key.exec.minWarmupRuns := 20,
    Key.exec.maxWarmupRuns := 40,
    Key.exec.benchRuns := 25,
    Key.verbose := true
  ) withWarmer (new Warmer.Default)


  def main(args: Array[String]) {

    val vueloItinerarios = new paquete.vuelosItinerarios()

    val prueba1 = "ATL"
    val prueba2 = "BOS"

    val seqTime = standardConfig measure {
      vueloItinerarios.itinerario(prueba1, prueba2)
    }
    println(s"tiempo secuencial: $seqTime ms")

    val partime = standardConfig measure {
      vueloItinerarios.itinerarioPar(prueba1, prueba2)
    }
    println(s"tiempo paralelo: $partime ms")

  }

}