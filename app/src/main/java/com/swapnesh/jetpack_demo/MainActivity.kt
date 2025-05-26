package com.swapnesh.jetpack_demo

import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.swapnesh.jetpack_demo.sreens.CategoryScreen
import com.swapnesh.jetpack_demo.sreens.DetailScreen
import com.swapnesh.jetpack_demo.ui.theme.Jetpack_DemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Jetpack_DemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(title = {
                            Text(text = "Tweets")
                           }, colors = TopAppBarDefaults.topAppBarColors(
                               containerColor = Color.Blue,
                               titleContentColor = Color.White))
                    }) { innerPadding ->
                    Box (modifier = Modifier.padding(innerPadding)){
                        App()
                    }


                }
            }
        }
    }
}

@Composable
fun App(){

    val navcontoller = rememberNavController()

    NavHost(navController = navcontoller, startDestination = "category" ){
        composable(route = "category") {
            CategoryScreen {
                navcontoller.navigate("detail/${it}")
            }
        }
        composable(route = "detail/{category}",
            arguments = listOf(
                navArgument("category"){
                    type = NavType.StringType
                }
            )
        ) {
            DetailScreen()
        }

    }
}



