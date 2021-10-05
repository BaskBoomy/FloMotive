package com.example.bottomnavitemplate.adpater

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavitemplate.R
import com.example.bottomnavitemplate.model.SongTrackData

class AlbumBsideTrackRecyclerAdapter(private val items: Array<SongTrackData>) : RecyclerView.Adapter<AlbumBsideTrackRecyclerAdapter.BaseViewHolder<*>>() {

    abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: T)
    }

    inner class ViewHolder1(itemView: View) : BaseViewHolder<SongTrackData>(itemView) {

        lateinit var isMainTitle: TextView
        lateinit var tv_title: TextView
        lateinit var tv_artist: TextView
        lateinit var tv_showTitle: TextView
        override fun bind(item: SongTrackData) {
            isMainTitle = itemView.findViewById(R.id.isMainTitle)
            tv_title = itemView.findViewById(R.id.tv_title)
            tv_artist = itemView.findViewById(R.id.tv_artist)
            tv_showTitle = itemView.findViewById(R.id.tv_showTitle)

            tv_title.text = item.title
            tv_artist.text = item.artist
            isMainTitle.text = item.isMainTitle

            Log.d("isMainTitle","${isMainTitle.text} 확인해주세요");
                if(isMainTitle.text.equals("0")){
                    tv_showTitle.visibility = View.GONE
                }else{
                    tv_showTitle.visibility = View.VISIBLE
                }
        }
        init{
            itemView.setOnClickListener {
                Toast.makeText(itemView.context,"${tv_title.text} 눌림",Toast.LENGTH_SHORT).show()
            }


        }

    }
    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {

       (holder as ViewHolder1).bind(items[position])
       holder.setIsRecyclable(false)

    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.music_list_item, viewGroup, false)
       return ViewHolder1(view)
    }


    override fun getItemCount() = items.size
}