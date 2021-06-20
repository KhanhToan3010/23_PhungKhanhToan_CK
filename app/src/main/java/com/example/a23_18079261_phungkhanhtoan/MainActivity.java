package com.example.a23_18079261_phungkhanhtoan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button   btncf, btnsn;
    EditText plsearch;

    RecyclerView rcv;
    CustomAdapter adt;
    List<ItemCF> itemscf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btncf = findViewById(R.id.btncf);
        btnsn = findViewById(R.id.btnsn);
        plsearch = findViewById(R.id.plsearch);
        rcv = findViewById(R.id.rcv);
        adt = new CustomAdapter(itemscf,this);

        rcv.setHasFixedSize(true);
        rcv.setAdapter(adt);
        rcv.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL,false));

        btncf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}