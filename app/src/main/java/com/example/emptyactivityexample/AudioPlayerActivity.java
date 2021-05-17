package com.example.emptyactivityexample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MINUTES;

public class AudioPlayerActivity extends AppCompatActivity implements View.OnClickListener {
    TextView playerPosition,playerDuration;
    SeekBar seekBar;
    ImageView btRew,btPlay,btPause,btFt;

    MediaPlayer mediaPlayer;
    Handler handler=new Handler();
    Runnable runnable;

    int duration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_player);
        playerPosition=findViewById(R.id.player_position);
        playerDuration=findViewById(R.id.player_duration);

        seekBar=findViewById(R.id.seek_bar);

        btRew=findViewById(R.id.bt_rew);
        btRew.setOnClickListener(this);
        btPlay=findViewById(R.id.bt_play);
        btPlay.setOnClickListener(this);
        btPause=findViewById(R.id.bt_pause);
        btPause.setOnClickListener(this);
        btFt=findViewById(R.id.bt_ff);
        btFt.setOnClickListener(this);

        mediaPlayer=MediaPlayer.create(this,R.raw.music);

        runnable=new Runnable()   {
            @Override
            public void run() {
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                handler.postDelayed(this,500);
            }
        };

        duration=mediaPlayer.getDuration();
        String sDuration=convertFormat(duration);
        playerDuration.setText(sDuration);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)   {
                if(fromUser)  {
                    mediaPlayer.seekTo(progress);
                }
                playerPosition.setText(convertFormat(mediaPlayer.getCurrentPosition()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)  {   }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar)   {   }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                btPause.setVisibility(View.GONE);
                btPlay.setVisibility(View.VISIBLE);
                mediaPlayer.seekTo(0);
            }
        });
    }

    @SuppressLint("DefaultLocale")
    private String convertFormat(int duration) {
        return String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(duration)
                , TimeUnit.MILLISECONDS.toSeconds(duration) - MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration))
        );
    }

    public void onClick(View view){
        int currentPosition;
        switch (view.getId()){
            case R.id.bt_play:
                btPlay.setVisibility(View.GONE);
                btPause.setVisibility(View.VISIBLE);
                mediaPlayer.start();
                seekBar.setMax(mediaPlayer.getDuration());
                handler.postDelayed(runnable,0);
                break;

            case R.id.bt_pause:
                btPause.setVisibility(View.GONE);
                btPlay.setVisibility(View.VISIBLE);
                mediaPlayer.pause();
                handler.removeCallbacks(runnable);
                break;

            case R.id.bt_rew:
                currentPosition=mediaPlayer.getCurrentPosition();
                if(mediaPlayer.isPlaying() && duration > currentPosition)
                {
                    currentPosition = currentPosition - 5000;
                    playerPosition.setText(convertFormat(currentPosition));
                    mediaPlayer.seekTo(currentPosition);
                }
                break;

            case R.id.bt_ff:
                currentPosition=mediaPlayer.getCurrentPosition();
                int duration=mediaPlayer.getDuration();
                if(mediaPlayer.isPlaying()&&duration!=currentPosition)
                {
                    currentPosition = currentPosition + 5000;
                    playerPosition.setText(convertFormat(currentPosition));
                    mediaPlayer.seekTo(currentPosition);
                }
                break;
        }
    }
}