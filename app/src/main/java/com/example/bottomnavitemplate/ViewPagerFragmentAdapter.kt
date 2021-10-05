package com.example.bottomnavitemplate

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerFragmentAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    private val TYPE_BSIDETRACKS = 0
    private val TYPE_INFO = 1
    private val TYPE_VIDEO = 2
    private var listPager: List<Int> = listOf(TYPE_BSIDETRACKS,TYPE_INFO,TYPE_VIDEO)
    override fun getItemCount(): Int {
        return listPager.size
     }
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            TYPE_BSIDETRACKS -> AlbumBsideTracksFragment()
            TYPE_INFO -> AlbumInfo()
            else -> AlbumVideo()
        }
    }
}
