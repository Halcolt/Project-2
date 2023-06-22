import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.sql.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class InformationController {
    @FXML
    private Label infoLabel;

    @FXML
    private void initialize() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("tmp.txt"));
            String name = reader.readLine();
            String pass = reader.readLine();

            // Connect to the database using DatabaseUtil
            Connection connection = DatabaseUtil.connect();
            if (connection != null) {
                // Create a statement
                Statement statement = null;
                ResultSet resultSet = null;

                try {
                    statement = connection.createStatement();

                    // Execute the query to retrieve data from the login table
                    resultSet = statement.executeQuery("SELECT * FROM login WHERE username = '" + name + "' AND Passwords = '" + pass + "'");

                    // Process the results and display them in the label
                    StringBuilder infoText = new StringBuilder();
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            String columnName = metaData.getColumnName(i);
                            String value = resultSet.getString(columnName);
                            infoText.append(columnName).append(": ").append(value);
                            if (i < columnCount) {
                                infoText.append("\n");
                            }
                        }
                        infoText.append("\n");
                    }

                    infoLabel.setText(infoText.toString());
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    // Close the resources
                    try {
                        if (resultSet != null)
                            resultSet.close();
                        if (statement != null)
                            statement.close();
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            // Display an error message to the user
            infoLabel.setText("Error reading configuration file.");
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
