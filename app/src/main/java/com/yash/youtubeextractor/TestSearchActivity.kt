package com.yash.youtubeextractor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.yash.youtube_extractor.ExtractorHelper
import com.yash.youtubeextractor.databinding.ActivityKotlinTestBinding
import kotlinx.coroutines.*

class TestSearchActivity : AppCompatActivity() {
    lateinit var kotlinTestBinding: ActivityKotlinTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        kotlinTestBinding = ActivityKotlinTestBinding.inflate(layoutInflater)
        setContentView(kotlinTestBinding.root)

        kotlinTestBinding.videoId.setHint("Query Text")
        kotlinTestBinding.videoId.editText?.text?.append("")

        kotlinTestBinding.testKotlin.setOnClickListener {
            if (kotlinTestBinding.videoId.editText?.text?.isEmpty()!!) {
                Toast.makeText(
                    this@TestSearchActivity,
                    "Please enter text to search",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            MainScope().launch(Dispatchers.IO) {
                val search = ExtractorHelper.search(kotlinTestBinding.videoId.editText?.text.toString())
                var response = "";
                search.songs.forEach { song ->
                    response = response + song.title + "\n";
                    response += "\n";
                }
                runOnUiThread {
                    kotlinTestBinding.testResult.gravity = GravityCompat.START
                    kotlinTestBinding.testResult.text = response
                }
                val search2 = ExtractorHelper.searchContinuation(kotlinTestBinding.videoId.editText?.text.toString(), search.continuationToken)
                println(search2)
            }

        }

    }
}