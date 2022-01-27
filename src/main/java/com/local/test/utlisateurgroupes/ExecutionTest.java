package com.local.test.utlisateurgroupes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExecutionTest {
    public static void main(String[] args) {
        List<Utilisateur> utilisateurs = Arrays.asList(
                new Utilisateur("code01", "nom01"),
                new Utilisateur("code02", "nom02"),
                new Utilisateur("code03", "nom03"),
                new Utilisateur("code04", "nom04"),
                new Utilisateur("code05", "nom05"),
                new Utilisateur("code06", "nom06"),
                new Utilisateur("code07", "nom07"),
                new Utilisateur("code08", "nom08"),
                new Utilisateur("code09", "nom09"),
                new Utilisateur("code10", "nom10"),
                new Utilisateur("code11", "nom11"),
                new Utilisateur("code12", "nom12"),
                new Utilisateur("code13", "nom13"),
                new Utilisateur("code14", "nom14"),
                new Utilisateur("code15", "nom15"));

        long debut = System.currentTimeMillis();
        // Filtrer la liste des utilisateurs avec la pagination
        //List<Utilisateur> listePagineeUtilisateurs = utilisateurs.stream().skip(0).limit(10).collect(Collectors.toList());
        List<Utilisateur> listePagineeUtilisateurs =
                utilisateurs.stream()
                        .filter(utilisateur ->
                                Arrays.asList("code01", "code02", "code03").contains(utilisateur.getCodeUtilisateur())
                        ).skip(0).limit(3).collect(Collectors.toList());
        List<Competence> competences = retournerCompetences();
        List<Groupe> groupes = retournerGroupe();

        listePagineeUtilisateurs.stream()
                .forEach(utilisateur -> {
                    competences.stream().filter(competence -> utilisateur.getCodeUtilisateur().equals(competence.getCodeUtilisateur()))
                            .forEach(competence -> utilisateur.addCompetence(competence));
                    groupes.stream().filter(groupe -> utilisateur.getCodeUtilisateur().equals(groupe.getCodeUtilisateur()))
                            .forEach(groupe -> utilisateur.addGroupe(groupe));
                });

        long fin = System.currentTimeMillis();
        for (Utilisateur utilisateur : listePagineeUtilisateurs) {
            System.out.println(utilisateur);
        }
        System.out.println("*-*-*-*-*-*-**- durée: " + (fin - debut) + " ms");
    }

    public static List<Competence> retournerCompetences() {
        // 01=>3, 03, 05, 08, 09, 10=>2
        return Arrays.asList(
                new Competence(101, "competence01", "code01"),
                new Competence(102, "competence02", "code01"),
                new Competence(103, "competence03", "code03"),
                new Competence(101, "competence01", "code05"),
                new Competence(105, "competence05", "code08"),
                new Competence(102, "competence02", "code09"),
                new Competence(101, "competence01", "code10"),
                new Competence(103, "competence03", "code10"),
                new Competence(104, "competence04", "code01"));
    }

    public static List<Groupe> retournerGroupe() {
        // 01=>3, 03, 05, 08, 09
        return Arrays.asList(
                new Groupe(201, "groupe01", "code01"),
                new Groupe(202, "groupe02", "code01"),
                new Groupe(201, "groupe01", "code03"),
                new Groupe(202, "groupe02", "code05"),
                new Groupe(202, "groupe02", "code08"),
                new Groupe(201, "groupe01", "code09"),
                new Groupe(203, "groupe03", "code01"));
    }
}
