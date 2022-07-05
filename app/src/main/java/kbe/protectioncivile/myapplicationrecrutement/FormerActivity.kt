package kbe.protectioncivile.myapplicationrecrutement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_former.*

class FormerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_former)
        //actionbar
        setupActionBar()
    }
    private fun setupActionBar() {

        setSupportActionBar(toolbar_former_activity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
            actionBar.title = resources.getString(R.string.Home)
        }

        toolbar_former_activity.setNavigationOnClickListener { onBackPressed() }
    }
}