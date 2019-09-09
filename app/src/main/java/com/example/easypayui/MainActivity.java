package com.example.easypayui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase getDatabase;
    private DatabaseReference getRefenence;

    Button btnRegister, btnLogin;
    EditText userName, password;
    TextView LoginPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegister = findViewById(R.id.btnRegister);
        btnLogin = findViewById(R.id.btnLogin);

        LoginPage = findViewById(R.id.LoginPageX);

        userName = findViewById(R.id.userName);
        password = findViewById(R.id.Password);

        getDatabase = FirebaseDatabase.getInstance();
        getRefenence = getDatabase.getReference();

        String userNameX = userName.getText().toString();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DataUser dataUser = ds.getValue(DataUser.class);
                //String username = ds.child("userName").getValue(String.class);
                final String userNameX = userName.getText().toString();
                final String passwordX = password.getText().toString();

                //String keyX = ds.child("userName").getValue(String.class);
                //String keyZ = ds.getKey();

                //LoginPage.setText(keyX);userNameX.equals(query) snapshot.getValue() != null

                final Query query = getRefenence.child("User").orderByChild("userName").equalTo(userNameX);
                final Query query1 = getRefenence.child("User").orderByChild("password").equalTo(passwordX);

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull final DataSnapshot dataSnapshotX) {

                        query1.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if(userNameX.equals("")){
                                    Toast.makeText(MainActivity.this, "Please input  username", Toast.LENGTH_SHORT).show();
                                }else if(passwordX.equals("")){
                                    Toast.makeText(MainActivity.this, "Please input  password", Toast.LENGTH_SHORT).show();
                                }else if(dataSnapshotX.getValue() == null){
                                    Toast.makeText(MainActivity.this, "Please input right username", Toast.LENGTH_SHORT).show();
                                }else if(dataSnapshot.getValue() == null){
                                    Toast.makeText(MainActivity.this, "Please input right password", Toast.LENGTH_SHORT).show();
                                }else{

                                    Intent x = new Intent(getApplicationContext(), HomePage.class);
                                    x.putExtra("userName", userNameX);
                                    startActivity(x);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(x);
            }
        });
    }
}
