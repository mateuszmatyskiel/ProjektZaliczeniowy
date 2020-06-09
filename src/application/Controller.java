package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    public void changeSceneToVigenereView(javafx.event.ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../szyfrVigenerea/szyfrVigenereaView.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        tableViewScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        window.setTitle("Szyfr Vigenere'a");
        window.setScene(tableViewScene);
        window.show();
    }

    public void changeSceneToPlotkowyView(javafx.event.ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../szyfrPlotkowy/szyfrPlotkowyView.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        tableViewScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        window.setTitle("Szyfr plotkowy");
        window.setScene(tableViewScene);
        window.show();
    }

    public void changeSceneToRSAView(javafx.event.ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../rsa/rsaView.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        tableViewScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        window.setTitle("RSA");
        window.setScene(tableViewScene);
        window.show();
    }
}
