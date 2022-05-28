package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /**
     * Attributes
     */
    private static ArrayList<String> list;
    private ListView listView;
    private Adapter adapter;
    private ImageButton addBtn;
    private TextView tf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.lv);
        list = new ArrayList<>();

        Adapter adapter = new Adapter(this, list);
        listView.setAdapter(adapter);

        /**
         * Get needed views
         */
        addBtn = (ImageButton) findViewById(R.id.addBtn);
        tf = (TextView) findViewById(R.id.tfInput);

        /**
         * OnButtonClicks
         */
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sequence = tf.getText().toString();
                list.add(sequence);
                adapter.notifyDataSetChanged();
                tf.setText("");
            }
        });
    }

    /**
     * Getter
     */
    public static ArrayList<String> getList() {
        return list;
    }
}