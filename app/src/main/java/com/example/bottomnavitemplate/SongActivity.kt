package com.example.bottomnavitemplate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bottomnavitemplate.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity() {
    //lateinit : 정방선언? 선언은 할건데 나중에 초기화를 해줄게!
    //var : 난 선언할 때 초기화 해줘야된다!
    /*예시
    var test1 : String = "2"
    lateinit var test2 : String
    */

    lateinit var binding : ActivitySongBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.songDownId.setOnClickListener{
//            finish()
//        }

        /*if(intent.hasExtra("title") && intent.hasExtra("singer")){
            binding.songMusicTitleTv.text = intent.getStringExtra("title")
            binding.songMusicSingerTv.text = intent.getStringExtra("singer")
        }*/


    }
}