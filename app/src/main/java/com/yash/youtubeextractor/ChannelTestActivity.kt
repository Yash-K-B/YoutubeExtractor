package com.yash.youtubeextractor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.yash.youtube_extractor.ExtractorHelper
import com.yash.youtubeextractor.databinding.ActivityKotlinTestBinding
import java.util.concurrent.Executors

class ChannelTestActivity : AppCompatActivity() {
    lateinit var kotlinTestBinding: ActivityKotlinTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        kotlinTestBinding = ActivityKotlinTestBinding.inflate(layoutInflater)
        setContentView(kotlinTestBinding.root)

        kotlinTestBinding.videoId.setHint("Enter channel Id")
        kotlinTestBinding.videoId.editText?.text?.append("UC-9-kyTW8ZkZNDHQJ6FgpwQ")

        kotlinTestBinding.testKotlin.setOnClickListener(View.OnClickListener {
            Executors.newSingleThreadExecutor().execute {
                if(kotlinTestBinding.videoId.editText?.text?.isEmpty()!!){
                    Toast.makeText(this@ChannelTestActivity, "Please enter channel id", Toast.LENGTH_SHORT).show()
                }
                val channelPlaylists = ExtractorHelper.channelPlaylists(kotlinTestBinding.videoId.editText?.text.toString())
                var response = "";
                channelPlaylists.entries.forEach {
                    entry ->
                    response = response + entry.key + "\n";
                    response = response + entry.value + "\n";
                    response += "\n";
                }
                runOnUiThread {
                    kotlinTestBinding.testResult.gravity = GravityCompat.START
                    kotlinTestBinding.testResult.text = response
                }

            }

        })


    }
}


