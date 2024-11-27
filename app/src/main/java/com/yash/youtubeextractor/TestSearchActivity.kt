package com.yash.youtubeextractor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.view.GravityCompat
import com.yash.youtube_extractor.ExtractorHelper
import com.yash.youtubeextractor.databinding.ActivityKotlinTestBinding
import com.yash.youtubeextractor.databinding.ActivityKotlinTestV2Binding
import kotlinx.coroutines.*

class TestSearchActivity : AppCompatActivity() {
    lateinit var kotlinTestBinding: ActivityKotlinTestV2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        kotlinTestBinding = ActivityKotlinTestV2Binding.inflate(layoutInflater)
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
                runOnUiThread {
                    kotlinTestBinding.content.setContent {
                        Box(Modifier.padding(20.dp)) {
                            Text("Searching...")
                        }
                    }
                }

                val search = ExtractorHelper.search(kotlinTestBinding.videoId.editText?.text.toString())
                runOnUiThread {

                    kotlinTestBinding.content.setContent {
                        Column {
                            Box(Modifier.padding(8.dp).background(Color.LightGray)) {
                                Text("Search Result")
                            }

                            LazyColumn (Modifier.fillMaxHeight()) {
                                items(search.songs.size) {
                                    Box(Modifier.padding(8.dp)) {
                                        Text(text = search.songs[it].title)
                                    }
                                    HorizontalDivider()
                                }
                            }
                        }

                    }
                }
                val search2 = ExtractorHelper.searchContinuation(kotlinTestBinding.videoId.editText?.text.toString(), search.continuationToken)
                println(search2)
            }

        }

    }
}