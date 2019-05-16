package com.klmpk2b.rstrnt_pj.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.klmpk2b.rstrnt_pj.MainActivity;
import com.klmpk2b.rstrnt_pj.R;

public class InvoiceActivity extends AppCompatActivity {

    private String Nama_Pb, Phone_Pb, Email_Pb, Alamat_Pb;
    private String nama_makanan, harga_makanan, jumlah_pbian, total_pbian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        Intent catchIntent = getIntent();
        this.Nama_Pb = catchIntent.getStringExtra("nama_pembeli");
        this.Phone_Pb = catchIntent.getStringExtra("phone_pembeli");
        this.Email_Pb = catchIntent.getStringExtra("email_pembeli");
        this.Alamat_Pb = catchIntent.getStringExtra("alamat_pembeli");
        this.nama_makanan = catchIntent.getStringExtra("nama_menu_mkn");
        this.harga_makanan = catchIntent.getStringExtra("harga");
        this.jumlah_pbian = catchIntent.getStringExtra("jumlah_pembelian");
        this.total_pbian = catchIntent.getStringExtra("total_pembelian");

        TextView nama_pb = findViewById(R.id.inv_nama_pb);
        nama_pb.setText(this.Nama_Pb);

        TextView ph_pb = findViewById(R.id.inv_phone_pb);
        ph_pb.setText(this.Phone_Pb);

        TextView em_pb = findViewById(R.id.inv_email_pb);
        em_pb.setText(this.Email_Pb);

        TextView al_pb = findViewById(R.id.inv_alamat_pb);
        al_pb.setText(this.Alamat_Pb);

        TextView nm_mkn = findViewById(R.id.inv_nama_makanan);
        nm_mkn.setText(this.nama_makanan);

        TextView hrg_mkn = findViewById(R.id.inv_harga_makanan);
        hrg_mkn.setText(this.harga_makanan);

        TextView jml_pb = findViewById(R.id.inv_jumlah_mkn);
        jml_pb.setText(this.jumlah_pbian);

        TextView ttl_pb = findViewById(R.id.inv_total_pbian);
        ttl_pb.setText(this.total_pbian);
    }

    public void onConfirm(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Total Pembayaran anda Rp. "+ this.total_pbian + " , Apakah anda setuju ?");
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

    private void onClickYes(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Proses Pembelian Success. Harap Segera Dibayar");
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
}
