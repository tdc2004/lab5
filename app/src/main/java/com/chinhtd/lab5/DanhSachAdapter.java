package com.chinhtd.lab5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class DanhSachAdapter extends BaseAdapter {

    private final Context context;
    private final ArrayList<DanhSach> list;

    public DanhSachAdapter(Context context, ArrayList<DanhSach> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.item_lv,parent,false);
        TextView textView = convertView.findViewById(R.id.tv1);
        TextView textView1 = convertView.findViewById(R.id.name);
        TextView textView2 = convertView.findViewById(R.id.diachi);

        textView.setText(list.get(position).getCoSo());
        textView1.setText(list.get(position).getName());
        textView2.setText(list.get(position).getDiaChi());
        Button btnDelete = convertView.findViewById(R.id.btn_delete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (deleteListener != null) {
                    deleteListener.onDelete(position);
                }
            }
        });
        Button btnUpdate = convertView.findViewById(R.id.btn_update);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (updateListener != null) {
                    updateListener.onUpdate(position);
                }
            }
        });


        return convertView;
    }
    private DeleteListener deleteListener;

    public interface DeleteListener {
        void onDelete(int position);
    }
    public void setDeleteListener(DeleteListener listener) {
        this.deleteListener = listener;
    }
    private UpdateListener updateListener;

    public interface UpdateListener {
        void onUpdate(int position);
    }

    public void setUpdateListener(UpdateListener listener) {
        this.updateListener = listener;
    }
}
