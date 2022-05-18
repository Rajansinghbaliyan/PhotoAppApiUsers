package io.cherrytechnologies.photoappapiusers.beans

import feign.Logger
import io.cherrytechnologies.photoappapiusers.web.services.albums.errordecoder.FeignErrorDecoder
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.client.RestTemplate

@Configuration
class BeanHouse {
    @Bean
    fun encoder() = BCryptPasswordEncoder()

    @Bean
    @LoadBalanced
    fun getRestTemplate() = RestTemplate()

    @Bean
    fun getLogger() = Logger.Level.FULL

    @Bean
    fun getFeignErrorDecoder() = FeignErrorDecoder()
}

