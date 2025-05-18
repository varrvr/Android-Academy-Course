package com.example.movie

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val ivPoster: ImageView = itemView.findViewById(R.id.ivPoster)
    private val tvAge: TextView = itemView.findViewById(R.id.tvAge)
    private val tvTitle: TextView  = itemView.findViewById(R.id.tvTitle)
    private val tvGenre: TextView  = itemView.findViewById(R.id.tvGenre)
    private val ivStar1: ImageView = itemView.findViewById(R.id.star1)
    private val ivStar2: ImageView = itemView.findViewById(R.id.star2)
    private val ivStar3: ImageView = itemView.findViewById(R.id.star3)
    private val ivStar4: ImageView = itemView.findViewById(R.id.star4)
    private val ivStar5: ImageView = itemView.findViewById(R.id.star5)
    private val tvReviews: TextView= itemView.findViewById(R.id.tvReviews)

    fun bind(movie: Movie) {
        ivPoster.setImageResource(movie.posterRes)
        tvAge.text    = movie.age
        tvTitle.text  = movie.title
        tvGenre.text  = movie.genre

        ivStar1.setImageResource(R.drawable.star_icon)
        ivStar2.setImageResource(R.drawable.star_icon)
        ivStar3.setImageResource(R.drawable.star_icon)
        ivStar4.setImageResource(R.drawable.star_icon)
        ivStar5.setImageResource(R.drawable.star_icon_gr)
        tvReviews.text = "${movie.reviews} reviews"
    }
}
