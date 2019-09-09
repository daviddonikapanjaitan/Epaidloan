package com.example.easypayui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PayLoanActivity extends AppCompatActivity implements
        ListAdapterPaymentMonthly.customButtonListener {

    ListView listViewX;
    ListAdapterPaymentMonthly adapterX;
    ArrayList<String> dataItems = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_loan);

        dataItems.add("Username : DavidKeren\nPhone Number : 0811600178\nTotal Loan : Rp. 500.000\nInterest Rate : 0.5%/month \nPeriod : 3 months\nDue Date : 20 Jun 2019\nMonthly Payment : Rp. 166.597\nStatus : First Payment");
        dataItems.add("Username : William\nPhone Number : 0811600177\nTotal Loan : Rp. 450.000\nInterest Rate : 0.5%/month \nPeriod : 2 months\nDue Date : 25 Jun 2019\nMonthly Payment : Rp. 224.953\nStatus : First Payment");
        dataItems.add("Username : Michelle\nPhone Number : 0811600444\nTotal Loan : Rp. 500.000\nInterest Rate : 1%/month \nPeriod : 1 months\nDue Date : 30 Jun 2019\nMonthly Payment : Rp. 505.000\nStatus : First Payment");

        listViewX = findViewById(R.id.listViewPaymentLoan);

        //ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listArrayUserName);

        adapterX = new ListAdapterPaymentMonthly(PayLoanActivity.this, dataItems);
        adapterX.setCustomButtonListner((ListAdapterPaymentMonthly.customButtonListener) PayLoanActivity.this);

        listViewX.setAdapter(adapterX);
    }

    @Override
    public void onButtonClickListner(int position, String value) {

    }
}
