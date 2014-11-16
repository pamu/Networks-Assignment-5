package com.sp.dijkstra

import scala.collection.mutable.Stack

case class DFS(g: EdgeWeightedDiGraph) {
  val visited = new Array[Boolean](g.V)
  
  val path = new Stack[Int]()
  
  def dfs(v: Int): Unit = {
	visited(v) = true
    for(edge <- g.adj(v); if !visited(edge.to)) dfs(edge.to)
    path.push(v)
  }
}