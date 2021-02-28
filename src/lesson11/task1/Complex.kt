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
class Complex(val re: Double, val im: Double) {
    var realPart = re
    var imaginaryPart = im

    /**
     * Конструктор из вещественного числа
     */
    constructor(x: Double) : this(x, 0.0) {
        this.realPart = x
        this.imaginaryPart = 0.0
    }

    /**
     * Конструктор из строки вида x+yi
     */
    constructor(s: String) : this(0.0, 0.0) {
        val tempElements: List<String> = if ('+' in s) s.split('+') else s.split('-')
        this.realPart = tempElements[0].toDouble()
        if (tempElements.size > 1 && tempElements[1].length > 1) {
            if ('+' in s) {
                this.imaginaryPart = tempElements[1].substring(0, endIndex = tempElements[1].length - 1)
                    .toDouble()
            } else this.imaginaryPart = tempElements[1].substring(0, endIndex = tempElements[1].length - 1)
                .toDouble() * -1
        } else {
            if ('+' in s) this.imaginaryPart = 1.0
            else this.imaginaryPart = -1.0
        }
    }

    /**
     * Сложение.
     */
    operator fun plus(other: Complex): Complex =
        Complex(
            "${this.realPart + other.realPart} ${
                if (this.imaginaryPart + other.imaginaryPart < 0)
                    '-' else '+'
            } ${this.imaginaryPart + other.imaginaryPart}"
        )

    /**
     * Смена знака (у обеих частей числа)
     */
    operator fun unaryMinus(): Complex = Complex(this.imaginaryPart * -1, this.realPart * -1)

    /**
     * Вычитание
     */
    operator fun minus(other: Complex): Complex =
        Complex(
            "${this.realPart - other.realPart} ${
                if (this.imaginaryPart + other.imaginaryPart < 0)
                    '-' else '+'
            } ${this.imaginaryPart - other.imaginaryPart}"
        )

    /**
     * Умножение
     */
    operator fun times(other: Complex): Complex =
        Complex(
            "${this.realPart * other.realPart - this.imaginaryPart * other.imaginaryPart} ${
                if (this.realPart * other.imaginaryPart + other.realPart * this.imaginaryPart < 0) '-' else '+'
            } ${this.realPart * other.imaginaryPart + other.realPart * this.imaginaryPart}"
        )

    /**
     * Деление
     */
    operator fun div(other: Complex): Complex =
        Complex(
            "${
                (this.realPart * other.realPart + this.imaginaryPart * other.imaginaryPart) /
                        (other.realPart * other.realPart + other.imaginaryPart * other.imaginaryPart)
            } ${
                if ((other.realPart * this.imaginaryPart - this.realPart * other.imaginaryPart)
                    / (other.realPart * other.realPart + other.imaginaryPart * other.imaginaryPart) < 0
                ) '-' else '+'
            } ${
                (other.realPart * this.imaginaryPart - this.realPart * other.imaginaryPart)
                        / (other.realPart * other.realPart + other.imaginaryPart * other.imaginaryPart)
            }"
        )

    /**
     * Сравнение на равенство
     */
    override fun equals(other: Any?): Boolean {
        if (other is Complex) {
            return this.realPart == other.realPart && this.imaginaryPart == other.imaginaryPart
        }
        return false
    }

    /**
     * Преобразование в строку
     */
    override fun toString(): String {
        var str = ""
        str += "${this.realPart}" + if (this.imaginaryPart < 0) '-' else '+' + "${this.imaginaryPart}"
        return str
    }

    override fun hashCode(): Int {
        var result = re.hashCode()
        result = 31 * result + im.hashCode()
        result = 31 * result + realPart.hashCode()
        result = 31 * result + imaginaryPart.hashCode()
        return result
    }
}
