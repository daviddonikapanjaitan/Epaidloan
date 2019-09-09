package com.example.easypayui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class HomePage extends AppCompatActivity {

    ImageButton topuppro, transfer, billPayment, loanPage;
    Toolbar toolbar1;
    Button paymentHistory;
    TextView balance;

    private FirebaseDatabase getDatabase;
    private DatabaseReference getRefenence;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        balance = findViewById(R.id.balance);

        Intent intent = getIntent();
        final String userNameZ = intent.getStringExtra("userName");

        getDatabase = FirebaseDatabase.getInstance();
        getRefenence = getDatabase.getReference();

        final Query query = getRefenence.child("User").orderByChild("userName").equalTo(userNameZ);

        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                DataUser dataUser = dataSnapshot.getValue(DataUser.class);
                balance.setText("Balance : " + dataUser.getBalance());
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

        topuppro = findViewById(R.id.topup);

        transfer = findViewById(R.id.transfer);

        paymentHistory = findViewById(R.id.paymentHistory);

        billPayment = findViewById(R.id.billPayment);

        loanPage = findViewById(R.id.loanPage);

        billPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(getApplicationContext(), BillActivity.class);
                startActivity(x);
            }
        });

        topuppro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(getApplicationContext(), TopUpActivity.class);
                startActivity(x);
            }
        });

        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(getApplicationContext(), TransferActivity.class);
                x.putExtra("userName", userNameZ);
                startActivity(x);
            }
        });

        loanPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(getApplicationContext(), LoanActivity.class);
                startActivity(x);
            }
        });

        paymentHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(getApplicationContext(), HistoryActivity.class);
                startActivity(x);
            }
        });

        android.support.v7.widget.Toolbar toolbar;

        toolbar = findViewById(R.id.toolBar);
        toolbar.inflateMenu(R.menu.menu_item);

        toolbar.setOnMenuItemClickListener(new android.support.v7.widget.Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if(menuItem.getItemId()==R.id.LogOut){
                    finish();
                }else if(menuItem.getItemId()==R.id.confContact){
                    Intent x = new Intent(getApplicationContext(), ConfirmationContactActivity.class);
                    startActivity(x);
                }else if(menuItem.getItemId()==R.id.confRequest){
                    Intent x = new Intent(getApplicationContext(), ConfirmationRequestActivity.class);
                    startActivity(x);
                }else if(menuItem.getItemId()==R.id.loanBuddies){
                    Intent x = new Intent(getApplicationContext(), ConfirmationBuddiesLoanActivity.class);
                    startActivity(x);
                }else if(menuItem.getItemId()==R.id.Profile){
                    Intent x = new Intent(getApplicationContext(), ProfileActivity.class);
                    startActivity(x);
                }
                return false;
            }
        });
    }

}
