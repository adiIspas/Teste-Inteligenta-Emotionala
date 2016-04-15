package com.example.noi25.testeinteligentaemotionala;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class NotImplementTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_implement_test);

        Button testAgain = (Button) findViewById(R.id.buttonTestAgain2);

        testAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),TestsActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
