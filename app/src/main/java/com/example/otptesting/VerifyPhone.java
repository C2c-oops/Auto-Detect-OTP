package com.example.otptesting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class VerifyPhone extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button button;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_phone);

        editText = findViewById(R.id.phone_number_edt);
        textView = findViewById(R.id.txt_selected_mobile_num);
        button = findViewById(R.id.txt_next);

        mAuth = FirebaseAuth.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    public void registerUser(){
        String phoneNo = editText.getText().toString();

        Intent intent = new Intent(this, OtpVerification.class);
        intent.putExtra("phoneNo", phoneNo);
        startActivity(intent);
    }
}
