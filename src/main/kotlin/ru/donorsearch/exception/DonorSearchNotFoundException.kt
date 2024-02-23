package ru.donorsearch.exception

class DonorSearchNotFoundException : DonorSearchException {

    companion object {
        private const val DEFAULT_MESSAGE = "Не найдено"
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