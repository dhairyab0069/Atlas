package com.example.atlas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button profile, friends, checkIn, main, leader, journal, metrics;
    TextView see, gym1, gym2, gym3, gym4;
    TextView gym1Friends, gym2Friends, gym3Friends, gym4Friends;
    Spinner gym;
    String name;
    String old1, old2, old3, old4;
//    String gymList[] = {"UBCO Gym", "Anytime Fitness", "World Gym", "YMCA"};
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
        journal = findViewById(R.id.journalButton);
        metrics = findViewById(R.id.metricsButton);

        //TextViews for gym names
        see = (TextView) findViewById(R.id.seeWho);
        gym1 = (TextView) findViewById(R.id.gym1);
        gym2 = (TextView) findViewById(R.id.gym2);
        gym3 = (TextView) findViewById(R.id.gym3);
        gym4 = (TextView) findViewById(R.id.gym4);

        //TextViews for friends in gyms
        gym1Friends = (TextView) findViewById(R.id.friends1);
        gym2Friends = (TextView) findViewById(R.id.friends2);
        gym3Friends = (TextView) findViewById(R.id.friends3);
        gym4Friends = (TextView) findViewById(R.id.friends4);


        //Spinner set up for gym check-in
        gym = (Spinner) findViewById(R.id.selectGym);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gym_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        gym.setAdapter(adapter);

        for(String name: gym1People){
            str1.append(name+"  ");
            System.out.println(str1);
        }
        gym1Friends.setText(str1.toString());
        old1 = str1.toString();

        for(String name: gym2People){
            str2.append(name+"  ");
        }
        gym2Friends.setText(str2.toString());
        old2 = str2.toString();

        for(String name: gym3People){
            str3.append(name+"  ");
        }
        gym3Friends.setText(str3.toString());
        old3 = str3.toString();

        for(String name: gym4People){
            str4.append(name+"  ");
        }
        gym4Friends.setText(str4.toString());
        old4 = str4.toString();

        if(gym.getSelectedItem()==null){
            checkIn.setEnabled(false);
        }else
            checkIn.setEnabled(true);

        checkIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gymSelection = gym.getSelectedItem().toString();
                if(gymSelection.equals("UBCO Gym")) {
                    gym1People.add(name);
                    str1.append(name);
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
            }
        });
    }
}