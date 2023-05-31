package com.chinhtd.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static String Key_COSO = "coso";
    public static String Key_Name = "name";
    public static String Key_DiaChi = "dia_chi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spiner);
        EditText editText = findViewById(R.id.edt_ten);
        EditText editText1 = findViewById(R.id.edt_diachi);
        Button button = findViewById(R.id.btn_sub);

        ArrayList<School> list = new ArrayList<>();
        list.add(new School(R.drawable.hn, "FPoly Ha Noi"));
        list.add(new School(R.drawable.hcm, "FPoly TP HCM"));
        list.add(new School(R.drawable.tn, "FPoly Tay Nguyen"));
        list.add(new School(R.drawable.dn, "FPoly Da Nang"));
        list.add(new School(R.drawable.ct, "FPoly Can Tho"));

        SchoolSpinnerAdapter adapter = new SchoolSpinnerAdapter(this, list);
        spinner.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spinner.getSelectedItem() != null) {
                    View selectedView = spinner.getSelectedView();
                    TextView textView = selectedView.findViewById(R.id.tv_cs);
                    String ten = editText.getText().toString();
                    String diachi = editText1.getText().toString();
                    String coso = textView.getText().toString();

                    Intent intent = new Intent(MainActivity.this, Activity_home.class);
                    intent.putExtra(Key_COSO, coso);
                    intent.putExtra(Key_Name, ten);
                    intent.putExtra(Key_DiaChi, diachi);
                    startActivity(intent);
                }
            }
        });

    }
}