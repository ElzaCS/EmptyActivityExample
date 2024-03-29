package com.example.emptyactivityexample.Intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.emptyactivityexample.R;

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
                message = intent.getStringExtra(Intent.EXTRA_TEXT)+intent.getStringExtra(IntentUsageActivity.EXTRA_TEXT2);
                Toast.makeText(IntentGetActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        }

    }
}