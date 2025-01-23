package com.example.practice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity  extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonPlayComputer = findViewById(R.id.buttonPlayComputer);
        Button buttonQuickPlay = findViewById(R.id.buttonQuickPlay);
        buttonPlayComputer.setOnClickListener(v ->{
            Toast.makeText(this , "coming soon :)" , Toast.LENGTH_SHORT).show();
        });
        buttonQuickPlay.setOnClickListener(v ->{
            Intent intent = new Intent(this,QuickPLayActivity.class);
            startActivity(intent);

        });

        

    }
}
