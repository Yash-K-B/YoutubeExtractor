package com.yash.youtubeextractor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.yash.youtube_extractor.ExtractorHelper
import com.yash.youtubeextractor.databinding.ActivityKotlinTestBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class TestWatchNextActivity : AppCompatActivity() {
    lateinit var kotlinTestBinding: ActivityKotlinTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        kotlinTestBinding = ActivityKotlinTestBinding.inflate(layoutInflater)
        setContentView(kotlinTestBinding.root)

        kotlinTestBinding.videoId.setHint("Video Id")
        kotlinTestBinding.videoId.editText?.text?.append("")

        kotlinTestBinding.testKotlin.setOnClickListener {
            if (kotlinTestBinding.videoId.editText?.text?.isEmpty()!!) {
                Toast.makeText(
                    this@TestWatchNextActivity,
                    "Please enter video id",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            MainScope().launch(Dispatchers.IO) {
                val watchNext =
                    ExtractorHelper.watchNext(kotlinTestBinding.videoId.editText?.text.toString())
                var response = "";
                watchNext.songs.forEach { song ->
                    response = response + song.title + "\n";
                    response += "\n";
                }
                runOnUiThread {
                    kotlinTestBinding.testResult.gravity = GravityCompat.START
                    kotlinTestBinding.testResult.text = response
                }
                val watchNext2 = ExtractorHelper.watchNextContinuation(
                    kotlinTestBinding.videoId.editText?.text.toString(),
                    watchNext.continuationToken
                )
                println(watchNext2)
            }

        }

    }
}