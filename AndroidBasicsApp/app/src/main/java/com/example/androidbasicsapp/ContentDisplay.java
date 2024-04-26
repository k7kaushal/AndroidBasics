package com.example.androidbasicsapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ContentDisplay extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.displaydata);

        TextView text = findViewById(R.id.text_display);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            text.setText(extras.getString("output"));
        }
    }
}
