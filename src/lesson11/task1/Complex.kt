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

    /**
     * Конструктор из вещественного числа
     */
    constructor(x: Double) : this(x, 0.0)

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
    operator fun plus(other: Complex): Complex = TODO()

    /**
     * Смена знака (у обеих частей числа)
     */
    operator fun unaryMinus(): Complex = TODO()

    /**
     * Вычитание
     */
    operator fun minus(other: Complex): Complex = TODO()

    /**
     * Умножение
     */
    operator fun times(other: Complex): Complex = TODO()

    /**
     * Деление
     */
    operator fun div(other: Complex): Complex = TODO()

    /**
     * Сравнение на равенство
     */
    override fun equals(other: Any?): Boolean = TODO()
    override fun hashCode(): Int {
        return super.hashCode()
    }

    /**
     * Преобразование в строку
     */
    override fun toString(): String = TODO()
}
