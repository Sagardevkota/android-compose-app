package com.sagardev.mycomposeapp.ui.viewmodels;

import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sagardev.mycomposeapp.model.UserDTO
import com.sagardev.mycomposeapp.network.APIService.ApiService
import com.sagardev.mycomposeapp.network.responses.JwtResponse
import kotlinx.coroutines.launch


class LoginViewModel
@ViewModelInject()
constructor(private val apiService: ApiService) : ViewModel() {

    //this values in view model persists across screen rotation
    private val _email = MutableLiveData("")
    val email: LiveData<String> = _email
    private val _password = MutableLiveData("")
    val password: LiveData<String> = _password
    val error = mutableStateOf(false)


    private val _response:MutableLiveData<JwtResponse> = MutableLiveData(JwtResponse("","",""))
    val response: LiveData<JwtResponse> get() = _response

    fun isValid():Boolean{
       val valid = email.value?.equals("sagardevkota55@gmail.com") == true
               && password.value?.equals("sagar123") == true
        error.value = !valid
        return valid

    }

    fun login(): JwtResponse? {

        viewModelScope.launch {
           _response.value =  apiService.login(getDto())

        }
        return _response.value
    }

    private fun getDto():UserDTO{
        return UserDTO(this.email.value,this.password.value)
    }

    fun onEmailChanged(newEmail: String) {
        _email.value = newEmail
    }


    fun onPasswordChanged(newPassword: String) {
        _password.value = newPassword
    }




}