package com.github.agetakoyaki29.scalafx.scene.control

import javafx.beans.binding.ObjectBinding
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.control.ScrollPane
import javafx.scene.layout.StackPane
import javafx.stage.Screen
import javafx.beans.binding.ObjectBinding
import javafx.geometry.Point2D
import javafx.scene.control.ScrollPane.ScrollBarPolicy


class StackedCanvas(_length: Int) extends ScrollPane {

  private val root: ScrollPane = this

  val canvases: Seq[Canvas] = (0 until _length) map {_ => makeCanvas}
  val gcs: Seq[GraphicsContext] = canvases map {_.getGraphicsContext2D}

  ; {
    root.setPannable(false)
    root.setHbarPolicy(ScrollBarPolicy.NEVER)
    root.setVbarPolicy(ScrollBarPolicy.NEVER)
    // root.setFocusTraversable(false)
    root.setContent(new StackPane(canvases:_*))
  }

  private def makeCanvas: Canvas = { // full screen canvas
    val screen = Screen.getPrimary().getVisualBounds()
    new Canvas(screen.getWidth(), screen.getHeight())
  }

  lazy val centerProperty = {
    val width = root.widthProperty
    val height = root.heightProperty
    new ObjectBinding[Point2D] {
      super.bind(width, height)
      override def computeValue = new Point2D(width.get()/2, height.get()/2)
    }
  }

}
