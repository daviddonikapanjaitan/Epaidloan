package com.example.easypayui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ConfirmationBuddiesLoanActivity extends AppCompatActivity  implements
        ListAdapterConfirmation.customButtonListener {

    ListView listViewXConf;
    ListAdapterConfirmation adapterXConf;
    ArrayList<String> dataItemsConf = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_buddies_loan);

        dataItemsConf.add("Username : Gabriel01\nPhone Number : 0811600666");
        dataItemsConf.add("Username : MichaelSmith\nPhone Number : 0811600777");
        dataItemsConf.add("Username : Suwotedjo\nPhone Number : 0811600888");
        dataItemsConf.add("Username : Soeharko\nPhone Number : 0811600999");

        listViewXConf = findViewById(R.id.listViewConfContact);

        adapterXConf = new ListAdapterConfirmation(ConfirmationBuddiesLoanActivity.this, dataItemsConf);
        adapterXConf.setCustomButtonListner((ListAdapterConfirmation.customButtonListener) ConfirmationBuddiesLoanActivity.this);

        listViewXConf.setAdapter(adapterXConf);
    }

    public void onButtonClickListner(int position , String value) {
        Toast.makeText(ConfirmationBuddiesLoanActivity.this, "Button click " + value,
                Toast.LENGTH_SHORT).show();
        if(position == 0){
            Toast.makeText(this, "Confirmation has been Process", Toast.LENGTH_SHORT).show();
        }else if(position == 1){
            Toast.makeText(this, "Deny it", Toast.LENGTH_SHORT).show();
        }
    }
}
