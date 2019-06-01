package com.example.twitchapp_android.adapter;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.twitchapp_android.R;
import com.example.twitchapp_android.model.Categories;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context mContext;
    private List<Categories> mData;
    private static final String TAG = "RecyclerViewAdapter";

    onItemClickListener onItemClickListener;

    public void setOnItemClickListener(RecyclerViewAdapter.onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface onItemClickListener {
        void onClick(Categories cat);//pass your object types.
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        ImageView mImageView;

        public MyViewHolder(View itemView){
            super(itemView);
            mTextView = itemView.findViewById(R.id.anime_title_id);
            mImageView = itemView.findViewById(R.id.anime_img_id);
        }

    }


    public RecyclerViewAdapter(Context mContext, List<Categories> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        View view = mInflater.inflate(R.layout.cardview_item_anime, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {

        final Categories cat = mData.get(position);
        myViewHolder.mTextView.setText(mData.get(position).getTitle());
        myViewHolder.mImageView.setImageDrawable(mData.get(position).getThumbnail());

        myViewHolder.mImageView.setOnClickListener(new View.OnClickListener() {
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
