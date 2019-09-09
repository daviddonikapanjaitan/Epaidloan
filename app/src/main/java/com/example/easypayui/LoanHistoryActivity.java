package com.example.easypayui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class LoanHistoryActivity extends AppCompatActivity {

    ListView listViewX;
    ArrayList<String> dataItems = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_history);

        listViewX = findViewById(R.id.listLoanHistory);

        dataItems.add("Borrower : DavidKeren\nPhone Number : 0811600178\nTotal Loan : Rp. 1.000.000\nInterest Rate : 1%/months\nPeriod : 3 months\nStatus : On Process");
        dataItems.add("Lender : William\nPhone Number : 0811600177\nTotal Loan : Rp. 500.000\nInterest Rate : 3%/months\nPeriod : 2 months\nStatus : On Process");
        dataItems.add("Borrower : Michelle\nPhone Number : 0811600444\nTotal Loan : Rp. 700.000\nInterest Rate : 4%/months\nPeriod : 1 months\nStatus : On Process");
        dataItems.add("Lender : John\nPhone Number : 0811600555\nTotal Loan : Rp. 700.000\nInterest Rate : 5%/months\nPeriod : 1 months\nStatus : Success");
        dataItems.add("Borrower : Gutfreund\nPhone Number : 0811600666\nTotal Loan : Rp. 700.000\nInterest Rate : 2%/months\nPeriod : 1 months\nStatus : Success");
        dataItems.add("Borrower : George\nPhone Number : 0811600777\nTotal Loan : Rp. 700.000\nInterest Rate : 3%/months\nPeriod : 1 months\nStatus : Success");

        listViewX.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, dataItems));
    }
}
