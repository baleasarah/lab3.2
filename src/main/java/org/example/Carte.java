package org.example;


import java.util.ArrayList;
import java.util.List;

public class Carte {
    private String autor;
    private String titlu;
    private int pagina;

    private List<String> fraze;

    public Carte(String autor, String titlu, int pagini) {
        this.autor = autor;
        this.titlu = titlu;
        this.pagina = pagini;
        this.fraze = new ArrayList<>();
    }



    public String getTitlu() {
        return titlu;
    }

    public String getAutor() {
        return autor;
    }

    public int getPagina() {
        return pagina;
    }
    public String getContinutPagina(int numarPagina) {
        if (numarPagina >= 1 && numarPagina <= fraze.size()) {
            return fraze.get(numarPagina - 1); // Scădem 1 pentru că indexul listei începe de la 0
        }
        return null; // Pagina nu există
    }
    public void adaugaFraza(String fraza) {
        fraze.add(fraza);
    }

    public List<String> getFraze() {
        return fraze;
    }

    @Override
    public String toString() {
        return "Titlu: " + titlu + ", Autor: " + autor + ", Pagini: " + pagina +",Fraza" + fraze;
    }

}