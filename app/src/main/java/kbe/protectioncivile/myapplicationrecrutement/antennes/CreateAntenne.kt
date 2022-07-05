package kbe.protectioncivile.myapplicationrecrutement.antennes

import kbe.protectioncivile.myapplicationrecrutement.MainActivity
import kbe.protectioncivile.myapplicationrecrutement.R
import kbe.protectioncivile.myapplicationrecrutement.api.antennes.model.AntennesModel
import kbe.protectioncivile.myapplicationrecrutement.api.antennes.model.AntennesResponse
import kbe.protectioncivile.myapplicationrecrutement.api.antennes.service.AntennesService
import kbe.protectioncivile.myapplicationrecrutement.api.provider.AppPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create_antenne.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateAntenne : AppCompatActivity() {
    var isResultValid: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_antenne)
        setupActionBar()
        val createButton = findViewById<Button>(R.id.btn_create_antenne)
        val nameAntenneInput = findViewById<EditText>(R.id.et_AntenneName)
        val adressAntenneInput = findViewById<EditText>(R.id.et_AntenneAdress)

        createButton.setOnClickListener{
            createAntenne(nameAntenneInput, adressAntenneInput)
        }
    }

    private fun createAntenne(nameAntenneInput: EditText?, adressAntenneInput: EditText?): Boolean {
        val nameAntenne = nameAntenneInput?.text.toString()
        val adressAntenne = adressAntenneInput?.text.toString()

        if(nameAntenne.isNotEmpty() && adressAntenne.isNotEmpty()){
            val antennesservice = AntennesService()

            antennesservice.CreateAntenne(
                AppPreferences.Token,
                AntennesModel(nameAntenne,adressAntenne), object :
            Callback<AntennesResponse> {
                override fun onResponse(call: Call<AntennesResponse>, response: Response<AntennesResponse>) {
                    if (response.code() == 201){
                        isResultValid = true
                        MainActivity.navigateTo(this@CreateAntenne)
                        Toast.makeText(
                            applicationContext,
                            "Antenne créée avec succès  ! ",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                       // Log.d("TAG1", response.code().toString())
                        Toast.makeText(
                            applicationContext,
                            "Failed ! ",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

                override fun onFailure(call: Call<AntennesResponse>, t: Throwable) {
                    Toast.makeText(
                        applicationContext,
                        "Failed ! ",
                        Toast.LENGTH_LONG
                    ).show()
                }

            })
        }
        return isResultValid
    }

    private fun setupActionBar() {

        setSupportActionBar(toolbar_Create_Antenne_activity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
            actionBar.title = resources.getString(R.string.Home)
        }

        toolbar_Create_Antenne_activity.setNavigationOnClickListener { onBackPressed() }
    }
}