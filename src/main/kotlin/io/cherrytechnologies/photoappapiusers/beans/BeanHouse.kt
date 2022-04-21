package io.cherrytechnologies.photoappapiusers.beans

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
class BeanHouse {
    @Bean
    fun encoder() = BCryptPasswordEncoder()
}

