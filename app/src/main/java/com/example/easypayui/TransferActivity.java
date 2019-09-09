package com.example.easypayui;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class TransferActivity extends AppCompatActivity {

    Button btnBack;
    ImageButton kirim, requestTransferPage, addContact, listContact;
    TextView balanceId;

    private FirebaseDatabase getDatabase;
    private DatabaseReference getRefenence;

    public static final int REQUEST_CODE = 100;
    public static final int PERMISSION_REQUEST = 200;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);

        Intent intent = getIntent();
        final String userNameZ = intent.getStringExtra("userName");

        balanceId = findViewById(R.id.balanceId);

        getDatabase = FirebaseDatabase.getInstance();
        getRefenence = getDatabase.getReference();

        final Query query = getRefenence.child("User").orderByChild("userName").equalTo(userNameZ);

        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                DataUser dataUser = dataSnapshot.getValue(DataUser.class);
                balanceId.setText("Balance : " + dataUser.getBalance());
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

        btnBack = findViewById(R.id.btnBackTransfer);

        kirim = findViewById(R.id.bayarQrCode);

        addContact = findViewById(R.id.addContact);

        listContact = findViewById(R.id.listContact);

        requestTransferPage = findViewById(R.id.requestTransferPage);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST);
        }

        addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(getApplicationContext(), AddContactActivity.class);
                startActivity(x);
            }
        });

        kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(getApplicationContext(), Scanner.class);
                //startActivity(x);
                x.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                x.putExtra("userName", userNameZ);
                startActivityForResult(x, REQUEST_CODE);
            }
        });

        requestTransferPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(getApplicationContext(), QrCodeActivity.class);
                x.putExtra("userName", userNameZ);
                startActivity(x);
            }
        });

        listContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(getApplicationContext(), ListContactActivity.class);
                startActivity(x);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /*
        *android.support.v7.widget.Toolbar toolbar;

        toolbar = findViewById(R.id.toolBar);
        toolbar.inflateMenu(R.menu.menu_item);

        toolbar.setOnMenuItemClickListener(new android.support.v7.widget.Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if(menuItem.getItemId()==R.id.LogOut){
                    finish();
                }else if(menuItem.getItemId()==R.id.QrCode){
                    Intent x = new Intent(getApplicationContext(), QrCodeActivity.class);
                    startActivity(x);
                }
                return false;
            }
        });
        * */
    }
}
