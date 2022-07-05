package kbe.protectioncivile.myapplicationrecrutement.Candidature

import kbe.protectioncivile.myapplicationrecrutement.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kbe.protectioncivile.myapplicationrecrutement.api.candidature.model.CandidatureResponse

class CandidatureViewHolder (inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_candidature, parent, false)),
    View.OnClickListener {
    interface OnCandidatureClickedListener {
        fun onCandidatureClicked(candidature: CandidatureResponse?)
    }

    private var candidature: CandidatureResponse? = null

    private var AdressePostaleTextView: TextView? = itemView.findViewById(R.id.AdresseCandidature)
    private var PostepostuleTextView: TextView? = itemView.findViewById(R.id.PostpostuleCandidature)
    private var DiplomeSecourismeTextView: TextView? = itemView.findViewById(R.id.DiplomeCandidature)
    private var StatutCandidatureTextView: TextView? = itemView.findViewById(R.id.StatutCandidature)
    private var onCandidatureClickedListener: OnCandidatureClickedListener? = null


    fun bind(position: Int, candidature: CandidatureResponse, onCandidatureClickedListener: OnCandidatureClickedListener) {
        this.candidature = candidature
        this.onCandidatureClickedListener = onCandidatureClickedListener

       AdressePostaleTextView?.text = candidature.adressePostale
       PostepostuleTextView?.text = candidature.postPostuler
       DiplomeSecourismeTextView?.text = candidature.diplomeSecourisme
       StatutCandidatureTextView?.text = candidature.statusCondidat

        itemView.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        onCandidatureClickedListener?.onCandidatureClicked(candidature)
    }
}
