package szyfrPlotkowy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SzyfrPlotkowy {

    public static String SzyfrowaniePlotkowe(String slowo, int klucz, int pozycja) throws IOException {
        String wynik;
        char[][] tablica = new char[klucz][slowo.length()];
        int zwiekszenieWiersza = 1;
        for (int wiersz = pozycja, kolumna = 0; kolumna < tablica[wiersz].length; kolumna++) {
            if (wiersz + zwiekszenieWiersza == tablica.length || wiersz + zwiekszenieWiersza == -1)
                zwiekszenieWiersza *= -1;
            tablica[wiersz][kolumna] = slowo.charAt(kolumna);
            wiersz += zwiekszenieWiersza;
        }
        wynik = TablicaWString(tablica);
        Files.write(Paths.get("szyfrogram.txt"), wynik.getBytes());
        return wynik;
    }

    public static String DeszyfrowaniePlotkowe(String slowo, int klucz, int pozycja) {
        String wynik;
        char[][] matrix = new char[klucz][slowo.length()];
        int zwiekszenieWiersza = 1;
        int indeks = 0;
        for (int wybranyWiersz = 0; wybranyWiersz < matrix.length; wybranyWiersz++) {
            for (int wiersz = pozycja, kolumna = 0; kolumna < matrix[wiersz].length; kolumna++) {
                if (wiersz + zwiekszenieWiersza == matrix.length || wiersz + zwiekszenieWiersza == -1) {
                    zwiekszenieWiersza *= -1;
                }
                if (wiersz == wybranyWiersz) {
                    matrix[wiersz][kolumna] = slowo.charAt(indeks++);
                }
                wiersz += zwiekszenieWiersza;
            }
        }
        matrix = Transpozycja(matrix);
        wynik = TablicaWString(matrix);
        return wynik;
    }

    public static String TablicaWString(char[][] matrix) {
        String result = "";
        for (char[] matrix1 : matrix) {
            for (int col = 0; col < matrix1.length; col++) {
                if (matrix1[col] != '\0') {
                    result += matrix1[col];
                }
            }
        }
        return result;
    }

    public static char[][] Transpozycja(char[][] matrix) {
        char[][] result = new char[matrix[0].length][matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                result[col][row] = matrix[row][col];
            }
        }
        return result;
    }
}
