package com.example.otptesting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_getStarted);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //isConnected();
                checkConnection(isConnected());
            }
        });
    }

    public void checkConnection(boolean isConnected){
        if (isConnected) {
            Intent intent = new Intent(this, VerifyPhone.class);
            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            //this.finish();
            //Toast.makeText(this, "Connected to Internet", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, ConnectionLost.class);
            startActivity(intent);
            //Toast.makeText(this, "Oops! Not Connected to Internet", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean isConnected(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }
}
