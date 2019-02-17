package com.mobile.yulihasni.apphotel;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class Restaurant extends Activity implements View.OnClickListener {
    TextView noStruk,nama,meja,pesanan,detail;
    EditText eNoStruk,eNama,eMeja,eJum1,eJum2,eJum3,eJum4,eJum5,eJum6,eHrg1,eHrg2,eHrg3,eHrg4,eHrg5,eHrg6;
    CheckBox cBakso,cNasgor,cAnekaMie,cJus,cEsTeh,cEscream;
    RadioGroup rgPesan;
    RadioButton rbBreakfast, rbLunch, rbDinner;
    String pesanmakanan;
    double tBakso,tNasi,tMie,tJus,tEsteh,tIce,jumBakso,jumNasgor,jumMie,jumJus,jumEsteh,jumIce;
    double totalMakanan,totalMinuman,Total,pajak,diskon,bayar;
    EditText TotMakanan,TotMinuman,pjk,dis,byr,tot;
    Button submit;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        cBakso      = (CheckBox) findViewById(R.id.cboBakso);
        cNasgor     = (CheckBox) findViewById(R.id.cboNasgor);
        cAnekaMie   = (CheckBox) findViewById(R.id.cboMie);
        cJus        = (CheckBox) findViewById(R.id.cboJus);
        cEsTeh      = (CheckBox) findViewById(R.id.cboEsTeh);
        cEscream    = (CheckBox) findViewById(R.id.cboEsCream);

        rgPesan = (RadioGroup)findViewById(R.id.rgPesan);

        rbBreakfast  = (RadioButton) findViewById(R.id.rbBreakfast);
        rbLunch  = (RadioButton) findViewById(R.id.rbLunch);
        rbDinner    = (RadioButton) findViewById(R.id.rbDinner);

        detail         = (TextView) findViewById(R.id.txtOutput) ;

        eNoStruk    = (EditText) findViewById(R.id.editNo);
        eNama       = (EditText) findViewById(R.id.editNama);
        eMeja       = (EditText) findViewById(R.id.editMeja);

        eJum1       = (EditText) findViewById(R.id.editJumlah1);
        eJum2       = (EditText) findViewById(R.id.editJumlah2);
        eJum3       = (EditText) findViewById(R.id.editJumlah3);
        eJum4       = (EditText) findViewById(R.id.editJumlah4);
        eJum5       = (EditText) findViewById(R.id.editJumlah5);
        eJum6       = (EditText) findViewById(R.id.editJumlah6);

        eHrg1       = (EditText) findViewById(R.id.editHarga1);
        eHrg2       = (EditText) findViewById(R.id.editHarga2);
        eHrg3       = (EditText) findViewById(R.id.editHarga3);
        eHrg4       = (EditText) findViewById(R.id.editHarga4);
        eHrg5       = (EditText) findViewById(R.id.editHarga5);
        eHrg6       = (EditText) findViewById(R.id.editHarga6);

        TotMakanan = (EditText) findViewById(R.id.editTotalMakanan);
        TotMinuman = (EditText) findViewById(R.id.editTotalMinuman);
        pjk      = (EditText) findViewById(R.id.editPajak);
        dis     = (EditText) findViewById(R.id.editDiskon);
        byr      = (EditText) findViewById(R.id.editBayar);
        tot = (EditText)findViewById(R.id.editTotal);

        submit      = (Button) findViewById(R.id.btnProses);
        submit.setOnClickListener(this);
    }

    private void PilihanPesanan(){
        if(rbBreakfast.isChecked())
            pesanmakanan=rbBreakfast.getText().toString();
        else if(rbLunch.isChecked())
            pesanmakanan=rbLunch.getText().toString();
        else if(rbDinner.isChecked())
            pesanmakanan=rbDinner.getText().toString();
        else
            Toast.makeText(getApplicationContext(), "Anda belum memilih pilhan pesanan", Toast.LENGTH_LONG).show();
    }


    private void PilihanMakanan(){
        if(cBakso.isChecked()){
            jumBakso=Double.parseDouble(eJum1.getText().toString());
            tBakso=jumBakso*13000;
            eHrg1.setText(Double.toString(tBakso));

        } else {
            tBakso=0.0;
        }
        if(cNasgor.isChecked()){
            jumNasgor   = Double.parseDouble(eJum2.getText().toString());
            tNasi       = jumNasgor*12000;
            eHrg2.setText(Double.toString(tNasi));
        } else {
            tNasi=0.0;
        }
        if(cAnekaMie.isChecked()){
            jumMie  = Double.parseDouble(eJum3.getText().toString());
            tMie    = jumMie*8000;
            eHrg3.setText(Double.toString(tMie));
        } else {
            tMie=0.0;
        }
        if(!cBakso.isChecked()&&!cNasgor.isChecked()&&!cAnekaMie.isChecked()){
            Toast.makeText(getApplicationContext(),"anda belum memilih makanan",Toast.LENGTH_SHORT).show();
        }

    }
    private void PilihanMinuman(){
        if(cJus.isChecked()){
            jumJus = Integer.parseInt(eJum4.getText().toString());
            tJus = jumJus*8000;
            eHrg4.setText(Double.toString(tJus));
        } else {
            tJus=0.0;
        }
        if(cEsTeh.isChecked()){
            jumEsteh = Integer.parseInt(eJum5.getText().toString());
            tEsteh = jumEsteh*5000;
            eHrg5.setText(Double.toString(tEsteh));
        }else{
            tEsteh=0.0;
        }
        if(cEscream.isChecked()){
            jumIce = Integer.parseInt(eJum6.getText().toString());
            tIce = jumIce*10000;
            eHrg6.setText(Double.toString(tIce));
        } else{
            tIce=0.0;
        }
        if(!cJus.isChecked()&&!cEsTeh.isChecked()&&!cEscream.isChecked())
            Toast.makeText(getApplicationContext(),"Anda belum memilih Minuman",Toast.LENGTH_SHORT).show();
    }
    private void Pembayaran(){
        PilihanMakanan();
        PilihanMinuman();
        totalMakanan = tBakso + tNasi + tMie;
        totalMinuman = tEsteh + tJus + tIce;

        //TotMakanan.setText(Double.toString(totalMakanan));
        //TotMinuman.setText(Double.toString(totalMinuman));
        Total = totalMakanan+totalMinuman;
        pajak = 0.1 * Total;
        if(Total>100000){
            diskon = 0.05 * Total;
        }else{
            diskon = 0;
        }
        bayar = Total +pajak-diskon;

    }

    public void onClick(View v) {
        PilihanMakanan();
        PilihanPesanan();
        PilihanMinuman();
        Pembayaran();
        TotMakanan.setText(Double.toString(totalMakanan));
        TotMinuman.setText(Double.toString(totalMinuman));
        tot.setText(Double.toString(Total));
        pjk.setText(Double.toString(pajak));
        dis.setText(Double.toString(diskon));
        byr.setText(Double.toString(bayar));
        detail.setText("\n No Struk      : "+eNoStruk.getText().toString()+
                "\n Nama          : "+eNama.getText().toString()+
                "\n Meja          : "+eMeja.getText().toString()+
                "\n Pesanan       : "+ pesanan +
                "\n Total Makanan : "+Double.toString(totalMakanan)+
                "\n Total Minuman : "+Double.toString(totalMinuman)+
                "\n Total         : "+Double.toString(Total)+
                "\n Pajak         : "+Double.toString(pajak)+
                "\n Diskon        : "+Double.toString(diskon)+
                "\n Bayar         : "+Double.toString(bayar));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_restaurant, menu);
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
