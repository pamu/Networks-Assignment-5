package com.sp.dijkstra

import java.io.InputStream
import java.util.Scanner

case class EdgeWeightedDiGraph(val V: Int, val E: Int) {
  
  /**
   * Adjacency Matrix representation of the Graph
   */
  val adjMat: Array[Array[Int]] = Array.ofDim[Int](V, V)
  
  /**
   * initialize the adjMatrix with -1 which represents the no edge exists between any two edges
   */
  
  for(i <- 0 until adjMat.length)
    for(j <- 0 until adjMat(0).length)
      adjMat(i)(j) = -1
  
  /**
   * @edge pass a directed Edge to the method it overrides the -1 value existing in the matrix initially
   */
  def addEdge(edge: DirectedEdge) = adjMat(edge.from)(edge.to) = edge.weight
  
  /** Get adjacent edges to the node represented by the Integer
   * 
   * @v is the integer representing the node is should be less than v passed in the constructor of the class
   */
  def adj(v: Int) = for(i <- 0 until V; if adjMat(v)(i) != -1) yield DirectedEdge(v, i, adjMat(v)(i))
  
  /**
   * @edges gives collection of all available edges in the graph
   */
  def edges() = for(i <- 0 until V; j <- 0 until V; if adjMat(i)(j) != -1) yield DirectedEdge(i, j, adjMat(i)(j))
  
  /**toString gives String representation of the Graph
   * 
   * @toString is overridden to specific needs
   */
  override def toString = adjMat.deep.mkString("\n")
}