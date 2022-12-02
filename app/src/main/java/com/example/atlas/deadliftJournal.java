package com.example.atlas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
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

public class deadliftJournal extends AppCompatActivity {

    TextView deadliftsets;
    TextView deadliftreps;
    TextView deadliftmax;

    Button next, prev, add, home,back;

    private static final String file="deadliftjournal.txt";

    public static String sets, reps, max;
    public static int  count= 0;
    public static ArrayList<String> deadlifttxt = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deadlift_journal);

        deadliftsets = (TextView) findViewById(R.id.dsets);
        deadliftreps = (TextView) findViewById(R.id.dreps);
        deadliftmax = (TextView) findViewById(R.id.dmax);
        next = (Button) findViewById(R.id.deadliftnext);
        prev = (Button) findViewById(R.id.deadliftprev);
        add = (Button) findViewById(R.id.deadliftadd);
        home = (Button) findViewById(R.id.deadlifthome);
        back = (Button) findViewById(R.id.deadliftback);

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
                finish();
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
                finish();
                home();
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(count == (deadlifttxt.size()-1) ){

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

                    if(deadlifttxt.size() == 0){

                        settext();
                    }
                    else{
                        count = deadlifttxt.size()-1;
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

        String view  = deadlifttxt.get(count);
        String[] str= view.split(",");
        sets = str[0];
        reps = str[1];
        max = str[2];


        deadliftsets.setText(sets);
        deadliftreps.setText(reps);
        deadliftmax.setText(max);

    }

    public void defsettext(){

        sets = "XXXXXXXXXXXX";
        reps = "XXXXXXXXXXXX";
        max  = "XXXXXXXXXXXX";


        deadliftsets.setText(sets);
        deadliftreps.setText(reps);
        deadliftmax.setText(max);

    }




    public void read(){


        String line = "";

        try {
            FileInputStream fis = openFileInput(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            if ((line = br.readLine()) == null){

                Toast.makeText(deadliftJournal.this, "File is empty", Toast.LENGTH_SHORT).show();
                journal();

            }else{
                while ((line = br.readLine()) != null) {
                    deadlifttxt.add(line);

                }

                if(deadlifttxt.isEmpty()){

                    deadlifttxt.add("XXXXXXXX,XXXXXXXX,XXXXXXXX");
                    //int s = deadlifttxt.size();
                    //String a = "Array is empty"+s+" "+line;
                    //Toast.makeText(deadliftJournal.this, a, Toast.LENGTH_SHORT).show();

                }
                else {


                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        //deadlifttxt.removeIf(n -> n.equals(" , , "));
                        deadlifttxt.removeIf(n -> n.equals("XXXXXXXX,XXXXXXXX,XXXXXXXX"));
                    }


                }
            }

        }catch (FileNotFoundException e){
            Toast.makeText(deadliftJournal.this, "File not found, initialising file", Toast.LENGTH_SHORT).show();
           // write("XXXXXXXX","XXXXXXXX","XXXXXXXX");
            //write("XXXXXXXX","XXXXXXXX","XXXXXXXX");
            finish();
            //current();
            //finish();
            journal();
            e.printStackTrace();
        }
        catch (IOException e){
            Toast.makeText(deadliftJournal.this, "IO exception", Toast.LENGTH_SHORT).show();
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

        Intent intent = new Intent(this,deadliftAddJ.class);
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