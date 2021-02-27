package com.example.puppysadoptionapp

import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceActivity
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.contextaware.ContextAware
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.core.content.ContextCompat
import com.example.puppysadoptionapp.model.DogDatas
import com.example.puppysadoptionapp.uitel.DogCard
import com.example.puppysadoptionapp.view.DogInfoActivity
import com.example.puppysadoptionapp.viewmodel.DogViewModel
import java.lang.reflect.Modifier
import java.nio.file.Files.size

class MainActivity : AppCompatActivity() {
    private val dogView:DogViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetDogCard()

        }
    }

    @Preview
    @Composable
    fun SetDogCard(){
        val dogDatas = dogView.dogList.value
       setPuppysList(puppyList = dogDatas!!)


    }
    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun setPuppysList(puppyList: List<DogDatas>){
        LazyColumn{
            itemsIndexed(items =puppyList){index, itemPuppy ->
                      DogCard(dogData =itemPuppy , onClick = {
                          /**set Intent*/
                          val dogIntent = Intent(this@MainActivity, DogInfoActivity::class.java)
                          dogIntent.putExtra("DogImgS",itemPuppy.dogImg)
                          dogIntent.putExtra("DogNames", itemPuppy.dogName)
                          dogIntent.putExtra("DogInfoS", itemPuppy.dogInfo)
                          startActivity(dogIntent)

                      })
            }

        }
    }
}