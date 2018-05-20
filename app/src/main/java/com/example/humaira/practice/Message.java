package com.example.humaira.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Message extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        Intent intent = getIntent();
        String msg = intent.getStringExtra("EXTRA_MESSAGE");
        TextView tv = findViewById(R.id.msg);
        tv.setText(msg);
    }
}
