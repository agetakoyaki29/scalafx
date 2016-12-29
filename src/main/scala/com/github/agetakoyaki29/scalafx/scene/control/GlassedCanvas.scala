package com.github.agetakoyaki29.scalafx.scene.control

import javafx.beans.binding.ObjectBinding
import javafx.scene.canvas.Canvas
import javafx.scene.control.ScrollPane
import javafx.scene.layout.StackPane
import javafx.stage.Screen
import javafx.beans.binding.ObjectBinding
import javafx.geometry.Point2D


class GlassedCanvas extends ScrollPane {
//  ; {
//    val root: ScrollPane = this
//    root.setFocusTraversable(false)
//  }
  
  val (coldGC, hotGC) = {
    val cold, hot = {
      val canvas = new Canvas
      // full screen canvas
      val screen = Screen.getPrimary().getVisualBounds();
      canvas.setWidth(screen.getWidth())
      canvas.setHeight(screen.getHeight())
      canvas
    }
    this.getChildren.add(new StackPane(cold, hot))
    (cold.getGraphicsContext2D, hot.getGraphicsContext2D)
  }
  
  lazy val centerProperty = {
    val width = this.widthProperty
    val height = this.heightProperty
    new ObjectBinding[Point2D] {
			super.bind(width, height)
			override def computeValue = new Point2D(width.get()/2, height.get()/2)
		}
  }
  
}
