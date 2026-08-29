package com.quiettube.app.adblock

import android.content.Context
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import java.io.ByteArrayInputStream

/**
 * Ad blocking is a fixed, always-on part of QuietTube. There is no setting or
 * toggle to disable it — every request is checked against [blockedHosts]
 * before the WebView is allowed to load it.
 */
object AdBlocker {

    private var blockedHosts: Set<String> = emptySet()

    fun initialize(context: Context) {
        if (blockedHosts.isNotEmpty()) return
        blockedHosts = context.assets.open("adblock_blocklist.txt")
            .bufferedReader()
            .useLines { lines ->
                lines
                    .map { it.trim() }
                    .filter { it.isNotEmpty() && !it.startsWith("#") }
                    .toSet()
            }
    }

    fun shouldBlock(request: WebResourceRequest): Boolean {
        val host = request.url.host ?: return false
        return blockedHosts.any { blocked -> host == blocked || host.endsWith(".$blocked") }
    }

    fun blockedResponse(): WebResourceResponse =
        WebResourceResponse("text/plain", "utf-8", ByteArrayInputStream(ByteArray(0)))
}
