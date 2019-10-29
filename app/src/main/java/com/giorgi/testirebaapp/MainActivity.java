package com.giorgi.testirebaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView mQuestionTextView;
    Button mAnswer1;
    Button mAnswer2;
    int mScore = 0;
    int mIndex = 0;
    int mQuestion;
    boolean stop = false;

    EditText mMobile;
    Button acceptNumber;

    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_1, R.string.answer_1_1, R.string.answer_1_2, 2),
            new Question(R.string.question_2, R.string.answer_2_1, R.string.answer_2_2, 1),
            new Question(R.string.question_3, R.string.answer_3_1, R.string.answer_3_2, 1),
            new Question(R.string.question_4, R.string.answer_4_1, R.string.answer_4_2, 1),
            new Question(R.string.question_5, R.string.answer_5_1, R.string.answer_5_2, 2),
            new Question(R.string.question_6, R.string.answer_6_1, R.string.answer_6_2, 2),
            new Question(R.string.question_7, R.string.answer_7_1, R.string.answer_7_2, 1)

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestionTextView = findViewById(R.id.question_text_view);
        mAnswer1 = findViewById(R.id.answer1);
        mAnswer2 = findViewById(R.id.answer2);

        mQuestion = mQuestionBank[mIndex].getQuestionID();
        mQuestionTextView.setText(mQuestion);
        mAnswer1.setText(mQuestionBank[mIndex].getAnswerFirst());
        mAnswer2.setText(mQuestionBank[mIndex].getAnswerSecond());

        mMobile = findViewById(R.id.editText);
        acceptNumber = findViewById(R.id.accept);

        mAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!stop) {
                    if (mQuestionBank[mIndex].isAnswer(1)){
                        Toast.makeText(getApplicationContext(), R.string.correct_toast, Toast.LENGTH_SHORT).show();
                        mScore+=1;
                    } else {
                        Toast.makeText(getApplicationContext(), R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
                    }

                    updateQuestion();
                }
            }
        });

        mAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!stop) {
                    if (mQuestionBank[mIndex].isAnswer(2)) {
                        Toast.makeText(getApplicationContext(), R.string.correct_toast, Toast.LENGTH_SHORT).show();
                        mScore += 1;
                    } else {
                        Toast.makeText(getApplicationContext(), R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
                    }

                    updateQuestion();
                }
            }
        });

        acceptNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewActivity.class);
                startActivity(intent);
            }
        });
    }

    private void updateQuestion() {
        if (mIndex == 6) {
            mMobile.setVisibility(View.VISIBLE);
            acceptNumber.setVisibility(View.VISIBLE);
            stop = true;
            if (mScore >= 5) {
                Toast.makeText(getApplicationContext(), "You've passed the exam! \n " + mScore + "/" + 7, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "You've failed the exam! \n " + mScore + "/" + 7, Toast.LENGTH_SHORT).show();
            }
        } else {
            mIndex+=1;
            mQuestion = mQuestionBank[mIndex].getQuestionID();
            mQuestionTextView.setText(mQuestion);
            mAnswer1.setText(mQuestionBank[mIndex].getAnswerFirst());
            mAnswer2.setText(mQuestionBank[mIndex].getAnswerSecond());
        }
    }
}
