package com.cts.demo

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var adapter: HeroesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview!!.setHasFixedSize(true)
        recyclerview!!.layoutManager = LinearLayoutManager(this)

        val model = ViewModelProviders.of(this).get<HeroViewModel>(HeroViewModel::class.java)

        model.heroes.observe(this, Observer { heroList ->
            adapter = HeroesAdapter(this@MainActivity, heroList!!) { hero : Hero -> recyclerviewItemClicked(hero) }
            if(heroList.isEmpty()){
                progressBar.visibility = View.GONE
                Toast.makeText(this@MainActivity, getString(R.string.error), Toast.LENGTH_SHORT).show()
            }else {
                recyclerview!!.adapter = adapter
                progressBar.visibility = View.GONE
            }
        })
    }

    private fun recyclerviewItemClicked(hero : Hero) {
        val intent = Intent(this, HeroDetailsActivity::class.java)
        intent.putExtra("hero", hero)
        this.startActivity(intent)
    }
}
