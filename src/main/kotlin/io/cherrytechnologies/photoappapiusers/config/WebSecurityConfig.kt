package io.cherrytechnologies.photoappapiusers.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
class WebConfig: WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity?) {
        http?.csrf()?.disable()
        http?.cors()?.disable()

        http?.authorizeRequests()
            ?.antMatchers("/v1/api/users/**")
            ?.permitAll()
    }
}