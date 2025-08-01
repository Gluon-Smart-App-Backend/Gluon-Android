package com.novation.data.remote.data_source

import com.novation.data.remote.dto.response.UserResponseDto
import com.novation.data.remote.service.QrApiService
import javax.inject.Inject

class UserRemoteDataSourceImpl @Inject constructor(
    private val apiService: QrApiService
) : UserRemoteDataSource {
    override suspend fun fetchUser(id:String): UserResponseDto {
        return apiService.getUserById(id)
    }
}