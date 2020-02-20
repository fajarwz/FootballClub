package com.example.footballclub


/*
    Created by: fajar on 21/11/19.
*/

//interface ada MainView

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}