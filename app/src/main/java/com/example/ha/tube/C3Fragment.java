package com.example.ha.tube;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class C3Fragment extends Fragment {

    ArrayList<VideoItem> videos;
    GridView glist;
    GridAdapter adapter;

    public C3Fragment() {
        // Required empty public constructor
    }

    public void itemAdd() {
        VideoItem[] v =  new VideoItem[9];
        v[0] = new VideoItem("https://i.ytimg.com/vi/yHp8bGC6XdA/hqdefault.jpg?sqp=-oaymwEZCNACELwBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLCYBeIt3CJS625y9s6cbNIo-8Vc4A",
                "지옥의 고슴도치와 뽀뽀하기 [냥이아빠]", "148130회", "yHp8bGC6XdA", "4,912");
        v[1] = new VideoItem("https://i.ytimg.com/vi/uNgynhPlA9Y/hqdefault.jpg?sqp=-oaymwEZCNACELwBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLCYBeIt3CJS625y9s6cbNIo-8Vc4A",
                "이사오고 적응 중인 고슴도치와 햄스터 [냥이아빠]", "184390회", "uNgynhPlA9Y", "5,302");
        v[2] = new VideoItem("https://i.ytimg.com/vi/jV3jgBIAkhg/hqdefault.jpg?sqp=-oaymwEZCNACELwBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLCYBeIt3CJS625y9s6cbNIo-8Vc4A",
                "[트위치] 오늘도 고양이들은 트롤링합니다", "97359회", "jV3jgBIAkhg", "2,512");
        v[3] = new VideoItem("https://i.ytimg.com/vi/OcSS9-W9Xfk/hqdefault.jpg?sqp=-oaymwEZCNACELwBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLCYBeIt3CJS625y9s6cbNIo-8Vc4A",
                "꾸릉이와 함께하는 이사한 집 소개 [냥이아빠]", "346838회", "OcSS9-W9Xfk", "9,973");
        v[4] = new VideoItem("https://i.ytimg.com/vi/F9evzGmnIfg/hqdefault.jpg?sqp=-oaymwEZCNACELwBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLCYBeIt3CJS625y9s6cbNIo-8Vc4A",
                "새로운 가족 미어캣 꾸릉이를 소개합니다.[냥이아빠]", "408138회", "Gfuecp7pnbQ", "12,794");
        v[5] = new VideoItem("https://i.ytimg.com/vi/JPi_kxDoAk0/hqdefault.jpg?sqp=-oaymwEZCNACELwBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLCYBeIt3CJS625y9s6cbNIo-8Vc4A",
                "반려동물을 위한 집 인테리어의 모든 것! 백호네 온라인 집들이 2편│이웃집의 백호│웰시코기 백호", "100132회", "JPi_kxDoAk0","3,073");
        v[6] = new VideoItem("https://i.ytimg.com/vi/4lsAjZc4VqI/hqdefault.jpg?sqp=-oaymwEZCNACELwBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLCYBeIt3CJS625y9s6cbNIo-8Vc4A",
                "[강아지와 여행하기] 제주 해안도로 강아지 동반카페 '파람'", "61463회", "4lsAjZc4VqI","1,714");
        v[7] = new VideoItem("https://i.ytimg.com/vi/XaezExBXIY0/hqdefault.jpg?sqp=-oaymwEZCNACELwBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLCYBeIt3CJS625y9s6cbNIo-8Vc4A",
                "강아지 형 행동을 따라하는 고양이 동생│이웃집의 백호│웰시코기 백호", "147476회", "XaezExBXIY0","4,372");
        v[8] = new VideoItem("https://i.ytimg.com/vi/ghdLvqP4CcQ/hqdefault.jpg?sqp=-oaymwEZCNACELwBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLCYBeIt3CJS625y9s6cbNIo-8Vc4A",
                "고등어를 먹고 신이 난 하트 강아지", "94286회", "ghdLvqP4CcQ","2,745");

        for (int i=0; i<9; i++) {
            videos.add(v[i]);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_c3, container, false);
        videos = new ArrayList<>();
        itemAdd();
        adapter = new GridAdapter(getContext(), R.layout.video_items_grid, videos);
        glist = view.findViewById(R.id.videogridList);
        glist.setAdapter(adapter);

        return view;
    }

}
