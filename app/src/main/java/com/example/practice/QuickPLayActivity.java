package com.example.practice;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuickPLayActivity extends AppCompatActivity {


        ChessBoardView chessBoardView;
        TextView textView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quickplay);

        chessBoardView = findViewById(R.id.chessBoardView);
        textView = findViewById(R.id.titleTextView);
        chessBoardView.setTextView(textView);



    }

}
