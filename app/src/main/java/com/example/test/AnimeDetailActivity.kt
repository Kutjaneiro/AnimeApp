package com.example.test

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class AnimeDetailActivity : AppCompatActivity() {

    private lateinit var animeImageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var synopsisTextView: TextView
    private lateinit var episodesTextView: TextView
    private lateinit var episodesAiredTextView: TextView
    private lateinit var statusTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anime_detail)

        // Inicializamos las vistas
        animeImageView = findViewById(R.id.animeImageView)
        titleTextView = findViewById(R.id.titleTextView)
        synopsisTextView = findViewById(R.id.synopsisTextView)
        episodesTextView = findViewById(R.id.episodesTextView)
        episodesAiredTextView = findViewById(R.id.episodesAiredTextView)
        statusTextView = findViewById(R.id.statusTextView)

        // Obtenemos los datos del intent
        val title = intent.getStringExtra("title") ?: "Título no disponible"
        val imageUrl = intent.getStringExtra("imageUrl") ?: ""
        val synopsis = intent.getStringExtra("synopsis") ?: "Sinopsis no disponible"
        val episodes = intent.getIntExtra("episodes", 0)
        val status = intent.getStringExtra("status") ?: "Estado no disponible"
        val episodesAired = intent.getIntExtra("episodesAired", 0)

        // Mostrar la información del anime
        titleTextView.text = title
        synopsisTextView.text = "Sinopsis: $synopsis"
        statusTextView.text = "Estado: $status"

        // Si no hay episodios emitidos disponibles
        if (episodesAired > 0) {
            episodesAiredTextView.text = "Episodios emitidos: $episodesAired"
        } else {
            episodesAiredTextView.text = "Episodios emitidos: No disponible"
        }

        // Mostrar el total de episodios
        episodesTextView.text = if (episodes > 0) {
            "Total de episodios: $episodes"
        } else {
            "Total de episodios: No disponible"
        }

        // Cargar la imagen del anime
        Glide.with(this).load(imageUrl).into(animeImageView)
    }
}
