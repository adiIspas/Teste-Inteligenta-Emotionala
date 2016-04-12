package com.example.noi25.testeinteligentaemotionala;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinishTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_test);

        int scor = getIntent().getIntExtra("Scor",-1);

        TextView completDescription = (TextView) findViewById(R.id.completScoreDescription);
        TextView score = (TextView) findViewById(R.id.score);
        score.setText("Punctaj " + scor);
        completDescription.setText("A fost ca niciodata o descriere si tot asa a fost si a fost si nu a mai fost doar sa fie scris.");

        Button alteTeste = (Button) findViewById(R.id.buttonTestAgain);

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
