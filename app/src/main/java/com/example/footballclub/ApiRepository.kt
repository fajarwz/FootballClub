package com.example.footballclub

import java.net.URL


/*
    Created by: fajar on 20/11/19.
*/

class ApiRepository {
    fun doRequest(url: String): String{
        return URL(url).readText()
    }
}