package io.cherrytechnologies.photoappapiusers.web.models

import io.cherrytechnologies.photoappapiusers.web.dto.UserDto
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size


open class CreateUserRequest(
    @field:NotNull(message = "please provide the first name.")
    @field:Size(min = 2, message = "first name must be greater than 2")
    val firstName:String,

    @field:NotNull(message = "please provide the last name.")
    @field:Size(min = 2, message = "first name must be greater than 2")
    val lastName:String,

    @field:NotNull(message = "please provide email.")
    @field:Email
    val email:String,

    @field:NotNull(message = "password can't be empty")
    @field:Size(min = 8, message = "password should be 8 character long")
    val password:String,
) {
    fun toUserDto() = with(this ){
        UserDto(
            null,
            firstName,
            lastName,
            email,
            password,
            null
        )
    }
}
