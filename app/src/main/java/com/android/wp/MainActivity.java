package com.android.wp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private WebView oWbview;
    private Button btnCode, btnSignIn;
    private EditText oEdiText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oWbview = (WebView) findViewById(R.id.wbvApp);
        oEdiText = (EditText) findViewById(R.id.idCodeaccess);
        btnCode = (Button) findViewById(R.id.btnRead);
        btnSignIn = (Button) findViewById(R.id.btnLogin);

        oWbview = (WebView) findViewById(R.id.wbvApp);

        btnCode.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.btnLogin:
                String sTexto = oEdiText.getText().toString();
                oWbview.clearCache(true);
                
                oWbview.getSettings().setJavaScriptEnabled(true);
                oWbview.getSettings().setLoadsImagesAutomatically(true);
                oWbview.loadUrl("http://10.182.136.109:8080");
                break;
            case R.id.btnRead:

                break;
        }
    }
}
