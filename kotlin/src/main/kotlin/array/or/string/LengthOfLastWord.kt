package array.or.string
// https://leetcode.com/problems/length-of-last-word/description/

class LengthOfLastWord {
    fun lengthOfLastWord(s: String): Int {
        if (s.isEmpty()) return 0

        var firstCharInd = -1
        var lastCharInd = -1

        for (i in s.lastIndex downTo 0) {
            if (s[i].isLetter() && lastCharInd == -1) {
                lastCharInd = i
            } else if (s[i] == ' ' && lastCharInd != -1) {
                firstCharInd = i + 1
                break
            }
        }

        if (firstCharInd == -1) {
            firstCharInd = 0
        }

        return lastCharInd - firstCharInd + 1
    }
}

fun main() {
    val sol = LengthOfLastWord()
    println(sol.lengthOfLastWord("   fly me   to   the    moon  "))
}
