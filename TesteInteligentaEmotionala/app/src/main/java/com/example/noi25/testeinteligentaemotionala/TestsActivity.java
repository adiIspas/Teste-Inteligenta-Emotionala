package com.example.noi25.testeinteligentaemotionala;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;

public class TestsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);

        String[] categoryTest = {
                "Tarie de caracter",
                "Factorul de succes",
                "Atitudinea",
                "Inteligenta sociala",
                "Optimist sau pesimist",
                "Tarie de caracter",
                "Factorul de succes",
                "Atitudinea",
                "Inteligenta sociala",
                "Optimist sau pesimist",
                "Tarie de caracter",
                "Factorul de succes",
                "Atitudinea",
                "Inteligenta sociala",
                "Optimist sau pesimist",
                "Tarie de caracter",
                "Factorul de succes",
                "Atitudinea",
                "Inteligenta sociala",
                "Optimist sau pesimist"
        };

        ListView listTests = (ListView) findViewById(R.id.listTests);

        final ArrayAdapter<String> listAdapter;

        ArrayList<String> tests = new ArrayList<>();
        tests.addAll(Arrays.asList(categoryTest));

        listAdapter = new ArrayAdapter<>(this, R.layout.simple_entry_test, tests);

        listTests.setAdapter(listAdapter);

        listTests.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String test = listAdapter.getItem(position);
               if(position == 0){
                    Intent intent = new Intent(TestsActivity.this, TestActivity.class).putExtra(Intent.EXTRA_TEXT, test);
                    intent.putExtra("Tarie de caracter",0);
                    startActivity(intent);
                    finish();
               }
               if(position == 1){
                   Intent intent = new Intent(TestsActivity.this, TestActivity.class).putExtra(Intent.EXTRA_TEXT, test);
                   intent.putExtra("Factorul de succes",1);
                   startActivity(intent);
                   finish();
               }
          }
       });
    }


}
