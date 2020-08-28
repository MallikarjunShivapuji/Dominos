package com.shivas.dominos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BaseObservable;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Set;
import java.util.TreeSet;

public class AlarmActivity extends AppCompatActivity {

    private static String TAG = "AlarmActivity";

    public void snooze(View view) {
        Toast.makeText(this, "SNOOZED", Toast.LENGTH_LONG).show();
    }

    public void stop (View view) {
        Toast.makeText(this, "STOPED", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_alarm);

        List set = new ArrayList();
        set.add("1");
        set.add("2");
        set.add("3");
        //Iterator i = set.iterator();
        //while (i.hasNext())
           // System.out.println("Malllik: " + set.get(3));

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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");

    }

}
