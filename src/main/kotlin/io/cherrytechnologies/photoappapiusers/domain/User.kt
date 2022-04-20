package io.cherrytechnologies.photoappapiusers.domain

import io.cherrytechnologies.photoappapiusers.web.dto.UserDto
import java.sql.Timestamp
import java.util.*
import javax.persistence.Entity

@Entity
data class User(
    override var id: UUID? = null,
    override var createdDate: Timestamp? = null,
    override var lastModifiedDate: Timestamp? = null,
    override var version: Long? = null,
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
) : Base(id, version, createdDate, lastModifiedDate) {

    fun toUserDto() = with(this) {
        UserDto(
            id = id,
            firstName = firstName,
            lastName = lastName,
            email = email,
            password = password
        )
    }
}