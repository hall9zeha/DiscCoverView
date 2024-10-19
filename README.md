# DiscCoverView
A simple custom view to display song covers on Android

<p align="center">

<a href="https://jitpack.io/#hall9zeha/DiscCoverView"><img alt="License" src="https://jitpack.io/v/hall9zeha/DiscCoverView.svg"/></a>
</p>

# Screenshots
|||
|--|--|
|<p align="center" width="70%"><img src="https://github.com/hall9zeha/DiscCoverView/blob/main/screenshots/screen1.jpg" width=70% height=70% /></p>|<p align="center" width="70%"><img src="https://github.com/hall9zeha/DiscCoverView/blob/main/screenshots/screen2.jpg" width=70% height=70% /></p>|
||
|--|
|<p align="center" width="70%"><img src="https://github.com/hall9zeha/DiscCoverView/blob/main/screenshots/example.gif" width=70% height=70% /></p>|
## Requirements
* Android min SDK 24

## Implementation

### How to use
### 1. Add the jitpack source in settings.gradle:

* In gradle 7 or latest

gradle groovy
```
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        //here
        maven { url 'https://jitpack.io' } 
    }
}
```
gradle kotlin
```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        //here
        maven ( url = "https://jitpack.io" )
    }
}
```
### 2. Add the dependency at application gradle level.
* gradle groovy
```gradle
dependencies{
    ...
    implementation 'com.github.hall9zeha:DiscCoverView:1.0.0'
}
```
* gradle kotlin
```gradle
dependencies{
    ...
    implementation ("com.github.hall9zeha:DiscCoverView:1.0.0")
}
```
### Xml design
* Example implementation
```xml
...

<com.barryzeha.library.components.DiscCoverView
        android:id="@+id/albumCover"
        android:layout_width="250dp"
        android:layout_height="250dp"
        android:src="@drawable/sample_cover"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintBottom_toBottomOf="parent"/>
...
```
### Properties

| Property          | Type      | Example   |Default value|
|--------------------|------------|-------------------------|-------------------------------------------------|
| shape               | enum     | "circle" or "rectangle"     | circle|
| trackColor          | color     | "#FF0000" or @color/my_color              |#76FFFFFF|
| speedRotation           | integer  | "1000" (milliseconds)                 |3500|

### Methods
Check the example in the app module

```java

val ivCoverView = findViewById<DiscCoverView>(R.id.albumCover)

ivCoverView.start()
ivCoverView.pause()
ivCoverView.resume()

// Stops rotation slowly to its original position
ivCoverView.stop()
// Stops rotation quickly to its original position
ivCoverView.end()


```

