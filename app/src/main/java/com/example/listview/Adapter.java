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

/**
 * Custom Adapter for customized design of ListView-Items
 *
 * @author Nicole Gottschall
 * @since 2022-05-28
 */

public class Adapter extends ArrayAdapter<String> {

     /**
     * Attributes
     */
     private Context mContext;
     private List<String> stringList = new ArrayList<>();

    /**
     * Constructor of Adapter
     *
     * @param context
     * @param list
     */
    public Adapter(@NonNull Context context, @LayoutRes ArrayList<String> list) {
            super(context, 0 , list);
            mContext = context;
            stringList = list;
    }

    /**
     * getView() is called when a ListItem needs to be created and populated with data.
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);

        //get Elements of ListItem
        TextView text = (TextView) listItem.findViewById(R.id.text);
        ImageButton delBtn = (ImageButton) listItem.findViewById(R.id.delBtn);

        //get clicked Item
        String current = stringList.get(position);
        //get Element from ArrayList
        ArrayList<String> list = MainActivity.getList();
        //show clicked Item in ListView
        text.setText(list.get(position));

        //OnButtonClickEvent to delete
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //remove element
                int index = list.indexOf(current);
                list.remove(index);
                //update ListView
                MainActivity.getListView().invalidateViews();
            }

        });
        return listItem;
    }


}
