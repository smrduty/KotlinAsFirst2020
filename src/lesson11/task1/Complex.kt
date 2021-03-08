@file:Suppress("UNUSED_PARAMETER")

package lesson11.task1

/**
 * Класс "комплексное число".
 *
 * Общая сложность задания -- лёгкая, общая ценность в баллах -- 8.
 * Объект класса -- комплексное число вида x+yi.
 * Про принципы работы с комплексными числами см. статью Википедии "Комплексное число".
 *
 * Аргументы конструктора -- вещественная и мнимая часть числа.
 */
class Complex(var re: Double, var im: Double) {
    /*var realPart = re
    var imaginaryPart = im*/

    /**
     * Конструктор из вещественного числа
     */
    constructor(x: Double) : this(x, 0.0) {
        this.re = x
        this.im = 0.0
    }

    /**
     * Конструктор из строки вида x+yi
     */
    constructor(s: String) : this(0.0, 0.0) {
        val tempElements: List<String> = if ('+' in s) s.split('+') else s.split('-')
        if (s[0] == '-') {
            this.re = tempElements[1].toDouble() * -1
            this.im = tempElements[2].substring(0, endIndex = tempElements[2].length - 1)
                .toDouble() * if ('+' in s) 1 else -1
        } else if (tempElements.size > 1 && tempElements[1].length > 1) {
            this.re = tempElements[0].toDouble()
            this.im = tempElements[1].substring(0, endIndex = tempElements[1].length - 1)
                .toDouble() * if ('+' in s) 1 else -1
        } else if (tempElements[1].length == 1) {
            if ('+' in s) this.im = 1.0
            else this.im = -1.0
        } else {
            this.im = 0.0
        }
    }

    /**
     * Сложение.
     */
    operator fun plus(other: Complex): Complex =
        Complex(
            this.re + other.re,
            this.im + other.im
        )

    /**
     * Смена знака (у обеих частей числа)
     */
    operator fun unaryMinus(): Complex = Complex(this.im * -1, this.re * -1)

    /**
     * Вычитание
     */
    operator fun minus(other: Complex): Complex =
        Complex(
            "${this.re - other.re} ${
                if (this.im + other.im < 0)
                    '-' else '+'
            } ${this.im - other.im}"
        )

    /**
     * Умножение
     */
    operator fun times(other: Complex): Complex =
        Complex(
            "${this.re * other.re - this.im * other.im} ${
                if (this.re * other.im + other.re * this.im < 0) '-' else '+'
            } ${this.re * other.im + other.re * this.im}"
        )

    /**
     * Деление
     */
    operator fun div(other: Complex): Complex =
        Complex(
            "${
                (this.re * other.re + this.im * other.im) /
                        (other.re * other.re + other.im * other.im)
            } ${
                if ((other.re * this.im - this.re * other.im)
                    / (other.re * other.re + other.im * other.im) < 0
                ) '-' else '+'
            } ${
                (other.re * this.im - this.re * other.im)
                        / (other.re * other.re + other.im * other.im)
            }"
        )

    /**
     * Сравнение на равенство
     */
    override fun equals(other: Any?): Boolean {
        if (other is Complex) {
            return this.re == other.re && this.im == other.im
        }
        return false
    }

    /**
     * Преобразование в строку
     */
    override fun toString(): String = "${this.re}" + "${this.im}"

    override fun hashCode(): Int {
        var result = re.hashCode()
        result = 31 * result + im.hashCode()
        result = 31 * result + re.hashCode()
        result = 31 * result + im.hashCode()
        return result
    }
}
