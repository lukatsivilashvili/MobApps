fun main() {

    val f1 = Fraction(3F, 4F)


    val f2 = Fraction(6F, 4F)

    println(f1 == f2)

    println(f1)

    println(f1.gayofa(f2))

    println(f1.gamravleba(5F))

    println(f1.shekveca(15F))

    println(f1.shekreba(f2))

}

class Fraction(n: Float, d: Float) {

    private var numerator: Float = n
    private var denominator: Float = d

    override fun equals(other: Any?): Boolean {
        if (other is Fraction) {
            if (numerator * other.denominator / denominator == other.numerator) {
                return true
            }
        }
        return false
    }

    override fun toString(): String {
        return "$numerator/$denominator"
    }

    fun gamravleba(samravli:Float):Fraction {
        return Fraction(numerator * samravli, denominator * samravli)
    }

    fun gayofa(gamyofi: Fraction):Fraction {
        return Fraction(numerator * gamyofi.denominator, denominator * gamyofi.numerator)

    }

    fun shekveca(shemkveci:Float):Fraction {
        return Fraction(numerator/shemkveci, denominator/shemkveci)
    }

    fun shekreba(damateba:Fraction):Fraction {
        return Fraction((denominator*damateba.denominator)/denominator * numerator + (denominator*damateba.denominator)/damateba.denominator * damateba.numerator, denominator*damateba.denominator )

    }


}