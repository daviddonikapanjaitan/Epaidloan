package com.example.easypayui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class LoanActivity extends AppCompatActivity {

    ImageButton giveLoan, requestLoan, paymentLoan, addContactLoan, listContactLoan, moreInfo;
    Button btnLoanHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan);

        giveLoan = findViewById(R.id.giveLoan);
        requestLoan = findViewById(R.id.requestLoan);
        paymentLoan = findViewById(R.id.paymentLoan);
        addContactLoan = findViewById(R.id.addContactLoan);
        listContactLoan = findViewById(R.id.listContactLoan);
        moreInfo = findViewById(R.id.moreInfo);
        btnLoanHistory = findViewById(R.id.btnLoanHistory);

        btnLoanHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(getApplicationContext(), LoanHistoryActivity.class);
                startActivity(x);
            }
        });

        giveLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(getApplicationContext(), MakeLoanActivity.class);
                startActivity(x);
            }
        });

        requestLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(getApplicationContext(), GetLoanActivity.class);
                startActivity(x);
            }
        });

        paymentLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(getApplicationContext(), PayLoanActivity.class);
                startActivity(x);
            }
        });

        addContactLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(getApplicationContext(), AddContactLoanActivity.class);
                startActivity(x);
            }
        });

        listContactLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(getApplicationContext(), ListContactLoanActivity.class);
                startActivity(x);
            }
        });

        moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(getApplicationContext(), MoreInfoActivity.class);
                startActivity(x);
            }
        });
    }
}
