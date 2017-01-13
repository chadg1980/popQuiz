
package com.h.chad.popquiz;

import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.duration;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {
    public int totalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //one method to keep this area clean.
        submitButtonClick();
    }

    /**
     * The submitButtonClick method is activated when the user presses the submit button.
     * The score will be calculated and the shown to the user in a toast method.
     * The method takes no input and returns to value
     */
    public void submitButtonClick() {
        final Button submit = (Button) findViewById(R.id.scoreQuiz);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalScore = 0;     //reset the score to 0 after button is pressed
                scoreQuestion1();   //Score question 1
                scoreQuestion2();   //Score question 2
                scoreQuestion3();   //Score question 3
                scoreQuestion4();   //Score question 4
                scoreQuestion5();   //Score question 5
                showToast();        //display the score in a toast message
            }
        });
    }

    /**
     * scoreQuestion1 method checks which radio button is marked when the submit button is clicked
     * if correct, totalScore has 1 added
     * else nothing is done
     */
    public void scoreQuestion1() {
        RadioButton answer1 = (RadioButton) findViewById(R.id.answer1);
        if (answer1.isChecked()) {
            totalScore += 1;
        }
    }
    /**
     * scoreQuestion2 adds one to totalScore if answer2 contain rainier
     * for Mount Rainier or Mt Rainier
     * Rainier or  rainier
     * all are correct....Spelling counts
     */
    public void scoreQuestion2() {
        EditText answer2 = (EditText) findViewById(R.id.rainier);
        String userInput = answer2.getText().toString().toLowerCase();
        if (userInput.contains("rainier")) {
            totalScore++;
        }
    }

    /**
     * ScoreQuestion3 will add a point only if all correct answers are chosen.
     * and the incorrect answers are not checked.
     * aliceInChains, pearl_jam, and queensrych are correct
     */
    public void scoreQuestion3() {
        CheckBox iron_maiden    = (CheckBox) findViewById(R.id.answer300);
        CheckBox aliceInChains  = (CheckBox) findViewById(R.id.answer301);
        CheckBox metallica      = (CheckBox) findViewById(R.id.answer302);
        CheckBox queensrych     = (CheckBox) findViewById(R.id.answer303);
        CheckBox pearl_jam      = (CheckBox) findViewById(R.id.answer304);
        CheckBox beegees        = (CheckBox) findViewById(R.id.answer305);

        if (aliceInChains.isChecked() &&
                pearl_jam.isChecked() &&
                queensrych.isChecked() &&
                !metallica.isChecked() &&
                !beegees.isChecked() &&
                !iron_maiden.isChecked()) {
            totalScore++;
        }
    }
    /**
     * scoreQuestion4 will add a point to totalScore if and only if
     * answer401 and answer403 are checked
     * Otherwise no score is added.
     * The correct answers are 1962 and 1909
     */
    public void scoreQuestion4() {
        CheckBox correct1 = (CheckBox) findViewById(R.id.answer401);
        CheckBox correct2 = (CheckBox) findViewById(R.id.answer403);
        CheckBox wrong1 = (CheckBox) findViewById(R.id.answer400);
        CheckBox wrong2 = (CheckBox) findViewById(R.id.answer402);
        CheckBox wrong3 = (CheckBox) findViewById(R.id.answer404);
        CheckBox wrong4 = (CheckBox) findViewById(R.id.answer405);

        if (correct1.isChecked() &&
                correct2.isChecked() &&
                !wrong1.isChecked() &&
                !wrong2.isChecked() &&
                !wrong3.isChecked() &&
                !wrong4.isChecked()) {
            totalScore++;
        }
    }
    /*
    * scoreQuestion5 will add a point to totalscore if answer5 is marked
    * the correct answer is Singles
    *
    * */
    public void scoreQuestion5() {
        RadioButton singles = (RadioButton) findViewById(R.id.answer5);
        if (singles.isChecked()) {
            totalScore++;
        }
    }
    /**
     * The showToast method just shows the toast message
     * No inputs
     * No outputs
     */
    public void showToast() {
        Context context = getApplicationContext();
        CharSequence score = "Sorry!\nYou only scored " + String.valueOf(totalScore) + " out of 5";
        CharSequence perfection = "Congratulations!\nYou got a perfect " + String.valueOf(totalScore) + " out of 5";
        int duration = Toast.LENGTH_SHORT;
        if (totalScore >= 5){
            Toast toast = Toast.makeText(context, perfection, duration);
            toast.show();
        }else{
            Toast toast = Toast.makeText(context, score, duration);
            toast.show();
        }


    }
}