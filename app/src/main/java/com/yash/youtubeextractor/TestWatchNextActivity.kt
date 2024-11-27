package com.yash.youtubeextractor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListItemInfo
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.view.GravityCompat
import com.yash.youtube_extractor.ExtractorHelper
import com.yash.youtube_extractor.models.YoutubeResponse
import com.yash.youtubeextractor.databinding.ActivityKotlinTestBinding
import com.yash.youtubeextractor.databinding.ActivityKotlinTestV2Binding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class TestWatchNextActivity : AppCompatActivity() {
    lateinit var kotlinTestBinding: ActivityKotlinTestV2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        kotlinTestBinding = ActivityKotlinTestV2Binding.inflate(layoutInflater)
        setContentView(kotlinTestBinding.root)

        kotlinTestBinding.videoId.setHint("Video Id")
        kotlinTestBinding.videoId.editText?.text?.append("FGNc3BibU3o")

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

                runOnUiThread {
                    kotlinTestBinding.content.setContent {
                        Box(Modifier.padding(20.dp)) {
                            Text("Loading...")
                        }
                    }
                }

                val watchNext = ExtractorHelper.watchNext(kotlinTestBinding.videoId.editText?.text.toString())

                var watchNext2: YoutubeResponse? = null
                if (watchNext.continuationToken != null) {
                    watchNext2 = ExtractorHelper.watchNextContinuation(
                        kotlinTestBinding.videoId.editText?.text.toString(),
                        watchNext.continuationToken
                    )
                }


                runOnUiThread {
                    kotlinTestBinding.content.setContent {

                        Column {
                            Box(Modifier.padding(8.dp).background(Color.LightGray)) {
                                Text("Watch Next")
                            }

                            LazyColumn (Modifier.height(200.dp)) {
                                items(watchNext.songs.size) {
                                    Box(Modifier.padding(8.dp)) {
                                        Text(text = watchNext.songs[it].title)
                                    }
                                    HorizontalDivider()
                                }
                            }

                            if (watchNext.continuationToken != null) {
                                Box(Modifier.padding(8.dp).background(Color.LightGray)) {
                                    Text("Watch Next Continuation")
                                }

                                LazyColumn (Modifier.height(200.dp)) {
                                    items(watchNext2?.songs?.size ?: 0) {
                                        Box(Modifier.padding(8.dp)) {
                                            Text(text = watchNext2!!.songs[it].title)
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