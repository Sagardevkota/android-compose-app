package com.sagardev.mycomposeapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.sagardev.mycomposeapp.R
import com.sagardev.mycomposeapp.model.Poster
import com.sagardev.mycomposeapp.utils.loadPicture

@Composable
fun PostCard(
        posts: Poster,
        onClick:()->Unit
){
    Card(
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                    .padding(
                            bottom = 6.dp,
                            top = 6.dp
                    )
                    .clickable(onClick = onClick),
            elevation = 8.dp,
    ){
        Column() {
            posts.poster.let { url->
                val image = loadPicture(url = url, defaultImage = R.drawable.loading )
                image.value?.let {
                    Image(bitmap = it.asImageBitmap(),
                            modifier = Modifier
                                .fillMaxWidth()
                                .preferredHeight(150.dp),
                            contentScale = ContentScale.Crop,

                    )
                }
            }

            posts.name.let {
                title -> Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp,
                            bottom = 12.dp,
                            start = 8.dp,
                            end = 8.dp)
            ) {
                Text(
                        text = title,
                        modifier = Modifier
                                .fillMaxWidth(0.85f)
                                .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.h5
                )
            }
            }

        }




    }

}