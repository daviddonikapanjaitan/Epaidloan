package com.example.easypayui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    ListView listViewX;
    ArrayList<String> dataItems = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        listViewX = findViewById(R.id.listHistory);

        dataItems.add("EasyPay : Qr-Code (Request)\nFrom : Diaz\nTotal : + Rp. 50.000");
        dataItems.add("EasyPay : Qr-Code (Sent)\nTo : Ayam Geprek Jaksel\nTotal : - Rp. 50.000");
        dataItems.add("EasyPay : Bill\nTo : Allianz (Insurance)\nCode : 000073569436\nTotal : - Rp. 100.000");
        dataItems.add("EasyPay : Request\nFrom : Ryan\nTotal : + Rp. 50.000");
        dataItems.add("EasyPay : Top-Up\nTotal : + Rp. 100.000");
        dataItems.add("EasyPay : Bill\nTo : PLN\n Total : - Rp. 50.000");
        dataItems.add("EasyPay : Transfer\nTo : William\nTotal : - Rp. 50.000");
        dataItems.add("EasyPay : Top-Up\nTotal : + Rp. 100.000");

        listViewX.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, dataItems));
    }
}
