package com.gasa.gasasil2_24;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

    private EditText etNom;
    private EditText etPrenom;
    private RadioButton rbMasculin;
    private RadioButton rbFeminin;
    private RadioButton rbAutre;
    private EditText etDatecenaissance;
    private EditText etEmail;
    private EditText etMotdepasse;
    private CheckBox cbGouvbj;
    private CheckBox cbYoutube;
    private CheckBox cbRfi;
    private Button btEnregistrer;
    private RadioGroup rgSexe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        initView();

        etNom.getText().toString();

        btEnregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormActivity.this, JeuActivity.class);
                intent.putExtra("nom", etNom.getText().toString());
                intent.putExtra("prenom", etPrenom.getText().toString());
                startActivity(intent);
            }
        });
    }

    private void initView() {
        etNom = findViewById(R.id.et_nom);
        etPrenom = findViewById(R.id.et_prenom);
        rbMasculin = findViewById(R.id.rb_masculin);
        rbFeminin = findViewById(R.id.rb_feminin);
        rbAutre = findViewById(R.id.rb_autre);
        etDatecenaissance = findViewById(R.id.et_datecenaissance);
        etEmail = findViewById(R.id.et_email);
        etMotdepasse = findViewById(R.id.et_motdepasse);
        cbGouvbj = findViewById(R.id.cb_gouvbj);
        cbYoutube = findViewById(R.id.cb_youtube);
        cbRfi = findViewById(R.id.cb_rfi);
        btEnregistrer = findViewById(R.id.bt_enregistrer);
        rgSexe = findViewById(R.id.rg_sexe);
    }
}