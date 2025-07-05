package com.yash.youtubeextractor

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.view.GravityCompat
import com.yash.logging.LogHelper
import com.yash.youtube_extractor.Extractor
import com.yash.youtube_extractor.exceptions.ExtractionException
import com.yash.youtube_extractor.models.VideoDetails
import com.yash.youtubeextractor.databinding.ActivityKotlinTestBinding
import com.yash.youtubeextractor.databinding.ActivityKotlinTestV2Binding

class KotlinTestActivity : AppCompatActivity() {
    lateinit var kotlinTestBinding: ActivityKotlinTestV2Binding
    lateinit var context: Context;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        kotlinTestBinding = ActivityKotlinTestV2Binding.inflate(layoutInflater)
        context = this@KotlinTestActivity
        setContentView(kotlinTestBinding.root)

        kotlinTestBinding.videoId.editText?.text?.append("daY_-Sb_jYo")
        kotlinTestBinding.testKotlin.setOnClickListener(View.OnClickListener {

            if(kotlinTestBinding.videoId.editText?.text?.isEmpty()!!){
                Toast.makeText(this@KotlinTestActivity, "Please Enter VideoId", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }

            val videoId = kotlinTestBinding.videoId.editText?.text.toString()

            runOnUiThread {
                kotlinTestBinding.content.setContent {
                    Box(modifier = Modifier.padding(horizontal = 10.dp)) {
                        Text("Fetching Details")
                    }
                }
            }

            val extractor = Extractor();
            extractor.extract(videoId, object : Extractor.Callback {
                override fun onSuccess(videoDetails: VideoDetails?) {
                    val videoUrl = videoDetails?.videoData?.thumbnail?.thumbnails?.get(0)?.url
                    Log.d("LOG_DEBUG", "Url: $videoUrl")
                    val channelThumbnailUrl = videoDetails?.videoData?.channelThumbnail?.thumbnails?.get(0)?.url
                    LogHelper.d("From Kotlin ", " channel Thumbnail : $channelThumbnailUrl")
                    LogHelper.d("From Kotlin: ", videoDetails?.videoData?.toString())

                    runOnUiThread {
                        kotlinTestBinding.content.setContent {
                            val scrollState = rememberScrollState()

                            Column(
                                modifier = Modifier
                                    .verticalScroll(scrollState)
                                    .padding(horizontal = 10.dp)
                                    .fillMaxSize()
                            ) {
                                Text(videoDetails?.videoData?.toString() ?: "")
                                Spacer(modifier = Modifier.height(5.dp))

                                Text("Muxed Streams")
                                videoDetails?.streamingData?.muxedStreamFormats?.forEach {
                                    Box(Modifier.padding(8.dp).clickable(enabled = true, onClick = { copyToClipboard(it.url) })) {
                                        Text(text = "Itag: ${it.itag}, Type: ${it.mimeType}")
                                    }
                                    HorizontalDivider()
                                }

                                Text("Video Streams")
                                videoDetails?.streamingData?.adaptiveVideoFormats?.forEach {
                                    Box(Modifier.padding(8.dp).clickable(enabled = true, onClick = { copyToClipboard(it.url) })) {
                                        Text(text = "Itag: ${it.itag}, Type: ${it.mimeType}")
                                    }
                                    HorizontalDivider()
                                }

                                Text("Audio Streams")
                                videoDetails?.streamingData?.adaptiveAudioFormats?.forEach {
                                    Box(Modifier.padding(8.dp).clickable(enabled = true, onClick = { copyToClipboard(it.url) })) {
                                        Text(text = "Itag: ${it.itag}, Type: ${it.mimeType}")
                                    }
                                    HorizontalDivider()
                                }
                            }

                            Toast.makeText(this@KotlinTestActivity, "Success", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }

                }

                override fun onError(e: ExtractionException) {
                    //here e is null
                    Log.d("LOG_DEBUG", "Error: " + e.localizedMessage)
                    Toast.makeText(this@KotlinTestActivity, "Failed", Toast.LENGTH_SHORT).show()
                }
            })

//            try {
//                var videoDetails = extractor.extract("GYGIVAb5s4U")
//            }
//            catch (e: ExtractionException){
//                Log.d("LOG_DEBUG", "Error: " + e.localizedMessage)
//            }


        })

    }

    private fun copyToClipboard(url: String) {
        var clipboardManager = this@KotlinTestActivity.context.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager;
        val copyData = ClipData.newPlainText("Url", url);
        clipboardManager.setPrimaryClip(copyData);
        Toast.makeText(context, "Url Copied", Toast.LENGTH_SHORT).show();
    }
}