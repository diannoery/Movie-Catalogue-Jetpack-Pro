package com.example.moviecataloguejetpackprosub2.helper.view

import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.moviecataloguejetpackprosub2.R
import com.example.moviecataloguejetpackprosub2.domain.DetailMovieDomain
import com.example.moviecataloguejetpackprosub2.helper.MOVIE
import com.squareup.picasso.Picasso
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_movie.view.*

class FavMoviesItemView (val detailMovieDomain: DetailMovieDomain) : Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        val image = viewHolder.itemView.movie_poster
        val title = viewHolder.itemView.movie_name
        val overview = viewHolder.itemView.movie_desc
        val date = viewHolder.itemView.movie_date

        Picasso.get().load(MOVIE.LINK_IMAGE + detailMovieDomain.poster_path).into(image)
        title.text = detailMovieDomain.original_title
        overview.text = detailMovieDomain.overview
        date.text = detailMovieDomain.release_date

        viewHolder.itemView.setOnClickListener {
            val bundle = bundleOf("idMovie" to detailMovieDomain.id)
            it.findNavController().navigate(R.id.action_favoriteFragment_to_detailActivity, bundle)
        }
    }

    override fun getLayout(): Int = R.layout.item_movie
}