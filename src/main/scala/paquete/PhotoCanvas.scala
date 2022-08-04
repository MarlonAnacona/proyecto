package paquete


import java.awt.Graphics
import java.awt.image.BufferedImage
import javax.swing.{JComponent, JTextArea}
import paquete.vuelosItinerarios

class PhotoCanvas extends JComponent {

  val vuelosItinerarios = new vuelosItinerarios;


  def applyFilter(filterName: String, hora: Int, min: Int, a1: String, a2: String, accion: String) {
    filterName match {
      case "Paralelo" =>
        accion match {
          case "Itinerarios" => vuelosItinerarios.itenerarioPar(a1, a2)
          case "Itinerarios Tiempo Vuelo" => vuelosItinerarios.itinerariosTiempoPar(a1, a2)
          case "Itinerarios Distancia" => vuelosItinerarios.itenerarioDistanciaPar(a1, a2)
          case "itinerarios escala" => vuelosItinerarios.itinerariosCambiosPar(a1, a2)
          case "Itinerario Salida" => vuelosItinerarios.itenerariosSalidaPar(a1, a2, hora, min)
        }

      case "Secuencial" =>
        accion match {
          case "Itinerarios" => vuelosItinerarios.itenerario(a1, a2)
          case "Itinerarios Tiempo Vuelo" => vuelosItinerarios.itinerariosTiempo(a1, a2)
          case "Itinerarios Distancia" => vuelosItinerarios.itenerarioDistancia(a1, a2)
          case "itinerarios escala" => vuelosItinerarios.itinerariosCambios(a1, a2)
          case "Itinerario Salida" => vuelosItinerarios.itenerariosSalida(a1, a2, hora, min)
        }
      case "" =>
    }
    repaint()
  }

  def setText1(campo: JTextArea, filterName: String, hora: Int, min: Int, a1: String, a2: String, accion: String) {
    filterName match {
      case "Paralelo" =>
        accion match {
          case "Itinerarios" => campo.setText("" + vuelosItinerarios.itenerarioPar(a1, a2))
          case "Itinerarios Tiempo Vuelo" => campo.setText("" + vuelosItinerarios.itinerariosTiempoPar(a1, a2))
          case "Itinerarios Distancia" => campo.setText("" + vuelosItinerarios.itenerarioDistanciaPar(a1, a2))
          case "itinerarios escala" => campo.setText("" + vuelosItinerarios.itinerariosCambiosPar(a1, a2))
          case "Itinerario Salida" => campo.setText("" + vuelosItinerarios.itenerariosSalidaPar(a1, a2, hora, min))
        }

      case "Secuencial" =>
        accion match {
          case "Itinerarios" => campo.setText("" + vuelosItinerarios.itenerario(a1, a2))
          case "Itinerarios Tiempo Vuelo" => campo.setText("" + vuelosItinerarios.itinerariosTiempo(a1, a2))
          case "Itinerarios Distancia" => campo.setText("" + vuelosItinerarios.itenerarioDistancia(a1, a2))
          case "itinerarios escala" => campo.setText("" + vuelosItinerarios.itinerariosCambios(a1, a2))
          case "Itinerario Salida" => campo.setText("" + vuelosItinerarios.itenerariosSalida(a1, a2, hora, min))
        }
      case "" =>
    }
    repaint()
  }

}