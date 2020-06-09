package szyfrVigenerea;

import application.Helper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SzyfrVigenereaController implements Initializable {

    public String wiadomosc;
    public String szyfrogram;
    public String klucz;

    @FXML
    private TextArea szyfrowanieWiadomosc;

    @FXML
    private Button szyfrowanieSzyfruj;

    @FXML
    private Button szyfrowanieWybierzPlik;

    @FXML
    private TextArea szyfrowanieKlucz;

    @FXML
    private TextArea szyfrowanieSzyfrogram;

    @FXML
    private TextArea deszyfrowanieSzyfrogram;

    @FXML
    private Button deszyfrowanieDeszyfruj;

    @FXML
    private Button deszyfrowanieWybierzPlik;

    @FXML
    private TextArea deszyfrowanieKlucz;

    @FXML
    private TextArea deszyfrowanieWiadomosc;

    Helper helper = new Helper();
    SzyfrVigenerea szyfr = new SzyfrVigenerea();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        szyfrowanieSzyfruj.setOnAction(event -> {
            wiadomosc = ((szyfrowanieWiadomosc.getText()).toUpperCase()).trim();
            klucz = (((szyfrowanieKlucz.getText()).toUpperCase()).trim()).replace(" ", "");
            try {
                szyfrogram = szyfr.SzyfrowanieVigenerea(wiadomosc, klucz);
            } catch (IOException e) {
                e.printStackTrace();
            }
            szyfrowanieSzyfrogram.setText(szyfrogram);
        });

        deszyfrowanieDeszyfruj.setOnAction(event -> {
            szyfrogram = ((deszyfrowanieSzyfrogram.getText()).toUpperCase()).trim();
            klucz = (((deszyfrowanieKlucz.getText()).toUpperCase()).trim()).replace(" ", "");
            wiadomosc = szyfr.DeszyfrowanieVigenerea(szyfrogram, klucz);
            deszyfrowanieWiadomosc.setText(wiadomosc);
        });

        szyfrowanieWybierzPlik.setOnAction(event -> {
            helper.fileChooser(szyfrowanieWiadomosc);
        });

        deszyfrowanieWybierzPlik.setOnAction(event -> {
            helper.fileChooser(deszyfrowanieSzyfrogram);
        });
    }
}
