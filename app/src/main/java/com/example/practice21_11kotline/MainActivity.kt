package com.example.practice21_11kotline

import android.graphics.Color
import android.os.AsyncTask
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var buttonLoadWebsite: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        webView = findViewById(R.id.webView)
        buttonLoadWebsite = findViewById(R.id.buttonLoadWebsite)


        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()


        buttonLoadWebsite.setOnClickListener {

            LoadWebsiteTask(webView).execute("https://xn--n1ae1b.xn--c1aavf6a.xn--p1ai/") // Замените на ваш сайт
        }
    }


    private class LoadWebsiteTask(private val webView: WebView) : AsyncTask<String, Void, Void>() {
        override fun doInBackground(vararg urls: String?): Void? {
            urls.firstOrNull()?.let {
                webView.post {
                    webView.loadUrl(it)
                }
            }
            return null
        }
    }
}