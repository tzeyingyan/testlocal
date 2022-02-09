package com.local.test.liste.uniqueobjet;

import com.local.test.liste.tri.ElementTri;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UniqueObjet {
    public static void main(String[] args) {
        Element element1 = new Element("libelle1", 1);
        Element element2 = new Element("libelle2", 1);
        Element element3 = new Element("libelle3", 3);
        Element element4 = new Element("libelle1", 2);
        Element element5 = new Element("libelle3", 2);

        List<Element> elements = Arrays.asList(element1, element2, element3, element4, element5);
        Set<Element> elementsSet = new HashSet<>(elements);

        List<Element> valeursRetenues = new ArrayList<>();
        for(Element element : elements) {
            Element elementAAjouter = element;
            for (Element elt : elements) {
                if (element.getLibelle().equals(elt.getLibelle()) && elt.getNumero() > element.getNumero()) {
                        elementAAjouter = elt;
                }
            }
            valeursRetenues.add(elementAAjouter);
        }

        for (Element element : valeursRetenues.stream().distinct().collect(Collectors.toList())) {
            System.out.println("*-*-*-*-*- Element retenu: " + element);
        }

        valeursRetenues = elementsSet.stream()
                .map(elt -> {
                    return getMaxElement(elt.getLibelle(), elementsSet);
                }).distinct().collect(Collectors.toList());

        for (Element element : valeursRetenues.stream().distinct().collect(Collectors.toList())) {
            System.out.println("*-*-*-*-*- Element retenu2: " + element);
        }

    }

    private static Element getMaxElement(String libelle, Set<Element> elements) {
        return elements.stream()
                .filter(elt -> libelle.equals(elt.getLibelle()))
                .sorted(Comparator.comparing(Element::getNumero, Comparator.nullsLast(Comparator.reverseOrder())))
                .findFirst()
                .orElse(null);
    }
}
