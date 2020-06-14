package com.example.a20153421adaptorview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class StaticList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_list);

        //1.string 배열 형태 선언
        final String[] games = {"LoL","Valolant","OverWatch","StarCraft","BattleGround"};

        //2.리스트 뷰 변수를 생성하고 xml과 대응
        ListView list = findViewById(R.id.ListView1);

        //3.ArrayAdator 생성 후 적용
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,games);

        //3.체크박스 및 선택 방식 설정(single)
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,games);
        //list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        //3.체크박스 및 선택 방식 설정(multiple)
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,games);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        list.setAdapter(adapter);

        //4. 리스트 중 하나를 클릭시 알림
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),games[position],Toast.LENGTH_SHORT).show();
            }
        });

        Button backPage = findViewById(R.id.backButton_Static);

        backPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
