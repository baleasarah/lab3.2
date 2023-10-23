    package org.example;

    import java.util.*;

    public class Biblioteca {

        private List<Carte> carti;
        private String fraza;

        public Biblioteca() {
            carti = new ArrayList<>();
            initializareColectie();
        }

        private void initializareColectie() {
            // Creăm fiecare carte și setăm titlul, numărul de pagini și frazele corespunzătoare
            Carte carte1 = new Carte("Mihai Eminescu", "Glossa", 3);
            carte1.adaugaFraza("Aceasta este fraza 1 pentru Glossa");
            carte1.adaugaFraza("Aceasta este fraza 2 pentru Glossa");
            carte1.adaugaFraza("Aceasta este fraza 3 pentru Glossa");

            Carte carte2 = new Carte("Ioan Slavici", "Moara cu Noroc", 2);
            carte2.adaugaFraza("Aceasta este fraza 1 pentru Moara cu Noroc");
            carte2.adaugaFraza("Aceasta este fraza 2 pentru Moara cu Noroc");

            Carte carte3 = new Carte("Ion Creanga", "Amintiri din copilarie", 4);
            carte3.adaugaFraza("Aceasta este fraza 1 pentru Amintiri din copilarie");
            carte3.adaugaFraza("Aceasta este fraza 2 pentru Amintiri din copilarie");
            carte3.adaugaFraza("Aceasta este fraza 3 pentru Amintiri din copilarie");
            carte3.adaugaFraza("Aceasta este fraza 4 pentru Amintiri din copilarie");

            Carte carte4 = new Carte("Mihail Sadoveanu", "Baltagul", 5);
            carte4.adaugaFraza("Aceasta este fraza 1 pentru Baltagul");
            carte4.adaugaFraza("Aceasta este fraza 2 pentru Baltagul");
            carte4.adaugaFraza("Aceasta este fraza 3 pentru Baltagul");
            carte4.adaugaFraza("Aceasta este fraza 4 pentru Baltagul");
            carte4.adaugaFraza("Aceasta este fraza 5 pentru Baltagul");

            Carte carte5 = new Carte("Mihai Eminescu", "Luceafrul", 2);
            carte5.adaugaFraza("Aceasta este fraza 1 pentru Luceafrul");
            carte5.adaugaFraza("Aceasta este fraza 2 pentru Luceafrul");

            // Adăugăm cărțile în lista de cărți
            carti.add(carte1);
            carti.add(carte2);
            carti.add(carte3);
            carti.add(carte4);
            carti.add(carte5);
        }


        public void afisareCarti() {
            // Sortăm lista de cărți în ordine alfabetică după autor și titlu
            Collections.sort(carti, new Comparator<Carte>() {

                public int compare(Carte carte1, Carte carte2) {
                    // Comparăm mai întâi după autor
                    int rezultat = carte1.getAutor().compareTo(carte2.getAutor());
                    if (rezultat == 0) {
                        // Dacă autorii sunt identici, comparăm după titlu
                        rezultat = carte1.getTitlu().compareTo(carte2.getTitlu());
                    }
                    return rezultat;
                }

            });
            System.out.println("Cartile din biblioteca soratate dupa autor sunt:");
            for (Carte carte : carti) {
                System.out.println(carte);
            }
        }

            //afisare dupa sortare dupa titlu
            public void afisareCartititlu () {
                // Sortăm lista de cărți în ordine alfabetică după autor și titlu
                Collections.sort(carti, new Comparator<Carte>() {

                    public int compare(Carte carte1, Carte carte2) {
                        // Comparăm mai întâi după autor
                        int rezultat = carte1.getTitlu().compareTo(carte2.getTitlu());
                        if (rezultat == 0) {
                            // Dacă autorii sunt identici, comparăm după titlu
                            rezultat = carte1.getTitlu().compareTo(carte2.getTitlu());
                        }
                        return rezultat;
                    }
                });


                System.out.println("Cartile din biblioteca sortate dupa titlu sunt:");
                for (Carte carte : carti) {
                    System.out.println(carte);
                }
            }
        public List<Carte> cautareFrazaDupaPaginaSiTitlu(String titlu, int pagina) {
            List<Carte> rezultat = new ArrayList<>();

            for (Carte carte : carti) {
                if (carte.getTitlu().equals(titlu)) {
                    String continutPagina = carte.getContinutPagina(pagina);
                    if (continutPagina != null && continutPagina.contains(fraza)) {
                        rezultat.add(carte);
                    }
                }
            }

            return rezultat;
        }


        public void adaugaCarteDeLaTastatura() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Introduceți numele autorului: ");
            String autor = scanner.nextLine();
            System.out.print("Introduceți titlul cărții: ");
            String titlu = scanner.nextLine();
            System.out.print("Introduceți numărul de pagini: ");
            int pagini = scanner.nextInt();
            scanner.nextLine();  // Consuma newline-ul

            Carte carteNoua = new Carte(autor, titlu, pagini);

            for (int i = 1; i <= pagini; i++) {
                System.out.print("Introduceți conținutul pentru pagina " + i + ": ");
                String continutPagina = scanner.nextLine();
                carteNoua.getFraze().add(continutPagina);
            }

            carti.add(carteNoua);
        }


    }
