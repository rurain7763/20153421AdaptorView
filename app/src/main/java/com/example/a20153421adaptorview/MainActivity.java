package com.example.a20153421adaptorview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("데이터 표기");

        Button pageMoveButton_Dynamic = findViewById(R.id.pageMoveButton_Dynamic);
        pageMoveButton_Dynamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),DynamicList.class);
                startActivity(i);
            }
        });


        Button pageMoveButton_Static = findViewById(R.id.pageMoveButton_Static);

        pageMoveButton_Static.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),StaticList.class);
                startActivity(i);
            }
        });

        Button pageMoveButton_Grid = findViewById(R.id.pageMoveButton_Grid);

        pageMoveButton_Grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),GridList.class);
                startActivity(i);
            }
        });
    }
}
