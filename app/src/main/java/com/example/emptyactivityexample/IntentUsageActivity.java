package com.example.emptyactivityexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntentUsageActivity extends AppCompatActivity implements View.OnClickListener {
    final String message = "I am learning intents";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intents_usage);

        //INTERNAL INTENTS
        Button btn_internal = findViewById(R.id.btn_internal);
        btn_internal.setOnClickListener(this);

        //GEOLOCATION
        Button btn_maps = findViewById(R.id.btn_maps);
        btn_maps.setOnClickListener(this);

        //OPEN WEBPAGE
        Button btn_webpage = findViewById(R.id.btn_webpage);
        btn_webpage.setOnClickListener(this);

        //PHONE DIAL
        Button btn_dial = findViewById(R.id.btn_dial);
        btn_dial.setOnClickListener(this);

        //VIEW INTENTS
        Button btn_viewIntents = findViewById(R.id.btn_viewIntents);
        btn_viewIntents.setOnClickListener(this);

        //BACK BUTTON
        Button btn_click = findViewById(R.id.btn_back_i);
        btn_click.setOnClickListener(this);
    }

    public void onClick(View v){
        Intent intent;
        switch (v.getId()){
            //INTERNAL INTENTS
            case R.id.btn_internal:
                intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, message);
                intent.setType("text/plain");
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
//                intent = new Intent(IntentUsageActivity.this, IntentGetActivity.class);
//                startActivity(intent);
                break;

            //GEOLOCATION
            case R.id.btn_maps:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:25.285446,51.531040"));
                startActivity(intent);
                break;

            //OPEN WEBPAGE
            case R.id.btn_webpage:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.nitt.edu"));
                startActivity(intent);
                break;

            //PHONE DIAL
            case R.id.btn_dial:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:12345"));
                startActivity(intent);
                break;

            //VIEW INTENTS
            case R.id.btn_viewIntents:
                intent = new Intent("com.example.emptyactivityexample.IntentGetActivity");
                startActivity(intent);
                break;

            //BACK BUTTON
            case R.id.btn_back:
                intent = new Intent(IntentUsageActivity.this, MainActivity.class);
                startActivity(intent);

            default:
                throw new IllegalStateException("Unexpected value: "+ v.getId());
        }
    }
}