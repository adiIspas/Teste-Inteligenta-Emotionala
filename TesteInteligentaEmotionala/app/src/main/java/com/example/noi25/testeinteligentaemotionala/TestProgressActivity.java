package com.example.noi25.testeinteligentaemotionala;

import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class TestProgressActivity extends Activity {
    List<Question> questionsList;
    int score = 0;
    int qid = 0;
    Question currentQuestion;
    TextView textQuestion;
    RadioButton buttonYes, buttonNo;
    Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_progress_model_1);

        DbHelper db = new DbHelper(this);
        questionsList = db.getAllQuestions();
        currentQuestion = questionsList.get(qid);

        textQuestion = (TextView)findViewById(R.id.textQuestion);
        buttonYes = (RadioButton)findViewById(R.id.buttonYes);
        buttonNo = (RadioButton)findViewById(R.id.buttonNo);
        buttonNext = (Button)findViewById(R.id.buttonNextQuestion);

        setQuestionView();

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChecked = false;

                if (buttonYes.isChecked()) {
                    isChecked = true;
                }

                if (isChecked) {
                    Log.d("raspuns", "r: " + Integer.parseInt(currentQuestion.getANSWER1()));
                    score += Integer.parseInt(currentQuestion.getANSWER1());

                    buttonYes.setChecked(false);
                    buttonYes.setSelected(false);
                    buttonYes.setClickable(true);
                }
                else {
                    Log.d("raspuns", "r: " + Integer.parseInt(currentQuestion.getANSWER2()));
                    score += Integer.parseInt(currentQuestion.getANSWER2());

                    buttonNo.setChecked(false);
                    buttonNo.setSelected(false);
                    buttonNo.setClickable(true);
                }

                if (qid < 3){
                    currentQuestion=questionsList.get(qid);
                    setQuestionView();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(),FinishTestActivity.class);
                    intent.putExtra("Scor",score);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void setQuestionView()
    {
        textQuestion.setText(currentQuestion.getQUESTION());
        buttonYes.setText(currentQuestion.getOPTA());
        buttonNo.setText(currentQuestion.getOPTB());
        qid++;
    }
}