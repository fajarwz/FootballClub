package com.example.footballclub

import com.google.gson.annotations.SerializedName


/*
    Created by: fajar on 21/11/19.
*/

//model

data class Team (
    @SerializedName("idTeam")
    var teamId: String? = null,

    @SerializedName("strTeam")
    var teamName: String? = null,

    @SerializedName("strTeamBadge")
    var teamBadge: String? = null
)