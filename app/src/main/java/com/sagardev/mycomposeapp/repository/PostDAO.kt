package com.sagardev.mycomposeapp.repository

import com.sagardev.mycomposeapp.model.Post

interface PostDAO{

    suspend fun getPosts():List<Post>
}