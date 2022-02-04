package com.local.test.liste.tri;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ElementTri {

    private String libelle;

    private LocalDateTime date;

    private int indice;

    public ElementTri(String libelle, String date, String format, int indice) {
        this.libelle = libelle;
        this.indice = indice;
        if (date != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            this.date = LocalDateTime.parse(date, formatter);
        }
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
