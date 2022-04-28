package com.example.izooto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

public class Webview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        WebView mywebview = (WebView) findViewById(R.id.webView1);

 Intent i=getIntent();
 String s1=i.getStringExtra("openURL");
mywebview.loadUrl(s1);
        Log.i("log","Openurl");
    }
}