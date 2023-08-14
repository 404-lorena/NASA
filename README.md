# NASA

## Getting Started: Empty Project
- Template: Empty Project
  - SDK API 24: Android 7.0 (Nougat)   

## Setting up composables
### Setup: NASA Project
- In Gradle scripts > build.gradle file
  - [ ] compileSdk 34
  - [ ] targetSdk 34
  - [ ] implementation 'androidx.compose.material3:material3:1.2.0-alpha05'
 
### [Image Composable](https://developer.android.com/jetpack/compose/graphics/images/loading)
NOTE: Using [Jetpack Compose](https://developer.android.com/jetpack/compose?gclid=Cj0KCQjwuNemBhCBARIsADp74QTy5DaYxDtw1fLXnJ_LBZvGVHZ5me7UEDyMn60p5OLibsR28pnf-LAaAvG2EALw_wcB&gclsrc=aw.ds), a native UI for Android
- In MainActivity.kt file, created an Image composable
```
Image(
    painter = painterResource(id = R.drawable.NAME_OF_IMAGE),
    contentDescription = "DESCRIPTION",
    modifier = Modifer.height(NUMBER.dp)
)
```
### [Slider Composable](https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary#Slider(androidx.compose.material3.SliderState,androidx.compose.ui.Modifier,kotlin.Boolean,androidx.compose.material3.SliderColors,androidx.compose.foundation.interaction.MutableInteractionSource,kotlin.Function1,kotlin.Function1))
- In MainActivity.kt file, created a Slider composable
```
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.semantics.semantics

var sliderPosition by remember { mutableStateOf(0f) }
Column {
    Text(text = sliderPosition.toString())
    Slider(
        modifier = Modifier.semantics { contentDescription = "Localized Description" },
        value = sliderPosition,
        onValueChange = { sliderPosition = it })
}
```

### [Date Picker Composable](https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary)
- In MainActivity.kt file, created a Date Picker composable
```
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState

Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
    val datePickerState = rememberDatePickerState(initialSelectedDateMillis = null)
    DatePicker(state = datePickerState, modifier = Modifier.padding(16.dp))

    Text("Selected date timestamp: ${datePickerState.selectedDateMillis ?: "no selection"}")
}
```
## Setting up API
### Setup: NASA Project - Gradle Dependencies
- In Gradle scripts > build.gradle file
  - [ ] [Retrofit](https://square.github.io/retrofit/) to connect to servers
```implementation('com.squareup.retrofit2:retrofit:2.9.0')```
  - [ ] [Retrofit with Kotlin Serialization Converter](https://github.com/JakeWharton/retrofit2-kotlinx-serialization-converter)
```implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0")```
  - [ ] [OkHttp to connect to networks](https://square.github.io/okhttp/)
```implementation("com.squareup.okhttp3:okhttp:4.10.0")```
  - [ ] [Retrofit Kotlin Serialization](https://kotlinlang.org/docs/serialization.html#example-json-serialization)
```implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")```
  - [ ] [Coil](https://coil-kt.github.io/coil/) is an image loading library for Android
```implementation("io.coil-kt:coil:2.4.0")```
  
### Setup: NASA Project - Image Model
- In java > siteDirectory (same directory where your ui.theme is located), create new package called model
- In model directory, create new Kotlin Class for your NASA images
  - This NASA Images class will need imports and attributes based on the [NASA API](https://api.nasa.gov/):
  - [ ] Import
  ```
  import kotlinx.serialization.SerialName
  import kotlinx.serialization.Serializable
  ```
  - [ ] Attributes based from the [demo](https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY) given
  ```
  @Serializable
  class NasaFotoApi {
    val copyright: String = "",
    val date: String,
    val explanation: String,
    @SerialName("hdurl"),
    val imageUrl: String,
    val media_type: String,
    @SerialName("service_version")
    val serviceVersion: String,
    val url: String,
  }
  ```
