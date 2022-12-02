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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class squatJournal extends AppCompatActivity {


    TextView squatsets;
    TextView squatreps;
    TextView squatmax;

    Button next, prev, add, home,back;

    private static final String file="squatjournal.txt";

    public static String sets, reps, max;
    public static int  count= 0;
    public static ArrayList<String> squattxt = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squat_journal);

        squatsets = (TextView) findViewById(R.id.Ssets);
        squatreps = (TextView) findViewById(R.id.Sreps);
        squatmax = (TextView) findViewById(R.id.Smax);
        next = (Button) findViewById(R.id.Squatnext);
        prev = (Button) findViewById(R.id.Squatprev);
        add = (Button) findViewById(R.id.Squatadd);
        home = (Button) findViewById(R.id.Squathome);
        back = (Button) findViewById(R.id.Squatback);

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

                if(count == (squattxt.size()-1) ){

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

                    if(squattxt.size() == 0){

                        settext();
                    }
                    else{
                        count = squattxt.size()-1;
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

        String view  = squattxt.get(count);
        String[] str= view.split(",");
        sets = str[0];
        reps = str[1];
        max = str[2];


        squatsets.setText(sets);
        squatreps.setText(reps);
        squatmax.setText(max);

    }

    public void defsettext(){

        sets = "XXXXXXXXXXXX";
        reps = "XXXXXXXXXXXX";
        max  = "XXXXXXXXXXXX";


        squatsets.setText(sets);
        squatreps.setText(reps);
        squatmax.setText(max);

    }




    public void read(){


        String line = "";

        try {
            FileInputStream fis = openFileInput(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            if ((line = br.readLine()) == null){

                Toast.makeText(squatJournal.this, "File is empty", Toast.LENGTH_SHORT).show();
                journal();

            }else{
                while ((line = br.readLine()) != null) {
                    squattxt.add(line);

                }

                if(squattxt.isEmpty()){

                    int s = squattxt.size();
                    String a = "Array is empty"+s;
                    Toast.makeText(squatJournal.this, a, Toast.LENGTH_SHORT).show();

                }
            }

        }catch (FileNotFoundException e){
            Toast.makeText(squatJournal.this, "File not found", Toast.LENGTH_SHORT).show();
            write("XXXXXXXX","XXXXXXXX","XXXXXXXX");
            current();
            //finish();
            //journal();
            e.printStackTrace();
        }
        catch (IOException e){
            Toast.makeText(squatJournal.this, "IO exception", Toast.LENGTH_SHORT).show();
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

        Intent intent = new Intent(this,squatAddJ.class);
        startActivity(intent);

    }

    public void current(){ //creates new intent

        Intent intent = new Intent(this,benchJournal.class);
        startActivity(intent);
    }





    public void write(String sets, String reps, String max){



        String txt =sets+","+reps+","+max+"\n";
        FileOutputStream fos = null;

        try {
            fos = openFileOutput(file, MODE_APPEND);
            fos.write(txt.getBytes());
            Toast.makeText(squatJournal.this, "Added!", Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{

            if(fos!=null){

                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        // finish();

    }

}