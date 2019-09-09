package com.example.easypayui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MakeLoanActivity extends AppCompatActivity implements
        ListAdapterLoan.customButtonListener{

    ListView listViewX;
    ListAdapterLoan adapterX;
    ArrayList<String> dataItems = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_loan);

        dataItems.add("Username : Hamdani\nPhone Number : 0811600178\nRate : 0.5%/months\nPeriod : 1 months\nTotal : Rp 500.000\nMessage : Please give me a loan, i need some money\nRating: B");
        dataItems.add("Username : Fauzan\nPhone Number : 0811600871\nRate : 0.75%/months\nPeriod : 2 months\nTotal : Rp 450.000\nMessage : Hi My Brothers, please give me a loan, i want to buy some book\nRating: A");
        dataItems.add("Username : Michael\nPhone Number : 0811600123\nRate : 0.5%/months\nPeriod : 3 months\nTotal : Rp 500.000\nMessage : Hi My Best Friends, please give me some good money\nRating: C");
        dataItems.add("Username : Nicholas\nPhone Number : 0811600321\nRate : 0.25%/months\nPeriod : 2 months\nTotal : Rp 450.000\nMessage : I need some moeny for vacation\nRating: Risk");

        listViewX = findViewById(R.id.listViewConfContact);

        //ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listArrayUserName);

        adapterX = new ListAdapterLoan(MakeLoanActivity.this, dataItems);
        adapterX.setCustomButtonListner(MakeLoanActivity.this);

        listViewX.setAdapter(adapterX);
    }

    public void onButtonClickListner(int position , String value) {
        Toast.makeText(MakeLoanActivity.this, "Button click " + value,
                Toast.LENGTH_SHORT).show();
        if(position == 0){
            Toast.makeText(this, "Request Process", Toast.LENGTH_SHORT).show();
            Intent x = new Intent(getApplicationContext(), RequestMoneyActivity.class);
            startActivity(x);
        }else if(position == 1){
            Toast.makeText(this, "Sent Process", Toast.LENGTH_SHORT).show();
            Intent x = new Intent(getApplicationContext(), SentMoneyActivity.class);
            startActivity(x);
        }
    }
}
