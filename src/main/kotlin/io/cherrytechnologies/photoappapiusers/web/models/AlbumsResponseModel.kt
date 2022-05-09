package io.cherrytechnologies.photoappapiusers.web.models

import java.util.UUID

class AlbumsResponseModel(
    var albumId:String,
    var userId:UUID,
    var name:String,
    var description:String,
)