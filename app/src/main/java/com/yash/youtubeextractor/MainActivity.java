package com.yash.youtubeextractor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.yash.youtube_extractor.Extractor;
import com.yash.youtubeextractor.adapters.MyAdapter;
import com.yash.youtubeextractor.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ActivityMainBinding mainBinding;
    BottomSheetBehavior bottomSheetBehavior;

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

        mainBinding.heading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetBehavior.setState(bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED ? BottomSheetBehavior.STATE_COLLAPSED : BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        Button search = findViewById(R.id.search);
        search.setOnClickListener(v -> {
            String[] parts = Objects.requireNonNull(mainBinding.link.getText()).toString().contains("=") ? Objects.requireNonNull(mainBinding.link.getText()).toString().split("=") : Objects.requireNonNull(mainBinding.link.getText()).toString().split("[/]");
            String id = parts[parts.length - 1];
            final Extractor extractor = new Extractor();
            new Thread(() -> extractor.extract(id, videoDetails -> {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                runOnUiThread(() -> {
                    MyAdapter adapter = new MyAdapter(MainActivity.this, new MyAdapter.MyData(videoDetails.getStreamingData()));
                    mainBinding.container.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));
                    mainBinding.container.setAdapter(adapter);
                });

                //LogHelper.d(TAG, "onCreate: "+streamingData.toString());
            })).start();
        });


        //text.setText(extractor.extract("_bcnhtesizI"));
    }

    void refresh(String url) {
        mainBinding.link.setText(url == null ? "https://www.youtube.com/watch?v=F-JoqgpSsBc" : url);
        mainBinding.container.setLayoutManager(new LinearLayoutManager(this));
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Bundle extras = intent.getExtras();
        String url = extras == null ? null : extras.getString(Intent.EXTRA_TEXT);
        refresh(url);
    }
}
