package com.dalelore.nasa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dalelore.nasa.ui.theme.NASATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NASATheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        NasaImg()
                        NasaSlider()
                        NasaDates()
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NasaDates(){
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)){
        val datePickerState = rememberDatePickerState(initialSelectedDateMillis = null)
        DatePicker(state =datePickerState, modifier = Modifier.padding(16.dp))

       Text("Selected date timestamp: ${datePickerState.selectedDateMillis ?: "no selection"}")
    }
}

@Composable
fun NasaImg(){

        Image(
            painter = painterResource(R.drawable.nasa_foto),
            contentDescription = "NASA foto of space",
            modifier = Modifier.height(220.dp)
        )
}

@Composable
fun NasaSlider(){
    Card(){
        var sliderPosition by remember { mutableStateOf(0f) }
        Column {
            Text(text = sliderPosition.toString())
            Slider(
                value = sliderPosition,
                onValueChange = { sliderPosition = it })
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello Lorena!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NASATheme {
        Greeting("Android")
    }
}