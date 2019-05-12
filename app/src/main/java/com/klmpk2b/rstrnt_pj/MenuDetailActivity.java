package com.klmpk2b.rstrnt_pj;

import android.app.ActionBar;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MenuDetailActivity extends AppCompatActivity {

    Button form_butt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);

        getIncomingIntent();
        form_butt = findViewById(R.id.goform);
    }

    private void getIncomingIntent(){
        String Img_Menu = getIntent().getStringExtra("img_menu");
        String Nama_Menu = getIntent().getStringExtra("nama_menu");
        String Desc_Menu = getIntent().getStringExtra("desc_menu");
        String Hrg_Menu = getIntent().getStringExtra("hrg_menu");

        setName(Img_Menu, Nama_Menu, Desc_Menu, Hrg_Menu);

    }

    private void setName(String Img_Menu, String Nama_Menu, String Desc_Menu, String Hrg_Menu){
        TextView nama_menu = findViewById(R.id.name_menu);
        nama_menu.setText(Nama_Menu);

        ImageView img_menu = findViewById(R.id.img_menu);
        Glide.with(this)
                .load(Img_Menu)
                .thumbnail(Glide.with(this).load(R.drawable.fried_egg_loader))
                .into(img_menu);

        TextView desc_menu = findViewById(R.id.desc_menu);
        desc_menu.setText(Desc_Menu);

        TextView hrg_menu = findViewById(R.id.hrg_menu);
        hrg_menu.setText(Hrg_Menu);
    }
}
