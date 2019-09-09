package com.example.easypayui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class BillActivity extends AppCompatActivity {

    ImageButton bayarPLN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        bayarPLN = findViewById(R.id.bayarPLN);

        bayarPLN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(getApplicationContext(), BayarPlnActivity.class);
                startActivity(x);
            }
        });
    }
}
