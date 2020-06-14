package com.example.a20153421adaptorview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DynamicList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_list);

        setTitle("리스트 페이지");

        final ArrayList<String> gameList = new ArrayList<String>();
        final ListView listView = findViewById(R.id.listView2);

        final ArrayAdapter<String> adaptor = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,gameList);
        listView.setAdapter(adaptor);

        final EditText editItem = findViewById(R.id.editText);
        Button addButton = findViewById(R.id.addButton);
        Button backButton = findViewById(R.id.backButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameList.add(editItem.getText().toString());
                adaptor.notifyDataSetChanged();
                editItem.setText("");
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                gameList.remove(position);
                adaptor.notifyDataSetChanged();

                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),gameList.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }
}

