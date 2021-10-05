package com.example.bottomnavitemplate

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.bottomnavitemplate.databinding.FragmentAlbumBinding
import com.example.bottomnavitemplate.model.ImageData
import com.google.android.material.tabs.TabLayoutMediator

class AlbumFragment : Fragment() {
    lateinit var binding : FragmentAlbumBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAlbumBinding.inflate(inflater,container,false)
        setStatusBar()
        binding.viewPager2.adapter = ViewPagerFragmentAdapter(requireContext() as FragmentActivity)
        binding.viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            when (position) {
                0 -> tab.text = "수록곡"
                1 -> tab.text = "상세정보"
                else -> tab.text = "영상"
            }
        }.attach()
        binding.viewPager2.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.appBarLayoutMiddle.setExpanded(true)
            }
        })

        //fixFromAppBar()

       /* binding.albumBackIv.setOnClickLitener{
            (context as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.layout.main_frm, HomeFragment())
                    .commitAllowingStateLoss()
        }*/

        /*binding.songLalacLayout.setOnClickListenr{
            Toast.makeText(activity,"라일락",Toast.LENGTH_SHORT).show();
        }*/
        return binding.root
    }

    fun setStatusBar(){
        requireActivity().getWindow().apply {
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }

    fun setImageObject(){
        val Image = ImageData(binding.sivAlbumImage)
    }
    fun fixFromAppBar() {
        binding.nestedScrollView.post(
            fun() {
                run {
                    val observer: ViewTreeObserver = binding.nestedScrollView.getViewTreeObserver()
                    observer.addOnScrollChangedListener(object : ViewTreeObserver.OnScrollChangedListener {
                        @SuppressLint("ResourceType")
                        override fun onScrollChanged() {
                            val scrollX: Int = binding.nestedScrollView.getScrollX()
                            val scrollY: Int = binding.nestedScrollView.getScrollY()
                            Log.d("확인","${binding.appBarLayoutMiddle.top}")
                            if (scrollY >= binding.appBarLayoutMiddle.top ){
                                Log.d("확인","멈춰!")
//                                binding.sivAlbumImage.setImageResource(R.drawable.album2)
                            }else{
                                Log.d("확인","멈추지마!")
                            }
                        }
                    })
                }
            }
        )
    }
}