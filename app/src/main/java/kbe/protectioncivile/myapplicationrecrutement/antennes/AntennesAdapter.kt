package kbe.protectioncivile.myapplicationrecrutement.antennes

import kbe.protectioncivile.myapplicationrecrutement.api.antennes.model.AntennesResponse
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AntennesAdapter(
    private val antennes: List<AntennesResponse>,
    private val onAntennesClickedListener: AntennesViewHolder.OnAntennesClickedListener
) :
    RecyclerView.Adapter<AntennesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AntennesViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return AntennesViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = antennes.size
    override fun onBindViewHolder(holder: AntennesViewHolder, position: Int) {
        val candidature = antennes[position]

        holder.bind(position+1,candidature, onAntennesClickedListener)
    }


}