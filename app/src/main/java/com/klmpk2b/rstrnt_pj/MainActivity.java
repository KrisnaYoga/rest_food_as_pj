package com.klmpk2b.rstrnt_pj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.klmpk2b.rstrnt_pj.Adapter_Makanan.ListMknnChnAdapter;
import com.klmpk2b.rstrnt_pj.Makanan_China.Mkn_Chn;
import com.klmpk2b.rstrnt_pj.Makanan_China.Mkn_Chn_Data;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvCategory;
    //private ArrayList<Mkn_Idn> list_idn = new ArrayList<>();
    //private ArrayList<Mkn_Jpn> list_jpn = new ArrayList<>();
    //private ArrayList<Mkn_Chn> list_chn = new ArrayList<>();
    private ArrayList<Mkn_Kor> list_kor = new ArrayList<>();

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

        //list_chn.addAll(Mkn_Chn_Data.getListData());
        //showRecyclerListMknJpn();

        list_kor.addAll(Mkn_Kor_Data.getListData());
        showRecyclerListMknKor();
    }

    //private void showRecyclerListMknIdn(){
        //rvCategory.setLayoutManager(new LinearLayoutManager(this));
        //ListMknnIdnAdapter listMknnIdnAdapter = new ListMknnIdnAdapter(this);
        //listMknnIdnAdapter.setListMknIdn(list_idn);
        //rvCategory.setAdapter(listMknnIdnAdapter);
    //}

    //private void showRecyclerListMknJpn(){
        //rvCategory.setLayoutManager(new LinearLayoutManager(this));
        //ListMknnJpnAdapter listMknnJpnAdapter = new ListMknnJpnAdapter(this);
        //listMknnJpnAdapter.setListMknJpn(list_jpn);
        //rvCategory.setAdapter(listMknnJpnAdapter);
    //}

    //private void showRecyclerListMknJpn(){
        //rvCategory.setLayoutManager(new LinearLayoutManager(this));
        //ListMknnChnAdapter listMknnChnAdapter = new ListMknnChnAdapter(this);
        //listMknnChnAdapter.setListMknChn(list_chn);
        //rvCategory.setAdapter(listMknnChnAdapter);
    //}

    private void showRecyclerListMknKor(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListMknnKorAdapter listMknnKorAdapter = new ListMknnKorAdapter(this);
        listMknnKorAdapter.setListMknKor(list_kor);
        rvCategory.setAdapter(listMknnKorAdapter);
    }
}
