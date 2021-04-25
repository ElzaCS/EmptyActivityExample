package com.example.emptyactivityexample.GridView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.emptyactivityexample.R;

public class Activity_gridview extends AppCompatActivity {
    GridView gridView;

    String[] numberWord = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};
    int[] numberImage = {R.drawable.image_one, R.drawable.image_two, R.drawable.image_three, R.drawable.image_four, R.drawable.image_five,
            R.drawable.image_six, R.drawable.image_seven, R.drawable.image_eight, R.drawable.image_nine, R.drawable.image_ten};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);

        gridView = findViewById(R.id.grid_view);

        GridAdapter adapter = new GridAdapter(Activity_gridview.this, numberWord, numberImage);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "You clicked"+numberWord[+position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}