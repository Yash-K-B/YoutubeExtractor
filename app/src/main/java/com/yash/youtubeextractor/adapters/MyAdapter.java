package com.yash.youtubeextractor.adapters;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yash.youtube_extractor.helper.PatternHelper;
import com.yash.youtube_extractor.models.Format;
import com.yash.youtube_extractor.models.StreamingData;
import com.yash.youtubeextractor.databinding.ListItemBinding;
import com.yash.youtubeextractor.utils.ConverterUtil;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;

import static android.content.Context.CLIPBOARD_SERVICE;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    MyData data;
    Context context;


    public MyAdapter(Context context, MyData data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(data, position, context);
    }

    @Override
    public int getItemCount() {
        return (data.getAudioStreams().size() + data.getVideoStreams().size() + data.getMuxedStreams().size());
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ListItemBinding binding;

        public MyViewHolder(@NonNull ListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(MyData myData, int position, Context context) {
            String pattern = "([A-za-z0-9_]+)\\/([A-za-z0-9_]+)\\;\\s*codecs=\\\"([A-za-z0-9_,. ]+)\\\"";
            try {
                if (position < myData.getMuxedStreams().size()) {
                    Matcher m = PatternHelper.getMatcher(pattern, myData.getMuxedStreams().get(position).getMimeType());
                    if (m.find())
                        binding.type.setText(Objects.requireNonNull(m.group(1)).toUpperCase());
                    binding.head1.setText(ConverterUtil.getBitrate(myData.getMuxedStreams().get(position).getBitrate()));
                    binding.head2.setText(myData.getMuxedStreams().get(position).getQualityLabel());
                    binding.subText.setText(m.group(3));
                    binding.fileSize.setText(ConverterUtil.convertToHighest(myData.getMuxedStreams().get(position).getContentLength()));
                    itemView.setOnClickListener(v -> {
                        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
                        ClipData copyData = ClipData.newPlainText("Url", myData.getMuxedStreams().get(position).getUrl());
                        clipboardManager.setPrimaryClip(copyData);
                        Toast.makeText(context, "Url Copied", Toast.LENGTH_SHORT).show();
                    });
                    //LogHelper.d(TAG, "bind: Muxed Stream Url :" + myData.getMuxedStreams().get(position).getUrl());
                } else if (position < (myData.getMuxedStreams().size() + myData.getAudioStreams().size())) {
                    Matcher m = PatternHelper.getMatcher(pattern, myData.getAudioStreams().get(position - myData.getMuxedStreams().size()).getMimeType());
                    if (m.find())
                        binding.type.setText(Objects.requireNonNull(m.group(1)).toUpperCase());
                    binding.head1.setText(ConverterUtil.getBitrate(myData.getAudioStreams().get(position - myData.getMuxedStreams().size()).getBitrate()));
                    binding.head2.setText(ConverterUtil.getSampleRate(myData.getAudioStreams().get(position - myData.getMuxedStreams().size()).getAudioSampleRate()));
                    binding.subText.setText(m.group(3));
                    binding.fileSize.setText(ConverterUtil.convertToHighest(myData.getAudioStreams().get(position - myData.getMuxedStreams().size()).getContentLength()));
                    itemView.setOnClickListener(v -> {
                        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
                        ClipData copyData = ClipData.newPlainText("Url", myData.getAudioStreams().get(position - myData.getMuxedStreams().size()).getUrl());
                        clipboardManager.setPrimaryClip(copyData);
                        Toast.makeText(context, "Url Copied", Toast.LENGTH_SHORT).show();
                    });
                    //LogHelper.d(TAG, "bind: Audio Url :" + myData.getAudioStreams().get(position - myData.getMuxedStreams().size()).getUrl());
                } else {
                    Matcher m = PatternHelper.getMatcher(pattern, myData.getVideoStreams().get(position - (myData.getMuxedStreams().size() + myData.getAudioStreams().size())).getMimeType());
                    if (m.find())
                        binding.type.setText(Objects.requireNonNull(m.group(1)).toUpperCase());
                    binding.head1.setText(ConverterUtil.getBitrate(myData.getVideoStreams().get(position - (myData.getMuxedStreams().size() + myData.getAudioStreams().size())).getBitrate()));
                    binding.head2.setText(myData.getVideoStreams().get(position - (myData.getMuxedStreams().size() + myData.getAudioStreams().size())).getQualityLabel());
                    binding.subText.setText(m.group(3));
                    binding.fileSize.setText(ConverterUtil.convertToHighest(myData.getVideoStreams().get(position - (myData.getMuxedStreams().size() + myData.getAudioStreams().size())).getContentLength()));
                    itemView.setOnClickListener(v -> {
                        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
                        ClipData copyData = ClipData.newPlainText("Url", myData.getVideoStreams().get(position - (myData.getMuxedStreams().size() + myData.getAudioStreams().size())).getUrl());
                        clipboardManager.setPrimaryClip(copyData);
                        Toast.makeText(context, "Url Copied", Toast.LENGTH_SHORT).show();
                    });
                    //LogHelper.d(TAG, "bind: Video Url :" + myData.getVideoStreams().get(position - (myData.getMuxedStreams().size() + myData.getAudioStreams().size())).getUrl());
                }
            } catch (Exception e) {
                String error = e.getMessage();
                e.printStackTrace();
            }
        }
    }

    public static class MyData {
        private List<Format> muxedStreams;
        private List<StreamingData.AdaptiveAudioFormat> audioStreams;
        private List<StreamingData.AdaptiveVideoFormat> videoStreams;

        public MyData(StreamingData data) {
            this.muxedStreams = data.getMuxedStreamFormats();
            this.audioStreams = data.getAdaptiveAudioFormats();
            this.videoStreams = data.getAdaptiveVideoFormats();
        }

        public List<Format> getMuxedStreams() {
            return muxedStreams;
        }

        public List<StreamingData.AdaptiveAudioFormat> getAudioStreams() {
            return audioStreams;
        }

        public List<StreamingData.AdaptiveVideoFormat> getVideoStreams() {
            return videoStreams;
        }
    }
}

