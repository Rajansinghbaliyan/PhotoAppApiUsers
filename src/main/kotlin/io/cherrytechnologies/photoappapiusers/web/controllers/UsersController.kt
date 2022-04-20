package io.cherrytechnologies.photoappapiusers.web.controllers

import io.cherrytechnologies.photoappapiusers.utils.responseOk
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/api/users")
class UsersController {

    @GetMapping("/hello")
    fun greetings() = "Hello is working".responseOk()
}