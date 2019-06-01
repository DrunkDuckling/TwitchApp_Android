package com.example.twitchapp_android.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.twitchapp_android.R;
import com.example.twitchapp_android.model.Categories;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private Context mContext;
    private List<Categories> mData;


    public RecyclerViewAdapter(Context mContext, List<Categories> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_anime, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {

        myViewHolder.tv_anime_title.setText(mData.get(position).getTitle());
        myViewHolder.img_anime_thumbnail.setImageResource(R.drawable.dragonball);


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_anime_title;
        ImageView img_anime_thumbnail;

        public MyViewHolder(View itemView){
            super(itemView);

            tv_anime_title = itemView.findViewById(R.id.anime_title_id);
            img_anime_thumbnail = itemView.findViewById(R.id.anime_img_id);


        }
    }

}
