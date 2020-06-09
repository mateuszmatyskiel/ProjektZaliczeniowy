package szyfrVigenerea;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SzyfrVigenerea {

    public String SzyfrowanieVigenerea(String slowo, String klucz) throws IOException {
        String wynik = "";
        slowo = slowo.toUpperCase();
        klucz = klucz.toUpperCase();
        int k;
        for (int i = 0, j = 0; i < slowo.length(); i++) {
            if (slowo.charAt(i) < 65 || slowo.charAt(i) > 90)
                wynik += slowo.charAt(i);
            else {
                if (j >= klucz.length()) j = 0;
                k = slowo.charAt(i) + (klucz.charAt(j++) - 65);
                if (k >= 91)
                    k = 65 + k - 91;
                wynik += (char) k;
            }
        }
        Files.write(Paths.get("szyfrogram.txt"), wynik.getBytes());
        return wynik;
    }

    public String DeszyfrowanieVigenerea(String slowo, String klucz) {
        String wynik = "";
        slowo = slowo.toUpperCase();
        klucz = klucz.toUpperCase();
        int k, t;
        for (int i = 0, j = 0; i < slowo.length(); i++) {
            if (slowo.charAt(i) < 65 || slowo.charAt(i) > 90)
                wynik += slowo.charAt(i);
            else {
                if (j >= klucz.length()) j = 0;
                k = klucz.charAt(j++);
                for (t = 0; k != (int) slowo.charAt(i); t++) {
                    if (k > 90) k = 65;
                    k++;
                }
                wynik += (char) (65 + t);
            }
        }
        return wynik;
    }
}
