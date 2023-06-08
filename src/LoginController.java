import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField;

    private Connection connection;

    public void setDatabaseConnection(Connection connection) {
        this.connection = connection;
    }

    @FXML
    private void loginButtonClicked() {
        String username = usernameTextField.getText();
        String Passwords = passwordTextField.getText();

        if (connection != null) {
            try {
                // Prepare a SQL statement to check username and Passwords
                String sql = "SELECT * FROM login WHERE username = ? AND Passwords = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, username);
                statement.setString(2, Passwords);

                // Execute the query
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    // Login successful
                    System.out.println("Login successful!");

                    // Load the new FXML file and set it as the new scene
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("E_Menu.fxml"));
                    Parent root = loader.load();
                    E_MenuController controller = loader.getController();
                    Scene scene = new Scene(root);

                    Stage stage = (Stage) usernameTextField.getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                } else {
                    // Login failed
                    System.out.println("Login failed!");
                    // Add code to display an error message or handle login failure
                }
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
