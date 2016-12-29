package com.github.agetakoyaki29.scalafx.scene.canvas

import javafx.scene.canvas.GraphicsContext
import javafx.geometry.Point2D
import javafx.scene.shape.ArcType


object XXX {

  implicit class GraphicsContextExtension(that : GraphicsContext) {
    def strokeLine(pt1: Point2D, pt2: Point2D) = that.strokeLine(pt1.getX, pt1.getY, pt2.getX, pt2.getY)
    
    def fillCircle(x: Double, y: Double, w: Double, h: Double) = that.fillArc(x, y, w, h, 0, 360, ArcType.OPEN)
    def strokeCircle(x: Double, y: Double, w: Double, h: Double) = that.strokeArc(x, y, w, h, 0, 360, ArcType.OPEN)
  }
  
}