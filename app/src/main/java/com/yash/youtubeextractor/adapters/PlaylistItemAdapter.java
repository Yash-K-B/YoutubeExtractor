package com.yash.youtubeextractor.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yash.youtube_extractor.models.YoutubeSong;
import com.yash.youtubeextractor.databinding.ListItemBinding;

import java.util.List;
import java.util.Locale;

public class PlaylistItemAdapter extends RecyclerView.Adapter<PlaylistItemAdapter.PlaylistItemViewHolder> {
    List<YoutubeSong> songs;
    Context context;


    public PlaylistItemAdapter(Context context, List<YoutubeSong> youtubeSongs) {
        this.context = context;
        this.songs = youtubeSongs;
    }

    @NonNull
    @Override
    public PlaylistItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PlaylistItemViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistItemViewHolder holder, int position) {
        holder.bind(songs.get(position));
    }

    @Override
    public int getItemCount() {
        return this.songs.size();
    }

    public static class PlaylistItemViewHolder extends RecyclerView.ViewHolder {
        ListItemBinding binding;

        public PlaylistItemViewHolder(@NonNull ListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(YoutubeSong song) {
            try {
                binding.head1.setText(song.getTitle());
                binding.subText.setText(song.getChannelTitle());
                binding.head2.setText(String.format(Locale.US,"%d s", song.getDurationMillis()));

            } catch (Exception e) {
                String error = e.getMessage();
                e.printStackTrace();
            }
        }
    }

}
