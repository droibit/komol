# Komol

Komol is a simple **Ko**tlin Multiplatform **Mo**bile **l**ogger.  
Supports the following targets:
- Android
- iOS

# Usage

```kotlin
// Install loggers to Komol only once.
Komol.initialize( ... /* e.g. TimberLogger()*/ )

// Komol's static function to output log.
Komol.d("Hello")
Komol.e(Exception("Error"))
...
```

## Build in loggers

### Android
- `LogcatLogger`: Use [`Log`](https://developer.android.com/reference/android/util/Log) provided by Android SDK to output a log.

```kotlin
Komol.i("Hello")
// ->
// 05-07 20:45:04.123 17643-17643/com.github.droibit.komol.sample I/Komol: Hello
```

- `TimberLogger`: Use [`Timber`](https://github.com/JakeWharton/timber) to output a log (It requires `komol-timber` separately).

```kotlin
Komol.i("Hello")
// ->
// 05-07 20:45:04.123 17643-17643/com.github.droibit.komol.sample I/SampleApplication: Hello
```

### iOS
- `PrintLogger`: Use [`println`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/println.html) function to output a log.
```kotlin
Komol.i("Hello")
// ->
// 2021-05-07 20:48:39.419 I/Komol: Hello
```

## Improve calls from Swift
If you want to use Komol from Swift code, it is recommended to create a wrapper for it.
- [`komol-sample/Komol.swift`](https://github.com/droibit/komol/blob/master/komol-sample/ios/Sources/Utils/Komol.swift)

# Download

```kotlin
repositories {
   maven(url = "https://repo.repsy.io/mvn/droibit/public")
}

dependencies {
   // For common
   implementation("com.github.droibit.komol:komol-core:0.2.0")

   // For Android if needed
   implementation("com.github.droibit.komol:komol-timber:0.2.0")
}
```

# Licenses

    Copyright (C) 2021 Shinya Kumagai

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.