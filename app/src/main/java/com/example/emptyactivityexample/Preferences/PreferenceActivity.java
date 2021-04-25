package com.example.emptyactivityexample.Preferences;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.emptyactivityexample.R;

public class PreferenceActivity extends AppCompatActivity implements View.OnClickListener {
    EditText name, email, phone;
    Button button,button2;
    SharedPreferences sp;
    String nameStr, emailStr, phoneStr;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

        name=findViewById(R.id.editTextTextPersonName);
        email=findViewById(R.id.editTextTextPersonName2);
        phone=findViewById(R.id.editTextPhone);

        button=findViewById(R.id.button);
        button.setOnClickListener(this);

        button2=findViewById(R.id.button2);
        button2.setOnClickListener(this);

        sp=getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE );
        if (!Settings.System.canWrite(getApplicationContext())) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS, Uri.parse("package:" + getPackageName()));
            startActivityForResult(intent, 200);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                nameStr=name.getText().toString();
                emailStr=email.getText().toString();
                phoneStr=phone.getText().toString();

                SharedPreferences.Editor editor=sp.edit();
                editor.putString("name",nameStr);
                editor.putString("email",emailStr);
                editor.putString("phone", phoneStr);
                editor.commit();
                Toast.makeText(PreferenceActivity.this,"Information Saved",Toast.LENGTH_LONG).show();
                break;

            case R.id.button2:
                SharedPreferences sp=getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
                String name=sp.getString("name", "");
                String email=sp.getString("email", "");
                String phone=sp.getString("phone", "");

                StringBuffer buffer=new StringBuffer();
                buffer.append("Name: "+name+"\n");
                buffer.append("Email: "+email+"\n");
                buffer.append("Phone: "+phone+"\n");
                showMessage("Data", buffer.toString());
                break;
        }
    }

    public void showMessage(String title, String message)  {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch(item.getItemId())  {
            case R.id.setp:
                Toast.makeText(getApplicationContext(),"Clicked Settings", Toast.LENGTH_LONG).show();
                intent = new Intent(android.provider.Settings.ACTION_SETTINGS);
                startActivity(intent);
                break;
            case R.id.abt:
                Toast.makeText(getApplicationContext(),"Clicked Control", Toast.LENGTH_LONG).show();
                intent=new Intent(this, ActivityPref.class);
                startActivity(intent);
                break;
            case R.id.hlp:
                Toast.makeText(getApplicationContext(),"Clicked help", Toast.LENGTH_LONG).show();
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://support.google.com/android/?hl=en#topic=7313011"));
                startActivity(intent);
                break;
            case R.id.ext:
                Toast.makeText(getApplicationContext(),"Clicked Exit", Toast.LENGTH_LONG).show();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}