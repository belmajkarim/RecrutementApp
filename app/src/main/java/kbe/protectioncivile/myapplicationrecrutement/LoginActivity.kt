package kbe.protectioncivile.myapplicationrecrutement

import kbe.protectioncivile.myapplicationrecrutement.api.authentication.model.LoginModel
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kbe.protectioncivile.myapplicationrecrutement.api.SessionService.SessionService
import kbe.protectioncivile.myapplicationrecrutement.api.authentication.model.TokenResponse
import kbe.protectioncivile.myapplicationrecrutement.api.provider.AppPreferences
import kbe.protectioncivile.myapplicationrecrutement.api.authentication.service.AuthenticationService
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class LoginActivity : AppCompatActivity() {
    var isResultValid: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailInput = findViewById<EditText>(R.id.et_email)
        val passwordInput = findViewById<EditText>(R.id.et_password)
        val LoginButton = findViewById<Button>(R.id.btn_sign_in)
        val InscriptionButton = findViewById<Button>(R.id.btn_sign_up_login)
        LoginButton.setOnClickListener{
            login(emailInput, passwordInput)
        }
        InscriptionButton.setOnClickListener{
            val intent = Intent(this, InscriptionActivity::class.java)
            startActivity(intent)
        }
    }


    private fun login(emailInput: EditText?, passwordInput: EditText?): Boolean {
        val email = emailInput?.text.toString()
        val password = passwordInput?.text.toString()

        if(email.isNotEmpty() && password.isNotEmpty() && email.isNotBlank() && password.isNotBlank()) {
            val loginService = AuthenticationService()

            loginService.login(LoginModel(email = email, password = password), object :
                Callback<TokenResponse> {
                override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
//                    Log.d("TAG", response.body().toString())
                    if (response.code() == 200){
                        //Log.d("TAG1onResponseToken", response.body()?.Token!!)
                        AppPreferences.init(applicationContext)
                        AppPreferences.Token = response.body()?.Token!!
                        AppPreferences.Role = response.body()?.role!!
                        val tokenResponse = SessionService().retrieveUserInfoViaToken(AppPreferences.Token);
                        AppPreferences.email = tokenResponse.email;
                        AppPreferences.Userid = response.body()?.Id!!;
                        isResultValid = true
                        MainActivity.navigateTo(this@LoginActivity)
                    } else {
                        Log.d("TAG1", response.code().toString())
                        Toast.makeText(
                            applicationContext,
                            "Login Failed ! ",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
                override fun onFailure(call: Call<TokenResponse>, t: Throwable) {

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