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

    private void showSelectedMakanan(Makanan makanan){
        Intent intent = new Intent(this , DetailMakananActivity.class);
        intent.putExtra("nama_makanan",makanan.namemkn);
        intent.putExtra("harga_makanan",makanan.harga);
        intent.putExtra("deskripsi_makanan",makanan.description);
        intent.putExtra("foto_makanan", makanan.photo);
        startActivity(intent);
        Toast.makeText(this , makanan.namemkn,Toast.LENGTH_SHORT).show();
    }

    private void showRecyclerMenuList(){
        rvCategory2.setLayoutManager(new LinearLayoutManager(this));
        ListMakananAdapter listMakananAdapter = new ListMakananAdapter(this);
        listMakananAdapter.setListMakanan(list_makanan_tercategory);
        rvCategory2.setAdapter(listMakananAdapter);

        ItemClickSupport.addTo(rvCategory2).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedMakanan(list_makanan_tercategory.get(position));
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
