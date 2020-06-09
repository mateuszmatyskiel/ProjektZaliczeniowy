package rsa;

import application.Helper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class RSAController implements Initializable {

    private static String wiadomosc;
    private static String szyfrogram;
    private static String kluczPrywatny;

    @FXML
    private TextArea szyfrowanieWiadomosc;

    @FXML
    private Button szyfrowanieSzyfruj;

    @FXML
    private Button szyfrowanieWybierzPlik;

    @FXML
    private TextArea szyfrowanieSzyfrogram;

    @FXML
    private TextArea deszyfrowanieSzyfrogram;

    @FXML
    private Button deszyfrowanieDeszyfruj;

    @FXML
    private Button deszyfrowanieWybierzPlik;

    @FXML
    private Button deszyfrowanieWybierzPlik2;

    @FXML
    private TextArea deszyfrowanieKluczPrywatny;

    @FXML
    private TextArea deszyfrowanieWiadomosc;

    public RSAController() {
    }

    Helper helper = new Helper();
    rsa.RSA rsa = new rsa.RSA();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        szyfrowanieSzyfruj.setOnAction(event -> {
            wiadomosc = ((szyfrowanieWiadomosc.getText()).toUpperCase()).trim();
            szyfrogram = rsa.SzyfrowanieTekstu(wiadomosc);
            szyfrowanieSzyfrogram.setText(szyfrogram);
        });

        deszyfrowanieDeszyfruj.setOnAction(event -> {
            szyfrogram = ((deszyfrowanieSzyfrogram.getText()).toUpperCase()).trim();
            kluczPrywatny = ((deszyfrowanieKluczPrywatny.getText()).toUpperCase()).trim();
            wiadomosc = rsa.DeszyfrowaniePliku(kluczPrywatny, szyfrogram);
            deszyfrowanieWiadomosc.setText(wiadomosc);
        });

        szyfrowanieWybierzPlik.setOnAction(event -> {
            helper.fileChooser(szyfrowanieWiadomosc);
        });

        deszyfrowanieWybierzPlik.setOnAction(event -> {
            helper.fileChooser2(deszyfrowanieSzyfrogram);
        });

        deszyfrowanieWybierzPlik2.setOnAction(event -> {
            helper.fileChooser2(deszyfrowanieKluczPrywatny);
        });
    }
}
