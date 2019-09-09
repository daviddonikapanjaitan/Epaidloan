package com.example.easypayui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RequestMoneyActivity extends AppCompatActivity {

    Button btnRequestBroX, btnBackToBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_money);

        btnRequestBroX = findViewById(R.id.btnRequestBroX);

        btnBackToBack = findViewById(R.id.btnBackToBack);

        btnRequestBroX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RequestMoneyActivity.this, "Your request has been process", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        btnBackToBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
