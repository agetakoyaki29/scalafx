package com.github.agetakoyaki29.scalafx.scene.canvas

import javafx.scene.canvas.GraphicsContext
import javafx.geometry.Point2D
import javafx.scene.shape.ArcType


object GraphicsContextExtension {
  implicit def toExtension(that: GraphicsContext) = new GraphicsContextExtension(that)
}


class GraphicsContextExtension(that : GraphicsContext) {
  def fillCircle(x: Double, y: Double, w: Double, h: Double) = that.fillArc(x, y, w, h, 0, 360, ArcType.OPEN)
  def strokeCircle(x: Double, y: Double, w: Double, h: Double) = that.strokeArc(x, y, w, h, 0, 360, ArcType.OPEN)

}
