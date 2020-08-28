package com.shivas.dominos;

import android.app.AlarmManager;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static String TAG = "MainActivity";
    int i = 0;
    MediaPlayer mp;
    int number;
    int oldNumber;// = 0;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.number);
        mp = MediaPlayer.create(MainActivity.this, R.raw.roll_dice_sound);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //startActivity(new Intent(MainActivity.this, AlarmActivity.class));

                try {
                    mp.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                new AsyncTaskRunner().execute();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
        mp.stop();
        mp.release();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    private class AsyncTaskRunner extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {

            for (int j = 0; j < 20; j++) {
                Log.d("TAG", "i :" + j);
                number = 1 + (((int) (Math.random() * 100)) % 6);
                while (oldNumber == number) {
                    number = 1 + (((int) (Math.random() * 100)) % 6);
                }

                textView.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(String.valueOf(number));
                    }
                });
                oldNumber = number;

                try {
                    Thread.sleep(j * j);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "";
        }

        @Override
        protected void onPostExecute(String result) {
            textView.setEnabled(true);
        }

        @Override
        protected void onPreExecute() {
            textView.setEnabled(false);
        }

        @Override
        protected void onProgressUpdate(String... text) {

        }
    }
}
