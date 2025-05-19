package binary.search

import scala.annotation.tailrec
// https://leetcode.com/problems/sqrtx/description/

object SqrtX {
  private def mySqrt(x: Int): Int = {
    @tailrec
    def binarySearch(left: Long, right: Long): Long = {
      if (left > right) right
      else {
        val mid = left + (right - left) / 2
        val square = mid * mid

        if (square == x) mid
        else if (square < x) binarySearch(mid + 1, right)
        else binarySearch(left, mid - 1)
      }
    }

    if (x < 2) x
    else binarySearch(1, x).toInt
  }

  def main(args: Array[String]): Unit = {
    println(mySqrt(8))
  }
}
