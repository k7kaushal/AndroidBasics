package com.example.androidbasicsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistrationForm extends AppCompatActivity {

    EditText username, pass, repass;
    Button Submit;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.registrationform);

        username = findViewById(R.id.username);
        pass = findViewById(R.id.pass);
        repass = findViewById(R.id.repass);
        Submit = findViewById(R.id.button);
        db = new DBHelper(this);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = username.getText().toString();
                String b = pass.getText().toString();
                String c = repass.getText().toString();
                if(b.equals(c)){
                    boolean check = db.checkusername(a);
                    if(check == false){
                        boolean insert = db.insertdata(a, b);
                        if(insert == true) Toast.makeText(RegistrationForm.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
                        else Toast.makeText(RegistrationForm.this, "Failure", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(RegistrationForm.this, "User already exists!", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(RegistrationForm.this, "Re-Enter password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
