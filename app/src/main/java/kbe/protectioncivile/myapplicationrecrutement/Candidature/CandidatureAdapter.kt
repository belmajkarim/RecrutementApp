package kbe.protectioncivile.myapplicationrecrutement.Candidature

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kbe.protectioncivile.myapplicationrecrutement.api.candidature.model.CandidatureResponse

class CandidatureAdapter (
    private val candidatures: List<CandidatureResponse>,
    private val onCandidatureClickedListener: CandidatureViewHolder.OnCandidatureClickedListener
) :
    RecyclerView.Adapter<CandidatureViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CandidatureViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return CandidatureViewHolder(
            inflater,
            parent
        )
    }

    override fun getItemCount(): Int = candidatures.size
    override fun onBindViewHolder(holder: CandidatureViewHolder, position: Int) {
        val candidature = candidatures[position]

        holder.bind(position+1,candidature, onCandidatureClickedListener)
    }


}
