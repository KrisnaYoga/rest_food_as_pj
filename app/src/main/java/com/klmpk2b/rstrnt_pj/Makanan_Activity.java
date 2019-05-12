package com.klmpk2b.rstrnt_pj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.klmpk2b.rstrnt_pj.Adapter.ListMakananAdapter;
import com.klmpk2b.rstrnt_pj.Data.Makanan_Data.Makanan;
import com.klmpk2b.rstrnt_pj.Data.Makanan_Data.Makanan_Data;

import java.util.ArrayList;

public class Makanan_Activity extends AppCompatActivity {

    private String nama_restaurant , jenis_restaurant;

    private RecyclerView rvCategory2;
    private ArrayList<Makanan> list_makanan = new ArrayList<>();
    private ArrayList<Makanan> list_makanan_tercategory = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan);

        Intent intent = getIntent();
        this.nama_restaurant = intent.getStringExtra("nama_restaurant");
        this.jenis_restaurant = intent.getStringExtra("jenis_restaurant");
        rvCategory2 = findViewById(R.id.rv_category2);
        rvCategory2.setHasFixedSize(true);

        list_makanan.addAll(Makanan_Data.getListData());
        select_list_makanan();
        showRecyclerMenuList();
    }

    private void showSelectedMenu(Makanan makanan){

        Intent intent = new Intent(this, MenuDetailActivity.class);
        intent.putExtra("img_menu", makanan.getPhoto());
        intent.putExtra("nama_menu", makanan.getNamemkn());
        intent.putExtra("desc_menu", makanan.getDescmkn());
        intent.putExtra("hrg_menu", makanan.getHarga());

        Toast.makeText(this, "You Choose " + makanan.getNamemkn(), Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    private void showRecyclerMenuList(){
        rvCategory2.setLayoutManager(new LinearLayoutManager(this));
        ListMakananAdapter listMakananAdapter = new ListMakananAdapter(this);
        listMakananAdapter.setListMakanan(list_makanan_tercategory);
        rvCategory2.setAdapter(listMakananAdapter);

        ItemClickSupport.addTo(rvCategory2).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedMenu(list_makanan_tercategory.get(position));
                /*
                Intent intent = new Intent(this, MenuDetailActivity.class);
                intent.putExtra("img_menu",Makanan_Data.getListData().get(position).getPhoto();
                intent.putExtra("nama_menu",Makanan_Data.getListData().get(position).getNamemkn();
                intent.putExtra("desc_menu",Makanan_Data.getListData().get(position).getDescmkn();
                startActivity(intent);
                */
            }
        });
    }

    private void select_list_makanan(){
        //melempar atau menaruh semua yg ada d list makanan ke variable item
        for (Makanan item: list_makanan) {
            //membandingkan yang sudah di variable item dengan yg di rest
            if(item.jenis.equals(this.jenis_restaurant)){
                this.list_makanan_tercategory.add(item);
            }
        }
    }

}
