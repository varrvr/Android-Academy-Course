package com.example.lists.workshop2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.lists.R
import com.example.lists.domain.ActorDataSource

class WS2ActorsFragment : Fragment() {

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
        recycler?.adapter = WS2ActorsAdapter()
    }

    override fun onStart() {
        super.onStart()

        updateData()
    }

    private fun updateData() {
        (recycler?.adapter as? WS2ActorsAdapter)?.apply {
            bindActors(ActorDataSource().getActors())
        }
    }

    companion object {
        fun newInstance() = WS2ActorsFragment()
    }
}