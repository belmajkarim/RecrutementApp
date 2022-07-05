package kbe.protectioncivile.myapplicationrecrutement.User

import kbe.protectioncivile.myapplicationrecrutement.R
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kbe.protectioncivile.myapplicationrecrutement.api.users.model.UserResponse
import kbe.protectioncivile.myapplicationrecrutement.api.users.service.ProfileService
import kbe.protectioncivile.myapplicationrecrutement.api.provider.AppPreferences
import kotlinx.android.synthetic.main.activity_all_users.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllUsersActivity : AppCompatActivity(), UserViewHolder.OnUserClickedListener {

    private var users: List<UserResponse>? = null
    companion object {
        fun navigateTo(context: Context, param1: String) {
            context.startActivity(Intent(context, AllUsersActivity::class.java))
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_users)
        setupActionBar()
        val Token = AppPreferences.Token

            ProfileService().GetAllUsers(Token, object :
                Callback<List<UserResponse>> {
                override fun onResponse(
                    call: Call<List<UserResponse>>,
                    response: Response<List<UserResponse>>
                ) {
                    Log.d("TAG", response.body().toString())
                    users = response.body()
                    if(users?.size == 0){
                        Toast.makeText(applicationContext,"No users ! ",Toast.LENGTH_LONG).show()
                    }
                    else{
                        myrecyclerview.apply {
                            layoutManager = LinearLayoutManager(this@AllUsersActivity)
                            adapter = users?.let { UserAdapter(it,this@AllUsersActivity) }
                        }
                       /* myformsview.apply {
                            layoutManager = LinearLayoutManager(this@AllUsersActivity)
                            adapter = users?.let { FormsAdapter(it,this@AllUsersActivity) }
                        }*/
                    }
                }

                override fun onFailure(call: Call<List<UserResponse>>, t: Throwable) {
                    Log.d("TAG3", t.toString())
                }
            })


    }
    private fun setupActionBar() {

        setSupportActionBar(toolbar_Allusers_activity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
            actionBar.title = resources.getString(R.string.Home)
        }

        toolbar_Allusers_activity.setNavigationOnClickListener { onBackPressed() }


    }

    override fun onUserClicked(user: UserResponse?) {
        if (user != null) {
           /* val intent = Intent(this, UserFormDetailActivity::class.java)
            startActivity(intent)*/
            UserFormDetailActivity.navigateTo(this, user.email)
        }
    }
}