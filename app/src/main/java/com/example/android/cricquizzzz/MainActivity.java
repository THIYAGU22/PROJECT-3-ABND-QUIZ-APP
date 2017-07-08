package com.example.android.cricquizzzz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * CRIC QUIZ APP
 * this activity lets us to answer the question
 */

public class MainActivity extends AppCompatActivity {

    //answers are declared here for the questions by final method and it can be retrieved later
    final int Q1_ANSWER = R.id.question_1_fourth_pic_radio;
    final int Q2_ANSWER = R.id.question_2_first_pic_radio;
    final int Q3_ANSWER = R.id.question_3_first_pic_radio;
    final int Q4_ANSWER = R.id.question_4_second_pic_radio;
    final String Q5_ANSWER = "WASIMAKRAM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * incorrect answers array list will be created
     * it will counts us the incorrect answers
     * if it is wrong the score wont be given
     */
    public void checkQuiz(View v) {
        ArrayList<String> incorrectAnswersList = new ArrayList<String>();

        int numberOfQuestionsCorrect = 0;

        //it will check the answer for qn 1
        //if the answer is correct "numberofQuestionscorrect" will increment by 1 with the help of increment operator
        //if it is not correct "incorrectanserList" will comes to play.there is no mark for incorrectanswer
        if (checkQuestion1()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 1");
        }

        //it will check the answer for qn 2
        //if the answer is correct "numberofQuestionscorrect" will increment by 1 with the help of increment operator
        //if it is not correct "incorrectanserList" will comes to play.there is no mark for incorrectanswer
        if (checkQuestion2()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 2");
        }

        //it will check the answer for qn 3
        //if the answer is correct "numberofQuestionscorrect" will increment by 1 with the help of increment operator
        //if it is not correct "incorrectanserList" will comes to play.there is no mark for incorrectanswer
        if (checkQuestion3()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 3");
        }

        //it will check the answer for qn 4
        //if the answer is correct "numberofQuestionscorrect" will increment by 1 with the help of increment operator
        //if it is not correct "incorrectanserList" will comes to play.there is no mark for incorrectanswer
        if (checkQuestion4()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 4");
        }

        //it will check the answer for qn 5
        //if the answer is correct "numberofQuestionscorrect" will increment by 1 with the help of increment operator
        //if it is not correct "incorrectanserList" will comes to play.there is no mark for incorrectanswer
        if (checkQuestion5()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 5");
        }

        //it will check the answer for qn 6
        //if the answer is correct "numberofQuestionscorrect" will increment by 1 with the help of increment operator
        //if it is not correct "incorrectanserList" will comes to play.there is no mark for incorrectanswer
        if (checkQuestion6()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 6");
        }

        /**
         * Stringbuilder method plays an interesting role
         * it collectsthe incorrect answers for users data
         */
        StringBuilder sb = new StringBuilder();
        for (String s : incorrectAnswersList) {
            sb.append(s);
            sb.append("\n");
        }

        //toast message will be displayed here
        //i.e the score for the quiz be finalised
        //stringbuilder will delivers his role (it suggests the user to recheck the incorrect answers following) by toast msg
        Context context = getApplicationContext();
        CharSequence text = "You got " + numberOfQuestionsCorrect + "/6 answers right.\n\nRecheck the following:\n" + sb.toString();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    /**
     * question 1 will be designated in the form of radio button form
     * if else statements are implemented to check the correct answers
     */
    private boolean checkQuestion1() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_1_radio_group);

        if (rg.getCheckedRadioButtonId() == Q1_ANSWER) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * question 2 will be designated in the form of radio button form
     * if else statements are implemented to check the correct answers
     */
    private boolean checkQuestion2() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_2_radio_group);
        if (rg.getCheckedRadioButtonId() == Q2_ANSWER) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * question 3 will be designated in the form of radio button form
     * if else statements are implemented to check the correct answers
     */
    private boolean checkQuestion3() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_3_radio_group);
        if (rg.getCheckedRadioButtonId() == Q3_ANSWER) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * question 4 will be designated in the form of radio button form
     * if else statements are implemented to check the correct answers
     */
    private boolean checkQuestion4() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_4_radio_group);

        if (rg.getCheckedRadioButtonId() == Q4_ANSWER) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * question 5 will be designated in the form of edit and typing form
     * the user might type the answer
     * "equalsignorecase" is implemented to check the answer (string type) which is prescribed in final method (@ top specified)
     */
    private boolean checkQuestion5() {
        EditText et = (EditText) findViewById(R.id.question_5_Edit_Text);
        return et.getText().toString().equalsIgnoreCase(Q5_ANSWER);
    }

    /**
     * question 6 will be designated in the form of check box form
     * first three check box is the correct choice for this qn
     * it must be checked and not the fourth one
     */
    private boolean checkQuestion6() {
        CheckBox c1 = (CheckBox) findViewById(R.id.question_6_first_checkbox);
        CheckBox c2 = (CheckBox) findViewById(R.id.question_6_second_checkbox);
        CheckBox c3 = (CheckBox) findViewById(R.id.question_6_third_checkbox);
        CheckBox c4 = (CheckBox) findViewById(R.id.question_6_fourth_checkbox);
        if (c1.isChecked() && c2.isChecked() && c3.isChecked() && !c4.isChecked()) {
            return true;
        } else {
            return false;
        }
    }
}


