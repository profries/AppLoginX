package com.example.iossenac.apploginx.model;

public class Usuario {
    private String nome, senha, nomeCompleto;

    public Usuario(String nome, String senha, String nomeCompleto) {
        this.nome = nome;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean verificaLogin(String username, String senha){
        return this.nome.equals(username) && this.senha.equals(senha);
    }
}