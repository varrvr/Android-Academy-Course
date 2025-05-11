package com.example.lists.workshop3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lists.R
import com.example.lists.domain.ActorDataSource
import com.example.lists.models.Actor
import com.google.android.material.snackbar.Snackbar

class WS3ActorsFragment : Fragment() {

    private var recycler: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_actors, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recycler = view.findViewById(R.id.rv_actors)
        recycler?.adapter = WS3ActorsAdapter(clickListener)
    }

    override fun onStart() {
        super.onStart()

        updateData()
    }

    override fun onDetach() {
        recycler = null

        super.onDetach()
    }

    private fun updateData() {
        (recycler?.adapter as? WS3ActorsAdapter)?.apply {
            bindActors(ActorDataSource().getActors())
        }
    }

    private fun doOnClick(actor: Actor) {
        recycler?.let { rv ->
            Snackbar.make(
                rv,
                getString(R.string.fragment_actors_chosen_text, actor.name),
                Snackbar.LENGTH_SHORT)
                .show()
        }
    }

    private val clickListener = object : OnRecyclerItemClicked {
        override fun onClick(actor: Actor) {
            doOnClick(actor)
        }
    }

    companion object {
        fun newInstance() = WS3ActorsFragment()
    }
}