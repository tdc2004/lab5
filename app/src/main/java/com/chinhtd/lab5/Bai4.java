package com.chinhtd.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Bai4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        EditText tk = findViewById(R.id.edt_user);
        EditText mk = findViewById(R.id.edt_pass);
        Button btn_dk = findViewById(R.id.btn_dk);
        Button btn_dn = findViewById(R.id.btn_dn);
        btn_dk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Bai4_dangky.class);
                startActivity(intent);
            }
        });
        String user = getIntent().getStringExtra(Bai4_dangky.Key_user);
        String pass = getIntent().getStringExtra(Bai4_dangky.Key_pass);
        tk.setText(user);
        mk.setText(pass);
        btn_dn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Activity_home.class);
                startActivity(intent);
            }
        });
    }
}