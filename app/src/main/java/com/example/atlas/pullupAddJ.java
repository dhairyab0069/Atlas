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

public class pullupAddJ extends AppCompatActivity {

    TextView pullupsets;
    TextView pullupreps;
    TextView pullupmax;

    Button submit, home,back;

    private static final String file="pullupjournal.txt";

    public static String sets, reps, max;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pullup_add_j);
        pullupsets = (TextView) findViewById(R.id.upSets);
        pullupreps = (TextView) findViewById(R.id.upreps);
        pullupmax = (TextView) findViewById(R.id.upmax);

        submit = (Button) findViewById(R.id.upsubmit) ;
        home = (Button) findViewById(R.id.uphome);
        back = (Button) findViewById(R.id.upback);

        submit.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v) {

                max = pullupmax.getText().toString();
                sets = pullupsets.getText().toString();
                reps = pullupreps.getText().toString();

                int maxc, setsc, repsc;
                maxc = max.length();
                setsc = sets.length();
                repsc = reps.length();


                if (maxc == 0 || setsc == 0 || repsc == 0) {

                    Toast.makeText(pullupAddJ.this, "Field(s) missing", Toast.LENGTH_SHORT).show();

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
                home();
                //finish();
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
            Toast.makeText(pullupAddJ.this, "Added!", Toast.LENGTH_SHORT).show();

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

        Intent intent = new Intent(this,pullupJournal.class);
        startActivity(intent);



    }
}