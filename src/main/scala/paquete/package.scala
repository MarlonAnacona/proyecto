import scala.math.Fractional.Implicits.infixFractionalOps


package
object paquete {

  class vuelosItinerarios {

    import scala.collection.parallel.CollectionConverters._
    import scala.collection.parallel.{ParMap, ParSeq}

    abstract class aero

    case class Aeropuerto(Cod: String, X: Int, Y: Int, GMT: Int) extends aero

    case class Vuelo(Aln: String, Num: Int, Org: String, HS: Int, MS: Int, Dst: String, HL: Int, ML: Int, Esc: Int) extends aero

    val aeropuertos = List(
      Aeropuerto("ABQ", 195, 275, -8),
      Aeropuerto("ATL", 470, 280, -6),
      Aeropuerto("BNA", 430, 240, -7),
      Aeropuerto("BOS", 590, 100, -6),
      Aeropuerto("DCA", 540, 180, -6),
      Aeropuerto("DEN", 215, 205, -8),
      Aeropuerto("DFW", 310, 305, -7),
      Aeropuerto("DTW", 445, 140, -6),
      Aeropuerto("HOU", 330, 355, -7),
      Aeropuerto("JFK", 565, 130, -6),
      Aeropuerto("LAX", 55, 270, -9),
      Aeropuerto("MIA", 535, 390, -6),
      Aeropuerto("MSP", 340, 115, -7),
      Aeropuerto("MSY", 405, 345, -7),
      Aeropuerto("ORD", 410, 155, -7),
      Aeropuerto("PHL", 550, 155, -6),
      Aeropuerto("PHX", 120, 290, -8),
      Aeropuerto("PVD", 595, 122, -6),
      Aeropuerto("RDU", 530, 230, -6),
      Aeropuerto("SEA", 55, 45, -9),
      Aeropuerto("SFO", 10, 190, -9),
      Aeropuerto("STL", 380, 210, -7),
      Aeropuerto("TPA", 500, 360, -6)
    )

    //________________________________________________________

    //longitud

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

      Vuelo("AA", 837, "ATL", 7, 25, "DFW", 13, 5, 0),
      Vuelo("AA", 728, "DFW", 6, 35, "BOS", 10, 58, 0),

      Vuelo("AA", 203, "DFW", 8, 10, "BOS", 11, 0, 0),


      Vuelo("AA", 334, "RDU", 9, 0, "PVD", 10, 40, 0),
      Vuelo("AA", 709, "ATL", 8, 28, "MIA", 10, 15, 0)
    )

    val vuelosA2 = List(
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

      Vuelo("AA", 837, "ATL", 7, 25, "DFW", 13, 5, 0),
      Vuelo("AA", 728, "DFW", 6, 35, "BOS", 10, 58, 0),

      Vuelo("AA", 203, "DFW", 8, 10, "BOS", 14, 7, 0),
      Vuelo("AA", 334, "RDU", 9, 0, "PVD", 10, 40, 0),
      Vuelo("AA", 709, "ATL", 8, 28, "MIA", 10, 15, 0)
    )

    val vuelosA3 = List(
      Vuelo("AA", 400, "LAX", 7, 30, "MIA", 15, 30, 0),
      Vuelo("AA", 978, "MIA", 8, 10, "MSY", 12, 4, 0),
      Vuelo("AA", 348, "ORD", 6, 15, "DFW", 13, 6, 0),
      Vuelo("AA", 71, "DFW", 16, 2, "SFO", 17, 43, 0),
      Vuelo("AA", 860, "BNA", 19, 27, "DTW", 11, 55, 0),
      Vuelo("AA", 749, "BOS", 18, 17, "BNA", 10, 12, 0),
      Vuelo("AA", 673, "ATL", 19, 57, "ORD", 10, 45, 0),
      Vuelo("AA", 926, "MIA", 19, 3, "MSY", 10, 17, 0),
      Vuelo("AA", 926, "MIA", 19, 3, "HOU", 12, 15, 2),
      Vuelo("AA", 586, "DFW", 17, 13, "PHL", 11, 13, 0),
      Vuelo("AA", 637, "PVD", 7, 35, "RDU", 12, 5, 0),
      Vuelo("AA", 329, "DFW", 14, 27, "ABQ", 15, 15, 0),
      Vuelo("AA", 568, "DFW", 6, 56, "DCA", 10, 33, 0),
      Vuelo("AA", 530, "SFO", 12, 22, "BOS", 12, 54, 1),
      Vuelo("AA", 379, "BOS", 6, 15, "ORD", 15, 4, 0)
    )

