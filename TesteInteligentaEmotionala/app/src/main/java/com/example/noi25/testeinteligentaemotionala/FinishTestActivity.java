package com.example.noi25.testeinteligentaemotionala;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinishTestActivity extends AppCompatActivity {

    int scor;
    int position;
    TextView completDescription;
    TextView score;
    TextView scoreDescription;
    Button alteTeste;

    String[] testInterpretationContent = {
            "Inteligenta sociala reprezinta capacitatea de a stabili un raport, de a intelege si de " +
                    "a interactiona eficient cu alti oameni in mod zilnic. \n\nEa ne ingaduie sa lucram " +
                    "in mod eficace cu colegii de munca si cu persoanele din comunitatea noastra si " +
                    "constituie o abilitate esentiala pentru orice domeniu de activitate."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_test);

        scor = getIntent().getIntExtra("Scor",-1);
        position = getIntent().getIntExtra("Categorie",-1);

        alteTeste = (Button) findViewById(R.id.buttonTestAgain);

        completDescription = (TextView) findViewById(R.id.completScoreDescription);
        score = (TextView) findViewById(R.id.score);
        scoreDescription = (TextView) findViewById(R.id.shortScoreDescription);

        score.setText("Punctaj " + scor);
        completDescription.setText(testInterpretationContent[position]);

        switch (position){
            case 0: {
                if(scor <= 20){
                    scoreDescription.setText("Inteligenta sociala mica");
                }
                if(scor >= 21 && scor <= 24){
                    scoreDescription.setText("Inteligenta sociala sub medie");
                }
                if(scor >= 25 && scor <= 28){
                    scoreDescription.setText("Inteligenta sociala medie");
                }
                if(scor >= 29 && scor <= 32){
                    scoreDescription.setText("Inteligenta sociala peste medie");
                }
                if(scor >= 33 && scor <= 36){
                    scoreDescription.setText("Inteligenta sociala mult peste medie");
                }
                if(scor >= 37 && scor <= 44){
                    scoreDescription.setText("Inteligenta sociala mare");
                }
                if(scor >= 45 && scor <= 54){
                    scoreDescription.setText("Inteligenta sociala foarte mare");
                }
                if(scor >= 55){
                    scoreDescription.setText("Inteligenta sociala exceptional de mare");
                }
            } break;

            default: break;
        }

        alteTeste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),TestsActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
