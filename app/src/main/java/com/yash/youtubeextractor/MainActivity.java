package com.yash.youtubeextractor;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.service.autofill.FieldClassification;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.yash.logging.LogHelper;
import com.yash.youtube_extractor.Extractor;
import com.yash.youtube_extractor.exceptions.ExtractionException;
import com.yash.youtube_extractor.models.VideoDetails;
import com.yash.youtubeextractor.adapters.MyAdapter;
import com.yash.youtubeextractor.databinding.ActivityKotlinTestBinding;
import com.yash.youtubeextractor.databinding.ActivityMainBinding;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ActivityMainBinding mainBinding;
    BottomSheetBehavior bottomSheetBehavior;
    Handler handler = new Handler();

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
            String[] parts = Objects.requireNonNull(mainBinding.link.getText()).toString().contains("=") ? Objects.requireNonNull(mainBinding.link.getText()).toString().split("=") : Objects.requireNonNull(mainBinding.link.getText()).toString().split("[/]");
            String id = parts[parts.length - 1];
            final Extractor extractor = new Extractor();
            try {
                extractor.extract(id, new Extractor.Callback() {
                    @Override
                    public void onSuccess(VideoDetails videoDetails) {
                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                        MyAdapter adapter = new MyAdapter(MainActivity.this, new MyAdapter.MyData(videoDetails.getStreamingData()));
                        mainBinding.container.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));
                        mainBinding.container.setAdapter(adapter);
                    }

                    @Override
                    public void onError(ExtractionException e) {
                        LogHelper.d(TAG, "onError: "+ e.getLocalizedMessage());
                        Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                });
            } catch (ExtractionException e) {
                e.printStackTrace();
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


        //text.setText(extractor.extract("_bcnhtesizI"));
    }

    void refresh(String url) {
        mainBinding.link.setText(url == null ? "https://www.youtube.com/watch?v=2pjrwEgwlo8" : url);
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
        LogHelper.d(TAG, "extractVideoIdAndSet: "+ raw);
        if(matcher.find()){
            id = matcher.group(2);
            LogHelper.d(TAG, "extractVideoIdAndSet: "+id);
        }
        if(id != null)
            return String.format(outPattern, id);
        return raw;
    }
}
