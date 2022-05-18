package io.cherrytechnologies.photoappapiusers.web.services;

import io.cherrytechnologies.photoappapiusers.web.models.AlbumsResponseModel;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@FeignClient(name = "albums-api")
public interface AlbumsServiceClient {

    @CircuitBreaker(name = "albumServiceCircuitBreaker", fallbackMethod = "fallBackMethodGetAlbumsByUserId")
    @Bulkhead(
            name = "albumServiceBulkHead",
//        type = Bulkhead.Type.THREADPOOL
        fallbackMethod = "fallBackMethodGetAlbumsByUserId"
    )
    @GetMapping("/users/{id}/albums")
    List<AlbumsResponseModel> getAlbumsByUserId(@PathVariable UUID id);

    default List<AlbumsResponseModel> fallBackMethodGetAlbumsByUserId(UUID id,Throwable t) {
        return new ArrayList<>();
    }
}


