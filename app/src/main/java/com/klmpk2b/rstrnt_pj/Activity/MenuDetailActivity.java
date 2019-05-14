package com.klmpk2b.rstrnt_pj.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.klmpk2b.rstrnt_pj.R;

public class MenuDetailActivity extends AppCompatActivity {

    private  String nama_makanan , harga_makanan ,deskripsi_makanan , foto_makanan;
    private TextView text_nama_makanan , text_harga_makanan , text_deskripsi_makanan;
    private ImageView imageView_makanan;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);

        Intent makananIntent = getIntent();
        this.nama_makanan = makananIntent.getStringExtra("nama_makanan");
        this.deskripsi_makanan = makananIntent.getStringExtra("deskripsi_makanan");
        this.harga_makanan = makananIntent.getStringExtra("harga_makanan");
        this.foto_makanan = makananIntent.getStringExtra("foto_makanan");

        this.text_nama_makanan = (TextView) findViewById(R.id.nama_makanan);
        this.text_deskripsi_makanan = (TextView) findViewById(R.id.Deskripsi_makanan);
        this.text_harga_makanan = (TextView) findViewById(R.id.harga_makanan);
        this.imageView_makanan = (ImageView) findViewById(R.id.gambar_makanan);

        this.text_nama_makanan.setText(this.nama_makanan);
        this.text_deskripsi_makanan.setText(this.deskripsi_makanan);
        this.text_harga_makanan.setText(this.harga_makanan);

        Glide.with(this)
                .load(this.foto_makanan)
                .thumbnail(Glide.with(this).load(R.drawable.fried_egg_loader))
                .apply(new RequestOptions().override(490,430))
                .into(this.imageView_makanan);
    }

    public void beliMakanan(View view){
        Intent intent = new Intent(this, FormPembelianActivity.class);
        intent.putExtra("harga",this.harga_makanan);
        startActivity(intent);
    }
}
