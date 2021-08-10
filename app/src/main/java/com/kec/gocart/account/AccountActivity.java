package com.kec.gocart.account;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.kec.gocart.R;

public class AccountActivity extends AppCompatActivity {

    private Button btnOpen;
    private ImageView imageView;


    private final int PHOTO_REQUEST = 0012;
    private final int PERMISSION_REQUEST = 001212;

    private String IMAGE_PATH = "/local/data/Photo1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        btnOpen = findViewById(R.id.btn_open_camera);
        imageView = findViewById(R.id.imageView);

        askPermissionWork();

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                askPermissionWork();

            }
        });

    }

    private void askPermissionWork() {

        ActivityCompat.requestPermissions(AccountActivity.this,
                new String[]{Manifest.permission.CAMERA},
                PERMISSION_REQUEST);
    }



    private void doOpenCameraWork() {

        // do Open Camera work

        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, PHOTO_REQUEST);


    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // check permission deny or success

        if (requestCode == PERMISSION_REQUEST) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();

                doOpenCameraWork();

            } else {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // result
        if (requestCode == PHOTO_REQUEST && resultCode == Activity.RESULT_OK) {
            if (data != null){
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(photo);

            }

        }



    }
}