package com.example.easypayui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ConfirmationRequestActivity extends AppCompatActivity implements
        ListAdapterRequest.customButtonListener {

    ListView listViewXReq;
    ListAdapterRequest adapterXReq;
    ArrayList<String> dataItemsReq = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_request);

        dataItemsReq.add("Username : Gabriel03\nPhone Number : 0811600233\nTotal Ask : Rp. 100.000\nMessage : Please give me some money brother");
        dataItemsReq.add("Username : MichaelJackson\nPhone Number : 0811600151\nTotal Ask : Rp. 150.000\nMessage : Help Me Mister, I need some Money");
        dataItemsReq.add("Username : Ramli\nPhone Number : 0811600232\nTotal Ask : Rp. 200.000\nMessage : This day my birthday, please give me money");
        dataItemsReq.add("Username : Pouyouno\nPhone Number : 0811600333\nTotal Ask : Rp. 300.000\nMessage : My Fried, still remember our lastest business ?");

        listViewXReq = findViewById(R.id.listViewRequest);

        adapterXReq = new ListAdapterRequest(ConfirmationRequestActivity.this, dataItemsReq);
        adapterXReq.setCustomButtonListner(ConfirmationRequestActivity.this);

        listViewXReq.setAdapter(adapterXReq);
    }

    public void onButtonClickListner(int position , String value) {
        Toast.makeText(ConfirmationRequestActivity.this, "Button click " + value,
                Toast.LENGTH_SHORT).show();
        if(position == 0){
            Toast.makeText(this, "Sent It", Toast.LENGTH_SHORT).show();
        }else if(position == 1){
            Toast.makeText(this, "Deny it", Toast.LENGTH_SHORT).show();
        }
    }
}
