package com.klmpk2b.rstrnt_pj;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


import java.util.ArrayList;

public class ListRestaurantAdapter extends RecyclerView.Adapter<ListRestaurantAdapter.CategoryViewHolder> {

    public ListRestaurantAdapter(Context context) {
        this.context = context;
    }

    private Context context;

    public ArrayList<Rest> getListRest() {
        return listRest;
    }

    public void setListRest(ArrayList<Rest> listRest) {
        this.listRest = listRest;
    }

    private ArrayList<Rest> listRest;

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemrow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_list_rest, viewGroup, false);
        return new CategoryViewHolder(itemrow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        categoryViewHolder.tvName.setText(getListRest().get(position).getNamerest());
        Glide.with(context)
                .load(getListRest().get(position).getPhotorest())
                .thumbnail(Glide.with(context).load(R.drawable.fried_egg_loader))
                .apply(new RequestOptions().override(490,430))
                .into(categoryViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListRest().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView imgPhoto;
        LinearLayout itemcontainer;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_item_name);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            itemcontainer = itemView.findViewById(R.id.item_container);
        }
    }
}
