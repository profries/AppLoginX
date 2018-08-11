package com.example.iossenac.apploginx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.iossenac.apploginx.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Usuario> listaUsuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciaUsuarios();
    }

    public void realizarLogin(View view){
        EditText textoUsuario = (EditText) findViewById(R.id.textoUsuario);
        String nome = textoUsuario.getText().toString();
        EditText textoSenha = (EditText) findViewById(R.id.textoSenha);
        String senha = textoSenha.getText().toString();

        boolean loginSucesso = false;

        for(Usuario u: listaUsuarios){
            if(u.verificaLogin(nome,senha)){
                loginSucesso = true;
                abrirTelaBemVindo();
            }
        }

        if(!loginSucesso){
            Toast.makeText(this, "Usuário ou senha inválidos", Toast.LENGTH_SHORT).show();
            zeraCampos();
        }
    }

    private void abrirTelaBemVindo() {
        Intent it = new Intent(this, BemVindoActivity.class);
        startActivity(it);
    }

    public void zeraCampos(){
        EditText textoUsuario = (EditText) findViewById(R.id.textoUsuario);
        EditText textoSenha = (EditText) findViewById(R.id.textoSenha);

        textoUsuario.setText("");
        textoUsuario.requestFocus();
        textoSenha.setText("");
    }

    private void iniciaUsuarios() {
        listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Usuario("teste1","123","Teste1"));
        listaUsuarios.add(new Usuario("teste2","123","Teste2"));
        listaUsuarios.add(new Usuario("teste3","123","Teste3"));
    }
}
