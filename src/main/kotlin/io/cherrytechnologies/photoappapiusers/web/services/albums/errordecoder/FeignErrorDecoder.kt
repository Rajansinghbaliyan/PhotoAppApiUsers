package io.cherrytechnologies.photoappapiusers.web.services.albums.errordecoder

import feign.Response
import feign.codec.ErrorDecoder
import io.cherrytechnologies.photoappapiusers.customexceptions.InternalErrorException
import io.cherrytechnologies.photoappapiusers.customexceptions.NotFoundException
import org.springframework.core.env.Environment
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import java.lang.Exception

@Component
class FeignErrorDecoder(val env:Environment) : ErrorDecoder {
    override fun decode(methodKey: String?, p1: Response?): Exception = when (p1?.status()) {
        HttpStatus.NOT_FOUND.value() -> when {
            methodKey?.contains("getAlbumsByUserId") == true -> NotFoundException(env.getProperty("albums.exception.albums-not-found"))
            else -> NotFoundException(p1.reason())
        }
        HttpStatus.INTERNAL_SERVER_ERROR.value() -> when {
            methodKey?.contains("getAlbumsByUserId") == true -> InternalErrorException(env.getProperty("albums.exception.internal-error"))
            else -> InternalErrorException(p1.reason())
        }
        else -> Exception(p1?.reason())
    }
}