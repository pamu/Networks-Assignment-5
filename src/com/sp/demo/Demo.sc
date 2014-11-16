package com.sp.demo

object Demo {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  import java.io._
  import java.util.Scanner
  
  import com.sp.graph.DirectedEdge
  import com.sp.graph.EdgeWeightedDiGraph
  import com.sp.dijkstra.DFS
  import com.sp.dijkstra.SP
  
  def getFromFile(path: String) = {
  	val file = new File(path)
  	val scan = new Scanner(new FileInputStream(file))
  	val vertices = scan.nextLine.trim.toInt
  	val edges = scan.nextLine.trim.toInt
  	val g = EdgeWeightedDiGraph(vertices, edges)
  	for(i <- 0 until edges) {
  		val list = scan.nextLine.trim.split("\\s+").map(_.toInt)
  		g.addEdge(DirectedEdge(list(0), list(1), list(2)))
  	}
  	
  	g
  }                                               //> getFromFile: (path: String)com.sp.graph.EdgeWeightedDiGraph
  
  val g = EdgeWeightedDiGraph(4, 3)               //> g  : com.sp.graph.EdgeWeightedDiGraph = Array(-1, -1, -1, -1)
                                                  //| Array(-1, -1, -1, -1)
                                                  //| Array(-1, -1, -1, -1)
                                                  //| Array(-1, -1, -1, -1)
  
  g addEdge(DirectedEdge(0, 1, 10))
  
  g addEdge(DirectedEdge(1, 2, 10))
  
  g addEdge(DirectedEdge(2, 3, 10))
  
  g.edges                                         //> res0: scala.collection.immutable.IndexedSeq[com.sp.graph.DirectedEdge] = Vec
                                                  //| tor(0 --10--> 1, 1 --10--> 2, 2 --10--> 3)
  g.V                                             //> res1: Int = 4
  
  g.adj(0)                                        //> res2: scala.collection.immutable.IndexedSeq[com.sp.graph.DirectedEdge] = Vec
                                                  //| tor(0 --10--> 1)
  
  println(g.adjMat(0)(1))                         //> 10
  
  println (g toString)                            //> Array(-1, 10, -1, -1)
                                                  //| Array(-1, -1, 10, -1)
                                                  //| Array(-1, -1, -1, 10)
                                                  //| Array(-1, -1, -1, -1)
  
  val dfs = DFS(g)                                //> dfs  : com.sp.dijkstra.DFS = DFS(Array(-1, 10, -1, -1)
                                                  //| Array(-1, -1, 10, -1)
                                                  //| Array(-1, -1, -1, 10)
                                                  //| Array(-1, -1, -1, -1))
  dfs.dfs(2)
  
  dfs.path                                        //> res3: scala.collection.mutable.Stack[Int] = Stack(2, 3)
  
  g.adj(0)                                        //> res4: scala.collection.immutable.IndexedSeq[com.sp.graph.DirectedEdge] = Vec
                                                  //| tor(0 --10--> 1)
  
  val sp = SP(g, 0)                               //> sp  : com.sp.dijkstra.SP = SP(Array(-1, 10, -1, -1)
                                                  //| Array(-1, -1, 10, -1)
                                                  //| Array(-1, -1, -1, 10)
                                                  //| Array(-1, -1, -1, -1),0)
  
  sp.distTo.mkString("\n")                        //> res5: String = 2147483647
                                                  //| 2147483647
                                                  //| 2147483647
                                                  //| 2147483647
  
  sp.dijkstra()
  
  
  sp.distTo.mkString("\n")                        //> res6: String = 0
                                                  //| 10
                                                  //| 20
                                                  //| 30
}