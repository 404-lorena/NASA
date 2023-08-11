# NASA

## Getting Started: Empty Project
- Template: Empty Project
  - SDK API 24: Android 7.0 (Nougat)   

## Setup: NASA Project
- In Gradle scripts > build.gradle file
  - [ ] compileSdk 34
  - [ ] targetSdk 34
  - [ ] implementation 'androidx.compose.material3:material3:1.2.0-alpha05'
 
## [Image Composable](https://developer.android.com/jetpack/compose/graphics/images/loading)
NOTE: Using [Jetpack Compose](https://developer.android.com/jetpack/compose?gclid=Cj0KCQjwuNemBhCBARIsADp74QTy5DaYxDtw1fLXnJ_LBZvGVHZ5me7UEDyMn60p5OLibsR28pnf-LAaAvG2EALw_wcB&gclsrc=aw.ds), a native UI for Android
- In MainActivity.kt file, created an Image composable
```
Image(
    painter = painterResource(id = R.drawable.NAME_OF_IMAGE),
    contentDescription = "DESCRIPTION",
    modifier = Modifer.height(NUMBER.dp)
)
```

## Resources
- Android Developer Docs
  - [Compose Material 3](https://developer.android.com/jetpack/androidx/releases/compose-material3)
- Connect Android Studio to GitHub
  - [How to upload an android studio project to GitHub](https://www.youtube.com/watch?v=GhfJTOu3_SE)
