package com.example.atlas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Friends extends AppCompatActivity {

    Button home,leader,metric,journal;
    ImageButton req,req2,req3;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        home = (Button) findViewById(R.id.mainactiviy);
        leader = (Button) findViewById(R.id.leaderboard);
        metric = (Button) findViewById(R.id.friendmetric);
        journal = (Button) findViewById(R.id.friendjournal);

        req = (ImageButton) findViewById(R.id.request1);
        req2 = (ImageButton) findViewById(R.id.request2);
        req3 = (ImageButton) findViewById(R.id.request3);

        req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                req.setImageResource(R.drawable.check);
                Toast.makeText(Friends.this, "Friend Request sent!", Toast.LENGTH_SHORT).show();
            }
        });
        req2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                req2.setImageResource(R.drawable.check);
                Toast.makeText(Friends.this, "Friend Request sent!", Toast.LENGTH_SHORT).show();

            }
        });
        req3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                req3.setImageResource(R.drawable.check);
                Toast.makeText(Friends.this, "Friend Request sent!", Toast.LENGTH_SHORT).show();

            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(view.getContext(),LeaderBoards.class);
                startActivity(home);
            }
        });
        leader.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent leader = new Intent(view.getContext(),LeaderBoards.class);
                startActivity(leader);
                finish();
            }
        }));
        metric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        journal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent journal = new Intent(view.getContext(),GymJournal.class);
                startActivity(journal);
            }
        });


    }
}