package paquete

import org.scalameter.{Key, Warmer, config}

import java.awt.event.{ActionEvent, ActionListener}
import java.awt.{BorderLayout, GridLayout}
import javax.swing._

object ScalaShop {

  class ScalaShopFrame extends JFrame("Itinerarios\u2122") {

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
    setSize(1550, 500)
    setLayout(new BorderLayout)

    val rightpanel = new JPanel
    rightpanel.setBorder(BorderFactory.createEtchedBorder(border.EtchedBorder.LOWERED))
    rightpanel.setLayout(new BorderLayout)
    add(rightpanel, BorderLayout.EAST)

    val leftPanel = new JPanel
    leftPanel.setBorder(BorderFactory.createEtchedBorder(border.EtchedBorder.LOWERED))
    leftPanel.setLayout(new BorderLayout)
    add(leftPanel, BorderLayout.WEST)

    val controls = new JPanel
    controls.setLayout(new GridLayout(0, 2))
    rightpanel.add(controls, BorderLayout.NORTH)


    val EscogerAcion = new JLabel("Metodo")
    controls.add(EscogerAcion)
    val filterCombo = new JComboBox(Array(
      "Paralelo",
      "Secuencial"
    ))
    controls.add(filterCombo)

    val Origen = new JLabel("Origen")
    controls.add(Origen)
    val filtroOrigen = new JComboBox(Array(
    "ABQ",
      "ATL",
      "BNA",
      "BOS",
      "DCA",
      "DEN",
      "DFW",
      "DTW",
      "HOU",
      "JFK",
      "LAX",
      "MIA",
      "MSP",
      "MSY",
      "ORD",
      "PHL",
      "PHX",
      "PVD",
      "RDU",
      "SEA",
      "SFO",
      "STL",
      "TPA"
    ))
    controls.add(filtroOrigen)

    val Destino = new JLabel("Destino ")
    controls.add(Destino)
    val filtroDestino = new JComboBox(Array(
      "ABQ",
      "ATL",
      "BNA",
      "BOS",
      "DCA",
      "DEN",
      "DFW",
      "DTW",
      "HOU",
      "JFK",
      "LAX",
      "MIA",
      "MSP",
      "MSY",
      "ORD",
      "PHL",
      "PHX",
      "PVD",
      "RDU",
      "SEA",
      "SFO",
      "STL",
      "TPA"
    ))
    controls.add(filtroDestino)


    val filterLabel = new JLabel("Accion")
    controls.add(filterLabel)
    val filterAccion = new JComboBox(Array(
      "Itinerarios",
      "Itinerarios Tiempo Vuelo",
      "Itinerarios Distancia",
      "itinerarios escala",
      "Itinerario Salida"
    ))
    controls.add(filterAccion)

    val radiusLabel = new JLabel("Hora")
    controls.add(radiusLabel)

    val horas = new JSpinner(new SpinnerNumberModel(0, 0, 24, 1))
    controls.add(horas)

    val tasksLabel = new JLabel("Minuto")
    controls.add(tasksLabel)

    val minutos = new JSpinner(new SpinnerNumberModel(0, 0, 60, 1))
    controls.add(minutos)

    val standardConfig = config(
      Key.exec.minWarmupRuns := 20,
      Key.exec.maxWarmupRuns := 40,
      Key.exec.benchRuns := 25,
      Key.verbose := true
    ) withWarmer (new Warmer.Default)

    val stepbutton = new JButton("Buscar")
    stepbutton.addActionListener(new ActionListener {
      def actionPerformed(e: ActionEvent) {
        val time = standardConfig measure {
          if(getOrigen.equals(getDestino)){
            JOptionPane.showMessageDialog(null,"Error, mismo destino al origen")
          }else{
            canvas.applyFilter(getFilterName, getHoras, getMinutos,getOrigen,getDestino,getAccion)
            canvas.setText1(respuesta,getFilterName, getHoras, getMinutos,getOrigen,getDestino,getAccion)
          }

        }
        updateInformationBox(time.value)
      }
    })
    controls.add(stepbutton)

    val info = new JTextArea("   ")
    info.setBorder(BorderFactory.createLoweredBevelBorder)
    rightpanel.add(info, BorderLayout.SOUTH)

    val respuesta = new JTextArea("")
    respuesta.setLineWrap(true)
    respuesta.setSize(1245,300)
    respuesta.setBorder(BorderFactory.createLoweredBevelBorder)
    leftPanel.add(respuesta, BorderLayout.NORTH)

    val canvas = new PhotoCanvas

    setVisible(true)

    def updateInformationBox(time: Double) {
      info.setText(s"Tiempo: $time")
    }

    def updateItinerarios(vuelos:String): Unit ={
      respuesta.setText(""+vuelos)
    }

    def getMinutos: Int = minutos.getValue.asInstanceOf[Int]

    def getHoras: Int = horas.getValue.asInstanceOf[Int]

    def getFilterName: String = {
      filterCombo.getSelectedItem.asInstanceOf[String]
    }
    def getOrigen: String={
      filtroOrigen.getSelectedItem.asInstanceOf[String]
    }


    def getDestino: String={
      filtroDestino.getSelectedItem.asInstanceOf[String]
    }
    def getAccion: String={
      filterAccion.getSelectedItem.asInstanceOf[String]
    }

  }

  try {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
  } catch {
    case _: Exception => println("Cannot set look and feel, using the default one.")
  }

  val frame = new ScalaShopFrame

  def main(args: Array[String]) {
    frame.repaint()
  }

}