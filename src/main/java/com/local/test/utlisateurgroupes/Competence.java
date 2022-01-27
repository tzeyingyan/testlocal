package com.local.test.utlisateurgroupes;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Competence {
    private int identifiant;
    private String description;
    private String codeUtilisateur;

    public Competence() {

    }

    public Competence(int identifiant, String description, String codeUtilisateur) {
        this.identifiant = identifiant;
        this.description = description;
        this.codeUtilisateur = codeUtilisateur;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCodeUtilisateur() {
        return codeUtilisateur;
    }

    public void setCodeUtilisateur(String codeUtilisateur) {
        this.codeUtilisateur = codeUtilisateur;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
