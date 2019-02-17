package com.mobile.yulihasni.apphotel;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class Promo extends ActionBarActivity {
    Button btnpromo;
    TextView txtTampilHasil;
    Spinner spinnerpromo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo);
        btnpromo = (Button) findViewById(R.id.btnProsesPromo);
        spinnerpromo = (Spinner) findViewById(R.id.spinner1);
        txtTampilHasil = (TextView) findViewById(R.id.txtHasilPromo);
        btnpromo.setOnClickListener(new ActionPromo());
        ArrayAdapter<CharSequence> adater = ArrayAdapter.createFromResource(this, R.array.promo, android.R.layout.simple_spinner_item);
        adater.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerpromo.setAdapter(adater);
        spinnerpromo.setOnItemSelectedListener(new MyOnItemSelectedListener());
    }
    class ActionPromo implements View.OnClickListener {
        Double diskon, total, totaldiskon, harga = 15000.00;

        @Override
        public void onClick(View v) {
            String stringspinner = null;
            stringspinner = spinnerpromo.getSelectedItem().toString();
            Integer indexspinner = spinnerpromo.getSelectedItemPosition();
            if (indexspinner == 0) {
                total = harga * 3;
                diskon = 0.05 * total;
                totaldiskon = total - diskon;
                txtTampilHasil.setText("Anda Mendapatkan diskon "+stringspinner+
                        "\n Total:" + Double.toString(total) +
                        "\n Diskon:" + Double.toString(diskon) +
                        "\n Total Setelah Diskon:" + Double.toString(totaldiskon));
            } else if (indexspinner == 1) {
                total = harga * 7;
                diskon = 0.07 * total;
                totaldiskon = total - diskon;
                txtTampilHasil.setText("Anda Mendapatkan diskon "+stringspinner+
                        "\n Total:" + Double.toString(total) +
                        "\n Diskon:" + Double.toString(diskon) +
                        "\n Total Setelah Diskon:" + Double.toString(totaldiskon));
            } else if (indexspinner == 2) {
                total = harga * 10;
                diskon = 0.10 * total;
                totaldiskon = total - diskon;
                txtTampilHasil.setText("Anda Mendapatkan diskon "+stringspinner+
                        "\n Total:" + Double.toString(total) +
                        "\n Diskon:" + Double.toString(diskon) +
                        "\n Total Setelah Diskon:" + Double.toString(totaldiskon));
            } else if (indexspinner == 2) {
                total = harga * 15;
                diskon = 0.15 * total;
                totaldiskon = total - diskon;
                txtTampilHasil.setText("Anda Mendapatkan diskon "+stringspinner+
                        "\n Total:" + Double.toString(total) +
                        "\n Diskon:" + Double.toString(diskon) +
                        "\n Total Setelah Diskon:" + Double.toString(totaldiskon));

            } else {
                total = harga * 0.0;
                diskon = 0.0 * total;
                totaldiskon = total - diskon;
                txtTampilHasil.setText("Anda Mendapatkan diskon "+stringspinner+
                        "\n Total:" + Double.toString(total) +
                        "\n Diskon:" + Double.toString(diskon) +
                        "\n Total Setelah Diskon:" + Double.toString(totaldiskon));
            }
        }
    }

    class MyOnItemSelectedListener implements AdapterView.OnItemSelectedListener, AdapterView.OnClickListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(parent.getContext(), "Item :" + parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }

        @Override
        public void onClick(View v) {

        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_promo, menu);
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
