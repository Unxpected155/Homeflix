package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class ControllerLogin {
    @FXML
    private TextField usuarioTF;
    @FXML
    private TextField contrasenaTF;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void cambiarEscenaRegistro(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Registro.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void botonLogin(ActionEvent event) throws IOException {
        String usuario = usuarioTF.getText();
        String contrasenia = contrasenaTF.getText();
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement prs = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx-homeflix", "root", "toor");
            prs = connection.prepareStatement("SELECT password FROM cuentapersona WHERE username = ?");
            prs.setString(1, usuario);
            resultSet = prs.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                System.out.println("Usuario no encontrado en la base de datos!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("El usuario no existe!");
                alert.show();
            } else {
                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString("password");
                    if (retrievedPassword.equals(contrasenia)) {
                        root = FXMLLoader.load(getClass().getResource("Principal.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    } else {
                        System.out.println("La contrasenia es incorrecta");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("La contraseña es incorrecta");
                        alert.show();
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
