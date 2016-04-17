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
import android.widget.Toast;

public class TestProgressActivity extends Activity {
    List<Question> questionsList;
    int score = 0;
    int qid = 0;
    int position;
    int[] numberQuestions = {32};
    static int currentQuestionNumber = 1;
    String remainingQuestionsText;
    int remainingQuestionsValue;
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

        position = getIntent().getIntExtra("Categorie",-1);

        setQuestionView();

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChecked = false;

                if (buttonYes.isChecked()) {
                    isChecked = true;
                    Log.d("raspuns", "r: " + Integer.parseInt(currentQuestion.getANSWER1()));
                    score += Integer.parseInt(currentQuestion.getANSWER1());

                    buttonYes.setChecked(false);
                    buttonYes.setSelected(false);
                    buttonYes.setClickable(true);
                }
                else
                    if(buttonNo.isChecked()) {
                        isChecked = true;
                        Log.d("raspuns", "r: " + Integer.parseInt(currentQuestion.getANSWER2()));
                        score += Integer.parseInt(currentQuestion.getANSWER2());

                        buttonNo.setChecked(false);
                        buttonNo.setSelected(false);
                        buttonNo.setClickable(true);
                }

                if(isChecked != false){
                    if (qid < numberQuestions[position]){
                        currentQuestion=questionsList.get(qid);
                        setQuestionView();
                    }
                    else {
                        Intent intent = new Intent(getApplicationContext(),FinishTestActivity.class);
                        intent.putExtra("Categorie",position);
                        intent.putExtra("Scor",score);
                        currentQuestionNumber = 1;
                        startActivity(intent);
                        finish();
                    }
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),"Te rugăm să răspunzi la întrebarea curentă pentru a trece la urmatoarea.",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }

    private void setQuestionView(){
        remainingQuestionsValue = numberQuestions[position] - currentQuestionNumber;
        remainingQuestionsText = "Au mai ramas " + remainingQuestionsValue + " intrebări\n\n";
        textQuestion.setText(remainingQuestionsText + currentQuestionNumber + ". " + currentQuestion.getQUESTION());
        currentQuestionNumber++;
        buttonYes.setText(currentQuestion.getOPTA());
        buttonNo.setText(currentQuestion.getOPTB());
        qid++;
    }
}
