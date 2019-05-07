package com.klmpk2b.rstrnt_pj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.klmpk2b.rstrnt_pj.Adapter_Makanan.ListMakananAdapter;
import com.klmpk2b.rstrnt_pj.Makanan_Data.Makanan;
import com.klmpk2b.rstrnt_pj.Makanan_Data.Makanan_Data;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvCategory;
    private ArrayList<Rest> list_rest = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list_rest.addAll(Rest_Data.getListData());
        showRecyclerRestList();

    }

    private void showSelectedAnime(Rest restaurant) {
        Intent intent = new Intent(this, Makanan_Activity.class);
        intent.putExtra("nama_restorant", restaurant.getNamerest());
        intent.putExtra("jenis_restaurant", restaurant.getJenisrest());
        Toast.makeText(this, "You Choose " + restaurant.getNamerest(), Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    private void showRecyclerRestList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListRestaurantAdapter listRestaurantAdapter = new ListRestaurantAdapter(this);
        listRestaurantAdapter.setListRest(list_rest);
        rvCategory.setAdapter(listRestaurantAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedAnime(list_rest.get(position));
            }
        });
    }
}
