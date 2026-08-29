package com.quiettube.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.quiettube.app.adblock.AdBlocker
import com.quiettube.app.ui.HomeScreen
import com.quiettube.app.ui.LoginScreen
import com.quiettube.app.ui.theme.QuietTubeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Ad blocking is initialized once, up front, and stays on for the
        // lifetime of the app — there is no user-facing switch for it.
        AdBlocker.initialize(applicationContext)

        setContent {
            QuietTubeTheme {
                var loggedIn by remember { mutableStateOf(false) }
                if (loggedIn) {
                    HomeScreen()
                } else {
                    LoginScreen(onLoggedIn = { loggedIn = true })
                }
            }
        }
    }
}
