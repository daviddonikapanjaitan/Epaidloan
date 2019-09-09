package com.example.easypayui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class SentMoneyActivity extends AppCompatActivity {

    Button btnSentBroX, btnSentBack;
    TextView userNameFriend, phoneNumberSent;
    EditText totalMoneySent;

    private FirebaseDatabase getDatabase;
    private DatabaseReference getRefenence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sent_money);

        btnSentBroX = findViewById(R.id.btnSentBroX);
        btnSentBack = findViewById(R.id.btnSentBack);

        getDatabase = FirebaseDatabase.getInstance();
        getRefenence = getDatabase.getReference();

        userNameFriend = findViewById(R.id.userNameFriend);
        phoneNumberSent = findViewById(R.id.phoneNumberSent);
        totalMoneySent = findViewById(R.id.totalMoneySent);

        Intent intent = getIntent();
        final String userNameZ = intent.getStringExtra("userName");
        final String barcodeX = intent.getStringExtra("barcode");

        userNameFriend.setText("Username : " + barcodeX);

        final Query query = getRefenence.child("User").orderByChild("userName").equalTo(barcodeX);

        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                DataUser dataUser = dataSnapshot.getValue(DataUser.class);
                phoneNumberSent.setText("Phone : " + dataUser.getPhoneNumber());
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnSentBroX.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                getRefenence.child("User").orderByChild("userName").equalTo(barcodeX).addChildEventListener(new ChildEventListener() {
                    @Override

                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        final DataUser dataUser = dataSnapshot.getValue(DataUser.class);

                        getRefenence.child("User").orderByChild("userName").equalTo(userNameZ).addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(@NonNull DataSnapshot dataSnapshotX, @Nullable String s) {
                                DataUser dataUserX = dataSnapshotX.getValue(DataUser.class);
                                int totalMoneySentX = Integer.parseInt(totalMoneySent.getText().toString());

                                if(totalMoneySentX > dataUserX.getBalance()){
                                    Toast.makeText(SentMoneyActivity.this, "Your money not enough", Toast.LENGTH_SHORT).show();
                                }else{
                                    int receiver = dataUser.getBalance();
                                    int sender = dataUserX.getBalance();

                                    getRefenence.child("User").child(barcodeX).child("balance").setValue(receiver+totalMoneySentX);
                                    getRefenence.child("User").child(userNameZ).child("balance").setValue(sender-totalMoneySentX);

                                    Toast.makeText(SentMoneyActivity.this, "Money has been sent", Toast.LENGTH_SHORT).show();
                                    finish();
                                    Intent x = new Intent(getApplicationContext(), HomePage.class);
                                    x.putExtra("userName", userNameZ);
                                    startActivity(x);
                                }
                            }

                            @Override
                            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                            }

                            @Override
                            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                            }

                            @Override
                            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });



        btnSentBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
