package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerPrincipal {
    @FXML
    private TreeView ultimosVideos;

    @FXML
    private TreeView listasVideos;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void botonBusqueda(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Busqueda.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void botonVolver(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}