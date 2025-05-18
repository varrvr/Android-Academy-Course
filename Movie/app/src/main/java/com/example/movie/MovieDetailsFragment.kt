package com.example.movie

import ActorAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MovieDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_movie_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.main)) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }

        view.findViewById<TextView>(R.id.tv_back).setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        view.findViewById<ImageView>(R.id.img_back).setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        val args      = requireArguments()
        val bannerRes = args.getInt("bannerRes")
        val title     = args.getString("title", "")
        val age       = args.getString("age", "")
        val genre     = args.getString("genre", "")
        val reviews   = args.getInt("reviews", 0)
        val duration  = args.getInt("duration", 0)

        view.findViewById<ImageView>(R.id.main_image)
            .setImageResource(bannerRes)
        view.findViewById<TextView>(R.id.tv_name).text    = title
        view.findViewById<TextView>(R.id.tv_age).text     = age
        view.findViewById<TextView>(R.id.tv_genre).text   = genre
        view.findViewById<TextView>(R.id.tv_reviews).text = "$reviews reviews"
        view.findViewById<TextView>(R.id.tvDuration)?.text = "$duration MIN"

        val actors = listOf(
            Actor("Robert Downey Jr.", R.drawable.robert),
            Actor("Chris Evans",       R.drawable.chris),
            Actor("Mark Ruffalo",      R.drawable.mark),
            Actor("Chris Hemsworth",   R.drawable.chris2)
        )
        val rvCast = view.findViewById<RecyclerView>(R.id.rvCast)
        rvCast.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        rvCast.adapter = ActorAdapter(actors)
    }
}
