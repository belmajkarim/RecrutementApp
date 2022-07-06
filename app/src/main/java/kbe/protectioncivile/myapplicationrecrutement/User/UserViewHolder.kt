package kbe.protectioncivile.myapplicationrecrutement.User

import kbe.protectioncivile.myapplicationrecrutement.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kbe.protectioncivile.myapplicationrecrutement.api.users.model.UserResponse

class UserViewHolder (inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.ma_ligne_users, parent, false)),
    View.OnClickListener {
    interface OnUserClickedListener {
        fun onUserClicked(user: UserResponse?)
    }

    private var user: UserResponse? = null


    private var firstNameTextView: TextView? = itemView.findViewById(R.id.prenom_user)
    private var LastNameTextView: TextView? = itemView.findViewById(R.id.nom_user)
    private var emailTextView: TextView? = itemView.findViewById(R.id.email_user)
    private var formsTextView: TextView? = itemView.findViewById(R.id.form_user)
    private var postpostulesTextView: TextView? = itemView.findViewById(R.id.postepostuleuser)
    //private var formsTextView: RecyclerView? = itemView.findViewById(R.id.myformsview)
    private var onUserClickedListener: OnUserClickedListener? = null


    fun bind(position: Int, user: UserResponse, onUserClickedListener: OnUserClickedListener) {
        this.user = user
        this.onUserClickedListener = onUserClickedListener

        firstNameTextView?.append("Nom : "+user.firstName)
        LastNameTextView?.text = user.lastName
        emailTextView?.text = user.email
        for (i in 0 until user.forms.size) {
            formsTextView?.append(user.forms[i].statusCondidat+"; ")
        }
        for (i in 0 until user.forms.size) {
            postpostulesTextView?.append(user.forms[i].postPostuler+"; ")
        }
        //formsTextView?.text = user.forms.first().statusCondidat




        itemView.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        onUserClickedListener?.onUserClicked(user)
    }
}