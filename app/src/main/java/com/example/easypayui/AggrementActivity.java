package com.example.easypayui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AggrementActivity extends AppCompatActivity {

    Spinner interest, period;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aggrement);

        interest = findViewById(R.id.interest);
        period = findViewById(R.id.period);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.spinner_item, rate1);
        adapter.setDropDownViewResource(R.layout.spinner_item);

        // mengeset Array Adapter tersebut ke Spinner
        interest.setAdapter(adapter);

        final ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,
                R.layout.spinner_item, period1);
        adapter1.setDropDownViewResource(R.layout.spinner_item);

        // mengeset Array Adapter tersebut ke Spinner
        period.setAdapter(adapter1);
    }

    private String[] rate1 = {
            "0.5%","0.6%","0.7%","0.8%","0.9%","1%"
    };

    private String[] period1 = {
            "1 months","2 months","3 months","4 months","5 months","6 months"
    };
}
