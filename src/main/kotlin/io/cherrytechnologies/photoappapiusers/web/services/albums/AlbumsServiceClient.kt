package io.cherrytechnologies.photoappapiusers.web.services.albums

import io.cherrytechnologies.photoappapiusers.web.models.AlbumsResponseModel
import io.github.resilience4j.bulkhead.annotation.Bulkhead
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.util.*

@FeignClient(name = "albums-api")
interface AlbumsServiceClient {

    @CircuitBreaker(name = "albumServiceCircuitBreaker")
    @Bulkhead(
        name = "albumServiceBulkHead",
//        type = Bulkhead.Type.THREADPOOL
//        fallbackMethod = "fallBackMethodGetAlbumsByUserId"
    )
    @GetMapping("/users/{id}/albums")
    fun getAlbumsByUserId(@PathVariable id: UUID): List<AlbumsResponseModel>

//    private fun fallBackMethodGetAlbumsByUserId(id: UUID, t: Throwable) = mutableListOf<AlbumsResponseModel>()
}

//val circuitBreaker = CircuitBreaker.ofDefaults("albumServiceCircuitBreaker")
//val bulkHead = Bulkhead.ofDefaults("albumServiceBulkHead")
//
//val decorator = FeignDecorators.builder()
//    .withBulkhead(bulkHead)
//    .withCircuitBreaker(circuitBreaker)
//    .build()
//
//val albumsServiceClient = Resilience4jFeign.builder(decorator).target(AlbumsServiceClient::class.java,"albums-api")


