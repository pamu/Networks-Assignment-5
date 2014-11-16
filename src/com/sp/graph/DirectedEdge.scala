package com.sp.graph

case class DirectedEdge(val from: Int, val to: Int, val weight: Int) {
  override def toString = s"$from --$weight--> $to"
}