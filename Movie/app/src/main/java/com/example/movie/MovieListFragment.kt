package com.example.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MovieListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_movie_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ViewCompat.setOnApplyWindowInsetsListener(view) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }

        val movies = listOf(
            Movie(
                title = "Avengers: End Game",
                age = "13+",
                genre = "Action, Adventure, Fantasy",
                reviews = 125,
                duration = 181,
                posterRes = R.drawable.movie,
                bannerRes = R.drawable.mask          // для Avengers баннер = mask
            ),
            Movie(
                title = "Tenet",
                age = "16+",
                genre = "Sci-Fi, Thriller",
                reviews = 89,
                duration = 91,
                posterRes = R.drawable.tenet,
                bannerRes = R.drawable.tenet        // для остальных — их баннер
            ),
            Movie(
                title = "Black Widow",
                age = "13+",
                genre = "Action, Adventure, Sci-Fi",
                reviews = 38,
                duration = 134,
                posterRes = R.drawable.black_widow,
                bannerRes = R.drawable.black_widow
            ),
            Movie(
                title = "Wonder Woman 1984",
                age = "13+",
                genre = "Action, Adventure, Fantasy",
                reviews = 76,
                duration = 120,
                posterRes = R.drawable.wonder_woman,
                bannerRes = R.drawable.wonder_woman
            )
        )

        val rv = view.findViewById<RecyclerView>(R.id.rvMovies)
        rv.layoutManager = GridLayoutManager(requireContext(), 2)
        rv.adapter = MovieAdapter(movies) { movie ->
            val frag = MovieDetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt("bannerRes", movie.bannerRes)
                    putString("title",    movie.title)
                    putString("age",      movie.age)
                    putString("genre",    movie.genre)
                    putInt("reviews",     movie.reviews)
                    putInt("duration",    movie.duration)
                }
            }
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, frag)
                .addToBackStack(null)
                .commit()
        }
    }
}
