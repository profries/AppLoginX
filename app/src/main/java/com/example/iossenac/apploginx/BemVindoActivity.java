package com.example.iossenac.apploginx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BemVindoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bem_vindo);

        TextView textoBemVindo = (TextView) findViewById(R.id.textoBemVindo);

        Intent it = this.getIntent();
        String nomeCompleto = it.getStringExtra("nomeCompleto");
        textoBemVindo.setText("Seja bem vindo, "+nomeCompleto);
    }


}
