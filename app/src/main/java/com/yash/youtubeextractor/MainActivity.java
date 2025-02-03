package com.yash.youtubeextractor;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.yash.logging.LogHelper;
import com.yash.youtube_extractor.Extractor;
import com.yash.youtube_extractor.ExtractorHelper;
import com.yash.youtube_extractor.exceptions.ExtractionException;
import com.yash.youtube_extractor.models.YoutubeResponse;
import com.yash.youtube_extractor.models.VideoDetails;
import com.yash.youtubeextractor.adapters.PlaylistItemAdapter;
import com.yash.youtubeextractor.adapters.StreamsAdapter;
import com.yash.youtubeextractor.databinding.ActivityMainBinding;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ActivityMainBinding mainBinding;
    BottomSheetBehavior bottomSheetBehavior;
    Handler handler = new Handler(Looper.getMainLooper());
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        bottomSheetBehavior = BottomSheetBehavior.from(mainBinding.bottomSheet);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        Bundle extras = getIntent().getExtras();
        String url = extras == null ? null : extras.getString(Intent.EXTRA_TEXT);
        refresh(url);

        mainBinding.heading.setOnClickListener(v -> bottomSheetBehavior.setState(bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED ? BottomSheetBehavior.STATE_COLLAPSED : BottomSheetBehavior.STATE_EXPANDED));

        Button search = findViewById(R.id.search);
        search.setOnClickListener(v -> {
            String stringUrl = Objects.requireNonNull(mainBinding.link.getText()).toString();
            String[] parts = stringUrl.contains("=") ? stringUrl.split("=") : stringUrl.split("[/]");
            String id = parts[parts.length - 1];
            if (stringUrl.contains("playlist")) {
                executorService.execute(() -> {
                    YoutubeResponse youtubeResponse = ExtractorHelper.playlistSongs(id);
                    handler.post(() -> {
                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                        PlaylistItemAdapter adapter = new PlaylistItemAdapter(MainActivity.this, youtubeResponse.getSongs());
                        mainBinding.container.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));
                        mainBinding.container.setAdapter(adapter);
                    });
                    YoutubeResponse youtubeResponse1 = null;
                    try {
                        youtubeResponse1 = ExtractorHelper.continuationResponse(youtubeResponse.getContinuationToken(), youtubeResponse.getContinuationType());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Log.i(TAG, "onCreate: "+ youtubeResponse1);
                });
            } else {
                LogHelper.d(TAG, "onCreate: Starting extraction of %s", id);
                final Extractor extractor = new Extractor();
                extractor.extract(id, new Extractor.Callback() {
                    @Override
                    public void onSuccess(VideoDetails videoDetails) {
                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                        StreamsAdapter adapter = new StreamsAdapter(MainActivity.this, new StreamsAdapter.MyData(videoDetails.getStreamingData()));
                        mainBinding.container.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));
                        mainBinding.container.setAdapter(adapter);
                    }

                    @Override
                    public void onError(ExtractionException e) {
                        LogHelper.e(TAG, "onError: ", e);
                        Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                });

            }

            //LogHelper.d(TAG, "onCreate: "+streamingData.toString());

//            new Thread(() -> {
//               try {
//                   VideoDetails details = extractor.extract(id);
//                   Log.d(TAG,details.getVideoData().getTitle());
//                   handler.post(()->Toast.makeText(MainActivity.this, "Extraction Successful", Toast.LENGTH_SHORT).show());
//               }
//               catch (ExtractionException e){
//                   e.printStackTrace();
//               }
//
//
//            }).start();


        });
        mainBinding.testKotlin.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, KotlinTestActivity.class);
            startActivity(intent);
        });

        mainBinding.testChannel.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ChannelTestActivity.class);
            startActivity(intent);
        });

        mainBinding.testSearch.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TestSearchActivity.class);
            startActivity(intent);
        });

        mainBinding.testWatchNext.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TestWatchNextActivity.class);
            startActivity(intent);
        });


        //text.setText(extractor.extract("_bcnhtesizI"));
    }

    void refresh(String url) {
        mainBinding.link.setText(url == null ? "https://www.youtube.com/watch?v=TVbI55pDdaI" : url);
        mainBinding.container.setLayoutManager(new LinearLayoutManager(this));
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Bundle extras = intent.getExtras();
        String url = extras == null ? null : extras.getString(Intent.EXTRA_TEXT);
        refresh(extractVideoIdAndSet(url));
    }

    private static String extractVideoIdAndSet(String raw) {
        String outPattern = "https://www.youtube.com/watch?v=%s";
        String id = null;
        Pattern pattern = Pattern.compile("https?://(www.)?youtube.com/shorts/([A-Za-z0-9]+)\\??.*");
        Matcher matcher = pattern.matcher(raw);
        LogHelper.d(TAG, "extractVideoIdAndSet: " + raw);
        if (matcher.find()) {
            id = matcher.group(2);
            LogHelper.d(TAG, "extractVideoIdAndSet: " + id);
        }
        if (id != null)
            return String.format(outPattern, id);
        return raw;
    }
}
