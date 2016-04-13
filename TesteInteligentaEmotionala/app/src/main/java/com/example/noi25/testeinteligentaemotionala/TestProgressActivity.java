package com.example.noi25.testeinteligentaemotionala;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

public class TestProgressActivity extends AppCompatActivity {

    int numarIntrebari = 2;
    int intrebareCurenta = 0;

    TextView enuntIntrebare;
    Button nextQuestion;
    RadioButton buttonYes;
    RadioButton buttonNo;
    int suma;

    List<Question> quesList;
    String ans = "25";
    int score=0;
    int qid=0;
    Question currentQ;

    String[] intrebari = {
            "Ana are mere?",
            "Esti sigur ca Ana are mere?"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_progress_model_1);

        DbHelper db=new DbHelper(this);
        quesList=db.getAllQuestions();
        currentQ=quesList.get(qid);

        enuntIntrebare = (TextView) findViewById(R.id.textQuestion);
        setQuestionView();
        //enuntIntrebare.setText(intrebari[intrebareCurenta]);

        buttonYes = (RadioButton) findViewById(R.id.buttonYes);
        buttonNo = (RadioButton) findViewById(R.id.buttonNo);

        nextQuestion = (Button) findViewById(R.id.buttonNextQuestion);
        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isChecked = false;
                if (buttonYes.isChecked()) {
                    isChecked = true;
                }

                if (isChecked) {
                    Log.d("raspuns", "r: " + Integer.parseInt(currentQ.getOPTC()));
                    suma += Integer.parseInt(currentQ.getOPTC());
                    buttonYes.setChecked(false);
                } else {
                    Log.d("raspuns", "r: " + Integer.parseInt(currentQ.getANSWER()));
                    suma += Integer.parseInt(currentQ.getANSWER());
                    buttonNo.setChecked(false);
                }

                intrebareCurenta++;
                if (intrebareCurenta < numarIntrebari){
                    currentQ=quesList.get(qid);
                    setQuestionView();
                }
                    //enuntIntrebare.setText(intrebari[intrebareCurenta]);
                else{
                    Intent intent = new Intent(getApplicationContext(),FinishTestActivity.class);
                    intent.putExtra("Scor",suma);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }

    private void setQuestionView()
    {
        enuntIntrebare.setText(currentQ.getQUESTION());
        //buttonYes.setText(currentQ.getOPTA());
        //buttonNo.setText(currentQ.getOPTB());
        qid++;
    }

}
