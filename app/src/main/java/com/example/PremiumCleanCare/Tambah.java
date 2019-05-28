package com.example.PremiumCleanCare;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Tambah extends AppCompatActivity {
    public static final int GET_FROM_GALLERY = 3;
    final int kodeGallery = 100, kodeKamera = 99;
    ImageButton shareloc;
    Button btnkeluar, btnuploadfoto;
    ImageView imgviewupload;
    Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        shareloc = (ImageButton) findViewById(R.id.shareloc);
        btnkeluar = (Button) findViewById(R.id.btnkeluar);
        btnuploadfoto = (Button) findViewById(R.id.btnuploadfoto);
        imgviewupload = (ImageView) findViewById(R.id.imgviewupload);

        shareloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Tambah.this,"Share Location", Toast.LENGTH_SHORT).show();
            }
        });
        btnkeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Tambah.this,"Batal", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent( Tambah.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnuploadfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intentGallery, kodeGallery);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == kodeGallery && resultCode == RESULT_OK) {
            imageUri = data.getData();
            imgviewupload.setImageURI(imageUri);
        }
    }
}
