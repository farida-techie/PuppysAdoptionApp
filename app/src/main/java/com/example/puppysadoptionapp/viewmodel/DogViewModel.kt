package com.example.puppysadoptionapp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.puppysadoptionapp.R
import com.example.puppysadoptionapp.model.DogDatas

class DogViewModel():ViewModel() {
   val dogList:MutableLiveData<List<DogDatas>> by lazy {
       MutableLiveData<List<DogDatas>>()
   }
   private  var puppyList :ArrayList<DogDatas>
    init {
        puppyList = ArrayList()
        getDogList()
    }
    fun getDogList(){
        fechList()
        dogList.value = puppyList
    }
    private fun fechList(){
        puppyList.add(DogDatas(R.drawable.bears,"Bear","Aloof,Loyal,Independent,Quiet"))
        puppyList.add(DogDatas(R.drawable.coorep,"Cooper","Steady,Bold,Independent,Confident,Intelligent,Proud"))
        puppyList.add(DogDatas(R.drawable.emersons,"Emerson","Spirited,Alert,Loyal,Companionable,Even,Tempered,Courageous"))
        puppyList.add(DogDatas(R.drawable.puppys,"Puppy","Feisty,Affectionate,Cheerful,Playful,Gentle,Sensitive"))
        puppyList.add(DogDatas(R.drawable.hudsons,"Hudson","Strong willed Stubborn,Friendly,Intelligent,Courageous,Affectionate"))
        puppyList.add(DogDatas(R.drawable.jikcs,"Jack","Kind,Sweet-Tempered,Loving,Loyal,Intelligent,Independent"))
        puppyList.add(DogDatas(R.drawable.kais,"Kai","Protective,Loyal,Gentle,Rational,Familial,Intelligent"))
        puppyList.add(DogDatas(R.drawable.maxs,"Max","Docile,Reliable,Devoted,Alert,Reserved,Calm,Courageous,Powerful"))
        puppyList.add(DogDatas(R.drawable.puppys,"Puppy","Feisty,Affectionate,Cheerful,Playful,Gentle,Sensitive"))
        puppyList.add(DogDatas(R.drawable.surreys,"Sawyer","Trainable,Playful,Friendly,Faithful,Affectionate"))
        puppyList.add(DogDatas(R.drawable.bears,"Bear","Aloof,Loyal,Independent,Quiet"))
        puppyList.add(DogDatas(R.drawable.coorep,"Cooper","Steady,Bold,Independent,Confident,Intelligent,Proud"))
        puppyList.add(DogDatas(R.drawable.finns,"Finn","Playful,Loyal,Intelligent,Vocal,Happy"))
    }
}