package com.github.tkqubo.scala_etude_01.part02

object Timer {
  def time[R](block: => R): R = {
    val t0 = System.nanoTime()
    val result = block    // call-by-name
    val t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) + "ns")
    result
  }
  def getTime[R](block: => R): Long = {
    val t0 = System.nanoTime()
    val result = block    // call-by-name
    val t1 = System.nanoTime()
    t1 - t0
  }

  def getAverageTime[R](block: => R, i: Int = 10): Long = {
    (0 until i).map(_ => getTime(block)).sum / i
  }

}
