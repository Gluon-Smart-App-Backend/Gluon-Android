package com.novation.data.repositories

import com.novation.data.remote.mapper.toDomain
import com.novation.data.remote.service.QrApiService
import com.novation.domain.model.UserModel
import com.novation.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val apiService: QrApiService
) : UserRepository {
    override suspend fun getUser(id:String): UserModel {
        return apiService.getUserById(id).toDomain()
    }


}