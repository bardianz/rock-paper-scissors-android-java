package ir.notroweb.rockpaperscissors;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Random;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView, resultTxtView;
    private ImageView paper, scissors, rock, userImage, pcImage;
    private int userChoice, pcChoice;
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
        resultTxtView = findViewById(R.id.resultTxtView);
        resultTxtView.setVisibility(View.INVISIBLE);

        paper = findViewById(R.id.paper);
        scissors = findViewById(R.id.scissors);
        rock = findViewById(R.id.rock);

    }

    private int makeRandom() {
        Random rand = new Random();
        int upperbound = 3;
        int int_random = rand.nextInt(upperbound);
        return int_random;
    }

    public void userSelect(View v) {
        resultTxtView.setVisibility(View.INVISIBLE);
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
        userCardView.setVisibility(View.VISIBLE);
        pcSelect();
        game(userChoice, pcChoice);

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
        pcCarView.setVisibility(View.VISIBLE);
    }

    public void game(int user, int pc) {
        resultTxtView.setVisibility(View.VISIBLE);
        if (user == pc) {
            resultTxtView.setText("Draw");
            resultTxtView.setTextColor(getResources().getColor(R.color.black));

        } else {
            switch (pc) {
                case 0:
                    if (user == 1) {
                        resultTxtView.setText("You Won :))");
                        resultTxtView.setTextColor(getResources().getColor(R.color.green));
                    } else {
                        resultTxtView.setText("You lose :))");
                        resultTxtView.setTextColor(getResources().getColor(R.color.red));
                    }
                    break;
                case 1:
                    if (user == 2) {
                        resultTxtView.setText("You Won :))");
                        resultTxtView.setTextColor(getResources().getColor(R.color.green));
                    } else {
                        resultTxtView.setText("You lose :))");
                        resultTxtView.setTextColor(getResources().getColor(R.color.red));
                    }
                    break;
                case 2:
                    if (user == 0) {
                        resultTxtView.setText("You lose :))");
                        resultTxtView.setTextColor(getResources().getColor(R.color.red));
                    } else {
                        resultTxtView.setText("You Won :))");
                        resultTxtView.setTextColor(getResources().getColor(R.color.green));
                    }
                    break;
            }
        }
    }
}


