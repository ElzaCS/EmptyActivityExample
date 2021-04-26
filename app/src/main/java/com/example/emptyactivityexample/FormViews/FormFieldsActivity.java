package com.example.emptyactivityexample.FormViews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.emptyactivityexample.MainActivity;
import com.example.emptyactivityexample.R;

public class FormFieldsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_fields);

        //NAME FIELD
        EditText editText = findViewById(R.id.plain_name);

        //TALK BUTTON
        Button btn_talk = findViewById(R.id.btn_name);
        btn_talk.setOnClickListener(this);

        //ISGOOD CHECKBOX
        CheckBox isGood = findViewById(R.id.check_isGood);
        isGood.setOnClickListener(this);

        //GREEATING DROPDOWN
        Spinner spin_greet = findViewById(R.id.spnr_greeting);
        //simple_spinner_item and simple_spinner_dropdown_item are basic layouts provided by platform
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.greetings_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_greet.setAdapter(adapter);
        spin_greet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedGreeting = parent.getItemAtPosition(position).toString();
                Toast.makeText(FormFieldsActivity.this, selectedGreeting, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        //NUMBER FIELD
        TextView txtview_num = findViewById(R.id.plain_num);
        //ADD BUTTON
        Button btn_add = findViewById(R.id.btn_plus);
        btn_add.setOnClickListener(this);

        //RECYCLER VIEW
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        String[] languages = {"Java", "Python", "C", "C++", "Kotlin"};
        LangaugeAdapter langaugeAdapter = new LangaugeAdapter(languages);
        recyclerView.setAdapter(langaugeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //for horizontal recyclerview
//        LinearLayoutManager layoutManager
//                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        recyclerView.setLayoutManager(layoutManager);

        //RADIO GROUP
        Button btn_radio = findViewById(R.id.btn_radio);
        btn_radio.setOnClickListener(this);

        //2nd ACTIVITY
        Button btn_click = findViewById(R.id.btn_back);
        btn_click.setOnClickListener(this);
    }

    public void onClick(View view){
        switch (view.getId()){
            //TALK BUTTON
            case R.id.btn_name:
                EditText editText = findViewById(R.id.plain_name);
                String name = editText.getText().toString();
                Toast.makeText(FormFieldsActivity.this, name, Toast.LENGTH_SHORT).show();
                break;

            //ISGOOD CHECKBOX
            case R.id.check_isGood:
                if (((CheckBox) view).isChecked())
                    Toast.makeText(FormFieldsActivity.this, "good", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(FormFieldsActivity.this, "bad", Toast.LENGTH_SHORT).show();
                break;

            //ADD BUTTON
            case R.id.btn_plus:
                TextView txtview_num = findViewById(R.id.plain_num);
                txtview_num.setText(String.valueOf(Integer.parseInt(txtview_num.getText().toString()) + 1));
                break;

            //RADIO GROUP
            case R.id.btn_radio:
                RadioGroup radioGroup_action = findViewById(R.id.radioGroup);
                int selectedId = radioGroup_action.getCheckedRadioButtonId();
                switch (selectedId){
                    case R.id.radioAlarm:
                        Toast.makeText(getApplicationContext(), "You clicked Alarm!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioMusic:
                        Toast.makeText(getApplicationContext(), "You clicked Music!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioMail:
                        Toast.makeText(getApplicationContext(), "You clicked Mail!", Toast.LENGTH_SHORT).show();
                        break;
                }
                break;

            //2nd ACTIVITY
            case R.id.btn_back:
                Intent intent = new Intent(FormFieldsActivity.this, MainActivity.class);
                startActivity(intent);
                break;

            default:
                throw new IllegalStateException("Unexpected value: "+ view.getId());

        }
    }
}