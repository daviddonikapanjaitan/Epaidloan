package com.example.easypayui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddContactActivity extends AppCompatActivity implements
        ListAdapterAddContact.customButtonListener{

    Button btnAddContact, backToHomePage;

    ListView listViewX;
    ListAdapterAddContact adapterX;
    ArrayList<String> dataItems = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        listViewX = findViewById(R.id.listBuddies);

        dataItems.add("Username : DavidKeren\nPhone Number : 0811600178");
        dataItems.add("Username : BlackMonday\nPhone Number : 0811600871");
        dataItems.add("Username : BlackTuesDay\nPhone Number : 0811600123");
        dataItems.add("Username : BrownField\nPhone Number : 0811600321");
        dataItems.add("Username : MichaelJackson\nPhone Number : 0811600777");
        dataItems.add("Username : Nicholas\nPhone Number : 0811600888");
        dataItems.add("Username : Petrus\nPhone Number : 0811600999");

        btnAddContact = findViewById(R.id.btnAddContact);
        backToHomePage = findViewById(R.id.btnBack);

        adapterX = new ListAdapterAddContact(AddContactActivity.this, dataItems);
        adapterX.setCustomButtonListner(AddContactActivity.this);

        listViewX.setAdapter(adapterX);

        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddContactActivity.this, "Please wait until your friends or family accept the request", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        backToHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onButtonClickListner(int position, String value) {

    }
}
