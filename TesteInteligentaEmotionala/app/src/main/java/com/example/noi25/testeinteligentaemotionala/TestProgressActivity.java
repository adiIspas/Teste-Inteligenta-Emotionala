package com.example.noi25.testeinteligentaemotionala;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TestProgressActivity extends Activity {

    int numarIntrebari = 2;
    int intrebareCurenta = 0;

    TextView enuntIntrebare;
    Button nextQuestion;
    RadioButton buttonYes;
    RadioButton buttonNo;
    int suma;

    String[] intrebari = {
            "Ana are mere?",
            "Esti sigur ca Ana are mere?"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_progress_model_1);

        enuntIntrebare = (TextView) findViewById(R.id.textQuestion);
        enuntIntrebare.setText(intrebari[intrebareCurenta]);

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
                    suma += 2;
                    buttonYes.setChecked(false);
                } else {
                    suma += 1;
                    buttonNo.setChecked(false);
                }

                intrebareCurenta++;
                if (intrebareCurenta < numarIntrebari)
                    enuntIntrebare.setText(intrebari[intrebareCurenta]);
                else{
                    Intent intent = new Intent(getApplicationContext(),FinishTestActivity.class);
                    intent.putExtra("Scor",suma);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }

}
