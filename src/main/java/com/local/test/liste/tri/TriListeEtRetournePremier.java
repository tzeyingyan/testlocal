package com.local.test.liste.tri;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class TriListeEtRetournePremier {
    private static final String FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) {
        List<ElementTri> elements = new ArrayList<>();
        elements.add(new ElementTri("libelle1", "2022-01-02 12:45:50", FORMAT, 1));
        elements.add(new ElementTri("libelle2", "2022-02-02 11:23:18", FORMAT, 3));
        elements.add(new ElementTri("libelle3", "2022-01-29 17:12:34", FORMAT, 5));
        elements.add(new ElementTri("libelle4", "2022-02-03 08:15:07", FORMAT, 4));
        elements.add(new ElementTri("libelle5", "2022-01-31 13:08:09", FORMAT, 6));
        elements.add(new ElementTri("libelle6", null, null, 2));
        Set<ElementTri> elementsSet = new HashSet<>(elements);

        ElementTri elementPlusRecent = Optional.ofNullable(elementsSet)
                .stream()
                .flatMap(Set::stream)
                .sorted(Comparator.comparing(ElementTri::getDate, Comparator.nullsLast(Comparator.reverseOrder())))
                .findFirst()
                .orElse(null);

        for (ElementTri element: elements) {
            System.out.println("*-*-*-*-Element:" + element);
        }
        System.out.println("*-*-*-*- ElementPlusRecent:" + elementPlusRecent);

        elementPlusRecent = Optional.ofNullable(elementsSet)
                .stream()
                .flatMap(Set::stream)
                .sorted(Comparator.comparing(ElementTri::getIndice, Comparator.nullsLast(Comparator.reverseOrder())))
                .findFirst()
                .orElse(null);

        System.out.println("*-*-*-*- ElementPlusRecent2:" + elementPlusRecent);
    }
}
