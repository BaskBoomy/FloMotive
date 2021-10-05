package com.example.bottomnavitemplate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bottomnavitemplate.adpater.AlbumRecyclerAdapter
import com.example.bottomnavitemplate.databinding.FragmentLookBinding
import com.example.bottomnavitemplate.model.AlbumData


class LookFragment : Fragment() {

    lateinit var binding: FragmentLookBinding

    lateinit var buttonRecyclerAdapter: AlbumRecyclerAdapter
    lateinit var flowChartRecyclerAdapter: AlbumRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLookBinding.inflate(inflater, container, false)

        val list1 = arrayOf(AlbumData(img = -1, title = "", artist = "",buttonTitle="차트",type = 2,buttonColor = resources.getDrawable(R.drawable.button_radius_blue)),
                AlbumData(img = -1, title = "", artist = "",buttonTitle="영상",type = 2,buttonColor = resources.getDrawable(R.drawable.button_radius_grey)),
                AlbumData(img = -1, title = "", artist = "",buttonTitle="장르",type = 2,buttonColor = resources.getDrawable(R.drawable.button_radius_grey)),
                AlbumData(img = -1, title = "", artist = "",buttonTitle="상황",type = 2,buttonColor = resources.getDrawable(R.drawable.button_radius_grey)),
                AlbumData(img = -1, title = "", artist = "",buttonTitle="분위기",type = 2,buttonColor = resources.getDrawable(R.drawable.button_radius_grey)),
                AlbumData(img = -1, title = "", artist = "",buttonTitle="등등",type = 2,buttonColor = resources.getDrawable(R.drawable.button_radius_grey)),
                AlbumData(img = -1, title = "", artist = "",buttonTitle="기타",type = 2,buttonColor = resources.getDrawable(R.drawable.button_radius_grey)))
        buttonRecyclerAdapter = AlbumRecyclerAdapter(list1)
        binding.rcContentButton.adapter = buttonRecyclerAdapter



        return binding.root
    }

}