package com.example.ha.tube;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout creatorBtn;
    LinearLayout viewerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addListener();
    }

    public void init() {
        creatorBtn = findViewById(R.id.creatorBtn);
        viewerBtn = findViewById(R.id.viewerBtn);
    }

    public void addListener() {
        creatorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"크리에이터", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, CreatorActivity.class));
                overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_right);
                finish();
            }
        });
        viewerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"시청자", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, ViewerActivity.class));
                overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);
                finish();
            }
        });
    }
}
