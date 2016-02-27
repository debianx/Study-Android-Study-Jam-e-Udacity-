package com.example.android.studygson;

//http://icetea09.com/blog/2014/11/02/android-parse-json-request-using-volley-gson/

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.ArrayList;

//

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Context context = MainActivity.this;
    ArrayList<Android> androidArrayList = new ArrayList<Android>();
    ListAdapter listAdapte;

    String url = "http://api.learn2crack.com/android/jsonos/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = (ListView) findViewById(R.id.list_item);

        listView.setAdapter(new ListAdapter(this, androidArrayList));

        exibir();
    }

    public void exibir() {

        final GsonRequest gsonRequest = new GsonRequest(url, Androids.class, null, new Response.Listener<Androids>() {

            @Override
            public void onResponse(Androids versions) {
//                final ArrayList<Android> android = new ArrayList<Android>();
                for (int i = 0; i < versions.getAndroid().size(); i++) {

                    Android androidItem = versions.getAndroid().get(i);
                    //androidItem.setApi("API:" + (i));
                    androidArrayList.add(androidItem);

                }

                listView.setAdapter(listAdapte);
                listView.deferNotifyDataSetChanged();
//                listAdapte.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (volleyError != null) Log.e("MainActivity", volleyError.getMessage());
            }
        });
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(gsonRequest);
    }

}