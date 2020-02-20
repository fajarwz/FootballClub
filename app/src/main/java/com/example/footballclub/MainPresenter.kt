package com.example.footballclub

import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


/*
    Created by: fajar on 21/11/19.
*/

//ketika fungsi dibawah dijalankan maka otomatis akan memanggil fungsi showLoading dan doAsync
//doAsync dari Anko bisa digunakan untuk menjalankan asynchronous task.
//fungsi doRequest akan dipanggil dan jika berhasil data akan ditampilkan oleh uiThread

//Presenter ada MainPresenter

class MainPresenter(
    private val view: MainView,
    private val apiRepository: ApiRepository,
    private val gson: Gson) {

    fun getTeamList(league: String?){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository.
                doRequest(TheSportDBApi.getTeams(league)),
                TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamList(data.teams)
            }
        }
    }
}