package com.example.izooto;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.izooto.NotificationHelperListener;
import com.izooto.NotificationWebViewListener;
import com.izooto.Payload;
import com.izooto.TokenReceivedListener;
import com.izooto.iZooto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements NotificationHelperListener,TokenReceivedListener,NotificationWebViewListener {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ApiData.class);
                startActivity(intent);
            }
        });




        iZooto.initialize(this)
                .setLandingURLListener(this)
                .setTokenReceivedListener((TokenReceivedListener) this)
                .setNotificationReceiveListener(this)

                .build();


        HashMap<String, Object> data = new HashMap<>();

        data.put("id", "key");
//Key - Value can be customized to suit your needs

        iZooto.addUserProperty(data);

    }

    @Override
    public void onTokenReceived(String token) {
        Log.i("Device Token: ", token + "task");
    }

    @Override
    public void onWebView(String landingUrl) {
        Log.i("web", "landingurl = " +landingUrl);
        if (landingUrl != null) {
            Intent intent = new Intent(getApplicationContext(), Webview.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("openURL", landingUrl);
            startActivity(intent);

        }

    }

    @Override
    public void onNotificationReceived(@NonNull Payload payload) {
        Log.i("iZootoExample", "payload = " + payload.getTitle());
    }

    @Override
    public void onNotificationOpened(String data) {
        Log.i("iZootoopend", "data = " + data);
        String actionType;
        try {
            JSONObject jsonObj = new JSONObject(data);
            actionType = jsonObj.getString("actionType");

            if (actionType.equalsIgnoreCase("0")) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            } else if (actionType.equalsIgnoreCase("1")) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            } else if (actionType.equalsIgnoreCase("2")) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}


