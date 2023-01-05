package kr.ac.kumoh.s20181071.hiphoplist

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.collection.LruCache
import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.Volley
import kr.ac.kumoh.s20181071.hiphoplist.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity() {
    companion object {
        const val KEY_TITLE = "SongTitle"
        const val KEY_ARTIST = "SongArtist"
        const val KEY_IMAGE = "SongImage"
        const val KEY_AGENCY = "SongAgency"
        const val KEY_RELEASE_DATE = "SongReleaseDate"
    }
    private lateinit var binding: ActivitySongBinding
    private lateinit var imageLoader: ImageLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageLoader = ImageLoader(Volley.newRequestQueue(this),
            object : ImageLoader.ImageCache {
                private val cache = LruCache<String, Bitmap>(100)
                override fun getBitmap(url: String): Bitmap? {
                    return cache.get(url)
                }
                override fun putBitmap(url: String, bitmap: Bitmap) {
                    cache.put(url, bitmap)
                }
            })

        binding.imageSong.setImageUrl(intent.getStringExtra(KEY_IMAGE), imageLoader)
        binding.textTitle.text = intent.getStringExtra(KEY_TITLE)
        binding.textArtist.text = intent.getStringExtra(KEY_ARTIST)
        binding.textAgency.text = intent.getStringExtra(KEY_AGENCY)
        binding.textReleaseDate.text = intent.getStringExtra(KEY_RELEASE_DATE)
    }
}