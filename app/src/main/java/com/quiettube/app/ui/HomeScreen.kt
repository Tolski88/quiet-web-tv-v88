package com.quiettube.app.ui

import android.annotation.SuppressLint
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.quiettube.app.adblock.AdBlocker

/**
 * Main content screen shown after login. Every request the WebView makes is
 * checked against [AdBlocker], which is always active — there is no setting
 * to turn it off.
 */
@SuppressLint("SetJavaScriptEnabled")
@Composable
fun HomeScreen() {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                webViewClient = object : WebViewClient() {
                    override fun shouldInterceptRequest(
                        view: WebView,
                        request: WebResourceRequest,
                    ): WebResourceResponse? {
                        if (AdBlocker.shouldBlock(request)) {
                            return AdBlocker.blockedResponse()
                        }
                        return super.shouldInterceptRequest(view, request)
                    }
                }
                loadUrl("https://www.youtube.com")
            }
        },
    )
}
