package xyz.malefic.compose.style

/**
 * Extension function to create a Triple from a Pair and an additional value.
 *
 * @param third the third value to be added to the Pair
 * @return a Triple containing the values from the Pair and the additional value
 */
infix fun <A, B, C> Pair<A, B>.to(third: C): Triple<A, B, C> = Triple(first, second, third)

/**
 * A data class representing a triple of values.
 *
 * @param A the type of the first value
 * @param B the type of the second value
 * @param C the type of the third value
 * @property first the first value
 * @property second the second value
 * @property third the third value
 */
data class Triple<A, B, C>(
    val first: A,
    val second: B,
    val third: C,
) {
    /**
     * Extension function to create a Quadruple from a Triple and an additional value.
     *
     * @param other the fourth value to be added to the Triple
     * @return a Quadruple containing the values from the Triple and the additional value
     */
    infix fun to(other: C): Quadruple<A, B, C, C> = Quadruple(first, second, third, other)
}

/**
 * A data class representing a quadruple of values.
 *
 * @param A the type of the first value
 * @param B the type of the second value
 * @param C the type of the third value
 * @param D the type of the fourth value
 * @property first the first value
 * @property second the second value
 * @property third the third value
 * @property fourth the fourth value
 */
data class Quadruple<A, B, C, D>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D,
) {
    /**
     * Extension function to create a Quintuple from a Quadruple and an additional value.
     *
     * @param other the fifth value to be added to the Quadruple
     * @return a Quintuple containing the values from the Quadruple and the additional value
     */
    infix fun to(other: D): Quintuple<A, B, C, D, D> = Quintuple(first, second, third, fourth, other)
}

/**
 * A data class representing a quintuple of values.
 *
 * @param A the type of the first value
 * @param B the type of the second value
 * @param C the type of the third value
 * @param D the type of the fourth value
 * @param E the type of the fifth value
 * @property first the first value
 * @property second the second value
 * @property third the third value
 * @property fourth the fourth value
 * @property fifth the fifth value
 */
data class Quintuple<A, B, C, D, E>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D,
    val fifth: E,
)
