package com.novation.domain.repository

import com.novation.domain.model.UserModel

interface UserRepository {
    suspend fun getUser(id:String):UserModel
}