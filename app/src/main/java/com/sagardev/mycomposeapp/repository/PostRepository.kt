package com.sagardev.mycomposeapp.repository

import com.sagardev.mycomposeapp.mapper.PostMapper
import com.sagardev.mycomposeapp.model.Post
import com.sagardev.mycomposeapp.model.Poster
import com.sagardev.mycomposeapp.network.APIService.ApiService

class PostRepository(private val postMapper: PostMapper,private val apiService: ApiService):PostDAO {

    override suspend fun getPosts(): List<Post> {
       return postMapper.toEntityList(apiService.getPosts())
    }

    suspend fun getPosters():List<Poster>{
        return apiService.getDisneyLists()
    }
}