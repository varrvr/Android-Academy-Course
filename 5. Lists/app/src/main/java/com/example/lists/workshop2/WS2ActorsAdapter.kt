package com.example.lists.workshop2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.lists.R
import com.example.lists.models.Actor

class WS2ActorsAdapter : RecyclerView.Adapter<ActorsViewHolder>() {

    private val imageOption = RequestOptions()
        .placeholder(R.drawable.ic_avatar_placeholder)
        .fallback(R.drawable.ic_avatar_placeholder)
        .circleCrop()

    private var actors = listOf<Actor>()

    override fun getItemViewType(position: Int): Int {
        return when (actors.size) {
            0 -> VIEW_TYPE_EMPTY
            else -> VIEW_TYPE_ACTORS
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorsViewHolder {
        return when (viewType) {
            VIEW_TYPE_EMPTY -> EmptyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_actors_empty, parent, false))
            else -> DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_actors_data, parent, false))
        }
    }

    override fun onBindViewHolder(holder: ActorsViewHolder, position: Int) {
        when (holder) {
            is DataViewHolder -> { holder.onBind(imageOption, actors[position]) }
            is EmptyViewHolder -> { /* nothing to bind */ }
        }
    }

    override fun getItemCount(): Int = actors.size

    fun bindActors(newActors: List<Actor>) {
        actors = newActors
    }
}

abstract class ActorsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

private class EmptyViewHolder(itemView: View) : ActorsViewHolder(itemView)
private class DataViewHolder(itemView: View) : ActorsViewHolder(itemView) {
    private val avatar: ImageView = itemView.findViewById(R.id.iv_actor_avatar)
    private val name: TextView? = itemView.findViewById(R.id.tv_actor_name)
    private val oscarState: TextView? = itemView.findViewById(R.id.tv_actor_oscar_state)

    fun onBind(options: RequestOptions, actor: Actor) {
        Glide.with(context)
            .load(actor.avatar)
            .apply(options)
            .into(avatar)

        name?.text = actor.name

        oscarState?.text = context.getString(
            R.string.fragment_actors_avatar_oscar_state_text,
            actor.hasOscar.toString()
        )
    }
}

private val RecyclerView.ViewHolder.context
    get() = this.itemView.context

private const val VIEW_TYPE_EMPTY = 0
private const val VIEW_TYPE_ACTORS = 1