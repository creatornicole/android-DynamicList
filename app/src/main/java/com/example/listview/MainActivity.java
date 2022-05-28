package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Configuration of ListView
         */
        //create ListView
        final ListView list = findViewById(R.id.list);
        //create ArrayList
        ArrayList<String> arrayList = new ArrayList<>();
        //add Elements to ArrayList
        arrayList.add("Java");
        arrayList.add("Python");
        arrayList.add("HTML");
        arrayList.add("CSS");
        arrayList.add("JavaScript");
        //create ArrayAdapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,
                arrayList);
        //set Adapter to ListView
        list.setAdapter(arrayAdapter);
        //set onclick Event
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem = (String) list.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, clickedItem, Toast.LENGTH_SHORT).show();
            }
        });


    }
}