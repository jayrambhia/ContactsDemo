package com.fenchtose.contactsdemo.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
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
public class SpeedDialAdapter extends RecyclerView.Adapter<SpeedDialAdapter.ViewHolder> {

    private Context mContext;
    private List<String> mItems;

    private final TypedArray mColors;

    public SpeedDialAdapter(Context context, List<String> items) {
        mContext = context;
        mItems = items;
        final Resources mRes = context.getResources();
        mColors = mRes.obtainTypedArray(R.array.letter_tile_colors);
    }

    @Override
    public SpeedDialAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.speeddial_item_layout,
                parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SpeedDialAdapter.ViewHolder holder, int position) {
        String text = mItems.get(position);
        holder.itemView.setBackgroundColor(getColor(text));
        holder.textView.setText(text);
    }

    private int getColor(String key) {
        final int color = Math.abs(key.hashCode()) % mColors.length();
        return mColors.getColor(color, Color.BLUE);
    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public View itemView;
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            textView = (TextView)itemView.findViewById(R.id.item_textview);
        }
    }
}