    val vuelosA4 = List(
      Vuelo("AA", 27, "MIA", 8, 0, "SEA", 11, 27, 0),
      Vuelo("AA", 1, "JFK", 9, 0, "LAX", 11, 39, 0),
      Vuelo("AA", 272, "HOU", 7, 25, "DFW", 13, 7, 0),
      Vuelo("AA", 227, "DFW", 9, 24, "LAX", 10, 17, 0),
      Vuelo("AA", 2, "LAX", 8, 30, "JFK", 16, 46, 0),
      Vuelo("AA", 523, "MIA", 7, 45, "DFW", 15, 1, 0),
      Vuelo("AA", 64, "SFO", 8, 0, "JFK", 16, 23, 0),
      Vuelo("AA", 181, "ORD", 9, 15, "LAX", 11, 10, 0),
      Vuelo("AA", 719, "TPA", 13, 20, "DFW", 14, 56, 0),
      Vuelo("AA", 127, "ORD", 18, 25, "SEA", 10, 58, 0),
      Vuelo("AA", 407, "ORD", 9, 10, "PHX", 11, 53, 0),
      Vuelo("AA", 606, "LAX", 7, 0, "DFW", 11, 57, 0),
      Vuelo("AA", 897, "DCA", 17, 54, "MIA", 10, 31, 0),
      Vuelo("AA", 566, "SFO", 7, 0, "BOS", 17, 19, 1),
      Vuelo("AA", 315, "ORD", 17, 30, "BNA", 18, 54, 0)
    )

    val vuelosA5 = List(
      Vuelo("AA", 856, "DFW", 14, 30, "HOU", 15, 39, 0),
      Vuelo("AA", 846, "DFW", 17, 16, "DCA", 11, 4, 0),
      Vuelo("AA", 745, "MIA", 16, 48, "DFW", 19, 5, 0),
      Vuelo("AA", 278, "ORD", 16, 30, "BOS", 19, 47, 0),
      Vuelo("AA", 483, "TPA", 17, 20, "RDU", 19, 1, 0),
      Vuelo("AA", 705, "DCA", 12, 45, "ORD", 13, 52, 0),
      Vuelo("AA", 212, "DFW", 17, 21, "DTW", 12, 40, 1),
      Vuelo("AA", 216, "DFW", 17, 15, "STL", 19, 4, 0),
      Vuelo("AA", 692, "MIA", 14, 5, "PHL", 16, 50, 0),
      Vuelo("AA", 705, "DCA", 12, 45, "DEN", 16, 30, 1),
      Vuelo("AA", 281, "ORD", 11, 15, "LAX", 15, 37, 1),
      Vuelo("AA", 501, "STL", 13, 5, "DFW", 14, 51, 0),
      Vuelo("AA", 721, "DCA", 11, 59, "RDU", 13, 9, 0),
      Vuelo("AA", 201, "PHL", 7, 24, "DFW", 10, 0, 0),
      Vuelo("AA", 59, "JFK", 8, 0, "SFO", 11, 33, 0)
    )

    type itn = List[Vuelo]

    //devuelve la ruta
    def itenerario(a1: String, a2: String): List[itn] = {

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


    //Busca los intenierarios de menor tiempo , al menos 3
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


      itenerario(a1, a2).sortBy(r => tiempoAux(r)).take(3)


    }


