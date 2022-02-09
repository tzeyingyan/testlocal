package com.local.test.liste.uniqueobjet;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Element {
    private String libelle;
    private int numero;

    public Element(String libelle, int numero) {
        this.libelle = libelle;
        this.numero = numero;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
