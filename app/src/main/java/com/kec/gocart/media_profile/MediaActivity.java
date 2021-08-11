package com.kec.gocart.media_profile;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kec.gocart.R;

import java.io.IOException;

public class MediaActivity extends AppCompatActivity {

    private Button btnPlayAudio;
    private Button btnPause;

    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        btnPlayAudio = findViewById(R.id.btn_audio);
        btnPause = findViewById(R.id.btn_pause);

        mediaPlayer = new MediaPlayer();

        btnPlayAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
                ) {
                    doPlayAudioWork();
                }

            }
        });


        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doPauseMediaPlayerWork();

            }
        });
    }

    private void doPauseMediaPlayerWork() {

        if (mediaPlayer != null){

            if (mediaPlayer.isPlaying()){

                mediaPlayer.pause();
            }

        }

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void doPlayAudioWork() {

        String url = "https://file-examples-com.github.io/uploads/2017/11/file_example_WAV_1MG.wav"; // your URL here
        mediaPlayer.setAudioAttributes(
                new AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
        );

        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare(); // might take long! (for buffering, etc)
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.start();

    }


}