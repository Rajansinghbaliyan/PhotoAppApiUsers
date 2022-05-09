package io.cherrytechnologies.photoappapiusers.web.models

import java.util.UUID

class UserResponseModel(
    var userId: UUID?,
    var firstName: String?,
    var lastName: String?,
    var email :String?,
    var albums: List<AlbumsResponseModel>?
)