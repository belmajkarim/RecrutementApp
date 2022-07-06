package kbe.protectioncivile.myapplicationrecrutement

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.GravityCompat
import kbe.protectioncivile.myapplicationrecrutement.Candidature.PostulerActivity
import kbe.protectioncivile.myapplicationrecrutement.Candidature.SuiviCandidatureActivity
import kbe.protectioncivile.myapplicationrecrutement.User.AllUsersActivity
import kbe.protectioncivile.myapplicationrecrutement.antennes.AntenneActivity
import kbe.protectioncivile.myapplicationrecrutement.antennes.CreateAntenne
import kbe.protectioncivile.myapplicationrecrutement.api.provider.AppPreferences
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupActionBar()
        if(AppPreferences.Role.equals("User")){
            nav_view.menu.removeItem(R.id.nav_Create_Antennes)
            nav_view.menu.removeItem(R.id.nav_UserManagement)
        }else
        {
            nav_view.menu.removeItem(R.id.nav_postuler)
            nav_view.menu.removeItem(R.id.nav_suivi_Candidature)
        }
        nav_view.setNavigationItemSelectedListener (this)
        val cardAider = findViewById<CardView>(R.id.AiderCard)
        val secourirCard = findViewById<CardView>(R.id.SecourirCard)
        val FormerCard = findViewById<CardView>(R.id.FormerCard)



        Cards(cardAider, secourirCard, FormerCard)

    }


    private fun Cards(cardAider: CardView,secourirCard: CardView, FormerCard: CardView)
    {
        cardAider.setOnClickListener {
            val intent = Intent(this, kbe.protectioncivile.myapplicationrecrutement.AiderActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
        secourirCard.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.protection-civile.org/dispositif-previsionnel-de-secours/")
            startActivity(openURL)
        }
        FormerCard.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://formations.protection-civile.org/")
            startActivity(openURL)
        }
    }

    private fun setupActionBar(){
        setSupportActionBar(toolbar_main_activity)
        toolbar_main_activity.setNavigationIcon(R.drawable.ic_action_navigation_menu)


        toolbar_main_activity.setNavigationOnClickListener {
            toggleDrawer()
        }
    }
    private fun toggleDrawer() {

        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            drawer_layout.openDrawer(GravityCompat.START)
        }
    }
    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            // A double back press function is added in Base Activity.
            doubleBackToExit()
        }
    }

    private fun doubleBackToExit() {
        super.onBackPressed()
    }

    companion object {
        fun navigateTo(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_my_profile ->{
                Toast.makeText(this@MainActivity,"Mon profil", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MyProfileActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
            R.id.nav_sign_out->{
                Toast.makeText(this@MainActivity,"Déconnexion", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LoginActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()
            }
            R.id.nav_postuler->{
                Toast.makeText(this@MainActivity,"Postuler", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, PostulerActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)

            }
            R.id.nav_suivi_Candidature->{
                Toast.makeText(this@MainActivity,"Suivi", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SuiviCandidatureActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
            R.id.nav_Antennes->{
                Toast.makeText(this@MainActivity,"Antennes", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, AntenneActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
            R.id.nav_Create_Antennes->{
                Toast.makeText(this@MainActivity,"Create Antenne", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, CreateAntenne::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }

            R.id.nav_UserManagement->{
                Toast.makeText(this@MainActivity,"Gestion des utilisateurs", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, AllUsersActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }

        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

}