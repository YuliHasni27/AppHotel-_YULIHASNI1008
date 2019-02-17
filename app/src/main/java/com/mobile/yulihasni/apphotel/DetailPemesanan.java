package com.mobile.yulihasni.apphotel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class DetailPemesanan extends ActionBarActivity {
Button btnBackHome;
TextView txtDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pemesanan);
        btnBackHome=(Button)findViewById(R.id.btnBackHome);
        btnBackHome.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DetailPemesanan.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Konfirmasi Oke"+intent,Toast.LENGTH_LONG).show();
            }
        });
        txtDetail=(TextView)findViewById(R.id.txtDetailPesanan);
        Intent intent = getIntent();

        String detailpemesanan= (String)intent.getSerializableExtra("DetailPemesanan");
        txtDetail.setText(detailpemesanan);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail_pemesanan, menu);
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
