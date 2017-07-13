# Viewtiful
Simple view utils

[![Build Status](https://travis-ci.org/Commit451/Viewtiful.svg?branch=master)](https://travis-ci.org/Commit451/Viewtiful)
[![](https://jitpack.io/v/Commit451/Viewtiful.svg)](https://jitpack.io/#Commit451/Viewtiful)

# Gradle Dependency
Add the jitpack url to the project:
```groovy
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```
then, in your app `build.gradle`
```groovy
dependencies {
    compile "com.github.Commit451.Viewtiful:viewtiful:latest.version.here"
    //and, for kotlin extensions
    compile "com.github.Commit451.Viewtiful:viewtiful-kotlin:latest.version.here"
}
```

# Usage
See the sample project for a comprehensive example.

```java
Viewtiful.onPreDraw(view, new Runnable() {
    @Override
    public void run() {
        Log.d("Hello", "The view is about to draw.");
    }
});
```
And Kotlin:
```kotlin
view.onViewPreDraw(Runnable {
    Log.d("Hello", "The view is about to draw.")
    Toast.makeText(this@MainKotlinActivity, "The view is about to draw!!! How exciting", Toast.LENGTH_SHORT).show()
})
```
Similar examples for `onGlobalLayout`.

Setting padding is also made easier:
```java
int padding = Viewtiful.dpToPx(4);
Viewtiful.setPaddingTop(padding);
Viewtiful.setPaddingBottom(padding);
Viewtiful.setPaddingLeft(padding);
Viewtiful.setPaddingRight(padding);
```

License
--------

    Copyright 2016 Commit 451

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
