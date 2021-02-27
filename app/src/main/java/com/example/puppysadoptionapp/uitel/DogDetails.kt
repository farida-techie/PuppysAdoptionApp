package com.example.puppysadoptionapp.uitel

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.puppysadoptionapp.R

@Composable
fun DogShowItem(c:Context,img:Int,name:String,info:String){
    MaterialTheme {
        val typography = MaterialTheme.typography
        Column(
            modifier = Modifier.padding(16.dp),
        ) {
            Card(
                modifier = Modifier
                    .padding(
                        bottom = 9.dp,
                        top = 9.dp,
                        start = 5.dp,
                        end = 5.dp
                    )
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                elevation = 16.dp
            ) {
                Image(
                    painter = painterResource(img),
                    contentDescription = null,
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(15.dp)),
                    contentScale = ContentScale.Crop
                )

            }
            Spacer(Modifier.height(16.dp))
            Text(
                name,
                modifier = Modifier
                    .padding(5.dp)
                ,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    fontSize = (25.sp)
                ),
                color = Color(R.color.titleColor),
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
            )
            Text(
                info,
                modifier = Modifier.padding(8.dp),
                style = typography.h6,
                overflow = TextOverflow.Ellipsis,
            )
            Text("Live 10 to 16 years",
                modifier = Modifier.padding(10.dp),
                style = typography.body2)
            Text("Contact Us : faridabhairakdar@gmail.com",
                modifier = Modifier.padding(10.dp)
                    .clickable(onClick = {
                        val to = "faridabhairakdar@gmail.com"
                        val subject = "This App is Very Nice "
                        val body = "I want to be this puppy"
                        val mailTo = "mailto:" + to +
                                "?&subject=" + Uri.encode(subject) +
                                "&body=" + Uri.encode(body)
                        val emailIntent = Intent(Intent.ACTION_VIEW)
                        emailIntent.data = Uri.parse(mailTo)
                        c.startActivity(emailIntent)

                    })
                ,
                style = typography.body2,

            )
        }
    }
}