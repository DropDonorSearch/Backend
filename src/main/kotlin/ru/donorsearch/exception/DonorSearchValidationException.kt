package ru.donorsearch.exception

class DonorSearchValidationException : DonorSearchException {

    companion object {
        private const val DEFAULT_MESSAGE = "Ошибка валидации"
    }

    constructor(message: String?) : super(message)

    constructor(cause: Throwable?) : super(
        java.lang.String.format(
            "%s: %s",
            DEFAULT_MESSAGE,
            throwableToString(cause!!)
        )
    )

    constructor(message: String?, cause: Throwable?) : super(
        java.lang.String.format(
            "%s: %s",
            message,
            throwableToString(cause!!)
        )
    )
}