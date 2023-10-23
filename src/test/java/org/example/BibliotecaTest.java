import org.example.Biblioteca;
import org.example.Carte;
import org.junit.jupiter.api.BeforeEach;
           import org.junit.jupiter.api.Test;

           import static org.junit.jupiter.api.Assertions.assertEquals;
            import static org.junit.jupiter.api.Assertions.assertTrue;
            import static org.junit.jupiter.api.Assertions.assertFalse;

    class BibliotecaTest {
        private Biblioteca biblioteca;

        @BeforeEach
        void setUp() {
            biblioteca = new Biblioteca();
        }

        @Test
      void afisareCartititlu() {
            // Testați adăugarea unei cărți
            Carte carte = new Carte("Autor Test", "Titlu Test", 100, null);
            biblioteca.adaugaCarte(carte);

            assertTrue(biblioteca.getCarti().contains(carte));
        }

        @Test
      void cautareFrazaDupaPaginaSiTitlu() {
            // Adăugați câteva cărți în bibliotecă

            biblioteca.adaugaCarteDeLaTastatura();
            biblioteca.adaugaCarteDeLaTastatura();
            biblioteca.adaugaCarteDeLaTastatura();

            // Testați sortarea după autor și titlu
            biblioteca.cautareFrazaDupaPaginaSiTitlu();
            assertEquals( biblioteca.getCarti().get(0));
            assertEquals(biblioteca.getCarti().get(1));
            assertEquals( biblioteca.getCarti().get(2));
        }

        @Test
        void adaugaCarteDeLaTastatura() {
            // Adăugați o carte cu fraze
            Carte carte = new Carte("Autor Test", "Titlu Test", 100, List.of("Aceasta este o fraza de test."));
            biblioteca.adaugaCarte(carte);

            // Testați căutarea frazei după titlu și pagină
            List<Carte> rezultate = biblioteca.adaugaCarteDeLaTastatura("Titlu Test", 100);
            assertTrue(rezultate.contains(carte));

            rezultate = biblioteca.adaugaCarteDeLaTastatura("Titlu Inexistent", 100);
            assertFalse(rezultate.contains(carte));

            rezultate = biblioteca.adaugaCarteDeLaTastatura("Titlu Test", 50);
            assertFalse(rezultate.contains(carte));
        }
    }
