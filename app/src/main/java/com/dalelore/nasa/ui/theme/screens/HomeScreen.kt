package com.dalelore.nasa.ui.theme.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.dalelore.nasa.R
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import coil.compose.AsyncImage
import com.dalelore.nasa.model.NasaPhoto
import kotlinx.serialization.json.JsonNull.content

@Composable
fun HomeScreen(
    nasaUiState: NasaUiState
    modifier: Modifier = Modifier
) {
    when (nasaUiState){
        is NasaUiState.Loading -> LoadingScreen()
        is NasaUiState.Success -> ResultScreen(nasaUiState.photo, modifier = modifier.fillMaxWidth())
        is NasaUiState.Error -> ErrorScreen()
    }
}

@Composable
fun ResultScreen(photo: NasaPhoto, modifier: Modifier = Modifier){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Arrangement.CenterHorizontally
    ) {
        AsyncImage(
            model = photo.imageUrl,
            contentDescription = photo.title)
        Text(
            photo.explanation,
            modifier = Modifier.padding(16.dp)
        )
    }
}
