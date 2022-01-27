package com.local.test.utlisateurgroupes;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class Utilisateur {
    private String codeUtilisateur;
    private String nom;
    private List<Competence> competences;
    private List<Groupe> groupes;

    public Utilisateur(String codeUtilisateur, String nom) {
        this.codeUtilisateur = codeUtilisateur;
        this.nom = nom;
    }

    public String getCodeUtilisateur() {
        return codeUtilisateur;
    }

    public void setCodeUtilisateur(String codeUtilisateur) {
        this.codeUtilisateur = codeUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(List<Competence> competences) {
        this.competences = competences;
    }

    public Utilisateur addCompetence(Competence competence) {
        if (this.competences == null) {
            this.competences = new ArrayList<>();
        }
        this.competences.add(competence);
        return this;
    }

    public List<Groupe> getGroupes() {
        return groupes;
    }

    public void setGroupes(List<Groupe> groupes) {
        this.groupes = groupes;
    }

    public Utilisateur addGroupe(Groupe groupe) {
        if (this.groupes == null) {
            this.groupes = new ArrayList<>();
        }
        this.groupes.add(groupe);
        return this;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
