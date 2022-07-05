package com.example.parecrutement.User

import kbe.protectioncivile.myapplicationrecrutement.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kbe.protectioncivile.myapplicationrecrutement.api.candidature.model.CandidatureResponse

class FormsViewHolder (inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.ma_ligneforms_users, parent, false)),
    View.OnClickListener {
    interface OnFormClickedListener {
        fun onFormClicked(user: CandidatureResponse?)
    }

    private var form: CandidatureResponse? = null


    private var AdresseUserForm: TextView? = itemView.findViewById(R.id.adresseUserForm)
    private var postepostuleuserForm: TextView? = itemView.findViewById(R.id.postepostuleuserForm)
    private var professionuserForm: TextView? = itemView.findViewById(R.id.professionuserForm)
    private var diplomeuserForm: TextView? = itemView.findViewById(R.id.diplomeuserForm)
    private var statususerForm: TextView? = itemView.findViewById(R.id.statususerForm)
    private var onFormsClickedListener: OnFormClickedListener? = null


    fun bind(position: Int, form: CandidatureResponse, onFormsClickedListener: OnFormClickedListener) {
        this.form = form
        this.onFormsClickedListener = onFormsClickedListener

        AdresseUserForm?.text = form.adressePostale
        postepostuleuserForm?.text = form.postPostuler
        professionuserForm?.text = form.profession
        diplomeuserForm?.text = form.diplomeSecourisme
        statususerForm?.text = form.statusCondidat
        //formsTextView?.



        itemView.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        onFormsClickedListener?.onFormClicked(form)
    }
}