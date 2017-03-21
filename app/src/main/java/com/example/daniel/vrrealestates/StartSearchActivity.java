package com.example.daniel.vrrealestates;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class StartSearchActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText searchInput;
    private String input;
    private TextView textView;
    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_search);

        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        searchInput = (EditText) findViewById(R.id.search_input);
        final Button searchButton = (Button) findViewById(R.id.search_button);
        textView =(TextView) findViewById(R.id.output);
        linearLayout = (LinearLayout) findViewById(R.id.layout);
        searchButton.setOnClickListener(this);

    }
    private String sendPost (String url) {
        RequestQueue queue = Volley.newRequestQueue(this);  // this = context
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response);
                        textView.setText(response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", error.toString());
                        textView.setText(error.toString() );
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");

                return params;
            }
        };

        queue.add(postRequest);
        return textView.getText().toString();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.search_button:
                input = searchInput.getText().toString();
                try {
                    JSONArray array = new JSONArray(sendPost("http://sosnovsky.hopto.org/jumba/listing/unAuth"));
                    Toast.makeText(getApplicationContext(), "SUCCESS!", Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject obj = array.getJSONObject(i);
                        linearLayout.removeAllViews();
                        TextView textView = new TextView(this);
                        textView.setText(obj.get("name").toString() + " " + obj.get("location").toString());
                        linearLayout.addView(textView);
                    }
                }catch (JSONException j) {
                    j.printStackTrace();
                    Toast.makeText(getApplicationContext(), "JSON Error", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
