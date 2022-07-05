package kbe.protectioncivile.myapplicationrecrutement

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash.*


class SplashActivity : AppCompatActivity() {

        @SuppressLint("WrongViewCast")
        override fun onCreate(savedInstanceState: Bundle?) {
        //This call the parent constructor
        super.onCreate(savedInstanceState)
        // This is used to align the xml view to this class
        setContentView(R.layout.activity_splash)
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )


        // This is used to get the file from the assets folder and set it to the title textView.
        val typeface: Typeface = Typeface.createFromAsset(assets, "carbon bl.ttf")
            tv_app_name.typeface = typeface

        // Adding the handler to after the a task after some delay.
        Handler().postDelayed({
            // Start the Intro Activity
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            finish() // Call this when your activity is done and should be closed.
        }, 1500) // Here we pass the delay time in milliSeconds after which the splash activity will disappear.
    }
}