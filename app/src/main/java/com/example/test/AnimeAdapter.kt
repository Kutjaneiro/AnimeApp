package com.example.test

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

data class Anime(
    val title: String,
    val imageUrl: String,
    val synopsis: String,
    val episodes: Int,
    val status: String,
    val episodesAired: String
)

class AnimeAdapter(private var animeList: List<Anime>) : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.anime_item, parent, false)
        return AnimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val anime = animeList[position]
        holder.titleTextView.text = anime.title

        // Cargamos la imagen usando Glide
        Glide.with(holder.itemView.context)
            .load(anime.imageUrl)
            .into(holder.animeImageView)

        // Evento de clic para mostrar los detalles del anime
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, AnimeDetailActivity::class.java)
            intent.putExtra("title", anime.title)
            intent.putExtra("imageUrl", anime.imageUrl)
            intent.putExtra("synopsis", anime.synopsis)
            intent.putExtra("episodes", anime.episodes)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return animeList.size
    }

    fun updateAnimeList(newAnimeList: List<Anime>) {
        animeList = newAnimeList
        notifyDataSetChanged()
    }

    class AnimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val animeImageView: ImageView = itemView.findViewById(R.id.animeImageView)
    }
}
