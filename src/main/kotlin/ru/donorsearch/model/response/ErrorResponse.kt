package ru.taskmanager.model.response

/**
 * Ответ сервиса после выполнения запроса.
 *
 * @param status  Статус ответа.
 * @param message Описание ответа.
 */
data class ErrorResponse(val status: String, val message: String?)