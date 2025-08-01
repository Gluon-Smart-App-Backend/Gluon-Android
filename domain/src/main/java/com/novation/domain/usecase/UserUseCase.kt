package com.novation.domain.usecase

import com.novation.domain.model.UserModel
import com.novation.domain.repository.UserRepository
import javax.inject.Inject

class UserUseCase @Inject constructor(
    private val userRepository: UserRepository
){
    suspend operator fun invoke(userId:String):Result<UserModel>{
        return try {
            val user = userRepository.getUser(userId)
            Result.success(user)
        } catch (e: Exception) {
            Result.failure(e)
        }

    }

}