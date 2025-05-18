package com.example.movie

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val ivPhoto: ImageView = itemView.findViewById(R.id.ivActorPhoto)
    private val tvName: TextView    = itemView.findViewById(R.id.tvActorName)

    fun bind(actor: Actor) {
        ivPhoto.setImageResource(actor.photoRes)
        tvName.text = actor.name
    }
}
