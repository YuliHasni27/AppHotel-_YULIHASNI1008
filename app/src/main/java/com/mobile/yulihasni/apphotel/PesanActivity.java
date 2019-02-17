package com.mobile.yulihasni.apphotel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class PesanActivity extends ActionBarActivity {
    Button pesan;
    EditText edit_booking,edit_tglcheck,edit_lamainap,edit_kamar,edit_tamu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);
        edit_booking=(EditText)findViewById(R.id.editNoBooking);
        edit_tglcheck=(EditText)findViewById(R.id.editChekIn);
        edit_lamainap=(EditText)findViewById(R.id.editLamaInap);
        edit_kamar=(EditText)findViewById(R.id.editKamar);
        edit_tamu=(EditText)findViewById(R.id.editTotTamu);
        pesan=(Button)findViewById(R.id.btnPesanHotel);
        pesan.setOnClickListener(new ActionProsesPesan());
    }
    class ActionProsesPesan implements View.OnClickListener {
        String no_booking, tgl_chekin,lama_menginap,total_tamu, kamar;

        @Override
        public void onClick(View v) {
            no_booking=edit_booking.getText().toString();
            tgl_chekin=edit_tglcheck.getText().toString();
            lama_menginap=edit_lamainap.getText().toString();
            total_tamu=edit_tamu.getText().toString();
            kamar=edit_kamar.getText().toString();
            Intent intent = new Intent(PesanActivity.this,DetailPemesanan.class);

            intent.putExtra("DetailPemesanan",
                    "\nNo Booking         : "+no_booking+
                            "\nTgl Checkin : "+tgl_chekin+
                            "\nLama Menginap        : "+lama_menginap+
                            "\nTotal        : "+total_tamu+
                            "\nKamar      : "+kamar);

            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pesan, menu);
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
