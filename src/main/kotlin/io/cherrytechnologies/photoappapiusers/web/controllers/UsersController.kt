package io.cherrytechnologies.photoappapiusers.web.controllers

import io.cherrytechnologies.photoappapiusers.utils.logInfo
import io.cherrytechnologies.photoappapiusers.utils.responseOk
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.logging.Logger

@RestController
@RequestMapping("/v1/api/users")
class UsersController {

    val log: Logger = Logger.getLogger(UsersController::class.toString())

    @GetMapping("/hello")
    fun greetings() = "Hello is working".responseOk().logInfo(log," GET: users")
}