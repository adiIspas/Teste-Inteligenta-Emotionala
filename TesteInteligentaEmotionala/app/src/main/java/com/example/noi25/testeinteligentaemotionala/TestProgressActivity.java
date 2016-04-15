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
    List<Question> quesList;
    int score=0;
    int qid=0;
    Question currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb;
    Button butNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_progress_model_1);
        DbHelper db=new DbHelper(this);
        quesList=db.getAllQuestions();
        currentQ=quesList.get(qid);
        txtQuestion=(TextView)findViewById(R.id.textQuestion);
        rda=(RadioButton)findViewById(R.id.buttonYes);
        rdb=(RadioButton)findViewById(R.id.buttonNo);
        butNext=(Button)findViewById(R.id.buttonNextQuestion);
        setQuestionView();
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChecked = false;
                if (rda.isChecked()) {
                    isChecked = true;
                }

                if (isChecked) {
                    Log.d("raspuns", "r: " + Integer.parseInt(currentQ.getOPTC()));
                    score += Integer.parseInt(currentQ.getOPTC());
                    rda.setChecked(false);
                } else {
                    Log.d("raspuns", "r: " + Integer.parseInt(currentQ.getANSWER()));
                    score += Integer.parseInt(currentQ.getANSWER());
                    rdb.setChecked(false);
                }

                if (qid < 3){
                    currentQ=quesList.get(qid);
                    setQuestionView();
                }
                //enuntIntrebare.setText(intrebari[intrebareCurenta]);
                else{
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
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        qid++;
    }
}