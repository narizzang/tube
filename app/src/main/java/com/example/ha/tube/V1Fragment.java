package com.example.ha.tube;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class V1Fragment extends Fragment {

    ArrayList<Contents> contents;
    ListView list;
    ContentsAdapter adapter;
    ImageView addBtn;

    public V1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_v1, container, false);
        contents = new ArrayList<Contents>();
        contents.add(new Contents("건국대학교"));
        contents.add(new Contents("게임"));
        contents.add(new Contents("롤드컵"));
        contents.add(new Contents("메이플스토리"));
        contents.add(new Contents("배틀그라운드"));
        contents.add(new Contents("카트라이더"));
        contents.add(new Contents("LOL"));
        contents.add(new Contents("마인크래프트"));
        contents.get(2).setCheck(true);
        contents.get(5).setCheck(true);
        contents.get(6).setCheck(true);
        adapter = new ContentsAdapter(getContext(), R.layout.contents_item, contents);
        list = view.findViewById(R.id.contentsList);
        list.setAdapter(adapter);
        addBtn = view.findViewById(R.id.add_btn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("컨텐츠 추가하기");

                final EditText input = new EditText(getContext());
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);

                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String s = input.getText().toString();
                        contents.add(new Contents(s));
                    }

                });
                builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });
        return view;
    }

}
