package kbe.protectioncivile.myapplicationrecrutement.Candidature

import kbe.protectioncivile.myapplicationrecrutement.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kbe.protectioncivile.myapplicationrecrutement.api.candidature.model.CandidatureResponse
import kbe.protectioncivile.myapplicationrecrutement.api.candidature.service.CandidatureService
import kbe.protectioncivile.myapplicationrecrutement.api.provider.AppPreferences
import kotlinx.android.synthetic.main.activity_suivi_candidature.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SuiviCandidatureActivity : AppCompatActivity(), CandidatureViewHolder.OnCandidatureClickedListener  {
    private var candidatures: List<CandidatureResponse>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suivi_candidature)
        setupActionBar()
        CandidatureService().GetAllCandidaturesByID(AppPreferences.Token, object :
            Callback<List<CandidatureResponse>>{
            override fun onResponse(call: Call<List<CandidatureResponse>>, response: Response<List<CandidatureResponse>>)
            {
                candidatures = response.body()
                if (candidatures?.size == 0){
                    candidatureRecyclerView?.visibility = View.GONE

                }else{

                    candidatureRecyclerView.apply {
                        layoutManager = LinearLayoutManager(this@SuiviCandidatureActivity)
                        adapter = candidatures?.let {CandidatureAdapter(it,this@SuiviCandidatureActivity )}
                    }
                }
            }

            override fun onFailure(call: Call<List<CandidatureResponse>>, t: Throwable)
            {
                val toast = Toast.makeText(
                    applicationContext,
                    "Error while loading list content",
                    Toast.LENGTH_SHORT
                )
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
                toast.show()
            }

        })
    }

    private fun setupActionBar() {

        setSupportActionBar(toolbar_suivi_activity1)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
            actionBar.title = resources.getString(R.string.Home)
        }

        toolbar_suivi_activity1.setNavigationOnClickListener { onBackPressed() }
    }

    override fun onCandidatureClicked(candidature: CandidatureResponse?) {
        Toast.makeText(
            applicationContext,
            "Non Clickable !",
            Toast.LENGTH_LONG
        ).show()
    }
}