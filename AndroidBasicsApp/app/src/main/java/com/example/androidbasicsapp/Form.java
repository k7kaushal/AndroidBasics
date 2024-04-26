package com.example.androidbasicsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Form extends AppCompatActivity {

    CheckBox checkBox, checkBox2;
    Button sendinfo;
    RadioGroup rg;
    RadioButton rb1, rb2;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.informationdisplay);

        checkBox = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        rg = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);
        sendinfo = findViewById(R.id.sendinfo);
        spinner = findViewById(R.id.spinner);

        ArrayList<String> Pro = new ArrayList<>();
        Pro.add("Pro");
        Pro.add("Noob");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Pro);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        sendinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder output = new StringBuilder();
                if(checkBox.isChecked()) output.append("UG");
                if(checkBox2.isChecked()) output.append("PG");
                int r = rg.getCheckedRadioButtonId();
                RadioButton gender = findViewById(r);
                String Gender = gender.getText().toString();
                output.append(Gender);
                String selectedspinner = spinner.getSelectedItem().toString();
                output.append(selectedspinner);

                Intent intent = new Intent(Form.this, ContentDisplay.class);
                intent.putExtra("output", (CharSequence) output);
                startActivity(intent);
            }
        });
    }
}
