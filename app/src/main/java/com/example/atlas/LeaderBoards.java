package com.example.atlas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LeaderBoards extends AppCompatActivity {

    ImageButton home,leader,Journal,data;
    TextView first, second, third, others;
    String[] names = {"Dhairya","Mehul","Sahil","Prithvi","Yegor","Andrew","Shaurya"};
    int[] scores={97,86,99,79,80,100,94};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_boards);
         home =(ImageButton) findViewById(R.id.imageButton2);
         leader =(ImageButton) findViewById(R.id.imageButton5);
         Journal =(ImageButton) findViewById(R.id.imageButton6);
         data =(ImageButton) findViewById(R.id.imageButton7);

        first = (TextView) findViewById(R.id.first);
        second = (TextView) findViewById(R.id.second);
        third = (TextView) findViewById(R.id.third);
        others = (TextView) findViewById(R.id.others);
        /*

        File f = new File("/data/data/com.example.atlas/files/Rankings.txt");
        if(!(f.exists() && !f.isDirectory()))
        {
            write_Data("Dhairya","97","Rankings.txt");
            write_Data("Mehul","86","Rankings.txt");
            write_Data("Sahil","99","Rankings.txt");
            write_Data("Prithvi","79","Rankings.txt");
            write_Data("Yegor","80","Rankings.txt");
            write_Data("Andrew","100","Rankings.txt");
            write_Data("Shaurya","94","Rankings.txt");
        }
        try {
            FileInputStream fs = openFileInput("Rankings.txt");
            InputStreamReader is = new InputStreamReader(fs);
            BufferedReader br = new BufferedReader(is);
            String line;
            while ((line = br.readLine())!= null)
            {

                    Participants.add(line);

            }

            int size = Participants.size();
            names = new String[size];
            scores = new int[size];
            for(int i = 0;i<size;i++)
            {
                int limiter = Participants.get(i).indexOf(",") + 1;
                names[i] = Participants.get(i).substring(0,limiter);
            }
            for(int i = 0;i<size;i++)
            {
                int start = Participants.get(i).indexOf(",") + 1;
                scores[i] = Integer.parseInt(Participants.get(i).substring(start,size-1));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } */
        int n = 7;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (scores[j] < scores[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp_s = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = temp_s;

                    String temp_t = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = temp_t;
                }



        first.setText("1) "+ names[0]+ ": "+ scores[0]+" /100" );
        second.setText("2) "+ names[1]+ ": "+ scores[1]+" /100" );
        third.setText("3) "+ names[2]+ ": "+ scores[2]+" /100" );

        String Others = "";
        for(int i = 3; i <n-1;i++)
        {
            Others += names[i] + ": " + scores[i]+" /100 \n";
        }

        Others += names[n-1] + ": " + scores[n-1]+" /100 ";

        others.setText(Others);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            finish();
            }
        });

        leader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Journal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }

    public void write_Data(String name, String score, String file)
    {
            String FileContent = name+","+score;
            FileOutputStream os;
        try {
            os = openFileOutput(file, Context.MODE_APPEND);
            os.write(FileContent.getBytes());
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}