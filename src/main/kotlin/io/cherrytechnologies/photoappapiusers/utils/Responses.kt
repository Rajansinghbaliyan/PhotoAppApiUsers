package io.cherrytechnologies.photoappapiusers.utils

import org.slf4j.Logger
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity


fun <T> T.responseOk(): ResponseEntity<T> = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(this)

fun <T> T.responseCreated(): ResponseEntity<T> =
    ResponseEntity.status(HttpStatus.CREATED).body(this)

fun <T> T.responseBadRequest(): ResponseEntity<T> =
    ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON).body(this)

fun <T> T.responseNotFound(): ResponseEntity<T> =
    ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).body(this)

fun <T> T.responseInternalError(logMessage: String? = null): ResponseEntity<T> =
    ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON).body(this)
