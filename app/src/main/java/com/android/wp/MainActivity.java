package com.android.wp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcEvent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.nfc.NdefRecord.createMime;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NfcAdapter.CreateNdefMessageCallback {

    private WebView oWbview;
    private Button btnCode, btnSignIn;
    private EditText oEdiText;

    static String sTexto;
    NfcAdapter nfcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oWbview = (WebView) findViewById(R.id.wbvApp);
        oEdiText = (EditText) findViewById(R.id.idCodeaccess);
        btnCode = (Button) findViewById(R.id.btnRead);


        oWbview = (WebView) findViewById(R.id.wbvApp);

        btnCode.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.btnRead:
                oWbview.clearCache(true);

                oWbview.getSettings().setJavaScriptEnabled(true);
                oWbview.getSettings().setLoadsImagesAutomatically(true);

                nfcAdapter = NfcAdapter.getDefaultAdapter(this);
                if (nfcAdapter == null) {
                    Toast.makeText(this, "NFC is not available", Toast.LENGTH_LONG).show();
                    finish();
                    return;
                }
                // Register callback
                nfcAdapter.setNdefPushMessageCallback(this, this);
                break;
        }
    }

    void processIntent(Intent intent) {
        Parcelable[] rawMsgs = intent.getParcelableArrayExtra(
                NfcAdapter.EXTRA_NDEF_MESSAGES);
        // only one message sent during the beam
        NdefMessage msg = (NdefMessage) rawMsgs[0];
        // record 0 contains the MIME type, record 1 is the AAR, if present
        //textView.setText(new String(msg.getRecords()[0].getPayload()));
        String texto = new String(msg.getRecords()[0].getPayload());
        String[]aTexto = texto.split(":");

        sTexto = "http://10.182.136.109:8080/login?user=" + aTexto[0] +
                "&&pass= " + aTexto[1] + "";
        //oWbview.loadUrl("http://10.182.136.109:8080/login?user=" + aTexto[0] +
                //"&&pass= " + aTexto[1] + "");
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Check to see that the Activity started due to an Android Beam
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(getIntent().getAction())) {
            //processIntent(getIntent());
            oWbview.loadUrl(sTexto);
        }
    }

    @Override
    public NdefMessage createNdefMessage(NfcEvent nfcEvent) {
        String text = ("Beam me up, Android!\n\n" +
                "Beam Time: " + System.currentTimeMillis());
        NdefMessage msg = new NdefMessage(
                new NdefRecord[] { createMime(
                        "application/vnd.com.example.android.beam", text.getBytes())
                        /**
                         * The Android Application Record (AAR) is commented out. When a device
                         * receives a push with an AAR in it, the application specified in the AAR
                         * is guaranteed to run. The AAR overrides the tag dispatch system.
                         * You can add it back in to guarantee that this
                         * activity starts when receiving a beamed message. For now, this code
                         * uses the tag dispatch system.
                        */
                        //,NdefRecord.createApplicationRecord("com.example.android.beam")
                });
        return msg;
    }
}
