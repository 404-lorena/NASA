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

## Resources
- Android Developer Docs
  - [Compose Material 3](https://developer.android.com/jetpack/androidx/releases/compose-material3)
- Connect Android Studio to GitHub
  - [How to upload an android studio project to GitHub](https://www.youtube.com/watch?v=GhfJTOu3_SE)
