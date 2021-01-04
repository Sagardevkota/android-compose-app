package com.sagardev.mycomposeapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.sagardev.mycomposeapp.R
import com.sagardev.mycomposeapp.model.Poster
import com.sagardev.mycomposeapp.utils.loadPicture

@Composable
 fun DetailedCard(posts: Poster){
     ScrollableColumn() {
         posts.poster.let { url->
             val image = loadPicture(url = url, defaultImage = R.drawable.loading )

             image.value?.let {
                 Image(bitmap = it.asImageBitmap(),
                     modifier = Modifier.
                     fillMaxWidth()
                         .preferredHeight(300.dp),
                     contentScale = ContentScale.FillWidth
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

         Row(modifier = Modifier.fillMaxWidth()
             .padding(start = 8.dp),
             horizontalArrangement = Arrangement.spacedBy(20.dp)
         ) {
             Text(text = "Release Date: ${posts.release}",
                 style = MaterialTheme.typography.caption
             )
             Text(text = "Play Time: ${posts.playtime}",
                 style = MaterialTheme.typography.caption)


         }



         Text(
             text = posts.description,
             modifier = Modifier
                 .padding(start = 8.dp,top = 8.dp,end = 8.dp)
                 .fillMaxWidth()
                 .wrapContentWidth(Alignment.Start),
             style = MaterialTheme.typography.body1
         )

         Text(
             text = posts.plot,
             modifier = Modifier
                 .padding(8.dp)
                 .fillMaxWidth()
                 .wrapContentWidth(Alignment.Start),
             style = MaterialTheme.typography.overline
         )
     }
 }