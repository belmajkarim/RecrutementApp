package kbe.protectioncivile.myapplicationrecrutement.api.candidature.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CandidatureModel(
    @Expose
    @SerializedName("dateNaissance")
    val dateNaissance: String,
    @Expose
    @SerializedName("numeroTelephone")
    val numeroTelephone: String,
    @Expose
    @SerializedName("adressePostale")
    val adressePostale: String,
    @Expose
    @SerializedName("permis")
    val permis: String,
    @Expose
    @SerializedName("honneurCasJudiciaire")
    val honneurCasJudiciaire: String,
    @Expose
    @SerializedName("profession")
    val profession: String,
    @Expose
    @SerializedName("diplomeSecourisme")
    val diplomeSecourisme: String,
    @Expose
    @SerializedName("diplomePseFormationContinue")
    val diplomePseFormationContinue: String,
    @Expose
    @SerializedName("numeroDiplome")
    val numeroDiplome: String,
    @Expose
    @SerializedName("postPostuler")
    val postPostuler: String,
    @Expose
    @SerializedName("benificierDautresCompetence")
    val benificierDautresCompetence: String,
    @Expose
    @SerializedName("pourquoiNousRejoindre")
    val pourquoiNousRejoindre: String,
    @Expose
    @SerializedName("langueParler")
    val langueParler: String,
    @Expose
    @SerializedName("remarqueCommentaireQuestion")
    val remarqueCommentaireQuestion: String,
    @Expose
    @SerializedName("commentAvezVousConnuProtectionCivil")
    val commentAvezVousConnuProtectionCivil: String
)
