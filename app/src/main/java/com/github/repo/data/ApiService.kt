package com.github.repo.data

import com.github.repo.data.repos.UserRepositoriesDTO
import com.github.repo.data.users.model.UserProfileDTO
import com.github.repo.data.users.model.UsersResultDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("search/users")
    suspend fun searchUsers(@Query("q") keyword: String): UsersResultDTO

    @GET("users/{userName}")
    suspend fun getUserProfile(@Path("userName") userName: String): UserProfileDTO

    @GET("users/{userName}/repos")
    suspend fun getUserRepos(@Path("userName") userName: String): List<UserRepositoriesDTO>
}
