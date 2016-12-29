package com.github.agetakoyaki29.scalafx.scene.control

import javafx.beans.binding.ObjectBinding
import javafx.scene.canvas.Canvas
import javafx.scene.control.ScrollPane
import javafx.scene.layout.StackPane
import javafx.stage.Screen
import javafx.beans.binding.ObjectBinding
import javafx.geometry.Point2D


class GlassedCanvas extends ScrollPane {
  
  private val root: ScrollPane = this
  
//  ; {
//    root.setFocusTraversable(false)
//  }
  
  val (coldGC, hotGC) = {
    val cold, hot = { // full screen canvas
      val screen = Screen.getPrimary().getVisualBounds()
      new Canvas(screen.getWidth(), screen.getHeight())
    }
    
    root.setContent(new StackPane(cold, hot))
    (cold.getGraphicsContext2D, hot.getGraphicsContext2D)
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
