package com.fenchtose.contactsdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fenchtose.contactsdemo.R;

import java.util.List;

/**
 * Created by Jay Rambhia on 11/06/15.
 */
public class RecentDialAdapter extends RecyclerView.Adapter<RecentDialAdapter.ViewHolder> {

    private Context mContext;
    private List<String> mItems;

    public RecentDialAdapter(Context context, List<String> items) {
        mContext = context;
        mItems = items;
    }

    @Override
    public RecentDialAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.recentdial_item_layout,
                parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecentDialAdapter.ViewHolder holder, int position) {
        holder.textView.setText(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems != null ? mItems.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.textview);
        }
    }
}
