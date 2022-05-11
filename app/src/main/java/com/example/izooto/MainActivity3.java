package com.example.izooto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
     Button b5;
    String STR="[{\n" +
            "\"appID\":\"aaa\",\n" +
            "\"senderID\":\"12324354545454554545454\",\n" +
            "\"serverkey\":\"Asdhfjkdghfklgjhklfdfjfkldgfjklgfgjfklgfk\",\n" +
            "\"pid\":45001,\n" +
            "\"lastSession\":\"12 dec 2022\",\n" +
            "\"firstTimeSession\":\"1 jan 2022\",\n" +
            "\"totalSessionCount\":12,\n" +
            "\"isAvailable\":true\n" +
            "},\n" +
            "{\n" +
            "\"appID\":\"aaa\",\n" +
            "\"senderID\":\"12324354545454554545454\",\n" +
            "\"serverkey\":\"Asdhfjkdghfklgjhklfdfjfkldgfjklgfgjfklgfk\",\n" +
            "\"pid\":45001,\n" +
            "\"lastSession\":\"12 dec 2022\",\n" +
            "\"firstTimeSession\":\"1 jan 2022\",\n" +
            "\"totalSessionCount\":12,\n" +
            "\"isAvailable\":true\n" +
            "},\n" +
            "{\n" +
            "\"appID\":\"aaa\",\n" +
            "\"senderID\":\"12324354545454554545454\",\n" +
            "\"serverkey\":\"Asdhfjkdghfklgjhklfdfjfkldgfjklgfgjfklgfk\",\n" +
            "\"pid\":45001,\n" +
            "\"lastSession\":\"12 dec 2022\",\n" +
            "\"firstTimeSession\":\"1 jan 2022\",\n" +
            "\"totalSessionCount\":12,\n" +
            "\"isAvailable\":true\n" +
            "},\n" +
            "{\n" +
            "\"appID\":\"aaa\",\n" +
            "\"senderID\":\"12324354545454554545454\",\n" +
            "\"serverkey\":\"Asdhfjkdghfklgjhklfdfjfkldgfjklgfgjfklgfk\",\n" +
            "\"pid\":45001,\n" +
            "\"lastSession\":\"12 dec 2022\",\n" +
            "\"firstTimeSession\":\"1 jan 2022\",\n" +
            "\"totalSessionCount\":12,\n" +
            "\"isAvailable\":true\n" +
            "},\n" +
            "{\n" +
            "\"appID\":\"aaa\",\n" +
            "\"senderID\":\"12324354545454554545454\",\n" +
            "\"serverkey\":\"Asdhfjkdghfklgjhklfdfjfkldgfjklgfgjfklgfk\",\n" +
            "\"pid\":45001,\n" +
            "\"lastSession\":\"12 dec 2022\",\n" +
            "\"firstTimeSession\":\"1 jan 2022\",\n" +
            "\"totalSessionCount\":12,\n" +
            "\"isAvailable\":true\n" +
            "},\n" +
            "{\n" +
            "\"appID\":\"aaa\",\n" +
            "\"senderID\":\"12324354545454554545454\",\n" +
            "\"serverkey\":\"Asdhfjkdghfklgjhklfdfjfkldgfjklgfgjfklgfk\",\n" +
            "\"pid\":45001,\n" +
            "\"lastSession\":\"12 dec 2022\",\n" +
            "\"firstTimeSession\":\"1 jan 2022\",\n" +
            "\"totalSessionCount\":12,\n" +
            "\"isAvailable\":true\n" +
            "}\n" +
            "]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        b5=findViewById(R.id.button4);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity3.this,MainActivityAPI.class);
                startActivity(intent);
            }
        });
        try {

            ListView listView = (ListView) findViewById(R.id.list_view);

            List<String> items = new ArrayList<>();
            JSONArray root = new JSONArray(STR);


            for(int i=0;i<root.length();i++)
            {
                JSONObject object= root.getJSONObject(i);
                items.add(object.getString("appID"));
                items.add(object.getString("senderID"));
                items.add(object.getString("serverkey"));
                items.add(object.getString("lastSession"));
                items.add(object.getString("totalSessionCount"));
                items.add(object.getString("isAvailable"));
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, items);

            if (listView != null) {
                listView.setAdapter(adapter);
            }




        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
