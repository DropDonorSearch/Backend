package ru.donorsearch.exception

/**
 * Базовое исключение DonorSearch.
 */
open class DonorSearchException(message: String?) : RuntimeException(message) {

    companion object {
        fun throwableToString(t: Throwable): String {
            return String.format(
                "%s: %s%s",
                t.javaClass.getSimpleName(),
                t.message,
                if (t.cause == null) "" else ", cause: " + t.cause
            )
        }
    }
}