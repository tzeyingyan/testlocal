package com.local.test.mapstruct.ignorenull;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.UUID;

public class Element2 {
    private UUID id;
    private int montant;

    public Element2() {
        this.id = null;
        this.montant = 0;
    }

    public Element2(UUID id, int montant) {
        this.id = id;
        this.montant = montant;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
