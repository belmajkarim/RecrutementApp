package kbe.protectioncivile.myapplicationrecrutement.User

import kbe.protectioncivile.myapplicationrecrutement.R
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parecrutement.User.FormsAdapter
import com.example.parecrutement.User.FormsViewHolder
import kbe.protectioncivile.myapplicationrecrutement.api.candidature.model.CandidatureResponse
import kbe.protectioncivile.myapplicationrecrutement.api.provider.AppPreferences.Token
import kbe.protectioncivile.myapplicationrecrutement.api.users.model.UserResponse
import kbe.protectioncivile.myapplicationrecrutement.api.users.service.ProfileService
import kotlinx.android.synthetic.main.activity_user_form_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserFormDetailActivity : AppCompatActivity(), FormsViewHolder.OnFormClickedListener {
    private var forms: List<CandidatureResponse>? = null
    companion object {
        private val PARAM1: String = "email"

        fun navigateTo(context: Context, param1: String) {
            val intent = Intent(context, UserFormDetailActivity::class.java).apply {
                putExtra(PARAM1, param1)
            }
            context.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_form_detail)

       //  val receivedEmail = intent?.getStringExtra("email")

        ProfileService().GetAllUsersForm(Token, object :
            Callback<List<CandidatureResponse>> {
            override fun onResponse(
                call: Call<List<CandidatureResponse>>,
                response: Response<List<CandidatureResponse>>
            ) {
                Log.d("TAG", response.body().toString());
                forms = response.body()
                if(forms?.size == 0){
                    Toast.makeText(applicationContext,"No users ! ", Toast.LENGTH_LONG).show()
                }
                else{
                    formsrecyclerview.apply {
                        layoutManager = LinearLayoutManager(this@UserFormDetailActivity)
                        adapter = forms?.let { FormsAdapter(it,this@UserFormDetailActivity) }
                    }
                    /* myformsview.apply {
                         layoutManager = LinearLayoutManager(this@AllUsersActivity)
                         adapter = users?.let { FormsAdapter(it,this@AllUsersActivity) }
                     }*/
                }
            }

            override fun onFailure(call: Call<List<CandidatureResponse>>, t: Throwable) {
                Log.d("TAG3", t.toString())
            }
        })
    }

    override fun onFormClicked(user: CandidatureResponse?) {

    }


}