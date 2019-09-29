package com.example.ha.tube;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.ViewHolder> {
    private ArrayList<VideoItem> data = null;
    Bitmap bitmap;

    public interface OnItemClickListener {
        void onItemClick(View v, int pos);
    }

    private OnItemClickListener vListener = null;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.vListener = listener;
    }

    public VideoListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.video_item, viewGroup, false);
        VideoListAdapter.ViewHolder vh = new VideoListAdapter.ViewHolder(view);

        return vh;
    }

    VideoListAdapter(ArrayList<VideoItem> list) {
        data = list;
    }

    public int getItemCount() {
        return data.size();
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
       final  VideoItem item = data.get(i);

        Thread getBitmap = new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL(item.getThumbnailUrl());
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
            viewHolder.thumbnail.setImageBitmap(bitmap);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        viewHolder.title.setText(item.getTitle());
        viewHolder.views.setText("조회수 "+item.getViews());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView thumbnail;
        TextView title;
        TextView views;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int p = getAdapterPosition();
                    if (p != RecyclerView.NO_POSITION) {
                        if (vListener != null) {
                            vListener.onItemClick(v, p);
                        }
                    }
                }
            });
            thumbnail = itemView.findViewById(R.id.video_thumbnail);
            title = itemView.findViewById(R.id.video_title);
            views = itemView.findViewById(R.id.video_views);
        }
    }
}
