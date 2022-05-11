package com.example.izooto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Apiarrayjesonexample extends AppCompatActivity {
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
    String data = "";
    Button b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apiarrayjesonexample);
        TextView output = (TextView) findViewById(R.id.textView1);
     b4=findViewById(R.id.button2);
     b4.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent=new Intent(Apiarrayjesonexample.this,MainActivity3.class);
             startActivity(intent);
         }
     });


        try {
            // Create the root JSONObject from the JSON string.

            //Get the instance of JSONArray that contains JSONObjects
            JSONArray jsonArray = new JSONArray(STR);

            //Iterate the jsonArray and print the info of JSONObjects
            for(int i=0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);


                String appID = jsonObject.optString("appID").toString();
                String senderID = jsonObject.optString("senderID").toString();
                String pid = jsonObject.optString("pid").toString();

                data += "Node"+i+" : \n senderID= "+ senderID +" \n Name= "+ appID +" \n pid="+pid+"\n";
            }
            output.setText(data);
        } catch (JSONException e) {e.printStackTrace();}
    }
}

