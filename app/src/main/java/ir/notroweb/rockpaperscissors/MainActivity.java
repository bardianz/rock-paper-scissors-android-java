package ir.notroweb.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Random;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private ImageView paper, scissors, rock, userImage, pcImage;
    private int userChoice,pcChoice;
    private CardView pcCarView, userCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pcImage = findViewById(R.id.pcImage);
        userImage = findViewById(R.id.userImage);

        userCardView = findViewById(R.id.cardViewUser);
        pcCarView = findViewById(R.id.cardViewPc);

        textView = findViewById(R.id.textView);

        paper = findViewById(R.id.paper);
        scissors = findViewById(R.id.scissors);
        rock = findViewById(R.id.rock);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = userChoice + "";
                textView.setText(text);
            }
        });
    }

    private int makeRandom() {
        Random rand = new Random();
        int upperbound = 3;
        int int_random = rand.nextInt(upperbound);
        return int_random;
    }

    public void userSelect(View v) {
        switch (v.getId()) {
            case R.id.rock:
                userChoice = 0;
                userImage.setImageResource(R.drawable.rock);
                break;
            case R.id.paper:
                userChoice = 1;
                userImage.setImageResource(R.drawable.paper);
                break;
            case R.id.scissors:
                userChoice = 2;
                userImage.setImageResource(R.drawable.scissors);
                break;
        }
        userCardView.setVisibility(1);

    }
    public void pcSelect() {
        pcChoice = makeRandom();
        switch (pcChoice) {
            case 0:
                pcImage.setImageResource(R.drawable.rock);
                break;
            case 1:
                pcImage.setImageResource(R.drawable.paper);
                break;
            case 2:
                pcImage.setImageResource(R.drawable.scissors);
                break;
        }
        pcImage.setVisibility(1);
    }
};


