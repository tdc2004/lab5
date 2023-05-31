package com.chinhtd.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity_home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View secondView = inflater.inflate(R.layout.item_lv,null);
        ListView listView = findViewById(R.id.lv);
        ArrayList<DanhSach> list = new ArrayList<>();
        list.add(new DanhSach("FPoly Hà Nội","Tống Doanh Chính","Nam Định"));
        list.add(new DanhSach("FPoly Hà Nội","Lê Mạnh Quỳnh","Vĩnh Phúc"));
        list.add(new DanhSach("FPoly Hà Nội","Tống Doanh Chính","Nam Định"));
        list.add(new DanhSach("FPoly Hà Nội","Tống Doanh Chính","Nam Định"));
        DanhSachAdapter adapter = new DanhSachAdapter(this,list);
        listView.setAdapter(adapter);
        Button button = findViewById(R.id.btn_them);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        TextView textView = secondView.findViewById(R.id.tv1);
        TextView tv = secondView.findViewById(R.id.name);
        TextView tv2 = secondView.findViewById(R.id.diachi);

        String ten = getIntent().getStringExtra(MainActivity.Key_Name);
        String cs = getIntent().getStringExtra(MainActivity.Key_COSO);
        String dc = getIntent().getStringExtra(MainActivity.Key_DiaChi);

        Button btn_capnhat = secondView.findViewById(R.id.btn_update);
        Button btn_del =secondView.findViewById(R.id.btn_delete);
        Button button1 =findViewById(R.id.btn_them1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add(new DanhSach(cs,ten,dc));
                adapter.notifyDataSetChanged();
            }
        });
        adapter.setDeleteListener(new DanhSachAdapter.DeleteListener() {
            @Override
            public void onDelete(int position) {
                list.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(Activity_home.this, "Xóa Thành Công", Toast.LENGTH_SHORT).show();
            }
        });

    }
}