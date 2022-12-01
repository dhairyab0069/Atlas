package com.example.atlas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class benchAddJ extends AppCompatActivity {

    Button back, home, submit ;
    EditText bmax ;
    EditText bsets ;
    EditText breps;

    private static final String file="benchjournal.txt";

    static ArrayList<String> benchdata = new ArrayList<String>();

    public static String sets, reps, max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bench_add_j);

        bmax = (EditText) findViewById(R.id.bjmax);
        bsets = (EditText) findViewById(R.id.bjSets);
        breps = (EditText) findViewById(R.id.bjreps);

        submit = (Button) findViewById(R.id.bsubmit) ;
        back = (Button) findViewById(R.id.bjback) ;
        home = (Button) findViewById(R.id.bjhome) ;




        submit.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v) {

                max = bmax.getText().toString();
                sets = bsets.getText().toString();
                reps = breps.getText().toString();

                int maxc, setsc, repsc;
                maxc = max.length();
                setsc = sets.length();
                repsc = reps.length();


                if (maxc == 0 || setsc == 0 || repsc == 0) {

                    Toast.makeText(benchAddJ.this, "Field(s) missing", Toast.LENGTH_SHORT).show();

                }

                else{
                    //writearr(sets,reps,max);
                    write(sets,reps,max);
                    home();
                    finish();
                }


            }

        });





        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home();
                finish();
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
                finish();
            }
        });


    }
    public void writearr(String sets, String reps, String max){

        String txt =sets+","+reps+","+max+"\n";
        benchdata.add(txt);



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

        finish();

    }

    public void home(){ //creates new intent

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();


    }


    public void back(){ //creates new intent

        Intent intent = new Intent(this,benchJournal.class);
        startActivity(intent);
        finish();


    }

    public void Bjournal(){ //creates new intent

        Intent intent = new Intent(this,benchJournal.class);
        startActivity(intent);



    }






}