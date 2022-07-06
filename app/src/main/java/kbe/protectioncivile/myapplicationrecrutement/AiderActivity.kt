package kbe.protectioncivile.myapplicationrecrutement


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_aider.*


class AiderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aider)

        val webViewPlayerView = findViewById<WebView>(R.id.webview_player_view)
        val donateButton = findViewById<Button>(R.id.btn_donate)
        donateButton.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://don.protection-civile.org/soutenir")
            startActivity(openURL)
        }
        webViewPlayerView.settings.javaScriptEnabled = true

        webview_player_view.webViewClient = WebViewClient()
        webViewPlayerView.loadUrl("https://youtu.be/BI7ENtjkZZQ")

        setupActionBar()
    }

    private fun setupActionBar() {

        setSupportActionBar(toolbar_aider_activity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
            actionBar.title = resources.getString(R.string.Home)
        }

        toolbar_aider_activity.setNavigationOnClickListener { onBackPressed() }
    }
}