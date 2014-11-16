package com.sp.dijkstra

import com.sp.graph.EdgeWeightedDiGraph
import scala.collection.mutable.Map

case class SP(g: EdgeWeightedDiGraph, source: Int) {
  
  import com.sp.graph.DirectedEdge
  
  val distTo = new Array[Int](g.V)
  val edgeTo = new Array[DirectedEdge](g.V)
  
  val map = Map[Int, Int]()
  
  for(i <- 0 until g.V) distTo(i) = Int.MaxValue
  
   def relax(edge: DirectedEdge) = {
    
    val from = edge.from
    val to = edge.to
    val weight = edge.weight
    
    if(distTo(to) > distTo(from) + weight) {
      distTo(to) = distTo(from) + weight
      edgeTo(to) = edge
      if(map contains to) map(to) = distTo(to)
      else map += ((to, distTo(to)))
    }
    
    
  }
  
  def dijkstra() {
   distTo(source) = 0
   map += ((source, 0))
    while(!map.isEmpty) {
    	val vertex = delMin()
    	for(edge <- g.adj(vertex))
    	  relax(edge)
    }
  }
  
  def delMin() = {
    val list: List[(Int, Int)] = map.toList.sortBy(t => t._2)
    val vertex = list.head._1
    map -= vertex
    vertex
  }
  
}