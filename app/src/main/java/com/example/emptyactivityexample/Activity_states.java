package com.example.emptyactivityexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_states extends AppCompatActivity implements View.OnClickListener {
    EditText edit_name;
    private String name;
    private static final String KEY_NAME = "key_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_states);

        //INPUT NAME
        edit_name = findViewById(R.id.edit_stPlain);

        //OUTPUT NAME
        TextView txt_finalName2 = findViewById(R.id.txt_finalName2);

        //TALK BUTTON
        Button btn_print = findViewById(R.id.btn_print);
        btn_print.setOnClickListener(this);

        if (savedInstanceState != null){
            String savedName = savedInstanceState.getString(KEY_NAME);
            txt_finalName2.setText(savedName);
        }
        else{
            Toast.makeText(this, "New entry", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString(KEY_NAME, edit_name.getText().toString());
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onClick(View view){
        switch (view.getId()){
            //TALK BUTTON
            case R.id.btn_print:
                edit_name = findViewById(R.id.edit_stPlain);
                name = edit_name.getText().toString();

                TextView txt_finalName = findViewById(R.id.txt_finalName);
                txt_finalName.setText(name);

                TextView txt_finalName2 = findViewById(R.id.txt_finalName2);
                txt_finalName2.setText(name);
                break;

            default:
                throw new IllegalStateException("Unexpected value: "+ view.getId());

        }
    }
}