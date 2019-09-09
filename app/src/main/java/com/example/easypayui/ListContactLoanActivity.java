package com.example.easypayui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListContactLoanActivity extends AppCompatActivity implements
        ListAdapter.customButtonListener{

    ListView listViewX;
    ListAdapter adapterX;
    ArrayList<String> dataItems = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contact_loan);

        dataItems.add("Username : DavidKeren\nPhone Number : 0811600178");
        dataItems.add("Username : BlackMonday\nPhone Number : 0811600871");
        dataItems.add("Username : BlackTuesDay\nPhone Number : 0811600123");
        dataItems.add("Username : BrownField\nPhone Number : 0811600321");
        dataItems.add("Username : MichaelJackson\nPhone Number : 0811600777");
        dataItems.add("Username : Nicholas\nPhone Number : 0811600888");
        dataItems.add("Username : Petrus\nPhone Number : 0811600999");

        listViewX = findViewById(R.id.listViewContact);

        //ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listArrayUserName);

        adapterX = new ListAdapter(ListContactLoanActivity.this, dataItems);
        adapterX.setCustomButtonListner((ListAdapter.customButtonListener) ListContactLoanActivity.this);

        listViewX.setAdapter(adapterX);
    }

    public void onButtonClickListner(int position , String value) {
        Toast.makeText(ListContactLoanActivity.this, "Button click " + value,
                Toast.LENGTH_SHORT).show();
        if(position == 1){
            Toast.makeText(this, "Buddies Remove", Toast.LENGTH_SHORT).show();
        }
    }
}
