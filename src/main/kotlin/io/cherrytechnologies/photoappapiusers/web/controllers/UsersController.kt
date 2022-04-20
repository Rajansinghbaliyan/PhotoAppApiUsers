package io.cherrytechnologies.photoappapiusers.web.controllers


import io.cherrytechnologies.photoappapiusers.utils.logInfo
import io.cherrytechnologies.photoappapiusers.utils.responseCreated
import io.cherrytechnologies.photoappapiusers.utils.responseOk
import io.cherrytechnologies.photoappapiusers.web.dto.UserDto
import io.cherrytechnologies.photoappapiusers.web.services.UserService
import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.logging.Logger

@RestController
@RequestMapping("/v1/api/users")
class UsersController(var userService: UserService) {

    val log: Logger = Logger.getLogger(UsersController::class.toString())

    @GetMapping("/hello")
    fun greetings() = "Hello is working".responseOk().logInfo(log, " GET: users")

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: UUID) =
        userService.getUserById(id).responseOk()

    @GetMapping("/")
    fun getAll(@RequestParam start: Int = 0, @RequestParam limit: Int = 5) =
        userService.getAllUser(limit, start).responseOk()

    @PostMapping("/")
    fun saveUser(@RequestBody userDto: UserDto) = userService.save(userDto).responseCreated()

    @PutMapping("/{id}")
    fun updateUser(
        @PathVariable
        @NotNull id: UUID,
        @RequestBody userDto: UserDto
    ) = userService.update(id, userDto)

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: UUID) = userService.delete(id).responseOk()
}