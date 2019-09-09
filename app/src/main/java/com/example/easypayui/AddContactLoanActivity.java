package com.example.easypayui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class AddContactLoanActivity extends AppCompatActivity implements
        ListAdapterAddContact.customButtonListener{

    ListView listViewX;
    ListAdapterAddContact adapterX;
    ArrayList<String> dataItems = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact_loan);

        listViewX = findViewById(R.id.listBuddiesLoan);

        dataItems.add("Username : DavidKeren\nPhone Number : 0811600178");
        dataItems.add("Username : BlackMonday\nPhone Number : 0811600871");
        dataItems.add("Username : BlackTuesDay\nPhone Number : 0811600123");
        dataItems.add("Username : BrownField\nPhone Number : 0811600321");
        dataItems.add("Username : MichaelJackson\nPhone Number : 0811600777");
        dataItems.add("Username : Nicholas\nPhone Number : 0811600888");
        dataItems.add("Username : Petrus\nPhone Number : 0811600999");

        adapterX = new ListAdapterAddContact(AddContactLoanActivity.this, dataItems);
        adapterX.setCustomButtonListner(AddContactLoanActivity.this);

        listViewX.setAdapter(adapterX);
    }

    @Override
    public void onButtonClickListner(int position, String value) {

    }
}
