---

# AnimeApp

AnimeApp es una aplicación móvil para Android que permite a los usuarios explorar y ver episodios de anime utilizando la [API de Jikan](https://jikan.moe/), que proporciona datos sobre animes desde MyAnimeList. La app ofrece una interfaz simple e intuitiva para navegar y disfrutar del contenido de anime en tiempo real.

## Características

- **Listado de Animes:** Muestra una lista de animes populares, en emisión o por temporada.
- **Visualización de Episodios:** Permite ver episodios (enlace a fuentes externas).
- **Búsqueda Avanzada:** Incluye una función de búsqueda para encontrar animes por título o género.
- **Favoritos:** Guarda tus animes favoritos para acceso rápido.
- **Interfaz de Usuario Amigable:** Diseño minimalista para una experiencia de usuario fluida.
- **Información Detallada:** Muestra detalles sobre cada anime, incluyendo sinopsis, episodios, calificación y más.

## Tecnologías Utilizadas

- **Lenguaje:** Kotlin
- **IDE:** Android Studio
- **API:** Jikan API (para datos de anime desde MyAnimeList)
- **Patrón de Arquitectura:** MVVM (Model-View-ViewModel)
- **Dependencias:** 
  - Retrofit para manejo de las API
  - Glide para cargar imágenes
  - ExoPlayer para reproducir trailers o clips de anime
  - LiveData y ViewModel para gestionar los datos

## Instalación

Sigue estos pasos para clonar y ejecutar la aplicación en tu entorno local:

1. Clona este repositorio:
    ```bash
    git clone https://github.com/tu-usuario/AnimeApp.git
    ```

2. Abre el proyecto en Android Studio.

3. Asegúrate de tener configurado un dispositivo emulador o un dispositivo físico para probar la aplicación.

4. Instala las dependencias necesarias ejecutando `gradle sync` en Android Studio.

5. Ejecuta la aplicación en tu dispositivo.

## Uso

1. Abre la aplicación y navega por la lista de animes.
2. Busca animes por título usando la barra de búsqueda.
3. Selecciona un anime para ver la información detallada.
4. Agrega animes a tu lista de favoritos para acceder rápidamente a ellos más tarde.
5. Ve trailers o clips directamente desde la app (si están disponibles).

## API Jikan

La app utiliza la [API de Jikan](https://jikan.moe/) para obtener datos de anime desde MyAnimeList, como:

- Listado de animes en emisión, por temporada o más populares.
- Detalles del anime: sinopsis, episodios, puntuación y otros datos importantes.

## Contribuciones

Las contribuciones son bienvenidas. Si deseas contribuir a este proyecto, sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcion`).
3. Realiza tus cambios y haz commit (`git commit -m 'Agrega nueva función'`).
4. Sube tus cambios (`git push origin feature/nueva-funcion`).
5. Abre un Pull Request.

## Licencia

Este proyecto está licenciado bajo la licencia MIT - consulta el archivo [LICENSE](LICENSE) para más detalles.

---

Este README ahora refleja el uso de la API de Jikan para obtener datos de anime, y proporciona una descripción clara de cómo funciona la app.
