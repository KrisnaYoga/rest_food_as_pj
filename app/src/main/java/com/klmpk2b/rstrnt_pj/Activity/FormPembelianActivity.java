package com.klmpk2b.rstrnt_pj.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.klmpk2b.rstrnt_pj.R;

public class FormPembelianActivity extends AppCompatActivity implements View.OnClickListener{

    /*Perhitungan*/
    EditText jml_mkn;
    Button konf;
    String harga_asl;

    /*Data Intent*/
    private String nama_makanan, harga_makanan;

    /*Data Input*/
    EditText Nm, Ph, Em, Al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_pembelian);

        /*Perhitungan*/
        jml_mkn = findViewById(R.id.jumlah_makanan);
        konf = findViewById(R.id.lyt_next);

        /*Data Input*/
        Nm = findViewById(R.id.nama_pembeli);
        Ph = findViewById(R.id.phone_pembeli);
        Em = findViewById(R.id.email_pembeli);
        Al = findViewById(R.id.alamat_pembeli);

        konf.setOnClickListener(this);

        /*Get Intent*/
        Intent makananIntent = getIntent();
        this.nama_makanan = makananIntent.getStringExtra("nama_menu_mkn");
        this.harga_makanan = makananIntent.getStringExtra("harga");
        this.harga_asl = makananIntent.getStringExtra("hrg_menu_mkn");

        /*Set TextView*/
        TextView nama_menu = findViewById(R.id.nama_menu_pilihan);
        nama_menu.setText(this.nama_makanan);
        TextView harga_menu = findViewById(R.id.harga_menu_pilihan);
        harga_menu.setText(this.harga_makanan);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()  == R.id.lyt_next) {
            String Nm_Pb = Nm.getText().toString().trim();
            String Ph_Pb = Ph.getText().toString().trim();
            String Em_Pb = Em.getText().toString().trim();
            String Al_Pb = Al.getText().toString().trim();
            String jumlah = jml_mkn.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;
            boolean validateemail = false;

            if (TextUtils.isEmpty(Nm_Pb)) {
                isEmptyFields = true;
                Nm.setError("Nama Pembeli Harus Diisi");
            }
            if (TextUtils.isEmpty(Ph_Pb)) {
                isEmptyFields = true;
                Ph.setError("No Handphone Pembeli Harus Diisi");
            }
            if (TextUtils.isEmpty(Em_Pb)) {
                isEmptyFields = true;
                Em.setError("Email Pembeli Harus Diisi");
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(Em_Pb).matches()){
                validateemail = true;
                Em.setError("Format Email Pembeli Harus Valid");
            }
            if (TextUtils.isEmpty(Al_Pb)) {
                isEmptyFields = true;
                Al.setError("Alamat Pembeli Harus Diisi");
            }
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

            if(!isEmptyFields && !isInvalidDouble && !validateemail){
                double total_Pembayaran = jml_pil * hrg_asli;
                int ttl = (int)total_Pembayaran;
                String total = Integer.toString(ttl);
                //Toast.makeText(this, "Jumlah Yang Harus Dibayar " + ttl, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, InvoiceActivity.class);
                intent.putExtra("nama_pembeli",Nm_Pb);
                intent.putExtra("phone_pembeli",Ph_Pb);
                intent.putExtra("email_pembeli",Em_Pb);
                intent.putExtra("alamat_pembeli",Al_Pb);
                intent.putExtra("nama_menu_mkn", this.nama_makanan);
                intent.putExtra("harga", this.harga_makanan);
                intent.putExtra("jumlah_pembelian", jumlah);
                intent.putExtra("total_pembelian", total);
                startActivity(intent);
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