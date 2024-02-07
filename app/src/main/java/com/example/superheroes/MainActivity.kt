@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.example.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroes.ui.theme.SuperheroeItem
import com.example.superheroes.ui.theme.SuperheroeTopBar
import com.example.superheroes.ui.theme.SuperheroesTheme
import model.HeroesRepository.heroes

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SuperheroeApp()
                }
            }
        }
    }
}



@ExperimentalMaterial3Api
@Composable
fun SuperheroeApp(){
    Scaffold(
        topBar = {
            SuperheroeTopBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(heroes) {
                SuperheroeItem(
                    hero = it,
                    modifier = Modifier
                )
            }
        }
    }
}


@ExperimentalMaterial3Api
@Preview
@Composable
fun HeroesPreview() {
    SuperheroesTheme(darkTheme = false) {
        SuperheroeApp()
    }
}
@ExperimentalMaterial3Api
@Preview
@Composable
fun HeroesDarkThemePreview() {
    SuperheroesTheme(darkTheme = true) {
        SuperheroeApp()
    }
}