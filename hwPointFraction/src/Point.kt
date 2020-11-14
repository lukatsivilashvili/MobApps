
fun main() {
    val dot = Point()
    dot.x = 35
    dot.y = -20
    println(dot.toString())

    println(dot.x == dot.y)
    println(dot.move(dot.x, dot.y))

}

class Point {

    var x:Int = 0
    var y:Int = 0

    override fun toString(): String {
        return "$x; $y"
    }

    override fun equals(other: Any?): Boolean {
        if (other is Point) {
            if (x == other.y) {
                return true
            }
        }
        return false
    }

    fun move(x: Int, y: Int):String {
        return "${this.x}; ${-this.y}"
    }
}