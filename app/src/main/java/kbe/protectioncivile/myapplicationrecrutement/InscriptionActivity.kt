package kbe.protectioncivile.myapplicationrecrutement


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kbe.protectioncivile.myapplicationrecrutement.api.authentication.model.InscriptionModel
import kbe.protectioncivile.myapplicationrecrutement.api.authentication.model.InscriptionResponse
import kbe.protectioncivile.myapplicationrecrutement.api.authentication.service.InscriptionService
import kotlinx.android.synthetic.main.activity_inscription.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class InscriptionActivity : AppCompatActivity() {
    var isResultValid: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_inscription)


        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setupActionBar()
        val submitButton = findViewById<Button>(R.id.btn_sign_up)
        val emailInput = findViewById<EditText>(R.id.et_Inscriptionemail)
        val passwordInput = findViewById<EditText>(R.id.et_Inscriptionpassword)
        val firstName = findViewById<EditText>(R.id.et_firstname)
        val lastName = findViewById<EditText>(R.id.et_lastname)
        submitButton.setOnClickListener{
            signup(firstName,lastName,emailInput, passwordInput)
        }
    }


    private fun setupActionBar() {

        setSupportActionBar(toolbar_sign_up_activity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_black_color_back_24dp)
        }

        toolbar_sign_up_activity.setNavigationOnClickListener { LoginActivity.navigateTo(this@InscriptionActivity) }
    }
    private fun signup(firstNameInput: EditText?, lastNameInput: EditText?,emailInput: EditText?,passwordInput: EditText?): Boolean {
        val email = emailInput?.text.toString()
        val password = passwordInput?.text.toString()
        val firstname = firstNameInput?.text.toString()
        val lastname = lastNameInput?.text.toString()

        if(firstname.isNotEmpty() && lastname.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && email.isNotBlank() && password.isNotBlank()) {
            val inscriptionService = InscriptionService()

            inscriptionService.inscription(InscriptionModel(firstName = firstname, lastName = lastname,email = email, password = password), object :
                Callback<InscriptionResponse> {
                override fun onResponse(call: Call<InscriptionResponse>, response: Response<InscriptionResponse>) {
                    Log.d("TAG", response.body().toString())
                    if (response.code() == 201){
                        isResultValid = true
                        LoginActivity.navigateTo(this@InscriptionActivity)
                    } else {
                        Log.d("TAG1", response.code().toString())
                        Toast.makeText(
                            applicationContext,
                            "Login Failed ! ",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
                override fun onFailure(call: Call<InscriptionResponse>, t: Throwable) {

                    Toast.makeText(
                        applicationContext,
                        call.toString(),
                        Toast.LENGTH_LONG
                    ).show()
                    Log.d("TAG1Failure", t.toString())

                }
            })
        }

        return isResultValid
    }
    companion object {
        fun navigateTo(context: Context) {
            context.startActivity(Intent(context, LoginActivity::class.java))
        }
    }
}