package com.klmpk2b.rstrnt_pj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.balysv.materialripple.MaterialRippleLayout;

public class FormPembelianActivity extends AppCompatActivity implements View.OnClickListener {

    EditText jml_mkn;
    //MaterialRippleLayout konf;
    Button konf;
    String harga_asl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_pembelian);

        jml_mkn = findViewById(R.id.jumlah_makanan);
        konf = findViewById(R.id.lyt_next);

        konf.setOnClickListener(this);
        getIncomingIntent();
    }

    private void getIncomingIntent(){
        String Nama_Menu = getIntent().getStringExtra("nama_menu_mkn");
        String Harga_Asli = getIntent().getStringExtra("hrg_menu_mkn");
        setName(Nama_Menu, Harga_Asli);
        harga_asl = Harga_Asli;
    }

    private void setName(String Nama_Menu, String Harga_Asli){
        TextView nama_menu = findViewById(R.id.nama_menu_pilihan);
        nama_menu.setText(Nama_Menu);
        TextView harga_menu = findViewById(R.id.harga_menu_pilihan);
        harga_menu.setText(Harga_Asli);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()  == R.id.lyt_next) {
            String jumlah = jml_mkn.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(jumlah)) {
                isEmptyFields = true;
                jml_mkn.setError("Harus ada jumlah yang dibeli, Minimal 1");
            }

            Double jml_pil = toDouble(jumlah);
            Double hrg_asli = toDouble(harga_asl);

            if (jml_pil == null){
                isInvalidDouble = true;
                jml_mkn.setError("Jumlah harus valid");
            }

            if(!isEmptyFields && !isInvalidDouble){
                double total_Pembayaran = jml_pil * hrg_asli;
                int ttl = (int)total_Pembayaran;
                Toast.makeText(this, "Jumlah Yang Harus Dibayar " + ttl, Toast.LENGTH_SHORT).show();
            }
        }
    }

    Double toDouble(String str){
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException e){
            return null;
        }
    }
}
