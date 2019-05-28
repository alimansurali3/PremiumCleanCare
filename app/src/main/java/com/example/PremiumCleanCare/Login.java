package com.example.PremiumCleanCare;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    // identititas id unik untuk notification
    public static final int NOTIFICATION_ID = 1;
    EditText edttxtusername, edttxtpassword;
    Button btnkeluar, btnmasuk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnkeluar = (Button) findViewById(R.id.btnkeluar);
        btnmasuk = (Button) findViewById(R.id.btnmasuk);
        edttxtusername = (EditText) findViewById(R.id.edttxtusername);
        edttxtpassword = (EditText) findViewById(R.id.edttxtpassword);

        btnkeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login.this,"Keluar", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent( Login.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login.this,"Masuk", Toast.LENGTH_SHORT).show();
                tampilNotification(v);

            }
        });
    }

    public void tampilNotification(View view) {
        //Menmbangun atau mensetup Notification dengan NotificationCompat.Builder
        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher) //ikon notification
                .setContentTitle("Notifikasi Saya") //judul konten
                .setAutoCancel(true)//untuk menswipe atau menghapus notification
                .setContentText("Login Berhasil"); //isi text
        //Kemudian kita harus menambahkan Notification dengan menggunakan NotificationManager
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, builder.build()
        );
    }
}
