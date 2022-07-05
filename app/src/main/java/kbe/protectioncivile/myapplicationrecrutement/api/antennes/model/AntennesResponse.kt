package kbe.protectioncivile.myapplicationrecrutement.api.antennes.model

import com.google.gson.annotations.SerializedName

data class AntennesResponse(
    @SerializedName("antenneId")
    val antenneId: String,
    @SerializedName("nomSite")
    val nomSite: String,
    @SerializedName("adresseAntenne")
    val adresseAntenne: String
    )
