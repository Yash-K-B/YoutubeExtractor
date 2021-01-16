package com.yash.youtubeextractor

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.yash.youtube_extractor.Extractor
import com.yash.youtube_extractor.exceptions.ExtractionException
import com.yash.youtube_extractor.models.VideoDetails
import com.yash.youtubeextractor.databinding.ActivityKotlinTestBinding

class KotlinTestActivity : AppCompatActivity() {
    lateinit var kotlinTestBinding: ActivityKotlinTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        kotlinTestBinding = ActivityKotlinTestBinding.inflate(layoutInflater)
        setContentView(kotlinTestBinding.root)

        kotlinTestBinding.testKotlin.setOnClickListener(View.OnClickListener {

                val extractor = Extractor();
                extractor.extract("GYGIVAb5s4U", object : Extractor.Callback {
                    override fun onSuccess(videoDetails: VideoDetails?) {
                        val videoUrl = videoDetails?.videoData?.thumbnail?.thumbnails?.get(0)?.url
                        Log.d("LOG_DEBUG", "Url: $videoUrl")
                        Toast.makeText(this@KotlinTestActivity,"Success",Toast.LENGTH_SHORT).show()
                    }

                    override fun onError(e: ExtractionException?) {
                        //here e is null
                        Log.d("LOG_DEBUG", "Error: " + e?.localizedMessage)
                        Toast.makeText(this@KotlinTestActivity,"Failed",Toast.LENGTH_SHORT).show()
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
}