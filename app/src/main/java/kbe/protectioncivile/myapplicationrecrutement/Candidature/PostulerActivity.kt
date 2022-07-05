package kbe.protectioncivile.myapplicationrecrutement.Candidature

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import kbe.protectioncivile.myapplicationrecrutement.api.candidature.model.CandidatureModel
import kbe.protectioncivile.myapplicationrecrutement.api.candidature.model.CandidatureResponse
import kbe.protectioncivile.myapplicationrecrutement.api.candidature.service.CandidatureService
import kbe.protectioncivile.myapplicationrecrutement.api.provider.AppPreferences.Token
import kbe.protectioncivile.myapplicationrecrutement.LoginActivity
import kbe.protectioncivile.myapplicationrecrutement.R

import kotlinx.android.synthetic.main.activity_postuler.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostulerActivity : AppCompatActivity() {
    private var isResultValid: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_postuler)
        setupActionBar()
        val postulerButton = findViewById<Button>(R.id.btn_update)
        postulerButton.setOnClickListener{
            sendCandidature()
        }
        postulerButton.setOnClickListener{
            val intent = Intent(this, SuiviCandidatureActivity::class.java)
            startActivity(intent)
        }
    }

    private fun sendCandidature(): Boolean
    {
        val datenaissance = findViewById<EditText>(R.id.DateNaissance).text.toString()
        val numeroTelephone = findViewById<EditText>(R.id.numerotelephone).text.toString()
        val adressePostale = findViewById<EditText>(R.id.adressepostale).text.toString()
        val permis=  findViewById<EditText>(R.id.et_permis).text.toString()
        val honneurCasJudiciaire = findViewById<EditText>(R.id.honneurCasJudiciaire).text.toString()
        val profession = findViewById<EditText>(R.id.profession).text.toString()
        val diplomeSecourisme = findViewById<EditText>(R.id.diplomeSecourisme).text.toString()
        val diplomePseFormationContinue = findViewById<EditText>(R.id.diplomePseFormationContinue).text.toString()
        val numeroDiplome = findViewById<EditText>(R.id.numeroDiplome).text.toString()
        val postPostuler = findViewById<EditText>(R.id.postPostuler).text.toString()
        val benificierDautresCompetence = findViewById<EditText>(R.id.benificierDautresCompetence).text.toString()
        val pourquoiNousRejoindre = findViewById<EditText>(R.id.pourquoiNousRejoindre).text.toString()
        val langueParler = findViewById<EditText>(R.id.langueParler).text.toString()
        val remarqueCommentaireQuestion = findViewById<EditText>(R.id.remarqueCommentaireQuestion).text.toString()
        val commentAvezVousConnuProtectionCivil = findViewById<EditText>(R.id.commentAvezVousConnuProtectionCivil).text.toString()

        if(numeroTelephone.isNotEmpty() && adressePostale.isNotEmpty() && permis.isNotEmpty()
            && honneurCasJudiciaire.isNotEmpty()) {
            if (Token == "") {
                LoginActivity.navigateTo(this)
                print("no token ")
            } else {
                CandidatureService().sendCandidature(Token, CandidatureModel(
                    datenaissance,numeroTelephone,adressePostale,permis,honneurCasJudiciaire,profession,
                    diplomeSecourisme,diplomePseFormationContinue,numeroDiplome, postPostuler,benificierDautresCompetence,
                    pourquoiNousRejoindre, langueParler, remarqueCommentaireQuestion,commentAvezVousConnuProtectionCivil), object :

                    Callback<CandidatureResponse> {
                    override fun onResponse(
                        call: Call<CandidatureResponse>,
                        response: Response<CandidatureResponse>
                    ) {
                        if (response.code() == 200) {
                            Log.d("TAG1onResponse", response.body().toString())
                        } else
                            Log.d("TAG1onResponse", response.code().toString())


                    }

                    override fun onFailure(call: Call<CandidatureResponse>, t: Throwable) {
                        Log.d("TAG1onFailure", t.message.toString())
                    }

                })
            }
        }
        return isResultValid
    }
    private fun setupActionBar() {

        setSupportActionBar(toolbar_postuler_activity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
            actionBar.title = resources.getString(R.string.Home)
        }

        toolbar_postuler_activity.setNavigationOnClickListener { onBackPressed() }
    }
}