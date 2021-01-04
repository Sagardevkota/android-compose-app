package com.sagardev.mycomposeapp.network.responses

data class JwtResponse(
    val jwt:String,
    val status:String,
    val message:String
    )