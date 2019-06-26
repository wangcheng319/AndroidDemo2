package com.example.wangc.androiddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        WebView webView = findViewById(R.id.wv);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl("file:///android_asset/test.html");
    }
}
