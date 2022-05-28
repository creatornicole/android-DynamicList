package com.example.listview;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class to Launch App
 *
 * @author Nicole Gottschall
 * @since 2022-05-28
 */

public class MainActivity extends AppCompatActivity {

    /**
     * Attributes
     */
    private static ArrayList<String> list;
    private static ListView listView;
    private static Adapter adapter;
    private ImageButton addBtn;
    private ImageButton delBtn;
    private TextView tf;

    /**
     * Initialization Method
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize ListView and ArrayList
        list = new ArrayList<String>(); //content of List
        listView = (ListView) findViewById(R.id.lv); //layout of List
        //Set Adapter
        Adapter adapter = new Adapter(this, list);
        listView.setAdapter(adapter);

        //Get needed views
        addBtn = (ImageButton) findViewById(R.id.addBtn);
        tf = (TextView) findViewById(R.id.tfInput);

        //OnButtonClickEvent to add and delete
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sequence = tf.getText().toString(); //get input
                list.add(sequence); //add input to ArrayList
                Collections.reverse(list); //reverse order of ArrayList
                adapter.notifyDataSetChanged();  //update view
                tf.setText(""); //clear input field
            }
        });
    }

    /**
     * Getter ArrayList<String>
     *
     * @return ArrayList<String> - List
     */
    public static ArrayList<String> getList() {
        return list;
    }

    public static Adapter getAdapter() {
        return adapter;
    }

    public static ListView getListView() {
        return listView;
    }
}