package kbe.protectioncivile.myapplicationrecrutement


import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_aider.*


class AiderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aider)
        val webViewPlayerView = findViewById<WebView>(R.id.webview_player_view)
        /*webViewPlayerView.settings.javaScriptEnabled = true
        webViewPlayerView.*/
        //actionbar
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