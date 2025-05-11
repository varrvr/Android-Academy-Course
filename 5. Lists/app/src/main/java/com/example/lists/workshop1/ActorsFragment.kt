package com.example.lists.workshop1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lists.R
import com.example.lists.domain.ActorDataSource

class ActorsFragment : Fragment() {

    // TODO 01: create a nullable var of the "androidx.recyclerview.widget.RecyclerView" class.
    private var recyclerView: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // TODO 02: Open a file: "../res/layout/fragment_actors.xml".
        //  You can see a recycler view: "rv_actors". This is your recycler.
        return inflater.inflate(R.layout.fragment_actors, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // TODO 03: First of all, find recycler view inside the fragment "view" and store to a variable.
        recyclerView = view.findViewById(R.id.rv_actors)
        // TODO 04: Instantiate the WS01ActorsAdapter and assign it to a recycler's adapter.
        recyclerView?.adapter = ActorsAdapter()
    }

    override fun onStart() {
        super.onStart()

        updateData()
    }

    private fun updateData() {
        // TODO 05: Uncomment and fix "someRecycler" name if needed.
        (recyclerView?.adapter as? ActorsAdapter)?.apply {
            bindActors(ActorDataSource().getActors())
        }

        // TODO 06: Open the WS01ActorsAdapter.kt file.
    }

    companion object {
        fun newInstance() = ActorsFragment()
    }
}
