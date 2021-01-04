package com.sagardev.mycomposeapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.sagardev.mycomposeapp.R
import com.sagardev.mycomposeapp.navigation.Navigation.navigate
import com.sagardev.mycomposeapp.presentation.components.CircularProgressBar
import com.sagardev.mycomposeapp.presentation.components.PostCard
import com.sagardev.mycomposeapp.presentation.components.custom.StaggeredVerticalGrid
import com.sagardev.mycomposeapp.ui.viewmodels.HomeViewModel
import com.sagardev.mycomposeapp.ui.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private val TAG = "Homefragment"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        return ComposeView(requireContext()).apply {
            setContent {

                val posters = viewModel.posters.value
                CircularProgressBar(shouldDisplay = viewModel.loading.value)
                LazyColumn {
                   itemsIndexed(items = posters,
                   ){
                       index, post ->
                       run {
                               PostCard(posts = post ,onClick = {
                                   val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(post)
                                   findNavController().navigate(action)
                               })


                       }
                   }

                }
            }
        }
    }
}