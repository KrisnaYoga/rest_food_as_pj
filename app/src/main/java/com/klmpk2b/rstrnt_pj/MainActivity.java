package com.klmpk2b.rstrnt_pj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.klmpk2b.rstrnt_pj.Adapter_Makanan.ListMknnJpnAdapter;
import com.klmpk2b.rstrnt_pj.Makanan_Jepang.Mkn_Jpn;
import com.klmpk2b.rstrnt_pj.Makanan_Jepang.Mkn_Jpn_Data;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvCategory;
    //private ArrayList<Mkn_Idn> list_idn = new ArrayList<>();
    //private ArrayList<Mkn_Jpn> list_jpn = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        //list_idn.addAll(Mkn_Idn_Data.getListData());
        //showRecyclerListMknIdn();

        //list_jpn.addAll(Mkn_Jpn_Data.getListData());
        //showRecyclerListMknJpn();
    }

    //private void showRecyclerListMknIdn(){
  //      rvCategory.setLayoutManager(new LinearLayoutManager(this));
  //      ListMknnIdnAdapter listMknnIdnAdapter = new ListMknnIdnAdapter(this);
   //     listMknnIdnAdapter.setListMknIdn(list_idn);
    //    rvCategory.setAdapter(listMknnIdnAdapter);
    //}

    //private void showRecyclerListMknJpn(){
    //    rvCategory.setLayoutManager(new LinearLayoutManager(this));
    //    ListMknnJpnAdapter listMknnJpnAdapter = new ListMknnJpnAdapter(this);
     //   listMknnJpnAdapter.setListMknJpn(list_jpn);
     //   rvCategory.setAdapter(listMknnJpnAdapter);
    //}
}
