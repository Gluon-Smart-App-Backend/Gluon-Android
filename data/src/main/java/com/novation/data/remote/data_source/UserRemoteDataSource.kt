package com.novation.data.remote.data_source

import com.novation.data.remote.dto.response.UserResponseDto

interface UserRemoteDataSource {
    suspend fun fetchUser(id:String): UserResponseDto
}