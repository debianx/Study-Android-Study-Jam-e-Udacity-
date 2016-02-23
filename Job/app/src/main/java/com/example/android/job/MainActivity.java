package com.example.android.job;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.android.model.Version;

public class MainActivity extends AppCompatActivity {


    // Log tag

//    // Movies json url
//
//    private static final String url = "http://api.androidhive.info/json/movies.json";
//    private ProgressDialog pDialog;
//    private List<Movie> movieList = new ArrayList<Movie>();
//    private ListView listView;
//    private CustomListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnJSONRequest;
        Button btnGSONRequest;
        final TextView txtDisplay;

        String url="http://api.learn2crack.com/android/jsonos/";

       // btnJSONRequest = (Button)findViewById(R.id.btnJSONRequest);
        btnGSONRequest = (Button)findViewById(R.id.btnGSONRequest);
        txtDisplay = (TextView)findViewById(R.id.txtDisplay);

      //  final JsonObjectRequest jsObjRequest = new JsonObjectRequest
            //    (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {


        final GsonRequest gsonRequest = new GsonRequest(url, Versions.class, null, new Response.Listener<Versions>() {
            @Override
            public void onResponse(Versions versions) {
                String textResult = "";
                for(int i=0; i<versions.getVersions().size(); i++) {
                    Version versionItem = versions.getVersions().get(i);
                    textResult += "Version: " + versionItem.getVer() + "\n";
                    textResult += "Name: " + versionItem.getName() + "\n";
                    textResult += "API: $" + versionItem.getApi() + "\n\n";
                }
                txtDisplay.setText(textResult);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (volleyError != null) Log.e("MainActivity", volleyError.getMessage());
            }


        });

        btnGSONRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MySingleton.getInstance(getApplicationContext()).addToRequestQueue(gsonRequest);
            }
        });
    }
}

//
//        ImageLoader mImageLoader;
//        ImageView mImageView;
//// The URL for the image that is being loaded.
//        final String IMAGE_URL =
//                "http://developer.android.com/images/training/system-ui.png";
//
//        mImageView = (ImageView) findViewById(R.id.regularImageView);
//
//// Get the ImageLoader through your singleton class.
//        mImageLoader = MySingleton.getInstance(this).getImageLoader();
//        mImageLoader.get(IMAGE_URL, ImageLoader.getImageListener(mImageView,
////                R.drawable.erroandroid, R.drawable.erroandroid));
//        final TextView mTxtDisplay;
//        final ImageView mImageView;
//        mTxtDisplay = (TextView) findViewById(R.id.txtDisplay);
//        String url =" http://jsonip.com/";
//
//        JsonObjectRequest jsObjRequest = new JsonObjectRequest
//                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        mTxtDisplay.setText("Response: " + response.toString());
//                        mImageView.getDrawable();
//                    }
//                }, new Response.ErrorListener() {
//
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//
//                    }
//                });
//
//// Access the RequestQueue through your singleton class.
//        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);
//
