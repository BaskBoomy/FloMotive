package com.example.bottomnavitemplate

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.bottomnavitemplate.adpater.AlbumRecyclerAdapter
import com.example.bottomnavitemplate.databinding.FragmentHomeBinding
import com.example.bottomnavitemplate.model.AlbumData


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var albumRecyclerAdapter: AlbumRecyclerAdapter
    lateinit var everyDayAlbumRecyclerAdapter: AlbumRecyclerAdapter
    lateinit var videoCollectionRecyclerAdapter: AlbumRecyclerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        makeStatusGone()
        setAdapter(binding)
        return binding.root
    }

    fun setAdapter(binding:FragmentHomeBinding){
        var blue = resources.getDrawable(R.drawable.button_radius_blue)

        val list1 = arrayOf(
                AlbumData(img = R.drawable.img_album_exp2, title = "LILAC", artist = "아이유(IU)",buttonTitle="",type = 0,buttonColor = blue),
                AlbumData(img = R.drawable.album1, title = "너를위한", artist = "펀치",buttonTitle="",type = 0,buttonColor = blue),
                AlbumData(img = R.drawable.album2, title = "CAPSULE", artist = "Daigo",buttonTitle="",type = 0,buttonColor = blue),
                AlbumData(img = R.drawable.album3, title = "봄의한가운데", artist = "홍대광",buttonTitle="",type = 0,buttonColor = blue),
                AlbumData(img = R.drawable.album4, title = "밤이되니까", artist = "PUNCH",buttonTitle="",type = 0,buttonColor = blue))
        albumRecyclerAdapter = AlbumRecyclerAdapter(list1)
        binding.rctodayLuchedMusic.adapter = albumRecyclerAdapter

        val list2 = arrayOf(AlbumData(img = R.drawable.img_potcast_exp, title = "제목", artist = "가수",buttonTitle="",type = 0,buttonColor = blue),
                AlbumData(img = R.drawable.img_potcast_exp, title = "제목", artist = "가수",buttonTitle="",type = 0,buttonColor = blue),
                AlbumData(img = R.drawable.img_potcast_exp, title = "제목", artist = "가수",buttonTitle="",type = 0,buttonColor = blue),
                AlbumData(img = R.drawable.img_potcast_exp, title = "제목", artist = "가수",buttonTitle="",type = 0,buttonColor = blue))
        everyDayAlbumRecyclerAdapter = AlbumRecyclerAdapter(list2)
        binding.rcEveryDayMusic.adapter = everyDayAlbumRecyclerAdapter

        val list3 = arrayOf(AlbumData(img = R.drawable.img_video_exp, title = "제목", artist = "가수",buttonTitle="",type = 1,buttonColor = blue),
                AlbumData(img = R.drawable.img_video_exp, title = "제목", artist = "가수",buttonTitle="",type = 1,buttonColor = blue),
                AlbumData(img = R.drawable.img_video_exp, title = "제목", artist = "가수",buttonTitle="",type = 1,buttonColor = blue),
                AlbumData(img = R.drawable.img_video_exp, title = "제목", artist = "가수",buttonTitle="",type = 1,buttonColor = blue))
        videoCollectionRecyclerAdapter = AlbumRecyclerAdapter(list3)
        binding.rcVideoCollectionAdapter.adapter = videoCollectionRecyclerAdapter
    }

    fun makeStatusGone() {
        requireActivity().getWindow().apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            statusBarColor = Color.TRANSPARENT
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        binding.homeScrollView.post(
                fun() {
                    run {
                        val observer: ViewTreeObserver = binding.homeScrollView.getViewTreeObserver()
                        observer.addOnScrollChangedListener(object : ViewTreeObserver.OnScrollChangedListener {
                            @SuppressLint("ResourceType")
                            override fun onScrollChanged() {
                                val scrollX: Int = binding.homeScrollView.getScrollX()
                                val scrollY: Int = binding.homeScrollView.getScrollY()
                                if (scrollY >= binding.liearLayout1.top ){
                                    requireActivity().getWindow().setStatusBarColor(getResources().getColor(R.color.halftransparent))
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
                                        requireActivity().getWindow().decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                                    }
                                }else{
//                                    requireActivity().getWindow().apply {
//                                        statusBarColor = Color.TRANSPARENT
//                                    }
                                }
                            }
                        })
                    }
                }
        )
    }

}