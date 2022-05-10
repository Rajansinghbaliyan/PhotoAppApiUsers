package io.cherrytechnologies.photoappapiusers.config

import io.cherrytechnologies.photoappapiusers.utils.logInfo
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
class WebConfig : WebSecurityConfigurerAdapter() {

    val log = LoggerFactory.getLogger(WebConfig::class.java.toString())

    @Value("\${gateway.ip}")
    var gateWayIp: String? = null

    override fun configure(http: HttpSecurity?) {
        http?.csrf()?.disable()
        http?.cors()?.disable()

        http?.authorizeRequests()
            ?.antMatchers("/**")
            ?.hasIpAddress(gateWayIp)
            .logInfo(log,"The gateway IP is: $gateWayIp")
    }
}