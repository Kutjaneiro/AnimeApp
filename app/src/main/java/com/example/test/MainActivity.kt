package com.example.test

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var searchEditText: EditText
    private lateinit var searchButton: Button
    private lateinit var animeRecyclerView: RecyclerView
    private lateinit var animeAdapter: AnimeAdapter

    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializamos las vistas
        searchEditText = findViewById(R.id.searchEditText)
        searchButton = findViewById(R.id.searchButton)
        animeRecyclerView = findViewById(R.id.animeRecyclerView)

        // Configuramos el RecyclerView con GridLayoutManager para mostrar 2 columnas
        animeRecyclerView.layoutManager = GridLayoutManager(this, 2)
        animeAdapter = AnimeAdapter(emptyList())
        animeRecyclerView.adapter = animeAdapter

        // Configuramos el botón de búsqueda
        searchButton.setOnClickListener {
            val query = searchEditText.text.toString()
            if (query.isNotEmpty()) {
                searchAnime(query)
            }
        }
    }

    private fun searchAnime(query: String) {
        val url = "https://api.jikan.moe/v4/anime?q=$query"

        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread {
                    // Manejar error de red o servidor
                }
            }

            override fun onResponse(call: Call, response: Response) {
                if (!response.isSuccessful) {
                    runOnUiThread {
                        // Maneja la respuesta fallida del servidor
                    }
                    return
                }

                val responseData = response.body?.string()
                if (responseData != null) {
                    val jsonObject = JSONObject(responseData)
                    val animeArray = jsonObject.getJSONArray("data")

                    val animeList = mutableListOf<Anime>()
                    for (i in 0 until animeArray.length()) {
                        val animeObject = animeArray.getJSONObject(i)
                        val title = animeObject.getString("title")
                        val imageUrl = animeObject.getJSONObject("images").getJSONObject("jpg").getString("image_url")
                        val synopsis = animeObject.optString("synopsis", "Sinopsis no disponible")
                        val episodes = animeObject.optInt("episodes", 0)
                        val status = animeObject.optString("status", "Estado no disponible")

                        // Comprobar si existen los episodios emitidos
                        val episodesAired = if (animeObject.has("aired") && !animeObject.isNull("aired")) {
                            animeObject.getJSONObject("aired").optInt("aired_episodes", 0)
                        } else {
                            0
                        }

                        animeList.add(Anime(title, imageUrl, synopsis, episodes, status, episodesAired))
                    }

                    runOnUiThread {
                        animeAdapter.updateAnimeList(animeList)
                    }
                }
            }
        })
    }
}
