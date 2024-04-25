package com.gasa.gasasil2_24;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class PregoListActivity extends AppCompatActivity {

    private RecyclerView rvPregoList;
    PregoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prego_list);

        initView();

        int[] images = {R.drawable.patrice_talon, R.drawable.vladmir_zelensky};
        String[] noms = {"Patrice Talon", "Vladmir Z"};

        adapter = new PregoAdapter(noms, images);
        rvPregoList.setAdapter(adapter);
    }

    private void initView() {
        rvPregoList = findViewById(R.id.rv_prego_list);
    }
}