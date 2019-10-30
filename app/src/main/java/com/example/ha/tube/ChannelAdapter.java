package com.example.ha.tube;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by ha on 2019-10-30.
 */

public class ChannelAdapter extends ArrayAdapter {
    Context context;
    ArrayList<ChannelItem> data;
    Bitmap bitmap;

    public ChannelAdapter(@NonNull Context context, int resource, ArrayList<ChannelItem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.data = objects;
    }

    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.channel_items_grid, null);
        }

        final ChannelItem item = data.get(position);

        ImageView tmp1 = v.findViewById(R.id.channel_thumbnail_grid);
        TextView tmp2 = v.findViewById(R.id.channel_title_grid);
        TextView tmp3 = v.findViewById(R.id.channel_subscribers_grid);
        Thread getBitmap = new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL(item.getCart());
                    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                    conn.setDoInput(true);
                    conn.connect();

                    InputStream is = conn.getInputStream();
                    bitmap = BitmapFactory.decodeStream(is);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        getBitmap.start();

        try {
            getBitmap.join();
            tmp1.setImageBitmap(bitmap);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tmp2.setText(item.getCname());
        tmp3.setText(item.getSubscribers());

        return v;
    }
}
