package com.sagardev.mycomposeapp.ui.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sagardev.mycomposeapp.model.Post
import com.sagardev.mycomposeapp.model.Poster
import com.sagardev.mycomposeapp.repository.PostRepository
import kotlinx.coroutines.launch

class HomeViewModel
@ViewModelInject
 constructor(private val postRepository: PostRepository)
    :ViewModel(){

    val posts: MutableState<List<Post>> = mutableStateOf(ArrayList())
    val posters: MutableState<List<Poster>> = mutableStateOf(ArrayList())
    val loading: MutableState<Boolean> = mutableStateOf(false)


    init {
        loadPosters()
    }

//    private fun loadPosts() {
//        viewModelScope.launch {
//            posts.value = postRepository.getPosts()
//        }
//    }

    private fun loadPosters(){
        viewModelScope.launch {
            loading.value = true
            try{
                posters.value = postRepository.getPosters()
            }
            catch (e:Exception){
                Log.e("","${e.message}")
            }

            loading.value = false
        }

    }
}