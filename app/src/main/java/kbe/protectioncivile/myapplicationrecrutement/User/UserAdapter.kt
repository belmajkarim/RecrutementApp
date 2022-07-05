package kbe.protectioncivile.myapplicationrecrutement.User

import kbe.protectioncivile.myapplicationrecrutement.api.users.model.UserResponse
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(
    private val users: List<UserResponse>,
    private val onUserClickedListener: UserViewHolder.OnUserClickedListener
) :
    RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return UserViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.bind(position+1, user, onUserClickedListener)
    }
}

