package com.example.atlas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

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
        home = (Button) findViewById(R.id.bjhome) ;


submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

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

}