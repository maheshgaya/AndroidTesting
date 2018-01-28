package com.maheshgaya.android.testspike.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.maheshgaya.android.testspike.R;
import com.maheshgaya.android.testspike.model.Item;

import java.util.List;

public class ListAdapter<T extends Item> extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private final List<T> mList;
    private final int mItemLayout;

    public ListAdapter(int itemLayout, List<T> list) {
        this.mItemLayout = itemLayout;
        this.mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup holder, int position) {
        View itemView = LayoutInflater.from(holder.getContext())
                .inflate(mItemLayout, holder, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setTitle(mList.get(position).getTitle());
        holder.setDescription(mList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    Item getItem(int position) {
        return mList.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView descriptionTextView;

        ViewHolder(View itemView) {
            super(itemView);
            this.titleTextView = itemView.findViewById(R.id.item_title);
            this.descriptionTextView = itemView.findViewById(R.id.item_description);
        }

        void setTitle(String title) {
            titleTextView.setText(title);
        }

        void setDescription(String description) {
            descriptionTextView.setText(description);
        }
    }
}
