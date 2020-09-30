package com.example.array_drawcards;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {
    GifImageView card;
    Button draw;
    String[] cardname = {"club_a","diamond_2","diamond_3","heart_4","diamond_5","diamond_6","diamond_7","diamond_8","diamond_9","diamond_10","heart_j","spade_q","heart_k"};
    TextView ketqua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        card = (GifImageView)findViewById(R.id.givCard);
        draw = (Button)findViewById(R.id.btnDraw);
        ketqua = (TextView)findViewById(R.id.tvResult);

        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                String name = cardname[random.nextInt(13)];
                int id = getResources().getIdentifier(name,"drawable",getPackageName());
                card.setImageResource(id);
                String[] type = name.split("_");
                ketqua.setText("Bạn rút được lá: " + ReadCardName(type));

            }
        });
    }
    String ReadCardName(String[] type)
    {
        String chat = "";
        String so = "";
        for (int i = 0;i < type.length;i++)
        {
            switch (type[0])
            {
                case "diamond": chat = "rô";break;
                case "heart": chat = "cơ";break;
                case "club": chat = "đầm";break;
                case "spade": chat = "bích";break;
            }
            switch (type[1])
            {
                case "a": so = "ách";break;
                case "2": so = "2";break;
                case "3": so = "3";break;
                case "4": so = "4";break;
                case "5": so = "5";break;
                case "6": so = "6";break;
                case "7": so = "7";break;
                case "8": so = "8";break;
                case "9": so = "9";break;
                case "10": so = "10";break;
                case "j": so = "bồi";break;
                case "q": so = "đầm";break;
                case "k": so = "già";break;
            }
        }
        return so + " " + chat;
    }

}