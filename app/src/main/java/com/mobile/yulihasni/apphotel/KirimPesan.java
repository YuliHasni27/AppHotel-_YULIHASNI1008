package com.mobile.yulihasni.apphotel;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class KirimPesan extends ActionBarActivity {
    Button kirimpesan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kirim_pesan);
        kirimpesan=(Button)findViewById(R.id.btnKirim);
        kirimpesan.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                //program kondisi ketika tombol exit di klik
                final AlertDialog.Builder exitAplikasi = new AlertDialog.Builder(KirimPesan.this);
                exitAplikasi.setMessage("Kami telah menerima saran anda \n Apakah anda ingin keluar?").setCancelable(false).setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        /*Intent exit = new Intent(Intent.ACTION_MAIN);
                        exit.setFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                        exit.addCategory(Intent.CATEGORY_HOME);*/
                        KirimPesan.this.finish();

                    }
                }).setNegativeButton("No", new AlertDialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog judul=exitAplikasi.create();
                judul.setTitle("Keluar Dari Saran");
                judul.show();

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_kirim_pesan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
