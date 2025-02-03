package com.yash.youtubeextractor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.view.GravityCompat
import com.yash.youtube_extractor.ExtractorHelper
import com.yash.youtube_extractor.service.ChannelExtractor
import com.yash.youtubeextractor.databinding.ActivityKotlinTestBinding
import com.yash.youtubeextractor.databinding.ActivityKotlinTestV2Binding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlin.streams.toList

class ChannelTestActivity : AppCompatActivity() {
    lateinit var kotlinTestBinding: ActivityKotlinTestV2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        kotlinTestBinding = ActivityKotlinTestV2Binding.inflate(layoutInflater)
        setContentView(kotlinTestBinding.root)

        kotlinTestBinding.videoId.setHint("Enter channel Id")
        kotlinTestBinding.videoId.editText?.text?.append("UC-9-kyTW8ZkZNDHQJ6FgpwQ")

        kotlinTestBinding.testKotlin.setOnClickListener {
            if (kotlinTestBinding.videoId.editText?.text?.isEmpty()!!) {
                Toast.makeText(
                    this@ChannelTestActivity,
                    "Please enter channel id",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            MainScope().launch(Dispatchers.IO) {
                runOnUiThread {
                    kotlinTestBinding.content.setContent {
                        Box(Modifier.padding(20.dp)) {
                            Text("Loading...")
                        }
                    }
                }
                val channelPlaylists =
                    ChannelExtractor.channelInfoV2(kotlinTestBinding.videoId.editText?.text.toString())

                runOnUiThread {
                    kotlinTestBinding.content.setContent {
                        val scrollState = rememberScrollState()
                        Column (Modifier.verticalScroll(scrollState)) {
                            for (x in channelPlaylists.playlistsByCategory) {
                                Column(Modifier.padding(8.dp)) {
                                    Box(Modifier.background(Color.LightGray).fillMaxWidth()) {
                                        Text(text = x.key, modifier = Modifier.padding(8.dp))
                                    }

                                    Box(Modifier.padding(start = 20.dp)) {
                                        Column {
                                            for (playlist in x.value) {
                                                Box(Modifier.padding(8.dp)) {
                                                    Text(text = "${playlist.title} (${playlist.videoCount})")
                                                }
                                                HorizontalDivider()
                                            }
                                        }

                                    }
                                }

                            }

                        }
                    }

                }
            }

        }

    }

}


