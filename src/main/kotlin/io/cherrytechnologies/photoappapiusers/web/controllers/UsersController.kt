package io.cherrytechnologies.photoappapiusers.web.controllers


import io.cherrytechnologies.photoappapiusers.utils.logInfo
import io.cherrytechnologies.photoappapiusers.utils.responseCreated
import io.cherrytechnologies.photoappapiusers.utils.responseOk
import io.cherrytechnologies.photoappapiusers.web.models.CreateUserRequest
import io.cherrytechnologies.photoappapiusers.web.models.UpdateUserModel
import io.cherrytechnologies.photoappapiusers.web.services.UserService
import org.jetbrains.annotations.NotNull
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.logging.Logger
import javax.validation.Valid
import javax.ws.rs.core.MediaType

@RestController
@RequestMapping("/users")
class UsersController(var userService: UserService, val env: Environment) {

    val log: Logger = Logger.getLogger(UsersController::class.toString())

    @GetMapping("/status/check")
    fun statusCheck() =
        "It's running and the Token expiration is: ${env.getProperty("jwt.expiration")}"
            .responseOk()
            .logInfo(log)

    @GetMapping("/hello")
    fun greetings() = "Hello is working".responseOk().logInfo(log, " GET: users")

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: UUID) =
        userService
            .getUserById(id)
            .toUserResponseModel()
            .responseOk()

    @GetMapping("/")
    fun getAll(
        @RequestParam start: Int?,
        @RequestParam limit: Int?
    ) =
        userService
            .getAllUser(limit ?: 5, start ?: 0)
            .map { it.toCreateUserResponseModel() }
            .responseOk()

    @PostMapping(
        "/register",
        consumes = [MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON],
        produces = [MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON]
    )
    fun saveUser(
        @Valid
        @RequestBody
        createUserModel: CreateUserRequest
    ) =
        userService
            .save(createUserModel.toUserDto())
            .toCreateUserResponseModel()
            .responseCreated()

    @PutMapping("/{id}")
    fun updateUser(
        @PathVariable
        @NotNull
        id: UUID,

        @Valid
        @RequestBody
        updateUserModel: UpdateUserModel
    ) =
        userService
            .update(id, updateUserModel.toUserDto())
            .toCreateUserResponseModel()
            .responseCreated()

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: UUID) = userService.delete(id).responseOk()
}