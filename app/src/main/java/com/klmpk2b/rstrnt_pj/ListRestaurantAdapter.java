package com.klmpk2b.rstrnt_pj;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ListRestaurantAdapter extends RecyclerView.Adapter<ListRestaurantAdapter.CategoryViewHolder> {

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
