# QuietTube

A minimal native Android app (Kotlin + Jetpack Compose).

## What's implemented

- **Login screen with no visible text or toggle** (`app/src/main/java/com/quiettube/app/ui/LoginScreen.kt`):
  only the planet logo, two icon-led input fields (username/password, distinguished
  by their leading icons rather than by label text), and an icon-only submit
  button. There is no on-screen copy and no switch of any kind on this screen.
- **Ad blocking, always on** (`app/src/main/java/com/quiettube/app/adblock/AdBlocker.kt`):
  a fixed blocklist (`app/src/main/assets/adblock_blocklist.txt`) is checked on
  every WebView request. There is no setting or toggle anywhere in the app to
  turn it off — it is wired in once at startup in `MainActivity` and applied
  in `HomeScreen`'s `WebViewClient`.
- **Planet logo/launcher icon**: `app/src/main/res/drawable/ic_planet_logo.xml`
  (in-app logo) and `app/src/main/res/drawable/ic_launcher_foreground.xml`
  (adaptive launcher icon) both draw a ringed planet.

## Building

Requires the Android SDK (compileSdk 34) and network access to Google's Maven
repository (`dl.google.com`) to resolve the Android Gradle Plugin and AndroidX
artifacts — this sandbox's network policy blocks that host, so the build could
not be run to completion here. Elsewhere:

```
./gradlew assembleDebug
```
