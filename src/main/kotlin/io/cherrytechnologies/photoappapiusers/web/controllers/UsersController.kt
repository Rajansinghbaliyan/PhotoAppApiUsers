package io.cherrytechnologies.photoappapiusers.web.controllers


import io.cherrytechnologies.photoappapiusers.utils.logInfo
import io.cherrytechnologies.photoappapiusers.utils.responseCreated
import io.cherrytechnologies.photoappapiusers.utils.responseOk
import io.cherrytechnologies.photoappapiusers.web.models.CreateUserRequest
import io.cherrytechnologies.photoappapiusers.web.models.UpdateUserModel
import io.cherrytechnologies.photoappapiusers.web.services.UserService
import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.logging.Logger
import javax.validation.Valid

@RestController
@RequestMapping("/v1/api/users")
class UsersController(var userService: UserService) {

    val log: Logger = Logger.getLogger(UsersController::class.toString())

    @GetMapping("/hello")
    fun greetings() = "Hello is working".responseOk().logInfo(log, " GET: users")

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: UUID) =
        userService
            .getUserById(id)
            .toCreateUserResponseModel()
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

    @PostMapping("/")
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