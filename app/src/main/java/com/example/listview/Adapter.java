package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends ArrayAdapter<String> {

        private Context mContext;
        private List<String> stringList = new ArrayList<>();

        public Adapter(@NonNull Context context, @LayoutRes ArrayList<String> list) {
            super(context, 0 , list);
            mContext = context;
            stringList = list;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View listItem = convertView;
            if(listItem == null)
                listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);

            String current = stringList.get(position);


            TextView text = (TextView) listItem.findViewById(R.id.text);
            //get Element from ArrayList
            ArrayList<String> list = MainActivity.getList();
            text.setText(list.get(position));

            ImageButton btn = (ImageButton) listItem.findViewById(R.id.btn);


            return listItem;
        }
}
