package com.example.atlas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button journal ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        journal = (Button) findViewById(R.id.journal) ;


        journal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                journal();
            }
        });


    }


    public void journal(){ //creates new intent

        Intent intent = new Intent(this,GymJournal.class);
        startActivity(intent);



    }



}



  