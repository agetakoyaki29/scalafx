package com.github.agetakoyaki29.scalafx.scene.canvas

import javafx.scene.canvas.GraphicsContext
import javafx.geometry.Point2D
import javafx.scene.shape.ArcType


object XXX {

  implicit class GraphicsContextExtension(that : GraphicsContext) {
    def fillCircle(x: Double, y: Double, w: Double, h: Double) = that.fillArc(x, y, w, h, 0, 360, ArcType.OPEN)
    def strokeCircle(x: Double, y: Double, w: Double, h: Double) = that.strokeArc(x, y, w, h, 0, 360, ArcType.OPEN)

    // ----

    def strokeLine2(sp: Point2D, ep: Point2D) = that.strokeLine(sp.getX, sp.getY, ep.getX, ep.getY)

    def strokeCircle2(sp: Point2D, size: Point2D) = this.strokeCircle(sp.getX, sp.getY, size.getX, size.getY)
    def fillCircle2(sp: Point2D, size: Point2D) = this.fillCircle(sp.getX, sp.getY, size.getX, size.getY)
  }

}
