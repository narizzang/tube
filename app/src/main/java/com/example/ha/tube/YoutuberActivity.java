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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.shortcutBtn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoYoutubeApp("UCeivPjjK9-cdj8-gw4-7JRg");
            }
        });
        init();
    }

    private void init() {
        list = new ArrayList<VideoItem>();
        VideoItem[] v =  new VideoItem[8];
        v[0] = new VideoItem("https://i.ytimg.com/vi/Gfuecp7pnbQ/hqdefault.jpg?sqp=-oaymwEZCPYBEIoBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLDDcWukeVrIRGQFRdf4c42BDnILQg",
        "문호준 인 걸 모르고 「아이디 삭제빵 뜨자고 온 유저」ㅋㅋㅋㅋㅋㅋㅋㅋ [카트 문호", "346만회", "Gfuecp7pnbQ");
        v[1] = new VideoItem("https://i.ytimg.com/vi/nG5y9vSLKBY/hqdefault.jpg?sqp=-oaymwEZCPYBEIoBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLALYBXNSZoWAJLHvOioQuydCyuGeg",
                "카트라이더 30초 핵을 이겨버린 문호준(feat.15초 핵)ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ [카트 문호준]", "285만회", "Gfuecp7pnbQ");
        v[2] = new VideoItem("https://i.ytimg.com/vi/T4r0J8xqQLM/hqdefault.jpg?sqp=-oaymwEZCPYBEIoBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLAP7mjP2pS7ZAjGb7ReB2CFfOeabQ",
                "「카트 스피드 핵 VS 문호준」ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ [카트 문호준]", "241만회", "Gfuecp7pnbQ");
        v[3] = new VideoItem("https://i.ytimg.com/vi/oOzQrRJzPMU/hqdefault.jpg?sqp=-oaymwEZCPYBEIoBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLCimfH1d1K5F8QM8hYcWGyCu5lqXQ",
                "카트 떡상 기념! 「문호준의 카트 잘하는 법 완벽 강좌!」 [카트 문호준]", "212만회", "Gfuecp7pnbQ");
        v[4] = new VideoItem("https://i.ytimg.com/vi/7A_QxwAC_eQ/hqdefault.jpg?sqp=-oaymwEZCPYBEIoBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLAOQy3xfyVK2a7fBOChM7y57f7kGg",
                "1 대 1 모드에서 유영혁을 만난 문호준ㅋㅋㅋㅋㅋㅋㅋㅋㅋ [카트 문호준]", "193만회", "Gfuecp7pnbQ");
        v[5] = new VideoItem("https://i.ytimg.com/vi/7A_QxwAC_eQ/hqdefault.jpg?sqp=-oaymwEZCPYBEIoBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLAOQy3xfyVK2a7fBOChM7y57f7kGg",
                "1 대 1 모드에서 유영혁을 만난 문호준ㅋㅋㅋㅋㅋㅋㅋㅋㅋ [카트 문호준]", "193만회", "Gfuecp7pnbQ");
        v[6] = new VideoItem("https://i.ytimg.com/vi/7A_QxwAC_eQ/hqdefault.jpg?sqp=-oaymwEZCPYBEIoBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLAOQy3xfyVK2a7fBOChM7y57f7kGg",
                "1 대 1 모드에서 유영혁을 만난 문호준ㅋㅋㅋㅋㅋㅋㅋㅋㅋ [카트 문호준]", "193만회", "Gfuecp7pnbQ");
        v[7] = new VideoItem("https://i.ytimg.com/vi/7A_QxwAC_eQ/hqdefault.jpg?sqp=-oaymwEZCPYBEIoBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLAOQy3xfyVK2a7fBOChM7y57f7kGg",
                "1 대 1 모드에서 유영혁을 만난 문호준ㅋㅋㅋㅋㅋㅋㅋㅋㅋ [카트 문호준]", "193만회", "Gfuecp7pnbQ");

        for (int i=0; i<8; i++) {
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
