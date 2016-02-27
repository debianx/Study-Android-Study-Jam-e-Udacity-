package com.example.android.studygson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by debianx on 24/02/16.
 */
public class ListAdapter extends BaseAdapter {

    ArrayList<Android> mylist = new ArrayList<Android>();
    LayoutInflater inflater;
    Context context;

    public ListAdapter(Context context, ArrayList<Android> mylist){
        this.mylist = mylist;
        this.context = context;
        inflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return mylist.size();
    }

    @Override
    public Object getItem(int position) {
        return mylist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Myview myView;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.layout_list_item,parent, false);
            myView = new Myview(convertView);
            convertView.setTag(myView);
        }else{
            myView = (Myview) convertView.getTag();
        }
        Android currentListAndroid = (Android) getItem(position);

        myView.api.setText(currentListAndroid.getVer());
        myView.api.setText(currentListAndroid.getName());
        myView.api.setText(currentListAndroid.getApi());

        return convertView;
    }
    private class Myview {
        TextView ver, name, api;
//        ImageView ivIcon;

        public Myview(View item) {
            ver = (TextView) item.findViewById(R.id.ver_item);
            name = (TextView) item.findViewById(R.id.name_item);
            api = (TextView) item.findViewById(R.id.api_item);
        }
    }
}
