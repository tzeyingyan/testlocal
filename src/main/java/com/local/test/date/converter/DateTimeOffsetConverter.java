package com.local.test.date.converter;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeOffsetConverter {

    public static void main(String[] args) {
        OffsetDateTime dateActuelle = OffsetDateTime.now();
        System.out.println("*-*-*- Date actuelle: " + dateActuelle);

        DateTimeFormatter formateur = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        System.out.println("*-*-*- Date actuelle formatée XXX: " + dateActuelle.format(formateur));

        formateur = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZZ");
        System.out.println("*-*-*- Date actuelle formatée ZZ: " + dateActuelle.format(formateur));
    }
}
