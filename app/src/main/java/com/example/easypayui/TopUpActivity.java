package com.example.easypayui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class TopUpActivity extends AppCompatActivity {

    Button btnBack;
    Spinner method;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);

        btnBack = findViewById(R.id.btnBack);

        method = findViewById(R.id.method);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.spinner_item, TopUp);
        adapter.setDropDownViewResource(R.layout.spinner_item);

        method.setAdapter(adapter);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private String[] TopUp = {
            "Top-Up From m-banking BCA", "Top-Up From m-banking BNI",
            "Top-Up From m-banking BRI", "Top-Up From m-banking BTN",
            "Top-Up From m-banking Indomaret", "Top-Up From m-banking Alfamart", "More.."
    };
}
