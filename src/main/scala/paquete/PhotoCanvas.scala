package paquete


import javax.swing.{JComponent, JTextArea}

class PhotoCanvas extends JComponent {

  val vuelosItinerarios = new vuelosItinerarios;


  def applyFilter(filterName: String, hora: Int, min: Int, a1: String, a2: String, accion: String) {
    filterName match {
      case "Paralelo" =>
        accion match {
          case "Itinerarios" => vuelosItinerarios.itinerarioPar(a1, a2)
          case "Itinerarios Tiempo Vuelo" => vuelosItinerarios.itinerariosTiempoPar(a1, a2)
          case "Itinerarios Distancia" => vuelosItinerarios.itinerarioDistanciaPar(a1, a2)
          case "itinerarios escala" => vuelosItinerarios.itinerariosCambiosPar(a1, a2)
          case "Itinerario Salida" => vuelosItinerarios.itinerariosSalidaPar(a1, a2, hora, min)
        }

      case "Secuencial" =>
        accion match {
          case "Itinerarios" => vuelosItinerarios.itinerario(a1, a2)
          case "Itinerarios Tiempo Vuelo" => vuelosItinerarios.itinerariosTiempo(a1, a2)
          case "Itinerarios Distancia" => vuelosItinerarios.itinerarioDistancia(a1, a2)
          case "itinerarios escala" => vuelosItinerarios.itinerariosCambios(a1, a2)
          case "Itinerario Salida" => vuelosItinerarios.itinerariosSalida(a1, a2, hora, min)
        }
      case "" =>
    }
    repaint()
  }

  def setText1(campo: JTextArea, filterName: String, hora: Int, min: Int, a1: String, a2: String, accion: String) {
    filterName match {
      case "Paralelo" =>
        accion match {
          case "Itinerarios" => campo.setText("" + vuelosItinerarios.itinerarioPar(a1, a2))
          case "Itinerarios Tiempo Vuelo" => campo.setText("" + vuelosItinerarios.itinerariosTiempoPar(a1, a2))
          case "Itinerarios Distancia" => campo.setText("" + vuelosItinerarios.itinerarioDistanciaPar(a1, a2))
          case "itinerarios escala" => campo.setText("" + vuelosItinerarios.itinerariosCambiosPar(a1, a2))
          case "Itinerario Salida" => campo.setText("" + vuelosItinerarios.itinerariosSalidaPar(a1, a2, hora, min))
        }

      case "Secuencial" =>
        accion match {
          case "Itinerarios" => campo.setText("" + vuelosItinerarios.itinerario(a1, a2))
          case "Itinerarios Tiempo Vuelo" => campo.setText("" + vuelosItinerarios.itinerariosTiempo(a1, a2))
          case "Itinerarios Distancia" => campo.setText("" + vuelosItinerarios.itinerarioDistancia(a1, a2))
          case "itinerarios escala" => campo.setText("" + vuelosItinerarios.itinerariosCambios(a1, a2))
          case "Itinerario Salida" => campo.setText("" + vuelosItinerarios.itinerariosSalida(a1, a2, hora, min))
        }
      case "" =>
    }
    repaint()
  }

}