package com.cts.demo

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HeroViewModel : ViewModel() {

    private val tag : String = HeroViewModel::class.java.simpleName

    //this is the data that we will fetch asynchronously
    private var heroList: MutableLiveData<List<Hero>>? = null

    //if the list is null
    //we will load it asynchronously from server in this method
    //finally we will return the list
    val heroes: LiveData<List<Hero>>
        get() {
            if (heroList == null) {
                heroList = MutableLiveData()
                loadHeroes()
            }
            return heroList as MutableLiveData<List<Hero>>
        }

    private fun loadHeroes() {

        val call = WebAccess.heroAPI.getHeros();
        call.enqueue(object : Callback<List<Hero>> {
            override fun onResponse(call: Call<List<Hero>>, response: Response<List<Hero>>) {
                //finally we are setting the list to our MutableLiveData
                heroList?.value = response.body()
            }

            override fun onFailure(call: Call<List<Hero>>, t: Throwable) {
                Log.e(tag, "Exception " + t.message)
                heroList?.value = emptyList()
            }
        })
    }

    override fun onCleared() {
        super.onCleared()
    }
}