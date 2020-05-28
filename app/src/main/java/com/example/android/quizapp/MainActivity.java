package com.example.android.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswers(View view) {
        int score = 0;
        EditText nameInput = (EditText) findViewById(R.id.name_input);
        CheckBox questionOneA = (CheckBox) findViewById(R.id.question_one_a);
        CheckBox questionOneB = (CheckBox) findViewById(R.id.question_one_b);
        CheckBox questionOneC = (CheckBox) findViewById(R.id.question_one_c);
        CheckBox questionOneD = (CheckBox) findViewById(R.id.question_one_d);
        CheckBox questionOneE = (CheckBox) findViewById(R.id.question_one_e);
        RadioButton questionTwoC = (RadioButton) findViewById(R.id.question_two_c);
        EditText questionThreeInput = (EditText) findViewById(R.id.question_three_input);
        EditText questionFourInput = (EditText) findViewById(R.id.question_four_input);

        String name = nameInput.getText().toString();
        String questionThree = questionThreeInput.getText().toString().toLowerCase();
        String questionFour = questionFourInput.getText().toString().toLowerCase();

        if(questionOneA.isChecked() && !(questionOneB.isChecked()) && questionOneC.isChecked() && !(questionOneD.isChecked()) && questionOneE.isChecked()) {
            score += 1;
        }

        if(questionTwoC.isChecked()) {
            score += 1;
        }

        String questionThreeAnswer = "yes";
        if(questionThree.contains(questionThreeAnswer)) {
            score += 1;
        }

        String questionFourAnswer = "bark";
        if(questionFour.contains(questionFourAnswer)) {
            score +=1;
        }

        if(score == 4) {
            Toast.makeText(getApplicationContext(),getString(R.string.all_correct, name),Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(),getString(R.string.toast, score, name),Toast.LENGTH_SHORT).show();
        }
    }
}
