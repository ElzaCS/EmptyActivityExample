package com.example.emptyactivityexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Activity_fragments extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);

        Fragment f1 = new FirstFragment();
        Fragment f2 = new SecondFragment();

        //setFragment(new FirstFragment());

        Button btn_f1 = findViewById(R.id.btn_fragment1);
        btn_f1.setOnClickListener(this);
        Button btn_f2 = findViewById(R.id.btn_fragment2);
        btn_f2.setOnClickListener(this);

    }

    public void setFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_fragment, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_fragment1:
                setFragment(new FirstFragment());
                Toast.makeText(Activity_fragments.this, "First", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_fragment2:
                setFragment(new SecondFragment());
                break;
        }
    }
}