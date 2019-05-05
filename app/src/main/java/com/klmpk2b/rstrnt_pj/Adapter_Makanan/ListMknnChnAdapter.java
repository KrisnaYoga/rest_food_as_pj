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
import com.klmpk2b.rstrnt_pj.Menu_List_Makanan.Makanan_China.Mkn_Chn;
import com.klmpk2b.rstrnt_pj.R;

import java.util.ArrayList;

public class ListMknnChnAdapter extends RecyclerView.Adapter<ListMknnChnAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<Mkn_Chn> listMknChn;

    public ListMknnChnAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Mkn_Chn> getListMknChn() {
        return listMknChn;
    }

    public void setListMknChn(ArrayList<Mkn_Chn> listMknChn) {
        this.listMknChn = listMknChn;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemrow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_mknn_chn, viewGroup, false);
        return new CategoryViewHolder(itemrow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        categoryViewHolder.tvName.setText(getListMknChn().get(position).getNamemknchn());
        Glide.with(context)
                .load(getListMknChn().get(position).getPhotochn())
                .thumbnail(Glide.with(context).load(R.drawable.fried_egg_loader))
                .apply(new RequestOptions().override(490,430))
                .into(categoryViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListMknChn().size();
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
