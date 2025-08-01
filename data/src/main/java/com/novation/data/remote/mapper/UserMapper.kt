package com.novation.data.remote.mapper

import com.novation.data.remote.dto.response.UserResponseDto
import com.novation.domain.model.UserModel

fun UserResponseDto.toDomain(): UserModel = UserModel(
    id = this.id,
    userName = this.userName,
    email = this.email,
    bio = this.bio,
)