    def horaSalidaAuxiliar(ls: (Vuelo)): Int = {


      val num = for (a <- aeropuertos if (ls.Org == a.Cod)) yield (a.GMT) + ls.HS
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

      val num = for (a <- aeropuertos if (ls.Dst == a.Cod)) yield a.GMT + ls.HL
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


    //El menor cambio de avion de los itenerarios
    def itinerariosCambios(a1: String, a2: String): List[itn] = {


      def numeroEscalas(xs: itn): Int = {

        val numeroEscalasVuelo = for {
          i <- xs
        } yield i.Esc

        numeroEscalasVuelo.sum + (xs.length - 1)

      }

      itenerario(a1, a2).sortBy(r => (numeroEscalas(r))).take(3);
    }

    //Itenerarios con menor  el tiempo de vuelo
    def itenerarioDistancia(a1: String, a2: String): List[itn] = {


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

      itenerario(a1, a2).sortBy(r => tiempoAux(r))

    }


    def horaLlegadaAuxiliarNecesaria(ls: (Vuelo), h: Int): Int = {

      val num = for (a <- aeropuertos if (ls.Dst == a.Cod)) yield a.GMT + h
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


    //Optimizacion en horario de salida
    def itenerariosSalida(a1: String, a2: String, h: Int, m: Int): List[itn] = {
      // val ls= itenerario(a1,a2)


      /*
  Un itinerario que salga a1  y llegue a2, de tal manera que dado h:m. se llegue a tiempo a a2


  6 AM SALIDA, 8 AM SALIDA.
  1 NECESARIA , 12:30 LLEGADA VUELO

  EL VUELO QUE SALGA DE a1 MAS TARDE.




*/
      /* def aux(horallegada:Int,horaNecesaria:Int,minutosllegada:Int,minutosNecesario:Int ): Int ={


     if(horaNecesaria<horallegada){
       ((   horallegada+(24-horaNecesaria))*60) + minutosAuxiliar(minutosllegada,minutosNecesario)
     }else{
       if(horallegada==horaNecesaria){
         0+minutosAuxiliar(minutosllegada,minutosllegada)
       }else{
         var s=horallegada-horaNecesaria
         ( (s*60)+minutosAuxiliar(minutosllegada,minutosNecesario)).abs
       }

     }

    }

    def minutosAuxiliar(minutollegada:Int,minutoNecesario:Int): Int ={
      if(minutollegada<minutoNecesario){
        var minFinal=(60-minutoNecesario)+minutollegada
        minFinal
      }else{
        if(minutollegada>minutoNecesario){
          var minFinal=minutollegada-minutoNecesario
          minFinal
        }else{
          0
        }
      }
    }
*/

      val ls = for (c <- itenerario(a1, a2) if (((horaLlegadaAuxiliarNecesaria(c.last, h) * 60) + m) >= ((horaLlegadaAuxiliar(c.last) * 60) + c.last.ML))) yield c


      if (ls.head.length == 1) {
        ls.sortBy(r => r.head.HS).reverse.take(1)

      } else {
        //ls.sortBy(r => (horaSalidaAuxiliar(r.head),horaSalidaAuxiliar(r.last)))
        ls.sortBy(r => (r.head.HS, r.last.HS)).reverse

      }

      //ls.filter(r=> (horaLlegadaAuxiliar(r.last)*60)<h)
      //ls.sortBy(r=>(aux(horaLlegadaAuxiliar(r.last),horaLlegadaAuxiliarNecesaria(r.last,h),r.last.ML,m),horaSalidaAuxiliar(r.head)))


    }



    //...paralelizar...


    def itenerarioPar(a1: String, a2: String): List[itn] = {


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


      itenerarioPar(a1, a2).sortBy(r => tiempoAux(r)).take(3).par.toList


    }


    def horaSalidaAuxiliarPar(ls: (Vuelo)): Int = {


      val num = for (a <- aeropuertos if (ls.Org == a.Cod)) yield (a.GMT) + ls.HS
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

      val num = for (a <- aeropuertos if (ls.Dst == a.Cod)) yield a.GMT + ls.HL


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


    //El menor cambio de avion de los itenerarios
    def itinerariosCambiosPar(a1: String, a2: String): List[itn] = {


      def numeroEscalas(xs: itn): Int = {

        val numeroEscalasVuelo = for {
          i <- xs
        } yield i.Esc

        numeroEscalasVuelo.sum + (xs.length - 1)

      }

      itenerarioPar(a1, a2).sortBy(r => (numeroEscalas(r))).take(3).par.toList;
    }

    //Itenerarios con menor  el tiempo de vuelo
    def itenerarioDistanciaPar(a1: String, a2: String): List[itn] = {


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

      itenerarioPar(a1, a2).sortBy(r => tiempoAux(r)).par.toList

    }


    def horaLlegadaAuxiliarNecesariaPar(ls: (Vuelo), h: Int): Int = {

      val num = for (a <- aeropuertos if (ls.Dst == a.Cod)) yield a.GMT + h
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


    //Optimizacion en horario de salida
    def itenerariosSalidaPar(a1: String, a2: String, h: Int, m: Int): List[itn] = {

      val ls = for (c <- itenerarioPar(a1, a2) if (((horaLlegadaAuxiliarNecesaria(c.last, h) * 60) + m) >= ((horaLlegadaAuxiliar(c.last) * 60) + c.last.ML))) yield c
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
      vueloItinerarios.itenerario(prueba1, prueba2)
    }
    println(s"tiempo secuencial: $seqTime ms")

    val partime = standardConfig measure {
      vueloItinerarios.itenerarioPar(prueba1, prueba2)
    }
    println(s"tiempo paralelo: $partime ms")

  }

}