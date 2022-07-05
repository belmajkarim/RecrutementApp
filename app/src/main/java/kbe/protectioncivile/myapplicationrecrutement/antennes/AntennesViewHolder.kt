package kbe.protectioncivile.myapplicationrecrutement.antennes

import kbe.protectioncivile.myapplicationrecrutement.R
import kbe.protectioncivile.myapplicationrecrutement.api.antennes.model.AntennesResponse
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AntennesViewHolder (inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_antennes, parent, false)),
    View.OnClickListener {
    interface OnAntennesClickedListener {
        fun onAntennesClicked(antennes: AntennesResponse?)
    }

    private var antennes: AntennesResponse? = null

    private var NomAntenneTextView: TextView? = itemView.findViewById(R.id.NomAntenne)
    private var AdresseAntenneTextView: TextView? = itemView.findViewById(R.id.AdresseAntenne)
    private var onAntennesClickedListener: OnAntennesClickedListener? = null


    fun bind(position: Int, antennes: AntennesResponse, onAntennesClickedListener: OnAntennesClickedListener) {
        this.antennes = antennes
        this.onAntennesClickedListener = onAntennesClickedListener

        NomAntenneTextView?.text = antennes.nomSite
        AdresseAntenneTextView?.text = antennes.adresseAntenne


        itemView.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        onAntennesClickedListener?.onAntennesClicked(antennes)
    }
}
