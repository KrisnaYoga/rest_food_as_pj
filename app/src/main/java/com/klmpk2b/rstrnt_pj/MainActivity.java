package com.klmpk2b.rstrnt_pj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.klmpk2b.rstrnt_pj.Adapter_Makanan.ListMakananAdapter;
import com.klmpk2b.rstrnt_pj.Makanan_Data.Makanan;
import com.klmpk2b.rstrnt_pj.Makanan_Data.Makanan_Data;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvCategory;
    private ArrayList<Makanan> list_makanan = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list_makanan.addAll(Makanan_Data.getListData());
        showRecyclerMenuList();

    }


    private void showRecyclerMenuList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListMakananAdapter listMakananAdapter = new ListMakananAdapter(this);
        listMakananAdapter.setListMakanan(list_makanan);
        rvCategory.setAdapter(listMakananAdapter);
    }

}
