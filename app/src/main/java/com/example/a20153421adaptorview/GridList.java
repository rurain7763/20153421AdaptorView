package com.example.a20153421adaptorview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

public class GridList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_list);
        setTitle("그리드 뷰 로고");

        Button backButton = findViewById(R.id.backButton_Grid);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final GridView gridview = findViewById(R.id.gridView1);

        MyGridAdator gAdator = new MyGridAdator(this);
        gridview.setAdapter(gAdator);
    }

    public class MyGridAdator extends BaseAdapter  {
        Context context;

        public MyGridAdator(Context c){
            context = c;
        }

        @Override
        public int getCount() {
            return posterID.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        Integer[] posterID = {R.drawable.lol,R.drawable.valolant,R.drawable.overwatch,R.drawable.starcraft ,R.drawable.starcraft,
                R.drawable.lol,R.drawable.valolant,R.drawable.overwatch,R.drawable.starcraft ,R.drawable.starcraft,
                R.drawable.lol,R.drawable.valolant,R.drawable.overwatch,R.drawable.starcraft ,R.drawable.starcraft,
                R.drawable.lol,R.drawable.valolant,R.drawable.overwatch,R.drawable.starcraft ,R.drawable.starcraft,
                R.drawable.lol,R.drawable.valolant,R.drawable.overwatch,R.drawable.starcraft ,R.drawable.starcraft,
                R.drawable.lol,R.drawable.valolant,R.drawable.overwatch,R.drawable.starcraft ,R.drawable.starcraft
        };

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(200,300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,5);
            imageView.setImageResource(posterID[position]);

            final int pos = position;

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogView = View.inflate(GridList.this,R.layout.dialog,null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(GridList.this);
                    ImageView imgPoster = dialogView.findViewById(R.id.imgPost);
                    imgPoster.setImageResource(posterID[pos]);
                    dlg.setTitle("로고 크게 보기");
                    dlg.setIcon(R.drawable.ic_launcher_background);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기",null);
                    dlg.show();
                }
            });

            return imageView;
        }
    }
}

