package application;

import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Helper {

    public Helper() {
    }

    public static void fileChooser(TextArea textArea) {
        Stage primaryStage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Wybierz plik tekstowy");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showOpenDialog(primaryStage);
        if (file != null) {
            try {
                textArea.setText(Files.readString(Path.of(file.getName())));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void fileChooser2(TextArea textArea) {
        Stage primaryStage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Wybierz plik tekstowy");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showOpenDialog(primaryStage);
        if (file != null) {
            textArea.setText(file.getName());
        }
    }
}
