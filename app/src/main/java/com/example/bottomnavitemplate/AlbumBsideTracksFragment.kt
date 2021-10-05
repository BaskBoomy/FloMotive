package com.example.bottomnavitemplate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.bottomnavitemplate.adpater.AlbumBsideTrackRecyclerAdapter
import com.example.bottomnavitemplate.databinding.FragmentAlbumBsideTracksBinding
import com.example.bottomnavitemplate.model.SongTrackData

class AlbumBsideTracksFragment : Fragment() {
    lateinit var binding : FragmentAlbumBsideTracksBinding
    lateinit var albumBsideTrackRecyclerAdapter: AlbumBsideTrackRecyclerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAlbumBsideTracksBinding.inflate(inflater,container,false)


        val list = arrayOf(
            SongTrackData(isMainTitle = "1", title = "너의 모습", artist = "가수"),
            SongTrackData(isMainTitle = "0", title = "제목", artist = "가수"),
            SongTrackData(isMainTitle = "0", title = "제목", artist = "가수"),
            SongTrackData(isMainTitle = "0", title = "제목", artist = "가수")
        )
        albumBsideTrackRecyclerAdapter = AlbumBsideTrackRecyclerAdapter(list)
        binding.rcAlbumBsideTrackSongs.adapter = albumBsideTrackRecyclerAdapter
        binding.swFavor.setOnCheckedChangeListener(CheckboxListener())



        return binding.root
    }
    inner class CheckboxListener : CompoundButton.OnCheckedChangeListener{
        override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
            if(isChecked){
                Toast.makeText(requireContext(),"체크됨", Toast.LENGTH_SHORT).show()
//                AlbumFragment().svImageView.albumImage.setImageResource(R.drawable.album2)
//                  .binding.sivAlbumImage.setImageResource(R.drawable.album2)
            }
            else{
                Toast.makeText(requireContext(),"체크취소됨", Toast.LENGTH_SHORT).show()
//                AlbumFragment().binding.sivAlbumImage.setImageResource(R.drawable.album2)
            }
        }
    }


}