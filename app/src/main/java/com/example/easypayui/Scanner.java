package com.example.easypayui;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;

public class Scanner extends AppCompatActivity {

    SurfaceView cameraView;
    BarcodeDetector barcode;
    CameraSource cameraSource;
    SurfaceHolder holder;
    ImageButton qrCode, contactBuddiesX;

    private FirebaseDatabase getDatabase;
    private DatabaseReference getRefenence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        Intent intent = getIntent();
        final String userNameZ = intent.getStringExtra("userName");

        getDatabase = FirebaseDatabase.getInstance();
        getRefenence = getDatabase.getReference();

        qrCode = findViewById(R.id.qrCodeImage);

        contactBuddiesX = findViewById(R.id.contactBuddiesX);

        qrCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PinActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        contactBuddiesX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListContactPaymentActivity.class);
                startActivity(intent);
            }
        });

        cameraView = (SurfaceView) findViewById(R.id.cameraView);
        cameraView.setZOrderMediaOverlay(true);
        holder = cameraView.getHolder();
        barcode = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.QR_CODE)
                .build();
        if(!barcode.isOperational()){
            Toast.makeText(getApplicationContext(), "Sorry, Couldn't setup the detector", Toast.LENGTH_LONG).show();
            this.finish();
        }
        cameraSource = new CameraSource.Builder(this, barcode)
                .setFacing(CameraSource.CAMERA_FACING_BACK)
                .setRequestedFps(24)
                .setAutoFocusEnabled(true)
                .setRequestedPreviewSize(1920,1024)
                .build();
        cameraView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try{
                    if(ContextCompat.checkSelfPermission(Scanner.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                        cameraSource.start(cameraView.getHolder());
                    }
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
        barcode.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> barcodes =  detections.getDetectedItems();
                if(barcodes.size() > 0){

                    final String barcodeResult = String.valueOf((barcodes.valueAt(0).displayValue));

                    final Query query = getRefenence.child("User").orderByChild("userName").equalTo(barcodeResult);

                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
                            if(dataSnapshot.getValue() == null){
                                Toast.makeText(Scanner.this, "Username in barcode doesnot registerd", Toast.LENGTH_SHORT).show();
                            }else if(barcodeResult.equals(userNameZ)){
                                Toast.makeText(Scanner.this, "That's barcode is your username ", Toast.LENGTH_SHORT).show();
                            }else{
                                Intent intent = new Intent(getApplicationContext(), SentMoneyActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                                intent.putExtra("userName", userNameZ);
                                intent.putExtra("barcode", barcodeResult);
                                setResult(RESULT_OK, intent);
                                finish();
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    /*
                    * Log.d("My QR Code's Data",
                            barcodes.valueAt(0).displayValue
                    );
                    * */

                    /*
                    * Intent intent = new Intent(getApplicationContext(), SentMoneyActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    intent.putExtra("userName", userNameZ);
                    intent.putExtra("barcode", (Parcelable) barcodes.valueAt(0));
                    setResult(RESULT_OK, intent);
                    finish();
                    startActivity(intent);
                    * */

                    /*
                    * Intent intent = new Intent(getApplicationContext(), SentMoneyActivity.class);
                    intent.putExtra("barcode", (Parcelable) barcodes.valueAt(0));
                    setResult(RESULT_OK, intent);
                    finish();
                    startActivity(intent);
                    * */
                    //intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

                    /*
                    Intent intent = new Intent();
                    intent.putExtra("barcode", (Parcelable) barcodes.valueAt(0));
                    setResult(RESULT_OK, intent);
                    finish();
                     */

                    /*
                    * Intent x = new Intent(getApplicationContext(), ListContactActivity.class);
                    x.putExtra("barcode", (Parcelable) barcodes.valueAt(0));
                    setResult(RESULT_OK, x);
                    startActivity(x);
                    * */
                }
            }
        });
    }
}
