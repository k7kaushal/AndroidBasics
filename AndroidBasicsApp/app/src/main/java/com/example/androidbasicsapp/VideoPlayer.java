package com.example.androidbasicsapp;

import android.widget.MediaController;
import android.widget.VideoView;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class VideoPlayer extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.video);
        VideoView videoView = findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.sample);
        videoView.start();
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
    }
}
