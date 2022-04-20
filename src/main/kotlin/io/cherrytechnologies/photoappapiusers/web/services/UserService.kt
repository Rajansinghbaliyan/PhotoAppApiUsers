package io.cherrytechnologies.photoappapiusers.web.services

import io.cherrytechnologies.photoappapiusers.customexceptions.NotFoundException
import io.cherrytechnologies.photoappapiusers.utils.OffsetBasedPageRequest
import io.cherrytechnologies.photoappapiusers.utils.logInfo
import io.cherrytechnologies.photoappapiusers.web.dto.UserDto
import io.cherrytechnologies.photoappapiusers.web.repositories.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.logging.Logger

@Service
class UserService(val userRepository: UserRepository) {

    val log: Logger = Logger.getLogger(UserService::class.toString())

    fun getUserById(id: UUID) =
        userRepository.findByIdOrNull(id)?.toUserDto()
            .logInfo(log, "/Get User Id:${id}")
            ?: throw NotFoundException("No User for this id:$id")

    fun getAllUser(limit: Int, offset: Int) =
        userRepository.findAll(OffsetBasedPageRequest(limit, offset))
            .logInfo(log, "/Get All")
            .map { it.toUserDto() }

    fun save(userDto: UserDto) =
        userRepository.save(userDto.toUser())
            .toUserDto()
            .logInfo(log, "/POST User Name:${userDto.firstName}")

    fun update(id: UUID, userDto: UserDto) = with(userRepository.findByIdOrNull(id)) {
        this ?: throw NotFoundException("User is not present with User id:$id")

        userDto.firstName?.let { firstName = userDto.firstName }
        userDto.lastName?.let { lastName = userDto.lastName }
        userDto.email?.let { email = userDto.email }
        userDto.password?.let { password = userDto.password }

        userRepository.save(this)
            .toUserDto()
            .logInfo(log, "/PUT User Id:${id}")
    }

    fun delete(id: UUID) =
        userRepository.deleteById(id)
}

