package com.sagardev.mycomposeapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sagardev.mycomposeapp.R
import androidx.navigation.fragment.findNavController
import com.sagardev.mycomposeapp.ui.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val TAG = "LoginFragment"

    private val viewModel: LoginViewModel by viewModels()


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment

        return ComposeView(requireContext()).apply {
            setContent {

                val email = viewModel.email.observeAsState("")
                val password = viewModel.password.observeAsState("")

                Column(
                        modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 16.dp, vertical = 8.dp),
                        Arrangement.spacedBy(8.dp)
                )
                {
                    Text(modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                            text = "SIGN IN",
                            color = MaterialTheme.colors.primaryVariant,
                        style = MaterialTheme.typography.h4
                    )

                    OutlinedTextField(modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                        value = email.value,
                        isErrorValue = viewModel.error.value,
                        leadingIcon = { Icon(Icons.Filled.Email) },
                        onValueChange = {
                            viewModel.onEmailChanged(it)
                        },
                        label = { Text("Enter your email") }
                    )
                    OutlinedTextField(modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally),
                        isErrorValue = viewModel.error.value,
                        leadingIcon = { Icon(Icons.Filled.Lock) },
                        visualTransformation = PasswordVisualTransformation(),

                            value = password.value, onValueChange = {
                        viewModel.onPasswordChanged(it)
                    },
                            label = { Text("Enter your password") }

                    )

                    if (viewModel.error.value){
                        Text(text = "Please enter correct/valid username or password",
                            color = MaterialTheme.colors.error,
                            style = MaterialTheme.typography.overline
                        )
                    }



                    Button(modifier = Modifier
                        .padding(top = 8.dp)
                            .fillMaxWidth()
                            .height(50.dp),
                            onClick = {
                                if (viewModel.isValid())
                                    this@LoginFragment
                                            .findNavController()
                                            .navigate(R.id.nav_to_home)

                            }) {
                        Text(text = "Login")

                    }
                }
            }

        }

    }


}