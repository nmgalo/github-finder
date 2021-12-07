package com.github.repo.data

import com.github.repo.data.users.model.UsersResultDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search/users")
    suspend fun searchUsers(@Query("q") keyword: String): UsersResultDTO
}
