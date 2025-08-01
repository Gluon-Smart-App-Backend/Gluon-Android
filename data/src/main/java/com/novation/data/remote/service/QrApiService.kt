package com.novation.data.remote.service

import com.novation.data.remote.dto.response.UserResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface QrApiService {
    @GET("api/users/{id}")
    suspend fun getUserById(
        @Path("id") id: String
    ): UserResponseDto

    @GET("api/users/{id}/qr")
    suspend fun getUserQrById(
        @Path("id") id: String
    ): UserResponseDto
}