package kbe.protectioncivile.myapplicationrecrutement.antennes

import kbe.protectioncivile.myapplicationrecrutement.R
import kbe.protectioncivile.myapplicationrecrutement.api.antennes.model.AntennesResponse
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kbe.protectioncivile.myapplicationrecrutement.api.antennes.service.AntennesService
import kbe.protectioncivile.myapplicationrecrutement.api.provider.AppPreferences



import kotlinx.android.synthetic.main.activity_antenne.*
import kotlinx.android.synthetic.main.activity_suivi_candidature.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AntenneActivity : AppCompatActivity(), AntennesViewHolder.OnAntennesClickedListener {
    private var antennes: List<AntennesResponse>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_antenne)
        setupActionBar()
        AntennesService().GetAllAntennes(AppPreferences.Token, object :
            Callback<List<AntennesResponse>> {
            override fun onResponse(call: Call<List<AntennesResponse>>, response: Response<List<AntennesResponse>>)
            {
                antennes = response.body()
                if (antennes?.size == 0){
                    candidatureRecyclerView?.visibility = View.GONE

                }else{

                    antennesRecyclerView.apply {
                        layoutManager = LinearLayoutManager(this@AntenneActivity)
                        adapter = antennes?.let { AntennesAdapter(it,this@AntenneActivity) }
                    }
                }
            }

            override fun onFailure(call: Call<List<AntennesResponse>>, t: Throwable)
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

        setSupportActionBar(toolbar_antennes_activity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
            actionBar.title = resources.getString(R.string.Home)
        }

        toolbar_antennes_activity.setNavigationOnClickListener { onBackPressed() }
    }

    override fun onAntennesClicked(antennes: AntennesResponse?) {
        val adresse = antennes?.adresseAntenne
        val gmmIntentUri =
            Uri.parse("geo:37.7749,-122.4194?z=10&q= "+adresse)
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }
}