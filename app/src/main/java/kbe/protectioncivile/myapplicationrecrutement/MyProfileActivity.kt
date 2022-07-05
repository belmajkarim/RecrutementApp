package kbe.protectioncivile.myapplicationrecrutement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kbe.protectioncivile.myapplicationrecrutement.api.users.model.UpdateUserResponse
import kbe.protectioncivile.myapplicationrecrutement.api.users.model.UserModel
import kbe.protectioncivile.myapplicationrecrutement.api.users.model.UserResponse
import kbe.protectioncivile.myapplicationrecrutement.api.users.service.ProfileService
import kbe.protectioncivile.myapplicationrecrutement.api.provider.AppPreferences
import kotlinx.android.synthetic.main.activity_my_profile.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyProfileActivity : AppCompatActivity() {
    private var userResponse: UserResponse? = null
    private var UpdateuserResponse: UpdateUserResponse? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)

        val UpdateButton = findViewById<Button>(R.id.btn_update)
        UpdateButton.setOnClickListener{
            updateUser()
        }

        setupActionBar()

        val Token = AppPreferences.Token
        val userId = AppPreferences.Userid

        if(Token == "") {
            LoginActivity.navigateTo(this)
        } else {
                ProfileService().getUserByID(Token, userId, object :
                    Callback<UserResponse> {
                    override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>)
                    {
                        if (response.body() != null) {
                            userResponse = response.body()
                            AppPreferences.Username = response.body()!!.firstName
                            AppPreferences.UserLastname = response.body()!!.lastName
                            AppPreferences.email = response.body()!!.email
                            setUserResponseData()
                        } else {
                            Log.d("TAG2", response.code().toString())
                        }
                    }
                    override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                        Log.d("TAG1onfailure", t.toString())
                    }
                })
               }
    }

    private fun updateUser() {
        val FirstNameInput = findViewById<EditText>(R.id.et_name)
        val LastNameInput = findViewById<EditText>(R.id.et_lastname)
        val emailInput = findViewById<EditText>(R.id.et_email)
        val FirstName = FirstNameInput?.text.toString()
        val LastName = LastNameInput?.text.toString()
        val emailupdate = emailInput?.text.toString()
        ProfileService().UpdateUserByID(
            AppPreferences.Token, AppPreferences.Userid,
            UserModel(AppPreferences.Userid,FirstName,LastName,emailupdate), object :
        Callback<UpdateUserResponse> {
            override fun onResponse(
                call: Call<UpdateUserResponse>,
                response: Response<UpdateUserResponse>
            ) {
                if (response.code() == 202) {
                    Log.d("TAGresponsebody", response.body().toString())
                    UpdateuserResponse = response.body()
                    updateUserResponseData()
                    Toast.makeText(
                        applicationContext,
                        "update done",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Log.d("TAG2", response.code().toString())
                }
            }

            override fun onFailure(call: Call<UpdateUserResponse>, t: Throwable) {
                Log.d("TAGonfailureUpdate", t.toString())
            }

        })
    }

    fun setUserResponseData() {
        if (userResponse != null) {
            et_name.setText(userResponse?.firstName)
            et_lastname.setText(userResponse?.lastName)
            et_email.setText(userResponse?.email)
        } else {
            LoginActivity.navigateTo(this)
        }
    }
    fun updateUserResponseData() {
        if (UpdateuserResponse != null) {
            et_name.setText(UpdateuserResponse?.firstName)
            et_lastname.setText(UpdateuserResponse?.lastName)
            et_email.setText(UpdateuserResponse?.email)
        } else {
            LoginActivity.navigateTo(this)
        }
    }
    private fun setupActionBar() {

        setSupportActionBar(toolbar_my_profile_activity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
            actionBar.title = resources.getString(R.string.my_profile)
        }

        toolbar_my_profile_activity.setNavigationOnClickListener { onBackPressed() }
    }
}