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
                "Inteligență socială",
                "Factorul de succes",
                "Atitudinea",
                "Tăria de caracter",
                "Mulțumit sau fără astâmpăr",
                "Extravertit sau introvertit",
                "Cât de categoric sunteți",
                "Lateralitatea",
                "Optimist sau pesimist",
                "Agresivitatea",
                "Aventuros sau timid",
                "Cât de răbdător sunteți",
                "Planificat sau spontan",
                "Încredere în sine",
                "Emotivitate",
                "Vă descurcați în condiții de presiune",
                "Diplomat sau lipsit de tact",
                "Factorul leadership",
                "Dur sau tandru",
                "Deschis sau închis",
                "Darul cumpatării",
                "Suferiți de obsesii"
        };

        final ArrayAdapter<String> listAdapter;
        ListView listTests = (ListView) findViewById(R.id.listTests);
        ArrayList<String> tests = new ArrayList<>();
        tests.addAll(Arrays.asList(categoryTest));
        listAdapter = new ArrayAdapter<>(this, R.layout.simple_entry_test, tests);

        listTests.setAdapter(listAdapter);

        listTests.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String test = listAdapter.getItem(position);

               switch (position) {
                   case 0: {
                       Intent intent = new Intent(TestsActivity.this, TestActivity.class).putExtra(Intent.EXTRA_TEXT, test);
                       intent.putExtra("Categorie", position);
                       startActivity(intent);
                       finish();
                   } break;

                   default: {
                       Intent intent = new Intent(TestsActivity.this, NotImplementTestActivity.class).putExtra(Intent.EXTRA_TEXT, test);
                       startActivity(intent);
                       finish();
                   }
               }
          }
       });
    }


}
