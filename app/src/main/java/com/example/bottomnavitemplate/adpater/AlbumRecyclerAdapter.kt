package com.example.bottomnavitemplate.adpater

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bottomnavitemplate.AlbumFragment
import com.example.bottomnavitemplate.MainActivity
import com.example.bottomnavitemplate.R
import com.example.bottomnavitemplate.model.AlbumData
import com.google.android.material.imageview.ShapeableImageView

class AlbumRecyclerAdapter(private val items: Array<AlbumData>) :
    RecyclerView.Adapter<AlbumRecyclerAdapter.BaseViewHolder<*>>() {

    val TAG : String = "AlbumRecyclerAdpater"


    abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: T)
    }
    companion object {
        private const val TYPE_1 = 0
        private const val TYPE_2 = 1
        private const val TYPE_3 = 2
    }
    @SuppressLint("ResourceType")
    inner class ViewHolder1(itemView: View) : BaseViewHolder<AlbumData>(itemView) {
        lateinit var tv_title: TextView
        lateinit var tv_artist: TextView
        lateinit var siv_album: ShapeableImageView
        override fun bind(item: AlbumData) {

            tv_title = itemView.findViewById(R.id.tv_title)
            tv_artist = itemView.findViewById(R.id.tv_artist)
            siv_album = itemView.findViewById(R.id.siv_album)

            tv_title.text = item.title
            tv_artist.text = item.artist
            Glide.with(itemView).load(item.img).into(siv_album)
        }
        init{
            itemView.setOnClickListener {
                Toast.makeText(itemView.context,"${tv_title.text} 눌림",Toast.LENGTH_SHORT).show()
                (itemView.context as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.main_frm, AlbumFragment())
                    .commitAllowingStateLoss()
            }
        }

    }
    inner class ViewHolder2(itemView: View) : BaseViewHolder<AlbumData>(itemView) {

        override fun bind(item: AlbumData) {
            val tv_content: Button

            tv_content = itemView.findViewById(R.id.tv_content)
            tv_content.text = item.buttonTitle
            tv_content.background = item.buttonColor
        }
    }
    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
       when(items[position].type) {
           TYPE_1-> {
               (holder as ViewHolder1).bind(items[position])
               holder.setIsRecyclable(false)
           }
           TYPE_2 -> {
               (holder as ViewHolder1).bind(items[position])
               holder.setIsRecyclable(false)
           }
           TYPE_3 -> {
               (holder as ViewHolder2).bind(items[position])
               holder.setIsRecyclable(false)
           }
       }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when (viewType) {
            TYPE_1 -> {
                val view = LayoutInflater.from(viewGroup.context)
                        .inflate(R.layout.today_music_item, viewGroup, false)
                /*view.setOnClickListener{
                        Toast.makeText(view.context,"눌림",Toast.LENGTH_SHORT).show()
                 }*/
                ViewHolder1(view)
            }
            TYPE_2 -> {
                val view = LayoutInflater.from(viewGroup.context)
                        .inflate(R.layout.video_collection_item, viewGroup, false)
                ViewHolder1(view)
            }
            TYPE_3 -> {
                val view = LayoutInflater.from(viewGroup.context)
                        .inflate(R.layout.button_item, viewGroup, false)
                ViewHolder2(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].type
    }

    override fun getItemCount() = items.size
}

/*class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tv_title: TextView
        val tv_artist: TextView
        val siv_album: ShapeableImageView
        init {
            tv_title = view.findViewById(R.id.tv_title)
            tv_artist = view.findViewById(R.id.tv_artist)
            siv_album = view.findViewById(R.id.siv_album)
        }
    }*/

/*override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(viewGroup.context)
        .inflate(R.layout.today_music_item, viewGroup, false)
    return ViewHolder(view)
}*/

/*override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
    viewHolder.tv_title.text = items[position].title
    viewHolder.tv_artist.text = items[position].artist
    Glide.with(viewHolder.itemView).load(items[position].img).into(viewHolder.siv_album)
}*/