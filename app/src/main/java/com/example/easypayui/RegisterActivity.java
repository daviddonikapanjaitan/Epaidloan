package com.example.easypayui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    Button btnBack, btnRegister;
    Spinner date, month, year;

    EditText nikKTP, userName, Password, Name, pin, phoneNumber;

    private String getNikKTP, getUserName, getPassword, getName, getPin, getPhoneNumber;

    private FirebaseDatabase database;
    private DatabaseReference getReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnBack = findViewById(R.id.btnBack);
        btnRegister = findViewById(R.id.btnRegister);

        date = findViewById(R.id.date);
        month = findViewById(R.id.month);
        year = findViewById(R.id.year);

        nikKTP = findViewById(R.id.nikKTP);
        userName = findViewById(R.id.userName);
        Password = findViewById(R.id.Password);
        Name = findViewById(R.id.Name);
        pin = findViewById(R.id.pin);
        phoneNumber = findViewById(R.id.phoneNumber);

        database = FirebaseDatabase.getInstance();

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.spinner_item, date1);
        adapter.setDropDownViewResource(R.layout.spinner_item);

        // mengeset Array Adapter tersebut ke Spinner
        date.setAdapter(adapter);

        final ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,
                R.layout.spinner_item, month1);
        adapter1.setDropDownViewResource(R.layout.spinner_item);

        // mengeset Array Adapter tersebut ke Spinner
        month.setAdapter(adapter1);

        final ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this,
                R.layout.spinner_item, Years1);
        adapter2.setDropDownViewResource(R.layout.spinner_item);

        // mengeset Array Adapter tersebut ke Spinner
        year.setAdapter(adapter2);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNikKTP = nikKTP.getText().toString();
                getUserName = userName.getText().toString();
                getPassword = Password.getText().toString();
                getName = Name.getText().toString();
                getPin = pin.getText().toString();
                getPhoneNumber = phoneNumber.getText().toString();
                int getBalance = 1000000;

                getReference = database.getReference();
                String key =  getReference.push().getKey();
                getReference.child("User").child(getUserName)
                        .setValue(new DataUser( getNikKTP, getUserName, getPassword, getName, getPin, getPhoneNumber, getBalance));

                finish();
                Toast.makeText(RegisterActivity.this, "Thanks to Register, Please Login", Toast.LENGTH_SHORT).show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private String[] date1 = {
            "01","02","03","04","05","06","07","08","09","10",
            "11","12","13","14","15","16","17","18","19","20",
            "21","22","23","24","25","26","27","28","29","30",
            "31"
    };

    private String[] month1 = {
            "January","Febuary","March","April","May","June","July",
            "August","September","October","November","Desember"
    };

    public String[] Years1 = {
            "1971","1972","1973","1974","1975","1976","1977","1978","1979","1980",
            "1981","1982","1983","1984","1985","1986","1987","1988","1989","1990",
            "1991","1992","1993","1994","1995","1996","1997","1998","1999","2000",
            "2001","2002","2003","2004","2005","2006","2007","2008","2009","2010"
    };
}
