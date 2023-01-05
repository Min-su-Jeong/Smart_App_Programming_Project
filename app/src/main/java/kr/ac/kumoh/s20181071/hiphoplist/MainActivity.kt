package kr.ac.kumoh.s20181071.hiphoplist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.NetworkImageView
import kr.ac.kumoh.s20181071.hiphoplist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var model: SongViewModel
    private val songAdapter = SongAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        model = ViewModelProvider(this)[SongViewModel::class.java]

        binding.list.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator()
            adapter = songAdapter
        }

        model.list.observe(this) {
            songAdapter.notifyItemRangeInserted(0,
                model.list.value?.size ?: 0)
        }

        model.requestSong()
    }

    inner class SongAdapter: RecyclerView.Adapter<SongAdapter.ViewHolder>() {
        inner class ViewHolder(itemView: View)
            : RecyclerView.ViewHolder(itemView), OnClickListener {

            val txTitle: TextView = itemView.findViewById(R.id.text1)
            val txArtist: TextView = itemView.findViewById(R.id.text2)

            val niImage: NetworkImageView = itemView.findViewById(R.id.image)

            init {
                niImage.setDefaultImageResId(android.R.drawable.ic_menu_report_image)
                itemView.setOnClickListener(this)
            }

            override fun onClick(p0: View?) {
                val intent = Intent(application, SongActivity::class.java)
                intent.putExtra(SongActivity.KEY_TITLE,
                    model.list.value?.get(adapterPosition)?.title)
                intent.putExtra(SongActivity.KEY_ARTIST,
                    model.list.value?.get(adapterPosition)?.artist)
                intent.putExtra(SongActivity.KEY_IMAGE,
                    model.getImageUrl(adapterPosition))
                intent.putExtra(SongActivity.KEY_AGENCY,
                    model.list.value?.get(adapterPosition)?.agency)
                intent.putExtra(SongActivity.KEY_RELEASE_DATE,
                    model.list.value?.get(adapterPosition)?.release_date)
                startActivity(intent)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = layoutInflater.inflate(R.layout.item_song,
                parent,
                false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.txTitle.text = model.list.value?.get(position)?.title
            holder.txArtist.text = model.list.value?.get(position)?.artist

            holder.niImage.setImageUrl(model.getImageUrl(position), model.imageLoader)
        }

        override fun getItemCount() = model.list.value?.size ?: 0
    }
}