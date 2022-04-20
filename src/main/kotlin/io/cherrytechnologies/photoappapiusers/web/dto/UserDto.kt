package io.cherrytechnologies.photoappapiusers.web.dto

import io.cherrytechnologies.photoappapiusers.domain.Users
import java.util.UUID

data class UserDto(
    var id:UUID?,
    val firstName:String?,
    val lastName: String?,
    val email:String?,
    val password:String?,
) {
    fun toUser() = with(this){
        Users(
            firstName = firstName,
            lastName = lastName,
            email = email,
            password = password,
        )
    }
}