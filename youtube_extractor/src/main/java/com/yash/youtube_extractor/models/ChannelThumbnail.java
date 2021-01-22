package com.yash.youtube_extractor.models;

import java.io.Serializable;
import java.util.List;

public class ChannelThumbnail implements Serializable {

    public List<Thumbnail> thumbnails;

    public List<Thumbnail> getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(List<Thumbnail> thumbnails) {
        this.thumbnails = thumbnails;
    }

    @Override
    public String toString() {
        return "ChannelThumbnail{" +
                "thumbnails=" + thumbnails +
                '}';
    }

    public static class Thumbnail{
        public String url;
        public int width;
        public int height;

        @Override
        public String toString() {
            return "Thumbnail{" +
                    "url='" + url + '\'' +
                    ", width=" + width +
                    ", height=" + height +
                    '}';
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }


}
