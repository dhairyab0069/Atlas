package com.example.atlas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class GymJournal extends AppCompatActivity {

    Button submit, home  ;
    RadioGroup rgroup;
    RadioButton rbutton;

    String exerciseChoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_journal);

        rgroup = (RadioGroup) findViewById(R.id.exradiogroup);
        submit = (Button) findViewById(R.id.SelEx) ;
        home = (Button) findViewById(R.id.Squathome) ;


submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        File f = new File("/data/data/com.example.atlas/files/benchjournal.txt");
        if(!(f.exists() && !f.isDirectory())) {
            Toast.makeText(GymJournal.this, "bench file doesn't exist", Toast.LENGTH_SHORT).show();
            write(" "," "," ","benchjournal.txt");
           // write(" "," "," ","benchjournal.txt");
        }

        File v = new File("/data/data/com.example.atlas/files/squatjournal.txt");
        if(!(v.exists()&& !v.isDirectory())) {
            Toast.makeText(GymJournal.this, "squat file doesn't exist", Toast.LENGTH_SHORT).show();
            write(" "," "," ","squatjournal.txt");
          // write(" "," "," ","squatjournal.txt");
        }

        File l = new File("/data/data/com.example.atlas/files/pullupjournal.txt");
        if(!(l.exists()&& !l.isDirectory())) {
            Toast.makeText(GymJournal.this, "pull up file doesn't exist", Toast.LENGTH_SHORT).show();
            write(" "," "," ","pullupjournal.txt");
           // write(" "," "," ","pullupjournal.txt");
        }

        File k = new File("/data/data/com.example.atlas/files/deadliftjournal.txt");
        if(!(k.exists()&& !k.isDirectory())) {
            Toast.makeText(GymJournal.this, "deadlift file doesn't exist", Toast.LENGTH_SHORT).show();
            write(" "," "," ","deadliftjournal.txt");
            //write(" "," "," ","deadliftjournal.txt");
        }





        int radioid = rgroup.getCheckedRadioButtonId();



        if (radioid == -1) {


            Toast.makeText(GymJournal.this, "Select an exercise", Toast.LENGTH_SHORT).show();
        } else {


            rbutton = findViewById(radioid);
            exerciseChoice = rbutton.getText().toString();


            switch (exerciseChoice){

                case "Bench Press":
                    benchJournal();
                    break;

                case "Squat":
                    squatJournal();
                    break;

                case "Deadlift":
                    deadliftJournal();
                    break;

                case "Pull ups":
                    pullupJournal();
                    break;

                default:
                    break;

            }

        }






    }
});


home.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        home();
    }
});


    }

    public void benchJournal(){ //creates new intent

        Intent intent = new Intent(this,benchJournal.class);
        startActivity(intent);
        finish();



    }

    public void squatJournal(){ //creates new intent

        Intent intent = new Intent(this,squatJournal.class);
        startActivity(intent);
        finish();


    }

    public void deadliftJournal(){ //creates new intent

        Intent intent = new Intent(this,deadliftJournal.class);
        startActivity(intent);
        finish();


    }

    public void pullupJournal(){ //creates new intent

        Intent intent = new Intent(this,pullupJournal.class);
        startActivity(intent);
        finish();


    }

    public void home(){ //creates new intent

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();


    }


    public void write(String sets, String reps, String max, String file){



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