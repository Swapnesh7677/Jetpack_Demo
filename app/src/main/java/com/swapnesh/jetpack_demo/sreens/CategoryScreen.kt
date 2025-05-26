package com.swapnesh.jetpack_demo.sreens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.swapnesh.jetpack_demo.R
import com.swapnesh.jetpack_demo.viewmodules.MainviewModule
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun CategoryScreen(onclick: (category:String)->Unit) {

    val mainviewModule : MainviewModule = hiltViewModel()
    val category: State<List<String>> = mainviewModule.categories.collectAsState()

    if(category.value.isEmpty()){
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center){
            CircularProgressIndicator()
            //Text(text = "Loading....", style = MaterialTheme.typography.bodyLarge)
        }
    }else {

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.padding(top = 25.dp)

        ) {
            items(category.value.distinct()) {
                CategoryItem(cat = it, onclick)
            }

        }
    }

}

@Composable
fun CategoryItem(cat :String, onclick: (category:String)->Unit){
    println(cat)
    Box(modifier = Modifier
        .padding(4.dp)
        .size(160.dp)
        .clickable {
            onclick(cat)
        }
        .clip(RoundedCornerShape(8.dp))
        .paint(
            painter = painterResource(id = R.drawable.wave_haikei),
            contentScale = ContentScale.Crop
        )
        .border(1.dp, Color(0xFFEEEEEE)),
        contentAlignment = Alignment.BottomCenter

    ){
        Text(text = cat,
            fontSize = 18.sp,
            color = Color.Black,
            modifier =  Modifier.padding(0.dp,20.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }

}