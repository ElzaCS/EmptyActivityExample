package com.example.emptyactivityexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public String greeting = "";

    //CHECKBOX
    CheckBox isGood;
    //checkbox onclick function
    public void onCheckboxClicked(View view){
        boolean clicked = ((CheckBox) view).isChecked();
        if (view.getId() == R.id.check_good && clicked)
            Toast.makeText(this, "U ticked", Toast.LENGTH_SHORT).show();
    }

    //RECYCLEVIEW
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //use tag in Log.d to find the log
        Log.d("Cybrary", "onCreate");

        //not necessary if not modifying the component

        //NAME FIELD
        EditText editText = findViewById(R.id.editText);

        //ISGOOD CHECKBOX
        isGood = findViewById(R.id.check_good);

        //GREEATING DROPDOWN
        Spinner spin_greet = findViewById(R.id.spinner_greeting);
        //simple_spinner_item and simple_spinner_dropdown_item are basic layouts provided by platform
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.greetings_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_greet.setAdapter(adapter);
        spin_greet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedGreeting = parent.getItemAtPosition(position).toString();
                greeting = selectedGreeting.toString();
                Toast.makeText(MainActivity.this, selectedGreeting, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //TALK BUTTON
        Button button = findViewById(R.id.buttonTalk);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //editText.getText() to get input of editable PlainText
                String nameText = editText.getText().toString();
                // without show(), the notification wont be displayed
                boolean current_isGood = isGood.isChecked();
                if (current_isGood)
                    Toast.makeText(MainActivity.this, "Good "+greeting+" "+nameText+"!!!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Bad "+greeting+" "+nameText+"!!!", Toast.LENGTH_SHORT).show();

                //convention to name var as componentType_componentFunction

            }
        });

        //NUMBER FIELD
        TextView txtview_num = findViewById(R.id.text_num);
        //ADD BUTTON
        Button btn_add = findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtview_num.setText(String.valueOf(Integer.parseInt(txtview_num.getText().toString()) + 1));
            }
        });

        //RECYCLER
        recyclerView = findViewById(R.id.recycler_view);
        String[] languages = {"Java", "Python", "C", "C++", "Kotlin"};
        LangaugeAdapter langaugeAdapter = new LangaugeAdapter(languages);
        recyclerView.setAdapter(langaugeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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
