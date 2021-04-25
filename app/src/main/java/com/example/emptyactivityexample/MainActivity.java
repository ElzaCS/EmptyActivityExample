package com.example.emptyactivityexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.emptyactivityexample.FormViews.FormFieldsActivity;
import com.example.emptyactivityexample.Fragments.Activity_fragments;
import com.example.emptyactivityexample.GridView.Activity_gridview;
import com.example.emptyactivityexample.Intents.IntentUsageActivity;
import com.example.emptyactivityexample.Preferences.PreferenceActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //use tag in Log.d to find the log
        Log.d("Cybrary", "onCreate");

        //SHARED PREFERENCES
        SharedPreferences sharedPreferences = getSharedPreferences("cybrarySettings", Context.MODE_PRIVATE);
        String check = sharedPreferences.getString("firstRun", "true");
        if (check.equals("true")){
            Toast.makeText(this, "Welcome to my app", Toast.LENGTH_SHORT).show();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("firstRun", "false");
            editor.apply();
        }
        else{
            Toast.makeText(this, "Welcome back", Toast.LENGTH_SHORT).show();
        }

        //ACTIVITY - FORMS
        Button btn_forms = findViewById(R.id.btn_forms);
        btn_forms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FormFieldsActivity.class);
                startActivity(intent);
            }
        });
        //ACTIVITY - INTENTS
        Button btn_intents = findViewById(R.id.btn_intents);
        btn_intents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IntentUsageActivity.class);
                startActivity(intent);
            }
        });
        //ACTIVITY - GRIDVIEW
        Button btn_gridview = findViewById(R.id.btn_gridview);
        btn_gridview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity_gridview.class);
                startActivity(intent);
            }
        });
        //ACTIVITY - STATES
        Button btn_states = findViewById(R.id.btn_states);
        btn_states.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity_states.class);
                startActivity(intent);
            }
        });
        //ACTIVITY - FRAGMENTS
        Button btn_fragments = findViewById(R.id.btn_fragments);
        btn_fragments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity_fragments.class);
                startActivity(intent);
            }
        });
        //ACTIVITY - ORIENTATION
        Button btn_orient = findViewById(R.id.btn_orientation);
        btn_orient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity_orientation.class);
                startActivity(intent);
            }
        });
        //ACTIVITY - DRAG
        Button btn_drag = findViewById(R.id.btn_drag);
        btn_drag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DragActivity.class);
                startActivity(intent);
            }
        });
        //ACTIVITY - NOTIFICATION
        Button btn_notif = findViewById(R.id.btn_notif);
        btn_notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NotificationActivity.class);
                startActivity(intent);
            }
        });
        //ACTIVITY - PREFERENCES
        Button btn_pref = findViewById(R.id.btn_pref);
        btn_pref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PreferenceActivity.class);
                startActivity(intent);
            }
        });
    }

    //MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.home_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.search:
                Toast.makeText(this, "Searching...", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.help:
                Toast.makeText(this, "Helping...", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.logout:
                Toast.makeText(this, "Loggin out...", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //other functions that are part of the android lifecycle

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("Cybrary", "onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("Cybrary", "onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("Cybrary", "onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("Cybrary", "onStop");
    }


    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("Cybrary", "onDestroy");
    }



}
