package io.cherrytechnologies.photoappapiusers.web.controllers

import io.cherrytechnologies.photoappapiusers.customexceptions.BadRequestException
import io.cherrytechnologies.photoappapiusers.customexceptions.InternalErrorException
import io.cherrytechnologies.photoappapiusers.customexceptions.NotFoundException
import io.cherrytechnologies.photoappapiusers.types.Message
import io.cherrytechnologies.photoappapiusers.utils.responseBadRequest
import io.cherrytechnologies.photoappapiusers.utils.responseInternalError
import io.cherrytechnologies.photoappapiusers.utils.responseNotFound
import org.springframework.web.bind.annotation.ExceptionHandler

@org.springframework.web.bind.annotation.ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(value = [NotFoundException::class])
    fun notFoundExceptionHandler(e: NotFoundException) = Message(e.toString()).responseNotFound()

    @ExceptionHandler(value = [BadRequestException::class])
    fun badRequestExceptionHandler(e: BadRequestException) = Message(e.toString()).responseBadRequest()

    @ExceptionHandler(value = [InternalErrorException::class])
    fun internalErrorExceptionHandler(e: InternalErrorException) = Message(e.toString()).responseInternalError()

    @ExceptionHandler(value = [Exception::class])
    fun globalExceptionHandler(e: Exception) = Message(e.message.toString()).responseInternalError(e.stackTraceToString())
}


