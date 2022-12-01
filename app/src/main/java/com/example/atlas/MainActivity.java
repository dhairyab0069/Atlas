package com.example.atlas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button profile, friends, checkIn, main, leader, journal, metrics;
    TextView see, gym1, gym2, gym3, gym4;
    TextView gym1Friends, gym2Friends, gym3Friends, gym4Friends;
    Spinner gym;
    String name;
    String gymList[][];
    String gym1People[];
    String gym2People[];
    String gym3People[];
    String gym4People[];
    String gymSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Placeholder user info
        name = "Alex";

        //Placeholder for friend info
//        gym1People

        //Buttons
        profile = findViewById(R.id.profileButton);
        friends = findViewById(R.id.friendsButton);
        checkIn = findViewById(R.id.checkIn);
        main = findViewById(R.id.main);
        leader = findViewById(R.id.leaderButton);
        journal = findViewById(R.id.journalButton);
        metrics = findViewById(R.id.metricsButton);

        //TextViews
        see = (TextView) findViewById(R.id.seeWho);
        gym1 = (TextView) findViewById(R.id.gym1);
        gym2 = (TextView) findViewById(R.id.gym2);
        gym3 = (TextView) findViewById(R.id.gym3);
        gym4 = (TextView) findViewById(R.id.gym4);
    }
}