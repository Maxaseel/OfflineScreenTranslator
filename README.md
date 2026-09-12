# Offline Screen Translator Professional

A **$0 / API-key-free / offline-first Android screen translator**.

## What is included

- Jetpack Compose + Material 3 UI
- Android Gradle Plugin 9.1.1
- Gradle Wrapper configuration
- JDK 17 build target
- Android SDK compile/target 36
- On-device ML Kit OCR
- Chinese OCR support
- Local dictionary and phrase matching
- Morphology-aware translation
- Script-aware language detection
- Uzbek contextual/syntax rules
- Translation history and favorites
- Floating screen translator service
- Offline Android Text-to-Speech
- No Firebase
- No Gemini
- No Retrofit / OkHttp
- No HTTP client
- No API keys
- No INTERNET permission

## Build

Open the project in Android Studio and let it install/sync the required Android SDK components.

Command line:

```text
./gradlew :app:assembleDebug
```

Windows:

```text
gradlew.bat :app:assembleDebug
```

Release:

```text
./gradlew :app:assembleRelease
```

The release APK is unsigned unless you configure your own signing key. The debug APK can be installed directly for testing.
