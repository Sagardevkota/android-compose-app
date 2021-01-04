package com.sagardev.mycomposeapp.navigation

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sagardev.mycomposeapp.R
import java.security.InvalidParameterException

enum class Screen { Welcome, SignUp, SignIn, Survey,Home }


object Navigation {
    fun Fragment.navigate(to: Screen, from: Screen) {
        if (to == from) {
            throw InvalidParameterException("Can't navigate to $to")
        }
        when (to) {

            Screen.SignUp ->{

            }

            Screen.Home -> {
                findNavController().navigate(R.id.nav_to_home)
            }

        }
    }
}




