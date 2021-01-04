package com.sagardev.mycomposeapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.platform.ComposeView
import androidx.navigation.fragment.navArgs
import com.sagardev.mycomposeapp.R
import com.sagardev.mycomposeapp.model.Poster
import com.sagardev.mycomposeapp.presentation.components.DetailedCard


class DetailsFragment : Fragment() {

    val args: DetailsFragmentArgs by navArgs()
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return ComposeView(requireContext()).apply {
            setContent {
                DetailedCard(posts = args.poster)
            }

        }
    }


}