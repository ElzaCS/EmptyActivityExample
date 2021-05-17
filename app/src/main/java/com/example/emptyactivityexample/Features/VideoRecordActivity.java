package com.example.emptyactivityexample.Features;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.example.emptyactivityexample.R;

public class VideoRecordActivity extends AppCompatActivity {

    private static int VIDEO_REQUEST=101;
    private Uri videoUri=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_record);

        Button btn_capture = findViewById(R.id.btn_capture101);
        btn_capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                captureVideo(v);
            }
        });
        Button btn_play = findViewById(R.id.btn_play);
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo(v);
            }
        });
    }

    public void captureVideo(View view)
    {
        Intent videoIntent=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if(videoIntent.resolveActivity(getPackageManager())!=null)
        {
            startActivityForResult(videoIntent,VIDEO_REQUEST);
        }
    }

    public void playVideo(View view)
    {
//        Intent playIntent=new Intent(this,VideoPlayActivity.class);
//        playIntent.putExtra("videoUri",videoUri.toString());
//        startActivity(playIntent);
        VideoView mVideoView=findViewById(R.id.videoView);
        //Uri videoUri_url= Uri.parse(videoUri);
        mVideoView.setVideoURI(videoUri);
        mVideoView.start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == VIDEO_REQUEST && resultCode == RESULT_OK)
        {
            videoUri=data.getData();
        }

    }
}