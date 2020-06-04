package garage.view;

import garage.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;

import java.io.File;

public class RootLayoutController {

    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Opens a FileChooser to select xml file to load.
     */
    @FXML
    private void handleOpen() {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

        if (file != null) {
            mainApp.loadPersonDataFromFile(file);
        }
    }

    /**
     * Called when the user clicks "save".
     */
    @FXML
    private void handleSave() {
        mainApp.savePersonDataToFile();
        saveAlert();
    }

    /**
     * Called when the user clicks "about".
     */
    @FXML
    private void handleAbout() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("GarageApp");
        alert.setHeaderText("About");
        alert.setContentText("Garage App 1.0");

        alert.showAndWait();
    }

    /**
     * Called when the user clicks "exit".
     */
    @FXML
    private void handleExit() {
        mainApp.savePersonDataToFile();
        saveAlert();

        System.exit(0);
    }

    private void saveAlert() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("GarageApp");
        alert.setHeaderText("Save");
        alert.setContentText("App saved");

        alert.showAndWait();
    }
}