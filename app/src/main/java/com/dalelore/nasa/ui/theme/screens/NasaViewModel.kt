package com.dalelore.nasa.ui.theme.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.dalelore.nasa.network.NasaApi
import com.dalelore.nasa.model.NasaPhoto
import java.io.IOException

sealed interface NasaUiState {
    data class Success(val photo: NasaPhoto) : NasaUiState
    object Error : NasaUiState
    object Loading : NasaUiState
}

class NasaViewModel : ViewModel(){
    var nasaUiState: NasaUiState by mutableStateOf(NasaUiState.Loading)
        private set

    private val _photo = MutableLiveData<NasaPhoto>()
    val photo: LiveData<NasaPhoto> = _photo

    init {
        getNasaPhoto()
    }

    private fun getNasaPhoto(){
        viewModelScope.launch {
            nasaUiState = try {
                _photo.value = NasaApi.retrofitService.getPhoto("PhwAFlShlco9MWbezPwJRLb5t4AW4vNUST9fLWkl")
                NasaUiState.Success(
                    _photo.value!!
                )
            } catch(e:IOException) {
                NasaUiState.Error
            }
        }
    }
}