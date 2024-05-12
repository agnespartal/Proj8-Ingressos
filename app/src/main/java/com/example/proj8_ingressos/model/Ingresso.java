package com.example.proj8_ingressos.model;

public class Ingresso {

    private String identificador;
    private float valor = 150;

    public Ingresso(){
        super();
    }
    public float ValorIngresso(float taxa){
        valor = valor + (valor *(taxa / 100));
        return valor;
    }
}
