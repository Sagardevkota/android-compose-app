package com.sagardev.mycomposeapp.network.APIService

import com.sagardev.mycomposeapp.model.PostDTO
import com.sagardev.mycomposeapp.model.Poster
import com.sagardev.mycomposeapp.model.UserDTO
import com.sagardev.mycomposeapp.network.responses.JwtResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST


interface ApiService {

    @POST("/login")
    suspend fun login(@Body userDTO: UserDTO):JwtResponse

    @GET("/posts")
    suspend fun getPosts():List<PostDTO>

    @GET("DisneyPosters.json")
    suspend fun getDisneyLists():List<Poster>
}