package com.gasa.gasasil2_24;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvWhoIs = findViewById(R.id.tv_who_is);
        Button btDeviner =findViewById(R.id.bt_deviner);
        Button btFormulaire =findViewById(R.id.bt_formulaire);
        tvWhoIs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvWhoIs.setText("It's me");
            }
        });

        btDeviner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, JeuActivity.class);
                startActivity(intent);
            }
        });

        btFormulaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PregoListActivity.class));
            }
        });

    }
}