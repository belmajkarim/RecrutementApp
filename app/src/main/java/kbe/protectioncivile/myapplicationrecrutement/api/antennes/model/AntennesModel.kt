package kbe.protectioncivile.myapplicationrecrutement.api.antennes.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AntennesModel(
    @Expose
    @SerializedName("nomSite")
    val nomSite: String,
    @Expose
    @SerializedName("adresseAntenne")
    val adresseAntenne: String,
)
