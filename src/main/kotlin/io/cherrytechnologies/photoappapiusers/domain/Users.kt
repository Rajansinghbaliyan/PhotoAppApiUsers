package io.cherrytechnologies.photoappapiusers.domain

import io.cherrytechnologies.photoappapiusers.web.dto.UserDto
import java.sql.Timestamp
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.UniqueConstraint

@Entity
data class Users(
    override var id: UUID? = null,
    override var createdDate: Timestamp? = null,
    override var lastModifiedDate: Timestamp? = null,
    override var version: Long? = null,
    var firstName: String?,
    var lastName: String?,
    @Column(unique = true)
    var email: String?,
    var password: String?,
) : Base(id, version, createdDate, lastModifiedDate) {

    fun toUserDto() = with(this) {
        UserDto(
            id = id,
            firstName = firstName,
            lastName = lastName,
            email = email,
            password = password,
            albumsList = null
        )
    }
}