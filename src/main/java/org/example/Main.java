package org.example;

import java.util.List;
import java.util.Scanner;

        public class Main {
            public static void main(String[] args) {
                Biblioteca biblioteca = new Biblioteca();
                biblioteca.afisareCarti();
                System.out.println("");
                biblioteca.afisareCartititlu();

                Scanner scanner = new Scanner(System.in);

                System.out.print("Introduceți titlul cărții: ");
                String titluCautat = scanner.nextLine();
                System.out.print("Introduceți pagina pe care doriți să căutați fraza: ");
                int paginaCautata = scanner.nextInt();

                List<Carte> rezultatFraza = biblioteca.cautareFrazaDupaPaginaSiTitlu(titluCautat, paginaCautata);

                if (rezultatFraza.isEmpty()) {
                    System.out.println("Nicio carte găsită pentru titlul și pagina specificate.");
                } else {
                    System.out.println("Fraza găsită pentru titlul și pagina specificate:");

                    for (Carte carte : rezultatFraza) {
                        String continutPagina = carte.getContinutPagina(paginaCautata);
                        System.out.println("Cartea: "  + carte.getTitlu());
                        System.out.println("Pagina: " + paginaCautata);
                        System.out.println("Fragment din carte: " + continutPagina);
                    }
                }
                System.out.println("Alegeți opțiunea:");
                System.out.println("1. Adăugare carte nouă");
                System.out.println("2. Iesi");
                int optiune = scanner.nextInt();

                if (optiune == 1) {
                    biblioteca.adaugaCarteDeLaTastatura();
                } else if (optiune == 2) {
                    System.out.println("Programul s-a oprit.");
                    return;  // Ieși din program
                }

                scanner.close();
            }
        }


