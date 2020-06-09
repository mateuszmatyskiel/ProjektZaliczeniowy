package rsa;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

import static rsa.RSAExample.decrypt;
import static rsa.RSAExample.encrypt;
import static rsa.RSAExample.generateKeyPair;

public class RSA {

    public static PrivateKey getPrK(String filename) throws Exception {
        byte[] keyBytes = Files.readAllBytes(Paths.get(filename));
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }

    public static String SzyfrowanieTekstu(String tekstJawny) {

        String wynik = "";
        try {
            KeyPair klucz = generateKeyPair();
            //Files.write(Paths.get("klucz publiczny.txt"), klucz.getPublic().getEncoded());
            Files.write(Paths.get("klucz prywatny.txt"), klucz.getPrivate().getEncoded());
            String szyfrogram = encrypt(tekstJawny, klucz.getPublic());
            Files.write(Paths.get("szyfrogram.txt"), szyfrogram.getBytes());

            wynik = szyfrogram;
        } catch (Exception ex) {
            System.err.println("Wyjatek: " + ex);
        }
        return wynik;
    }

    public static String DeszyfrowaniePliku(String kluczPrywatny, String szyfrogram) {
        String wynik = "";
        try {
            PrivateKey privateKey = getPrK(kluczPrywatny);
            byte[] tekstJawnyBajty = Files.readAllBytes(Paths.get(szyfrogram));
            String SzyfrogramZPliku = new String(tekstJawnyBajty);
            String tekstPoDeszyfrowaniu = decrypt(SzyfrogramZPliku, privateKey);

            wynik = tekstPoDeszyfrowaniu;
        } catch (Exception ex) {
            System.err.println("Wyjatek: " + ex);
        }
        return wynik;
    }
}
