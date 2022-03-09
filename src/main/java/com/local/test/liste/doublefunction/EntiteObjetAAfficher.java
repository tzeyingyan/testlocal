package com.local.test.liste.doublefunction;

public class EntiteObjetAAfficher {
    private String identifiant;
    private String identifiantEnveloppe;
    private String description;
    private String estEditable;

    public EntiteObjetAAfficher(String identifiant, String description, String identifiantEnveloppe) {
        this.identifiant = identifiant;
        this.description = description;
        this.identifiantEnveloppe = identifiantEnveloppe;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdentifiantEnveloppe() {
        return identifiantEnveloppe;
    }

    public void setIdentifiantEnveloppe(String identifiantEnveloppe) {
        this.identifiantEnveloppe = identifiantEnveloppe;
    }

    public String getEstEditable() {
        return estEditable;
    }

    public void setEstEditable(String estEditable) {
        this.estEditable = estEditable;
    }

    public String toString() {
        return "*-*-*-*-* EntiteObjet trouve: " + this.description + " - modifiable: " + this.estEditable;
    }
}
