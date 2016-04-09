package com.example.noi25.testeinteligentaemotionala;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Button startTest = (Button) findViewById(R.id.buttonStartTest);

        int position;

        position = getIntent().getIntExtra("Tarie de caracter",-1);

        if(position == 0)
            startTest.setText("Start Tarie de caracter");

        startTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestActivity.this,TestProgressActivity.class);
                intent.putExtra("Tarie de caracter",0);
                startActivity(intent);
            }
        });
    }
}
