package com.example.healthassist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;


//this class handles the activity when making the journal entries
public class Journal extends AppCompatActivity {
    private int[] hash = new int[8];
    private CardView head;
    private CardView throat;
    private CardView ear;
    private CardView mouth;
    private CardView tongue;
    public static final int HEAD_SELECT = 0;
    public static final int THROAT_SELECT = 1;
    public static final int EAR_SELECT = 2;
    public static final int MOUTH_SELECT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);
        head = findViewById(R.id.head);
        throat = findViewById(R.id.throat);
        ear = findViewById(R.id.ear);
        mouth = findViewById(R.id.mouth);
        tongue = findViewById(R.id.tongue);

        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                hash[0] ++;
            }
        });
        throat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                hash[1] ++;
            }
        });
        ear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                hash[2] ++;
            }
        });
        mouth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                hash[3] ++;
            }
        });
        tongue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(Journal.this, MainActivity.class);
                i.putExtra("map", hash);
                finish();
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //head symptom
        if (requestCode == HEAD_SELECT) {
            if (resultCode == RESULT_OK) {
                Bundle extras = getIntent().getExtras();
                hash[0] = extras.getInt("severity");
            }
        }
        //throat symptom
        else if (requestCode == THROAT_SELECT) {
            if (resultCode == RESULT_OK) {
                Bundle extras = getIntent().getExtras();
                hash[1] = extras.getInt("severity");
            }
        }
        //ear symptom
        else if (requestCode == EAR_SELECT) {
            if (resultCode == RESULT_OK) {
                Bundle extras = getIntent().getExtras();
                hash[2] = extras.getInt("severity");
            }
        }
        //mouth symptom
        else if (requestCode == MOUTH_SELECT) {
            if (resultCode == RESULT_OK) {
                Bundle extras = getIntent().getExtras();
                hash[3] = extras.getInt("severity");
            }
        }

        //done button
        else if (resultCode == RESULT_OK) {
            Intent i = new Intent(Journal.this, MainActivity.class);
            i.putExtra("map", hash);
            finish();
        }
    }
}
