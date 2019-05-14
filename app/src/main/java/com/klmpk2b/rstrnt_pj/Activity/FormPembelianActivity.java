package com.klmpk2b.rstrnt_pj.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.klmpk2b.rstrnt_pj.MainActivity;
import com.klmpk2b.rstrnt_pj.R;

public class FormPembelianActivity extends AppCompatActivity {

    private String harga;
    private TextInputLayout input_nama , input_alamat , input_jumlah , input_no_hp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_pembelian);

        Intent intent = getIntent();
        this.harga = intent.getStringExtra("harga");

        this.input_nama = (TextInputLayout) findViewById(R.id.input_nama);
        this.input_alamat = (TextInputLayout) findViewById(R.id.input_alamat);
        this.input_jumlah = (TextInputLayout) findViewById(R.id.input_jumlah);
        this.input_no_hp = (TextInputLayout) findViewById(R.id.input_Hp);
    }

    public void onConfirm(View view) {
        if(validate()){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Total Pembayaran anda "+ this.harga + " , Apakah anda setuju ?");
            builder.setTitle("Alert !");
            builder.setCancelable(false);



            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    onClickYes();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }


    }

    private void onClickYes(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Proses Pembayaran Success");
        builder.setTitle("Success !");
        builder.setCancelable(false);
        final Intent home = new Intent(this , MainActivity.class);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(home);
                finishAffinity();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private boolean validate(){
        boolean validasi = true;
        if(this.input_nama.getEditText().getText().toString().isEmpty()){
            this.input_nama.setError("Nama harus diisi");
            validasi = false;
        }
        else if(this.input_alamat.getEditText().getText().toString().isEmpty()){
            this.input_alamat.setError(" Alamat harus diisi");
            validasi = false;
        }
        else if(this.input_jumlah.getEditText().getText().toString().isEmpty()){
            this.input_jumlah.setError(" Jumlah Harus diisi");
            validasi = false;
        }
        else if(this.input_no_hp.getEditText().getText().toString().isEmpty()){
            this.input_no_hp.setError(" No Hp harus diisi");
            validasi = false;
        }

        return validasi;

    }
}
