package com.example.easypayui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class QrCodeActivity extends AppCompatActivity {

    String TAG = "GenerateQRCode";
    ImageView qrImage;
    String inputValue;
    Bitmap bitmap;
    QRGEncoder qrgEncoder, coderName;
    Button buttonX;
    ImageButton myQrCode, requestBuddies;

    void generateCoderBung() throws WriterException {

        Intent intent = getIntent();
        final String userNameZ = intent.getStringExtra("userName");

        inputValue = "David Donika Panjaitan";

        inputValue = userNameZ;

        qrImage = (ImageView) findViewById(R.id.QR_Image);

        buttonX = findViewById(R.id.btnBackToHomePage);

        myQrCode = findViewById(R.id.myQrCode);

        requestBuddies = findViewById(R.id.requestBuddies);

        myQrCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        requestBuddies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(getApplicationContext(), ListRequestActivity.class);
                startActivity(x);
            }
        });

        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int width = point.x;
        int height = point.y;
        int smallerDimension = width < height ? width : height;
        smallerDimension = smallerDimension * 3 / 4;

        coderName = new QRGEncoder(
                inputValue, null,
                QRGContents.Type.TEXT,
                smallerDimension);

        bitmap = coderName.encodeAsBitmap();
        qrImage.setImageBitmap(bitmap);

        buttonX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);

        qrImage = (ImageView) findViewById(R.id.QR_Image);

        try {
            generateCoderBung();
        } catch (WriterException e) {
            e.printStackTrace();
        }

    }
}
