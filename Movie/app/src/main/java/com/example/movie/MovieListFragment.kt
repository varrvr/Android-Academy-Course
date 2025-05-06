package com.example.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView

class MovieListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_movie_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val card = view.findViewById<MaterialCardView>(R.id.cardMovie)

        card.setOnClickListener {
            val details = MovieDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString("title", "Avengers: Endgame")
                    //toDo добавить другие поля
                }
            }
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, details)
                .addToBackStack(null)
                .commit()
        }
    }
}