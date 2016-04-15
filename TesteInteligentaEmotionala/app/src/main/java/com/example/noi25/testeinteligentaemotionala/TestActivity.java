package com.example.noi25.testeinteligentaemotionala;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {

    int position;
    Button startTest;
    TextView testName;
    TextView testDescription;

    String[] categoryTest = {
            "Inteligenta sociala",
            "Factorul de succes",
            "Atitudinea",
            "Taria de caracter",
            "Multumit sau fara astampar",
            "Extravertit sau introvertit",
            "Cat de categoric sunteti",
            "Lateralitatea",
            "Optimist sau pesimist",
            "Agresivitatea",
            "Aventuros sau timid",
            "Cat de rabdator sunteti",
            "Planificat sau spontan",
            "Incredere in sine",
            "Emotivitate",
            "Va descurcatii in conditii de presiune",
            "Diplomat sau lipsit de tact",
            "Factorul leadership",
            "Dur sau tandru",
            "Deschis sau inchis",
            "Darul cumpatarii",
            "Suferiti de obsesii"
    };

    String[] testDescriptionContent = {
            "In testul care urmeaza trebuie sa raspundeti prin DA sau NU " +
            "la fiecare afirmatie, in functie de afirmatia care va reprezinta cel mai bine. " +
            "\n\nAlegeti DA in cazul in care afirmatia respectiva va reprezinta sau NU in caz contrar."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        testName = (TextView) findViewById(R.id.testName);
        testDescription = (TextView) findViewById(R.id.testDescription);

        startTest = (Button) findViewById(R.id.buttonStartTest);
        position = getIntent().getIntExtra("Categorie",-1);

        switch (position){
            case 0: {
                testName.setText(categoryTest[position]);
                testDescription.setText(testDescriptionContent[position]);

                startTest.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TestActivity.this,TestProgressActivity.class);
                        intent.putExtra("Categorie", position);
                        startActivity(intent);
                        finish();
                    }
                });
            } break;

            default: break;
        }
    }
}
