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
import com.klmpk2b.rstrnt_pj.Menu_List_Makanan.Makanan_Indonesia.Mkn_Idn;
import com.klmpk2b.rstrnt_pj.R;

import java.util.ArrayList;

public class ListMknnIdnAdapter extends RecyclerView.Adapter<ListMknnIdnAdapter.CategoryViewHolder> {
    private ArrayList<Mkn_Idn> listMknIdn;
    private Context context;

    public ListMknnIdnAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Mkn_Idn> getListMknIdn() {
        return listMknIdn;
    }

    public void setListMknIdn(ArrayList<Mkn_Idn> listMknIdn) {
        this.listMknIdn = listMknIdn;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemrow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_mknn_idn, viewGroup, false);
        return new CategoryViewHolder(itemrow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        categoryViewHolder.tvName.setText(getListMknIdn().get(position).getNamemknidn());
        Glide.with(context)
                .load(getListMknIdn().get(position).getPhotoidn())
                .apply(new RequestOptions().override(490,430))
                .into(categoryViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListMknIdn().size();
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
