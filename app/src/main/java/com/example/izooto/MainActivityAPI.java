package com.example.izooto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivityAPI extends AppCompatActivity {
    ListView List;
    String url = "https://nh.iz.do/nh/a588d2fb1061d6931af41496660ef3b70fbcf708/0.json";
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_api);
        List = (ListView)findViewById(R.id.List);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading....");
        dialog.show();

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                parseJsonData(string);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getApplicationContext(), "Some error occurred!!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(MainActivityAPI.this);
        rQueue.add(request);
    }

    void parseJsonData(String jsonString) {
        try {


            List<String> items = new ArrayList<>();
            JSONArray jsonArray = new JSONArray(jsonString);



            for(int i = 0; i <jsonArray.length(); ++i) {
                JSONObject root= jsonArray.getJSONObject(i);
                JSONObject object = root.getJSONObject("p");
                items.add(object.getString("id"));
                items.add(object.getString("r"));
                items.add(object.getString("ln"));
                items.add(object.getString("i"));
                items.add(object.getString("k"));
            }

            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, items);
            List.setAdapter(adapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        dialog.dismiss();
    }
}