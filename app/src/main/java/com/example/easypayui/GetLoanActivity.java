package com.example.easypayui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class GetLoanActivity extends AppCompatActivity implements
        ListAdapterGetLoan.customButtonListener{

    ListView listViewX;
    ListAdapterGetLoan adapterX;
    ArrayList<String> dataItems = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_loan);

        dataItems.add("Username : DavidKeren\nPhone Number : 0811600178");
        dataItems.add("Username : BlackMonday\nPhone Number : 0811600871");
        dataItems.add("Username : BlackTuesDay\nPhone Number : 0811600123");
        dataItems.add("Username : BrownField\nPhone Number : 0811600321");
        dataItems.add("Username : MichaelJackson\nPhone Number : 0811600777");
        dataItems.add("Username : Nicholas\nPhone Number : 0811600888");
        dataItems.add("Username : Petrus\nPhone Number : 0811600999");

        listViewX = findViewById(R.id.listGetLoan);

        //ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listArrayUserName);

        adapterX = new ListAdapterGetLoan(GetLoanActivity.this, dataItems);
        adapterX.setCustomButtonListner(GetLoanActivity.this);

        listViewX.setAdapter(adapterX);
    }

    @Override
    public void onButtonClickListner(int position, String value) {
        if(position == 0){
            Toast.makeText(this, "Request Loan", Toast.LENGTH_SHORT).show();
            Intent x = new Intent(getApplicationContext(), AggrementActivity.class);
            startActivity(x);
        }
    }
}
