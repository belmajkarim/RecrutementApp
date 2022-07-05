package kbe.protectioncivile.myapplicationrecrutement.api.candidature.model

import com.google.gson.annotations.SerializedName

data class CandidatureResponse(
    @SerializedName("formId")
    val formId: String,

    @SerializedName("dateNaissance")
    val dateNaissance: String,

    @SerializedName("numeroTelephone")
    val numeroTelephone: String,

    @SerializedName("adressePostale")
    val adressePostale: String,

    @SerializedName("permis")
    val permis: String,

    @SerializedName("honneurCasJudiciaire")
    val honneurCasJudiciaire: String,

    @SerializedName("profession")
    val profession: String,

    @SerializedName("diplomeSecourisme")
    val diplomeSecourisme: String,

    @SerializedName("diplomePseFormationContinue")
    val diplomePseFormationContinue: String,

    @SerializedName("numeroDiplome")
    val numeroDiplome: String,

    @SerializedName("postPostuler")
    val postPostuler: String,

    @SerializedName("benificierDautresCompetence")
    val benificierDautresCompetence: String,

    @SerializedName("pourquoiNousRejoindre")
    val pourquoiNousRejoindre: String,

    @SerializedName("langueParler")
    val langueParler: String,

    @SerializedName("remarqueCommentaireQuestion")
    val remarqueCommentaireQuestion: String,

    @SerializedName("commentAvezVousConnuProtectionCivil")
    val commentAvezVousConnuProtectionCivil: String,

    @SerializedName("statusCondidat")
    val statusCondidat: String

)
