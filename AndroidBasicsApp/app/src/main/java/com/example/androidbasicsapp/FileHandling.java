package com.example.androidbasicsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileHandling extends AppCompatActivity {

    Button load, save;
    EditText text;
    String FILE_NAME = "results.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.filehandling);

        load = findViewById(R.id.load);
        save = findViewById(R.id.save);
        text = findViewById(R.id.editText);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = text.getText().toString();
                FileOutputStream fos = null;

                try{
                    fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
                    fos.write(input.getBytes());
                    text.getText().clear();
                    Toast.makeText(FileHandling.this, "Saved", Toast.LENGTH_SHORT).show();
                }
                catch (IOException e){
                    throw new RuntimeException(e);
                }
                finally {
                    if(fos != null){
                        try{
                            fos.close();
                        }
                        catch (IOException e){
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileInputStream fis = null;
                try{
                    fis = openFileInput(FILE_NAME);
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader br = new BufferedReader(isr);
                    StringBuilder sb = new StringBuilder();
                    String text1;
                    while((text1 = br.readLine()) != null){
                        sb.append(text1).append("\n");
                    }
                    text.setText(sb.toString());
                }
                catch (IOException e){
                    throw new RuntimeException(e);
                }
                finally {
                    if(fis != null){
                        try{
                            fis.close();
                        }
                        catch (IOException e){
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });

    }
}
