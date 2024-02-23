package ru.donorsearch.handler

import com.fasterxml.jackson.databind.exc.MismatchedInputException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingRequestValueException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import ru.donorsearch.exception.DonorSearchException
import ru.donorsearch.exception.DonorSearchInternalException
import ru.donorsearch.exception.DonorSearchNotFoundException
import ru.donorsearch.exception.DonorSearchValidationException
import ru.taskmanager.model.response.ErrorResponse
import javax.xml.bind.ValidationException

@RestControllerAdvice
class ErrorResponseHandler {

    @ExceptionHandler(value = [Throwable::class])
    fun handleException(ex: Throwable): ResponseEntity<*> {
        val e: DonorSearchException
        val status: HttpStatus

        if (ex is DonorSearchNotFoundException) {
            e = ex
            status = HttpStatus.NOT_FOUND
        } else if (ex is MethodArgumentNotValidException ||
            ex is MethodArgumentTypeMismatchException ||
            ex is MissingRequestValueException ||
            ex is ValidationException ||
            ex.cause is MismatchedInputException
        ) {
            e = DonorSearchValidationException(ex)
            status = HttpStatus.BAD_REQUEST
        } else {
            e = DonorSearchInternalException(ex)
            status = HttpStatus.INTERNAL_SERVER_ERROR
        }

        return ResponseEntity(ErrorResponse(status.reasonPhrase, e.message), status)
    }
}