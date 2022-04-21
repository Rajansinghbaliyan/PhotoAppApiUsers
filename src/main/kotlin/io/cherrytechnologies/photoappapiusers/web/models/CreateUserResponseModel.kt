package io.cherrytechnologies.photoappapiusers.web.models

import java.util.UUID

data class CreateUserResponseModel(
    val id:UUID?,
    val firstName:String?,
    val lastName:String?,
)
