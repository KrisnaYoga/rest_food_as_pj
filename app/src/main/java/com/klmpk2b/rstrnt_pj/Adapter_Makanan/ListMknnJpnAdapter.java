package com.klmpk2b.rstrnt_pj.Adapter_Makanan;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.klmpk2b.rstrnt_pj.Makanan_Jepang.Mkn_Jpn;
import com.klmpk2b.rstrnt_pj.R;

import java.util.ArrayList;

public class ListMknnJpnAdapter extends RecyclerView.Adapter<ListMknnJpnAdapter.CategoryViewHolder> {
    public ListMknnJpnAdapter(Context context) {
        this.context = context;
    }

    private Context context;

    public ArrayList<Mkn_Jpn> getListMknJpn() {
        return listMknJpn;
    }

    public void setListMknJpn(ArrayList<Mkn_Jpn> listMknJpn) {
        this.listMknJpn = listMknJpn;
    }

    private ArrayList<Mkn_Jpn> listMknJpn;

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemrow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_mknn_jpn, viewGroup, false);
        return new ListMknnJpnAdapter.CategoryViewHolder(itemrow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        categoryViewHolder.tvName.setText(getListMknJpn().get(position).getNamemknjpn());
        Glide.with(context)
                .load(getListMknJpn().get(position).getPhotojpn())
                .apply(new RequestOptions().override(490,430))
                .into(categoryViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListMknJpn().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView imgPhoto;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
