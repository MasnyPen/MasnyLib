## MasnyLib
The MasnyLib project is a Java Gradle-based library providing a set of tools and APIs 
designed for the development of Minecraft plugins.

## 📦 How to Add `MasnyLib` to Your Plugin

### ✅ 1. Add the Repository

In your `build.gradle.kts`, add the Maven repository:

```kotlin
repositories {
    maven("https://maven.pcreators.pl/releases")
    mavenCentral()
}
```

If you're using a -SNAPSHOT version, change the URL to:

```kotlin
maven("https://maven.pcreators.pl/snapshots")
```

### ✅ 2. Add the Dependency
In the dependencies block, add:

```kotlin
dependencies {
    implementation("dev.masnypen:MasnyLib:1.0.0")
}
```
For snapshot builds:

```kotlin
dependencies {
    implementation("dev.masnypen:MasnyLib:1.0.0-SNAPSHOT")
}
```
