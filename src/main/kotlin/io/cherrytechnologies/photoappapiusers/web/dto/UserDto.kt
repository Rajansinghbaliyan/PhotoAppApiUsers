package io.cherrytechnologies.photoappapiusers.web.dto

import io.cherrytechnologies.photoappapiusers.domain.Users
import io.cherrytechnologies.photoappapiusers.web.models.AlbumsResponseModel
import io.cherrytechnologies.photoappapiusers.web.models.CreateUserRequest
import io.cherrytechnologies.photoappapiusers.web.models.CreateUserResponseModel
import io.cherrytechnologies.photoappapiusers.web.models.UserResponseModel
import java.util.*

data class UserDto(
    var id: UUID?,
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val password: String?,
    var albumsList: List<AlbumsResponseModel>?
) {
    fun toUser() = with(this) {
        Users(
            firstName = firstName,
            lastName = lastName,
            email = email,
            password = password,
        )
    }

    fun toCreateUserResponseModel() = with(this) {
        CreateUserResponseModel(
            id,
            firstName,
            lastName
        )
    }

    fun toUserResponseModel() = with(this){
        UserResponseModel(
            userId = id,
            firstName = firstName,
            lastName = lastName,
            email = email,
            albums = albumsList,
        )
    }
}