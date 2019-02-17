package com.mobile.yulihasni.apphotel;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    Button btnRestaurant,btnProfil,btnPesan,btnPromo,btnSaran,btnExit,btnDetailPemesanan,btnList,btnBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRestaurant=(Button)findViewById(R.id.btnRestaurant);
        btnProfil=(Button)findViewById(R.id.btnProfil);
        btnPesan=(Button)findViewById(R.id.btnPesan);
        btnPromo=(Button)findViewById(R.id.btnPromo);

        btnSaran=(Button)findViewById(R.id.btnSaran);
        btnExit=(Button)findViewById(R.id.btnExit);
        btnDetailPemesanan=(Button)findViewById(R.id.btnDetailPemesanan);
        btnList = (Button)findViewById(R.id.btnList);
        btnBus=(Button)findViewById(R.id.btnBus);

        btnRestaurant.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                panggilAksiIntent(v);
            }
        });
        btnProfil.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                panggilAksiIntent(v);
            }
        });
        btnPromo.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                panggilAksiIntent(v);
            }
        });
        btnBus.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                panggilAksiIntent(v);
            }
        });
        btnPesan.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                panggilAksiIntent(v);
            }
        });
        btnSaran.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                panggilAksiIntent(v);
            }
        });

        btnList.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                panggilAksiIntent(v);
            }
        });
        btnExit.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                panggilAksiIntent(v);
            }
        });

    }

    public void panggilAksiIntent(View view){
        switch(view.getId()){
            case R.id.btnRestaurant :
                Intent intent = new Intent(MainActivity.this,Restaurant.class);
                startActivity(intent);
                break;
            case R.id.btnProfil:
                intent = new Intent(MainActivity.this,Profil.class);
                startActivity(intent);
                break;
            case R.id.btnBus :
                intent = new Intent(MainActivity.this,BusTravel.class);
                startActivity(intent);
                break;
            case R.id.btnSaran:
                intent = new Intent (MainActivity.this, KirimPesan.class);
                startActivity(intent);
                break;
            case R.id.btnPesan:
                intent = new Intent (MainActivity.this,PesanActivity.class);
                startActivity(intent);
                break;
            case R.id.btnPromo:
                intent = new Intent(MainActivity.this,Promo.class);
                startActivity(intent);
                break;
            case R.id.btnDetailPemesanan:
                intent = new Intent(MainActivity.this,DetailPemesanan.class);
                startActivity(intent);
                break;
            case R.id.btnList:
                intent = new Intent(MainActivity.this,ListMakanan.class);
                startActivity(intent);
                break;

            case R.id.btnExit:
                //program kondisi ketika tombol exit di klik
                final AlertDialog.Builder exitAplikasi = new AlertDialog.Builder(MainActivity.this);
                exitAplikasi.setMessage("Apakah Anda yakin ingin keluar ?").setCancelable(false).setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        /*Intent exit = new Intent(Intent.ACTION_MAIN);
                        exit.setFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                        exit.addCategory(Intent.CATEGORY_HOME);*/
                        MainActivity.this.finish();

                    }
                }).setNegativeButton("No", new AlertDialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog judul=exitAplikasi.create();
                judul.setTitle("Keluar Aplikasi");
                judul.show();
                break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
