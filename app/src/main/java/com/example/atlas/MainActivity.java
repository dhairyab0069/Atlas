package com.example.atlas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button profile, friends, checkIn, main, leader, journal, metrics, checkOut;
    TextView see, gym1, gym2, gym3, gym4;
    TextView gym1Friends, gym2Friends, gym3Friends, gym4Friends;
    Spinner gym;
    String name;

    ArrayList<String> gym1People = new ArrayList<String>();
    ArrayList<String> gym2People = new ArrayList<String>();
    ArrayList<String> gym3People = new ArrayList<String>();
    ArrayList<String> gym4People = new ArrayList<String>();

    String gymSelection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Stringbuilders to add names
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        StringBuilder str3 = new StringBuilder();
        StringBuilder str4 = new StringBuilder();




        //Placeholder user info
        name = "Yegor";

        //Placeholder for friend info
        gym1People.add("Sahil");
        gym1People.add("Dhairya");
        gym3People.add("Mehul");
        gym3People.add("Prithvi");
        gym4People.add("Alex");

        //Buttons
        profile = findViewById(R.id.profileButton);
        friends = findViewById(R.id.friendsButton);
        checkIn = findViewById(R.id.checkIn);
        main = findViewById(R.id.main);
        leader = findViewById(R.id.leaderButton);
        journal = (Button) findViewById(R.id.journal) ;
        metrics = findViewById(R.id.metricsButton);
        checkOut = findViewById(R.id.checkOut);

        //TextViews for gym names
        see = (TextView) findViewById(R.id.seeWho);
        see.setTypeface(null, Typeface.BOLD);
        gym1 = (TextView) findViewById(R.id.gym1);
        gym1.setTypeface(null, Typeface.BOLD);
        gym2 = (TextView) findViewById(R.id.gym2);
        gym2.setTypeface(null, Typeface.BOLD);
        gym3 = (TextView) findViewById(R.id.gym3);
        gym3.setTypeface(null, Typeface.BOLD);
        gym4 = (TextView) findViewById(R.id.gym4);
        gym4.setTypeface(null, Typeface.BOLD);

        //TextViews for friends in gyms
        gym1Friends = (TextView) findViewById(R.id.friends1);
        gym1Friends.setTypeface(null, Typeface.BOLD);
        gym2Friends = (TextView) findViewById(R.id.friends2);
        gym2Friends.setTypeface(null, Typeface.BOLD);
        gym3Friends = (TextView) findViewById(R.id.friends3);
        gym3Friends.setTypeface(null, Typeface.BOLD);
        gym4Friends = (TextView) findViewById(R.id.friends4);
        gym4Friends.setTypeface(null, Typeface.BOLD);


        //Spinner set up for gym check-in
        gym = (Spinner) findViewById(R.id.selectGym);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gym_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        gym.setAdapter(adapter);

        for(String name: gym1People){
            str1.append(name+"  ");
        }
        gym1Friends.setText(str1.toString());

        for(String name: gym2People){
            str2.append(name+"  ");
        }
        gym2Friends.setText(str2.toString());

        for(String name: gym3People){
            str3.append(name+"  ");
        }
        gym3Friends.setText(str3.toString());

        for(String name: gym4People){
            str4.append(name+"  ");
        }
        gym4Friends.setText(str4.toString());

        if(gym.getSelectedItem()==null){
            checkIn.setEnabled(false);
        }else
            checkIn.setEnabled(true);

        checkOut.setEnabled(false);

        checkIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gymSelection = gym.getSelectedItem().toString();
                if(gymSelection.equals("UBCO Gym")) {
                    gym1People.add(name);
                    str1.append(name+" ");
                    gym1Friends.setText(str1.toString());
                }else if(gymSelection.equals("Anytime Fitness")) {
                    gym2People.add(name);
                    str2.append(name);
                    gym2Friends.setText(str2.toString());
                }else if(gymSelection.equals("World Gym")) {
                    gym3People.add(name);
                    str3.append(name);
                    gym3Friends.setText(str3.toString());
                }else {
                    gym4People.add(name);
                    str4.append(name);
                    gym4Friends.setText(str4.toString());
                }
                checkIn.setEnabled(false);
                checkOut.setEnabled(true);
            }
        });

        checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gymSelection.equals("UBCO Gym")) {
                    if(str1.length()==name.length()) {
                        gym1Friends.setText(" ");
                        str1.replace(0, str1.length()," ");
                    }
                    else {
                        str1.delete(str1.length() - 1 - name.length() - 1, str1.length());
                        gym1Friends.setText(str1);
                    }
                }else if(gymSelection.equals("Anytime Fitness")) {
                    if(str2.length()==name.length()) {
                        gym2Friends.setText(" ");
                        str2.replace(0, str2.length(), " ");
                    }else {
                        str2.delete(str2.length() - name.length() - 1, str2.length());
                        gym2Friends.setText(str2);
                    }
                }else if(gymSelection.equals("World Gym")) {
                    if(str3.length()==name.length()) {
                        str3.replace(0, str3.length() ," ");
                        gym3Friends.setText(" ");
                    }else {
                        str3.delete(str3.length() - 1 - name.length() - 1, str3.length());
                        gym3Friends.setText(str3);
                    }
                }else {
                    if (str4.length() == name.length()){
                        str4.replace(0, str4.length() , " ");
                        gym4Friends.setText(" ");
                    }else {
                        str4.delete(str4.length() - 1 - name.length() - 1, str4.length());
                        gym4Friends.setText(str4);
                    }
                }
                checkOut.setEnabled(false);
                checkIn.setEnabled(true);
            }
        });


        journal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                journal();
            }
        });

        leader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Leaderboard = new Intent(view.getContext(),LeaderBoards.class);
                startActivity(Leaderboard);
            }
        });
        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent friends = new Intent(view.getContext(),Friends.class);
                startActivity(friends);
            }
        });


    }



    public void journal(){ //creates new intent

        Intent intent = new Intent(this,GymJournal.class);
        startActivity(intent);



    }




}



  