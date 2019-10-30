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
public class C1Fragment extends Fragment {

    ArrayList<Contents> contents;
    ListView list;
    ContentsAdapter adapter;
    ImageView addBtn;

    public C1Fragment() {
        // Required empty public constructor
    }

    public void itemAdd() {
        contents.add(new Contents("브이로그"));
        contents.add(new Contents("일상"));
        contents.add(new Contents("반려동물"));
        contents.add(new Contents("영화"));
        contents.add(new Contents("음악"));
        contents.add(new Contents("동물"));
        contents.add(new Contents("카트라이더"));
        contents.add(new Contents("마인크래프트"));
        //contents.get(2).setCheck(true);
        //contents.get(5).setCheck(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_c1, container, false);
        contents = new ArrayList<Contents>();
        itemAdd();

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
