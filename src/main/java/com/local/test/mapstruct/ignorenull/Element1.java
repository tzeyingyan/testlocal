package com.local.test.mapstruct.ignorenull;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Element1 {
    private static final String CHAINE_VIDE = "CHAINE_VIDE";
    private String identifiant;
    private int montant;

    public Element1() {
        this.identifiant = CHAINE_VIDE;
        this.montant = 0;
    }

    public Element1(String identifiant, int montant) {
        this.identifiant = identifiant;
        this.montant = montant;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
