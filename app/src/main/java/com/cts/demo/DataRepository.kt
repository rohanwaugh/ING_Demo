package com.cts.demo

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class DataRepository {

    private var heroList: MutableLiveData<DataRepoModel>? = MutableLiveData()

    @Inject set
    var webService: API? = null

    init {
        AppController.Companion.instance.getApplicationComponent().inject(this)
    }

    fun getHeros(): MutableLiveData<DataRepoModel>? {

     //   AppController.Companion.instance.getApplicationComponent().inject(this)

        Log.i("XXX","Inside getHeros")
        val call  = webService!!.getHeros()
        //val call = WebAccess.heroAPI.getHeros();
        Log.i("XXX", "call object created $call")
        call.enqueue(object : Callback<List<Hero>> {

            override fun onResponse(call: Call<List<Hero>>, response: Response<List<Hero>>) {
                Log.i("XXX","Inside onResponse")
                heroList?.value = DataRepoModel(response.body()!!)

            }

            override fun onFailure(call: Call<List<Hero>>, t: Throwable) {
                Log.i("XXX","Inside onFailure")
                heroList?.value = DataRepoModel(t)
            }
        })

        return heroList
    }
}