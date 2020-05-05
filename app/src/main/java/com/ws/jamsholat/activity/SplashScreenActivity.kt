package com.ws.jamsholat.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import com.ws.jamsholat.R
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val animation = AnimationUtils.loadAnimation(this,
            R.anim.slide_up
        )
        iv_mosque.startAnimation(animation)
        Handler().postDelayed({
            openMainAct()
        },1200)

    }

    private fun openMainAct(){
        val intent = Intent(this, GetStartedActivity::class.java)

        startActivity(intent)
        finish()
    }
}
