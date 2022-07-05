package kbe.protectioncivile.myapplicationrecrutement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_secourir.*

class SecourirActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secourir)
//actionbar
        setupActionBar()
    }
    private fun setupActionBar() {

        setSupportActionBar(toolbar_secourir_activity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
            actionBar.title = resources.getString(R.string.Home)
        }

        toolbar_secourir_activity.setNavigationOnClickListener { onBackPressed() }
    }
}