package com.example.atlas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LeaderBoards extends AppCompatActivity {

    ImageButton home,leader,dm,gear,order;
    TextView first, second, third, others;
    String[] names;
    int[] scores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_boards);
        ImageButton home =(ImageButton) findViewById(R.id.imageButton2);
        ImageButton leader =(ImageButton) findViewById(R.id.imageButton5);
        ImageButton dm =(ImageButton) findViewById(R.id.imageButton6);
        ImageButton gear =(ImageButton) findViewById(R.id.imageButton7);
        ImageButton order =(ImageButton) findViewById(R.id.imageButton8);

        ArrayList<String> Participants = new ArrayList<String>();

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
        }
        int n = Participants.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (scores[j] > scores[j + 1]) {
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

            }
        });

        leader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        dm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        gear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int size = Participants.size();
                for(int i = 0;i<size/2;i++)
                {
                    String temp_s = names[i];
                    names[i] = names[size-i];
                    names[size-1] = temp_s;

                    int temp_n = scores[i];
                    scores[i] = scores[size-i];
                    scores[size-1] = temp_n;

                }
                String Others = "";
                for(int i = 3; i <n-1;i++)
                {
                    Others += names[i] + ": " + scores[i]+" /100 \n";
                }

                Others += names[n-1] + ": " + scores[n-1]+" /100 ";
            }
        });

    }




}