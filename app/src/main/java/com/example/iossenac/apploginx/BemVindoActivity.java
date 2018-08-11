package com.example.iossenac.apploginx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.iossenac.apploginx.model.Usuario;

public class BemVindoActivity extends AppCompatActivity {
    public final static int RESULTADO_SENHAALTERADA = 1;
    public final static int RESULTADO_LOGOUT = 0;

    Usuario usuario;
    int indiceUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bem_vindo);

        TextView textoBemVindo = (TextView) findViewById(R.id.textoBemVindo);

        Intent it = this.getIntent();
        usuario = (Usuario) it.getSerializableExtra("usuario");
        indiceUsuario = it.getIntExtra("indice",0);
        textoBemVindo.setText("Seja bem vindo, "+usuario.getNomeCompleto());
    }

    public void alterarSenha(View view){
        EditText textoNovaSenha = (EditText) findViewById(R.id.textoNovaSenha);
        usuario.setSenha(textoNovaSenha.getText().toString());

        Intent it = new Intent();
        it.putExtra("usuarioAlterado",usuario);
        it.putExtra("",indiceUsuario);

        setResult(RESULTADO_SENHAALTERADA,it);

        finish();
    }

    public void realizarLogout(View view){
        setResult(RESULTADO_LOGOUT);
        finish();
    }


    @Override
    public void onBackPressed() {
        Log.w("Debug", "Back pressed!");
    }
}
