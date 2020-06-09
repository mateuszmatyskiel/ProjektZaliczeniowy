package szyfrPlotkowy;

import application.Helper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SzyfrPlotkowyController implements Initializable {

    public String wiadomosc;
    public String szyfrogram;
    public int pozycja;
    public int klucz;

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
    private TextArea szyfrowaniePozycja;

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

    @FXML
    private TextArea deszyfrowaniePozycja;

    Helper helper = new Helper();
    SzyfrPlotkowy szyfr = new SzyfrPlotkowy();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        szyfrowanieSzyfruj.setOnAction(event -> {
            wiadomosc = ((szyfrowanieWiadomosc.getText()).toUpperCase()).trim();
            klucz = Integer.parseInt(szyfrowanieKlucz.getText());
            pozycja = Integer.parseInt(szyfrowaniePozycja.getText());
            try {
                szyfrogram = szyfr.SzyfrowaniePlotkowe(wiadomosc, klucz, pozycja);
            } catch (IOException e) {
                e.printStackTrace();
            }
            szyfrowanieSzyfrogram.setText(szyfrogram);
        });

        deszyfrowanieDeszyfruj.setOnAction(event -> {
            szyfrogram = ((deszyfrowanieSzyfrogram.getText()).toUpperCase()).trim();
            klucz = Integer.parseInt(deszyfrowanieKlucz.getText());
            pozycja = Integer.parseInt(deszyfrowaniePozycja.getText());
            wiadomosc = szyfr.DeszyfrowaniePlotkowe(szyfrogram, klucz, pozycja);
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