package com.example.listview_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerTest;
    private String[] testData;
    private Spinner spinnerDrink;
    private ArrayAdapter<CharSequence> spinnerAdapter;
    private String[] foodData;
    private ListView listViewFood;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testData = getResources().getStringArray(R.array.test);

        spinnerTest = (Spinner) findViewById(R.id.spinner_test);
     //  spinnerTest,setProp
        spinnerTest.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String data = testData[position];
                Toast.makeText(MainActivity.this, "Select:"+data, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        
        spinnerDrink = (Spinner) findViewById(R.id.spinner_drink);
//        spinnerAdapter = ArrayAdapter.createFromResource(MainActivity.this,R.array.drink,
//                android.R.layout.simple_spinner_item);

      //  spinnerAdapter = ArrayAdapter.createFromResource(MainActivity.this,R.array.drink, R.layout.simple_spinner_item);
        spinnerAdapter = ArrayAdapter.createFromResource(MainActivity.this,R.array.drink, R.layout.simple_spinner_dropdown_item);

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDrink.setAdapter(spinnerAdapter);   // 很重要!!!!
        spinnerDrink.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String data = parent.getItemAtPosition(position).toString() + 1;
                Toast.makeText(MainActivity.this, "Select :"+data, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //// ListView
        foodData = getResources().getStringArray(R.array.food);
        listViewFood = findViewById(R.id.listView_food);
//        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1,foodData);

        adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.simple_expandable_list_item_1,foodData);
        listViewFood.setAdapter(adapter);    // 很重要!!!!
        listViewFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this,"Select:" + data,Toast.LENGTH_SHORT).show();
            }
        });
    }
}