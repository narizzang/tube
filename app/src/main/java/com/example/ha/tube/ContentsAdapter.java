package com.example.ha.tube;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ha on 2019-10-29.
 */

public class ContentsAdapter extends ArrayAdapter {
    Context context;
    ArrayList<Contents> data;

    public ContentsAdapter(@NonNull Context context, int resource, ArrayList<Contents> objects) {
        super(context, resource, objects);
        this.context = context;
        data = objects;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.contents_item, null);
        }
        final Contents temp = data.get(position);
        if (temp!=null) {
            TextView t = (TextView)v.findViewById(R.id.contents_name);
            t.setText(temp.getS());
            if (temp.isCheck()) {
                CheckBox c = (CheckBox)v.findViewById(R.id.check_btn);
                c.setChecked(true);
            }
        }
        return v;
    }
}
