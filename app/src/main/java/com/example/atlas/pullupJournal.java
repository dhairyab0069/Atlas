package com.example.atlas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class pullupJournal extends AppCompatActivity {
    TextView pullupsets;
    TextView pullupreps;
    TextView pullupmax;

    Button next, prev, add, home,back;

    private static final String file="pullupjournal.txt";

    public static String sets, reps, max;
    public static int  count= 0;
    public static ArrayList<String> pulluptxt = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pullup_journal);
        pullupsets = (TextView) findViewById(R.id.usets);
        pullupreps = (TextView) findViewById(R.id.ureps);
        pullupmax = (TextView) findViewById(R.id.umax);
        next = (Button) findViewById(R.id.pullupnext);
        prev = (Button) findViewById(R.id.pullupprev);
        add = (Button) findViewById(R.id.pullupadd);
        home = (Button) findViewById(R.id.pulluphome);
        back = (Button) findViewById(R.id.pullupback);

        read();
        settext();

        //if(benchdata.isEmpty()){

        //       defsettext();
        //     }
        //     else {
        //         settext();

        //      }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                journal();
            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home();
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(count == (pulluptxt.size()-1) ){

                    count = 0;
                    settext();


                }

                else {
                    count++;
                    settext();
                }
            }
        });


        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count == 0) {

                    if(pulluptxt.size() == 0){

                        settext();
                    }
                    else{
                        count = pulluptxt.size()-1;
                        settext();}
                }

                else{
                    count--;
                    settext();


                }
            }
        });





    }

    public void settext(){

        String view  = pulluptxt.get(count);
        String[] str= view.split(",");
        sets = str[0];
        reps = str[1];
        max = str[2];


        pullupsets.setText(sets);
        pullupreps.setText(reps);
        pullupmax.setText(max);

    }

    public void defsettext(){

        sets = "XXXXXXXXXXXX";
        reps = "XXXXXXXXXXXX";
        max  = "XXXXXXXXXXXX";


        pullupsets.setText(sets);
        pullupreps.setText(reps);
        pullupmax.setText(max);

    }




    public void read(){


        String line = "";

        try {
            FileInputStream fis = openFileInput(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            if ((line = br.readLine()) == null){

                Toast.makeText(pullupJournal.this, "File is empty", Toast.LENGTH_SHORT).show();
                journal();

            }else{
                while ((line = br.readLine()) != null) {
                    pulluptxt.add(line);

                }

                if(pulluptxt.isEmpty()){

                    int s = pulluptxt.size();
                    String a = "Array is empty"+s;
                    Toast.makeText(pullupJournal.this, a, Toast.LENGTH_SHORT).show();

                }
            }

        }catch (FileNotFoundException e){
            Toast.makeText(pullupJournal.this, "File not found", Toast.LENGTH_SHORT).show();
            //finish();
            journal();
            e.printStackTrace();
        }
        catch (IOException e){
            Toast.makeText(pullupJournal.this, "IO exception", Toast.LENGTH_SHORT).show();
            //finish();
            journal();
            e.printStackTrace();
        }


    }




    public void home(){ //creates new intent

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }


    public void journal(){ //creates new intent

        Intent intent = new Intent(this,GymJournal.class);
        startActivity(intent);
    }


    public void add(){ //creates new intent

        Intent intent = new Intent(this,pullupAddJ.class);
        startActivity(intent);


    }
}