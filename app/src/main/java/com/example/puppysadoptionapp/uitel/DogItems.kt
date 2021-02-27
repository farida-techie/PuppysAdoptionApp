package com.example.puppysadoptionapp.uitel

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.puppysadoptionapp.R
import com.example.puppysadoptionapp.model.DogDatas


@Composable
fun DogCard(
    dogData: DogDatas,
    onClick:()-> Unit,
){
   Card(
       modifier = Modifier.padding(
           bottom = 9.dp,
           top = 9.dp,
           start = 5.dp,
           end = 5.dp
       )
           .fillMaxWidth()
           .clickable(onClick = onClick)
       ,
       shape =  RoundedCornerShape(19.dp),
       elevation = 16.dp,

   ) {
       Row (
               modifier = Modifier
               .clip(RoundedCornerShape(4.dp))
               .background(MaterialTheme.colors.surface)
       ){
           Surface(
               modifier = Modifier.size(130.dp),
               shape = RoundedCornerShape(16.dp),
               color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f),
               elevation = 19.dp,
               border = BorderStroke(1.dp, Color.Gray)
           ) {
                   Image(
                       painter = painterResource(dogData.dogImg),
                       contentDescription = null,
                       modifier = Modifier
                           .height(120.dp)
                           .fillMaxWidth()
                           .clip(shape = RoundedCornerShape(15.dp)),
                       contentScale = ContentScale.Crop,
                   )

           }
           Column(
               modifier = Modifier
                   .padding(start = 12.dp)
                   .align(Alignment.CenterVertically)
           ) {
               Text(text = dogData.dogName,
                   fontWeight = FontWeight.Bold,
                   style = TextStyle(
                       fontSize = (22.sp)
                   ),
                   color = Color(R.color.titleColor)
               )
               CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                   Text(text = dogData.dogInfo,
                       style = typography.body2,
                       maxLines = 1,
                       overflow = TextOverflow.Ellipsis,
                       modifier = Modifier.padding(
                           end = 25.dp
                       )
                   )
               }
           }
       }
   }
}

