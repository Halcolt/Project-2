import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class E_MenuController {
    @FXML
    private Button PersonalInfo;

    @FXML
    private Button Importing;

    @FXML
    private Button CreateOrder;

    @FXML
    private void initialize() {
        PersonalInfo.setOnAction(event -> {
            // Load the information scene
            loadScene("Information.fxml");
        });

        Importing.setOnAction(event -> {
            // Load the import scene
            loadScene("Import.fxml");
        });

        CreateOrder.setOnAction(event -> {
            // Load the create order scene
            loadScene("CreateOrder.fxml");
        });
    }

    private void loadScene(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) PersonalInfo.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
