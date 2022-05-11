package com.example.izooto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class ApiData extends AppCompatActivity {
    String JSON_STRING = "{\"employee\":{\n" +
            "\"appID\":\"aaa\",\n" +
            "\"senderID\":\"12324354545454554545454\",\n" +
            "\"serverkey\":\"Asdhfjkdghfklgjhklfdfjfkldgfjklgfgjfklgfk\",\n" +
            "\"pid\":45001,\n" +
            "\"lastSession\":\"12 dec 2022\",\n" +
            "\"firstTimeSession\":\"1 jan 2022\",\n" +
            "\"totalSessionCount\":12,\n" +
            "\"isAvailable\":true\n" +
            "}}";

    String senderId, serverkey, appID,pid,lastSession,totalSessionCount,firstTimeSession,isAvailable;
    EditText t1, t2,t3,t4,t5,t6,t7,t8;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_data);
            t1= (EditText) findViewById(R.id.serverkey);
            t2 = (EditText) findViewById(R.id.senderID);
            t3=(EditText) (findViewById(R.id.appid));
            t4=(EditText) (findViewById(R.id.pid));
        t5 = (EditText) findViewById(R.id.first);
        t6=(EditText) (findViewById(R.id.total));
        t7=(EditText) (findViewById(R.id.last));
        t8=(EditText) (findViewById(R.id.Avl));
        b1=findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ApiData.this,Apiarrayjesonexample.class);
                startActivity(intent);
            }
        });

        try {
                // get JSONObject from JSON file
                JSONObject obj = new JSONObject(JSON_STRING);
                // fetch JSONObject employee
                JSONObject employee = obj.getJSONObject("employee");
                // get employee  key and id
                serverkey = employee.getString("serverkey");
                senderId = employee.getString("senderID");
                appID=employee.getString("appID");
                pid=employee.getString("pid");
            firstTimeSession=employee.getString("firstTimeSession");
            lastSession=employee.getString("lastSession");
            totalSessionCount=employee.getString("totalSessionCount");
            isAvailable=employee.getString("isAvailable");

                // set employee name and salary in TextView's
                t1.setText("id: "+serverkey);
                t2.setText("sender: "+senderId);
                t3.setText("app: "+appID);
                t4.setText("pid: "+pid);
            t5.setText("first: "+firstTimeSession);
            t6.setText("last: "+lastSession);
            t7.setText("total:"+totalSessionCount);
            t8.setText("Avl: "+isAvailable);


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
}