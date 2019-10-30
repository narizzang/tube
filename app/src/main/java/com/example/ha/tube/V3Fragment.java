package com.example.ha.tube;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class V3Fragment extends Fragment {

    ArrayList<ChannelItem> channels;
    ChannelAdapter adapter;
    GridView glist;

    public V3Fragment() {
        // Required empty public constructor
    }

    public void itemAdd() {
        channels.add(new ChannelItem("노곤하개냥tv",
                "https://yt3.ggpht.com/a/AGF-l7-2lX-ibBsAFF9Po5FDffl3RWjM1zkFwV80Xw=s100-c-k-c0xffffffff-no-rj-mo",
                "UCnPRslWJm1Na6DUuTuSZ12A",
                "21만"));

        channels.add(new ChannelItem("냥이아빠",
                "https://yt3.ggpht.com/a/AGF-l7_mubLe4tjFhEZZPWFKf_FR3qIX-CJXMmjzKw=s100-c-k-c0xffffffff-no-rj-mo",
                "UC5AAf4_zZxk-mCl46TogZQQ",
                "41만"));
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_v3, container, false);
        channels = new ArrayList<>();
        itemAdd();
        adapter = new ChannelAdapter(getContext(), R.layout.channel_items_grid, channels);
        glist = view.findViewById(R.id.channelgridList);
        glist.setAdapter(adapter);
        glist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ChannelItem c = (ChannelItem)parent.getItemAtPosition(position);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/" + c.getCid()));
                startActivity(intent);
            }
        });
        return view;
    }

}
