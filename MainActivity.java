package com.example.ngolamdoon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Dialog dialog;
    ListView lis_408;
    String[] ten_408 = {"Áo trường UTE","Áo khoa Điện - Điện tử","Móc khoá UTE"};
    String[] gia_408 = {"100.000","100.000","20.000"};
    String[] sl_408 = {"1","1","3"};
    int[] img_408 ={R.drawable.bt4_aotruong,R.drawable.bt4_dien,R.drawable.bt4_mockhoavuong};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner chon_tinh = findViewById(R.id.tinh);
        ArrayAdapter<CharSequence> adapter_tinh = ArrayAdapter.createFromResource(this, R.array.tinh, android.R.layout.simple_spinner_item);
        adapter_tinh.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        chon_tinh.setAdapter(adapter_tinh);
        chon_tinh.setOnItemSelectedListener(this);

        Spinner chon_quan = findViewById(R.id.quan);
        ArrayAdapter<CharSequence> adapter_quan = ArrayAdapter.createFromResource(this, R.array.quan, android.R.layout.simple_spinner_item);
        adapter_tinh.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        chon_quan.setAdapter(adapter_quan);
        chon_quan.setOnItemSelectedListener(this);


        dialog = new Dialog(this);
        Button dh_408 = (Button) findViewById(R.id.dh);
        dh_408.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }


        });

        lis_408 = findViewById(R.id.list);
        CustomAdapter customAdapter = new CustomAdapter();
        lis_408.setAdapter(customAdapter);
        lis_408.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==0) {
                    Toast.makeText(MainActivity.this, "Áo", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
    @Override
    public void onItemSelected (AdapterView < ? > parent, View view,int position, long id){

    }

    @Override
    public void onNothingSelected (AdapterView < ? > parent){

    }
    public void openDialog() {
        dialog.setContentView(R.layout.dialog_dh);

        Button yes_408 = dialog.findViewById(R.id.dia_yes);
        Button no_408 = dialog.findViewById(R.id.dia_no);
        yes_408.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        no_408.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }


    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return ten_408.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = getLayoutInflater().inflate(R.layout.row_list,null);
            TextView ten = v.findViewById(R.id.tensp);
            TextView gia = v.findViewById(R.id.giasp);
            TextView sl = v.findViewById(R.id.slsp);
            ImageView img = v.findViewById(R.id.imagesp);

            ten.setText(ten_408[position]);
            gia.setText(gia_408[position]);
            sl.setText(sl_408[position]);
            img.setImageResource(img_408[position]);
            return v;
        }
    }
}