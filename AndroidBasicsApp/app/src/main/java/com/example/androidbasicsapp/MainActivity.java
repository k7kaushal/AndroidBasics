package com.example.androidbasicsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button register, display, file, video, audio, map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        register = findViewById(R.id.register);
        display = findViewById(R.id.display);
        file = findViewById(R.id.fileUpload);
        video = findViewById(R.id.video);
        audio = findViewById(R.id.audio);
        map = findViewById(R.id.map);

        Intent RegistrationFormIntent = new Intent(this, RegistrationForm.class);
        Intent DisplayContentIntent = new Intent(this, Form.class);
        Intent FileHandlingIntent = new Intent(this, FileHandling.class);
        Intent VideoIntent = new Intent(this, VideoPlayer.class);
        Intent AudioIntent = new Intent(this, AudioPlayer.class);
        Intent MapIntent = new Intent(this, MapsIntegration.class);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(RegistrationFormIntent);
            }
        });
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(DisplayContentIntent);
            }

        });
        file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(FileHandlingIntent);
            }
        });
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(VideoIntent);
            }
        });
        audio.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(AudioIntent);
            }
        }));
        map.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MapIntent);
            }
        }));
    }
}