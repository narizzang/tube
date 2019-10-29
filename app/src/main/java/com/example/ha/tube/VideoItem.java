package com.example.ha.tube;

public class VideoItem {

    public VideoItem(String u, String t, String v, String id) {
        this.thumbnailUrl = u;
        this.title = t;
        this.views = v;
        this.videoId = id;
        this.likes = 0;
    }

    public VideoItem(String u, String t, String v, String id, int i) {
        this.thumbnailUrl = u;
        this.title = t;
        this.views = v;
        this.videoId = id;
        this.likes = i;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    String thumbnailUrl;
    String videoId;
    String title;
    String views;
    int likes;

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getViews() {
        return views;
    }

    public String getLikes() {
        return "좋아요 "+likes+"회";
    }

    public void setViews(String views) {
        this.views = views;
    }

}
