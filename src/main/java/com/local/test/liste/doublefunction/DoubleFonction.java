package com.local.test.liste.doublefunction;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DoubleFonction {
    private static final String PARAM = "TOTO";
    public static void main(String[] args) {
        var pair = Optional.ofNullable(PARAM)
                .map(param -> retourneIdentifiant())
                .map(entiteIdentifiant -> Pair.of(
                        entiteIdentifiant,
                        methode2(entiteIdentifiant.getIdentifiantEnveloppe())
                ))
                /*.map(pair -> {
                    pair.getRight()
                            .stream()
                            .forEach(entiteObjet -> {
                                if (pair.getLeft().getIdentifiant().equalsIgnoreCase(entiteObjet.getIdentifiant())) {
                                    entiteObjet.setEstEditable("O");
                                } else {
                                    entiteObjet.setEstEditable("N");
                                }
                            });
                    return pair.getRight();
                })*/
                .orElse(null);

        var page = pair.getRight()
                        .stream()
                        .map(entiteObjet -> Optional.ofNullable(entiteObjet)
                                .map(DoubleFonction::mapper)
                                .map(dto -> {
                                    if (pair.getLeft().getIdentifiant().equalsIgnoreCase(dto.getIdentifiant())) {
                                        dto.setEstEditable("O");
                                    } else {
                                        dto.setEstEditable("N");
                                    }
                                    return dto;
                                })
                                .orElse(null))
                .collect(Collectors.toList());

        PageImpl pageI = new PageImpl(page);

        pageI.forEach(element -> {
            System.out.println(element.toString());
        });


        /*page.forEach(element -> {
            System.out.println("*-*-*-*-* EntiteObjet trouve: " + element.getDescription() + " - modifiable: " + element.getEstEditable());
        });*/
    }

    public static EntiteIdentifiant retourneIdentifiant() {
        return new EntiteIdentifiant("1", "2");
    }

    public static Page<EntiteObjet> methode2(String identifiantEnveloppe) {
        var liste = Arrays.asList(new EntiteObjet("1", "c'est 1!", "2"),
                new EntiteObjet("1", "c'est 1 mais pas bon!", "4"),
                new EntiteObjet("2", "c'est 2!", "2"),
                new EntiteObjet("3", "c'est 3!", "2"),
                new EntiteObjet("1", "c'est encore 1!", "2"),
                new EntiteObjet("4", "c'est 4!", "2"),
                new EntiteObjet("1", "c'est 1 mais pas bon 2!", "3")
        );

        return new PageImpl<>(Optional.ofNullable(liste)
                .stream()
                .flatMap(List::stream)
                .filter(entiteObjet -> identifiantEnveloppe.equalsIgnoreCase(entiteObjet.getIdentifiantEnveloppe()))
                .collect(Collectors.toList()));
    }

    public static EntiteObjetAAfficher mapper(EntiteObjet entiteObjet) {
        return new EntiteObjetAAfficher(entiteObjet.getIdentifiant(), entiteObjet.getDescription(), entiteObjet.getIdentifiantEnveloppe());
    }
}
