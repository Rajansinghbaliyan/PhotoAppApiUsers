package io.cherrytechnologies.photoappapiusers.web.repositories

import io.cherrytechnologies.photoappapiusers.domain.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UserRepository: JpaRepository<Users,UUID>