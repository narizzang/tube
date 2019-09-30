package com.example.ha.tube;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class YoutuberActivity extends AppCompatActivity {
    RecyclerView vRecyclerView = null;
    VideoListAdapter vadapter = null;
    ArrayList<VideoItem> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtuber);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.shortcutBtn);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoYoutubeApp("UCeivPjjK9-cdj8-gw4-7JRg");
            }
        });
        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.backBtn);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(YoutuberActivity.this, MainActivity.class));
                overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);
                finish();
            }
        });
        init();
    }

    private void init() {
        list = new ArrayList<VideoItem>();
        VideoItem[] v =  new VideoItem[9];
        v[0] = new VideoItem("https://i.ytimg.com/vi/kIUD_0ytG34/hqdefault.jpg?sqp=-oaymwEZCPYBEIoBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLAtBoBc3CC1rBCDVQItlQfJDjMDJg",
        "[건국대학교 Konkuk University] 학생 홍보영상 Promotional Video (for prospective students)", "33,275회", "kIUD_0ytG34");
        v[1] = new VideoItem("https://i.ytimg.com/vi/AaKDBm_d9bI/hqdefault.jpg?sqp=-oaymwEZCPYBEIoBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLB8X2PjERbg_GjTa8Uk_SfeNq953w",
                "[건국대/영상공모전 대상] 나에게 건국이란~ \"세상에 필요한 진짜 공부\"", "11,515회", "Gfuecp7pnbQ");
        v[2] = new VideoItem("https://i.ytimg.com/vi/V18iJOcNfuo/hqdefault.jpg?sqp=-oaymwEZCPYBEIoBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLCLxnPsWEZ8515ybR52h_eRAkXDlA",
                "[전지적 전공 시점 ] 건국대 수의대 학생이 밝히는 수의대의 진실??", "19,548회", "Gfuecp7pnbQ");
        v[3] = new VideoItem("https://i.ytimg.com/vi/Z2QbxSkQUYM/hqdefault.jpg?sqp=-oaymwEZCPYBEIoBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLChCIe5Z05zE00L_jZu5JpgX0Patw",
                "건국대 홍보대사 '건우건희' 일상 브이로그. 건국대 미디어커뮤니케이션학과", "15,089회", "Gfuecp7pnbQ");
        v[4] = new VideoItem("https://i.ytimg.com/vi/Xlsj8hdx1XU/hqdefault.jpg?sqp=-oaymwEZCPYBEIoBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLCRldjsTx7SP8ergPEWbvw4BQ-5kg",
                "[건국대/캠퍼스투어] 함께 걸을까? 건국대 캠퍼스투어", "13,981회", "Gfuecp7pnbQ");
        v[5] = new VideoItem("https://i.ytimg.com/vi/ViEOO0dBl_M/hqdefault.jpg?sqp=-oaymwEZCPYBEIoBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLB46U6CeYB4I7nk94Xepahu8aaOUQ",
                "\"젊음으로 새 도약\" 23만 건국의 자부심 건국대 총동문회", "12,515회", "Gfuecp7pnbQ");
        v[6] = new VideoItem("https://i.ytimg.com/vi/3wZCHDFUzh4/hqdefault.jpg?sqp=-oaymwEZCPYBEIoBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLBy4cReVngOUwnrPdGqcugyj5sFHw",
                "건국대 공대생의 브이로그", "8,508회", "Gfuecp7pnbQ");
        v[7] = new VideoItem("https://i.ytimg.com/vi/WPHw0WLDm28/hqdefault.jpg?sqp=-oaymwEZCPYBEIoBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLBn_l1Y0ac1V6FmCijbaR72xDopIw",
                "[전지적 전공 시점 4편] 건국대 미디어커뮤니케이션학과 + 문화콘텐츠학과", "6,815회", "Gfuecp7pnbQ");
        v[8] = new VideoItem("https://i.ytimg.com/vi/nLj2boMqO5M/hqdefault.jpg?sqp=-oaymwEZCPYBEIoBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLCnhPSqB7HJwmrzHarzsvktHsk1xA",
                "입학사정관이 알려주는 2020 건국대 학종의 모든것", "2,273회", "Gfuecp7pnbQ");

        for (int i=0; i<9; i++) {
            list.add(v[i]);
        }

        vRecyclerView = findViewById(R.id.video_list);
        vadapter = new VideoListAdapter(list);
        vadapter.setOnItemClickListener(new VideoListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                String vid = list.get(pos).getVideoId();
                gotoYoutubeVideo(vid, true);
            }
        });
        vRecyclerView.setAdapter(vadapter);
        vRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void gotoYoutubeApp(String youtuber_id) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/" + youtuber_id));
        startActivity(intent);
    }

    public void gotoYoutubeVideo(String youtube_video_id, boolean isFull) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://" + youtube_video_id));
        if (isFull) intent.putExtra("force_fullscreen",true);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_youtuber, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
