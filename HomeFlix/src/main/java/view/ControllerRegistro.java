package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.*;

public class ControllerRegistro {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ImageView avatar;
    @FXML
    private TextField nombreTF;
    @FXML
    private TextField identificacionTF;
    @FXML
    private TextField primerApellidoTF;
    @FXML
    private TextField segundoApellidoTF;
    @FXML
    private TextField usuarioTF;
    @FXML
    private TextField contrasenaTF;
    @FXML
    private TextField confirmarContrasenaTF;


    public void volverLogin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
