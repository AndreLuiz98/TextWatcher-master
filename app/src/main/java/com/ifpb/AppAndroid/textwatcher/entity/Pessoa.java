package com.ifpb.AppAndroid.textwatcher.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Pessoa implements Serializable {

    public Pessoa(){

    }

    public Pessoa (String nome, String descricao) {
        this.nome = nome;
        this.texto = descricao;
    }

    @SerializedName("id")
    private int id;

    @SerializedName("fullName")
    private String nome;

    @SerializedName("email")
    private String email;

    @SerializedName("typeInscription")
    private String texto;

    @SerializedName("isDelivered")
    private boolean entregue;

    public String getDescricao() {
        return texto;
    }

    public void setDescricao(String descricao) {
        this.texto = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOk() {
        return entregue;
    }

    public void setEntregue(boolean entregue) {
        this.entregue = entregue;
    }

    @Override
    public String toString() {
        return "[fullName: " + nome + "; email: " + email + "]";
    }
}
