package com.example.emptyactivityexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class IntentGetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_get);

        Intent intent = getIntent();
        String type = intent.getType();
        String action = intent.getAction();
        String message;
        if (action.equals(Intent.ACTION_SEND) && type != null){
            if ("text/plain".equals(type)) {
                message = intent.getStringExtra(Intent.EXTRA_TEXT);
                Toast.makeText(IntentGetActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        }

    }
}