package com.example.sampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import static android.view.ViewGroup.LayoutParams.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout ll = (LinearLayout) findViewById(R.id.myRoot);

        final EditText edit = (EditText) findViewById(R.id.editText);
        Button search = (Button) findViewById(R.id.search);
        final WebView webView = (WebView) findViewById(R.id.webView);
        Button dynBtn = new Button(this);

        dynBtn.setLayoutParams(new ViewGroup.LayoutParams(MATCH_PARENT, WRAP_CONTENT));
        dynBtn.setText(R.string.dyn_btn_txt);

        //        add view at the end of all items on view, by default
        ll.addView(dynBtn);

//        add view(button) to the direct place
//        linearLayout.addView(dynBtn, 2);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.setWebViewClient(new WebViewClient());
                webView.loadUrl(getString(R.string.search_engine_base_url) + edit.getText().toString());
            }
        });
    }
}
