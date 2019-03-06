package com.cts.demo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.heros_details.*


class HeroDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.heros_details)

        val bundle: Bundle? = intent.extras

        bundle.apply {
            val hero:Hero? = this!!.getParcelable("hero")
            heroRealName.text = hero?.realname
            heroTeam.text = hero?.team
            firstAppreance.text = hero?.firstappearance
            createdBy.text = hero?.createdby
        }

    }
}