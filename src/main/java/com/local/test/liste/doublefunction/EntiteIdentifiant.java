package com.local.test.liste.doublefunction;

public class EntiteIdentifiant {
    private String identifiant;
    private String identifiantEnveloppe;

    public EntiteIdentifiant(String identifiant, String identifiantEnveloppe) {
        this.identifiant = identifiant;
        this.identifiantEnveloppe = identifiantEnveloppe;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getIdentifiantEnveloppe() {
        return identifiantEnveloppe;
    }

    public void setIdentifiantEnveloppe(String identifiantEnveloppe) {
        this.identifiantEnveloppe = identifiantEnveloppe;
    }
}
