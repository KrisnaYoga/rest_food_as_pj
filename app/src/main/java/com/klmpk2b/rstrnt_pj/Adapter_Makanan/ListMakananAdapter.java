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
import com.klmpk2b.rstrnt_pj.Makanan_Data.Makanan;
import com.klmpk2b.rstrnt_pj.R;

import java.util.ArrayList;

public class ListMakananAdapter extends RecyclerView.Adapter<ListMakananAdapter.CategoryViewHolder> {
    public ListMakananAdapter(Context context) {
        this.context = context;
    }

    private Context context;

    public ArrayList<Makanan> getListMakanan() {
        return listMakanan;
    }

    public void setListMakanan(ArrayList<Makanan> listMakanan) {
        this.listMakanan = listMakanan;
    }

    private ArrayList<Makanan> listMakanan;

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemrow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_menu_makanan, viewGroup, false);
        return new CategoryViewHolder(itemrow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        categoryViewHolder.tvName.setText(getListMakanan().get(position).getNamemkn());
        Glide.with(context)
                .load(getListMakanan().get(position).getPhoto())
                .thumbnail(Glide.with(context).load(R.drawable.fried_egg_loader))
                .apply(new RequestOptions().override(490,430))
                .into(categoryViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListMakanan().size();
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
