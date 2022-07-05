package com.example.parecrutement.User

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kbe.protectioncivile.myapplicationrecrutement.api.candidature.model.CandidatureResponse


class FormsAdapter(
    private val forms: List<CandidatureResponse>,
    private val onFormClickedListener: FormsViewHolder.OnFormClickedListener
) :
    RecyclerView.Adapter<FormsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FormsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FormsViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = forms.size


    override fun onBindViewHolder(holder: FormsViewHolder, position: Int) {
        val form = forms[position]
        holder.bind(position+1, form, onFormClickedListener)
    }
}