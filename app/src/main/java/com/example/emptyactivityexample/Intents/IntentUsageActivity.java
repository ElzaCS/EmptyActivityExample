package com.example.emptyactivityexample.Intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import com.example.emptyactivityexample.MainActivity;
import com.example.emptyactivityexample.R;

public class IntentUsageActivity extends AppCompatActivity implements View.OnClickListener {
    final String message = "I am learning intents! ";
    public static final int CAMERA_REQUEST = 1;

    public static final String EXTRA_TEXT2 = "com.example.emptyactivityexample.EXTRA_TEXT2";

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

        //CAMERA
        Button btn_camera = findViewById(R.id.btn_camera);
        btn_camera.setOnClickListener(this);

        //NEW NOTE
        Button btn_note = findViewById(R.id.btn_note);
        btn_note.setOnClickListener(this);

        //ALARM
        Button btn_alarm = findViewById(R.id.btn_alarm);
        btn_alarm.setOnClickListener(this);

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
                intent.putExtra(EXTRA_TEXT2, "second message");
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
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com"));
                startActivity(intent);
                break;

            //PHONE DIAL
            case R.id.btn_dial:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:12345"));
                startActivity(intent);
                break;

            //VIEW INTENTS
            case R.id.btn_viewIntents:
                intent = new Intent("com.example.emptyactivityexample.Intents.IntentGetActivity");
                startActivity(intent);
                break;

            //CAMERA
            case R.id.btn_camera:
                //image
                intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //video
                //intent= new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivityForResult(intent, CAMERA_REQUEST);
                break;

            //NEW NOTE
            case R.id.btn_note:
                intent = new Intent(Intent.ACTION_SEND)
                        .putExtra(Intent.EXTRA_TITLE, "subject")
                        .putExtra(Intent.EXTRA_TEXT, "text");
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent, "Create note..."));
                break;

            //ALARM
            case R.id.btn_alarm:
                intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                if (intent.resolveActivity(getPackageManager()) != null)
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