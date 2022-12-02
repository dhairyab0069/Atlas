package com.example.atlas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class deadliftAddJ extends AppCompatActivity {

    TextView deadliftsets;
    TextView deadliftreps;
    TextView deadliftmax;

    Button submit, home,back;

    private static final String file="deadliftjournal.txt";

    public static String sets, reps, max;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deadlift_add_j);
        deadliftsets = (TextView) findViewById(R.id.deSets);
        deadliftreps = (TextView) findViewById(R.id.dereps);
        deadliftmax = (TextView) findViewById(R.id.demax);

        submit = (Button) findViewById(R.id.desubmit) ;
        home = (Button) findViewById(R.id.dehome);
        back = (Button) findViewById(R.id.deback);

        submit.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v) {

                max = deadliftmax.getText().toString();
                sets = deadliftsets.getText().toString();
                reps = deadliftreps.getText().toString();

                int maxc, setsc, repsc;
                maxc = max.length();
                setsc = sets.length();
                repsc = reps.length();


                if (maxc == 0 || setsc == 0 || repsc == 0) {

                    Toast.makeText(deadliftAddJ.this, "Field(s) missing", Toast.LENGTH_SHORT).show();

                }

                else{
                    //writearr(sets,reps,max);
                    write(sets,reps,max);
                    //home();
                    //finish();
                }


            }

        });





        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                home();
                //finish();
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                back();
                //finish();
            }
        });


    }
    // public void writearr(String sets, String reps, String max){

    //  String txt =sets+","+reps+","+max+"\n";
    //benchdata.add(txt);



    // }

    public void write(String sets, String reps, String max){



        String txt =sets+","+reps+","+max+"\n";
        FileOutputStream fos = null;

        try {
            fos = openFileOutput(file, MODE_APPEND);
            fos.write(txt.getBytes());
            Toast.makeText(deadliftAddJ.this, "Added!", Toast.LENGTH_SHORT).show();

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

    public void home(){ //creates new intent

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);



    }


    public void back(){ //creates new intent

        Intent intent = new Intent(this,deadliftJournal.class);
        startActivity(intent);



    }


}