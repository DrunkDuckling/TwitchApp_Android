package com.example.twitchapp_android.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.twitchapp_android.R;
import com.example.twitchapp_android.model.Categories;

import java.util.List;

public class StreamersRecyclerViewAdapter extends RecyclerView.Adapter<StreamersRecyclerViewAdapter.ViewHolder> {


    private Context mContext;
    // TODO RENAME LIST OBJECT TO STREAMERS
    private List<Categories> mData;
    private static final String TAG = "StreamersRecyclerViewAd";
    StreamersRecyclerViewAdapter.onItemClickListener onItemClickListener;

    public StreamersRecyclerViewAdapter(Context mContext, List<Categories> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    public void setOnItemClickListener(StreamersRecyclerViewAdapter.onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface onItemClickListener {
        void onClick(Categories cat);//pass your object types.
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        ImageView mImageView;

        public ViewHolder(View itemView){
            super(itemView);
            mTextView = itemView.findViewById(R.id.anime_title_id);
            mImageView = itemView.findViewById(R.id.anime_img_id);
        }

    }

    public StreamersRecyclerViewAdapter(Context mContext, List<Categories> mData, onItemClickListener onItemClickListener) {
        this.mContext = mContext;
        this.mData = mData;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        View view = mInflater.inflate(R.layout.cardview_item_anime, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final Categories cat = mData.get(i);
        viewHolder.mTextView.setText(mData.get(i).getTitle());
        viewHolder.mImageView.setImageResource(mData.get(i).getThumbnail());
        viewHolder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onClick(cat);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
