package view;

import DBConexion.DAOPlaylistImpl;
import Interfaces.DAOPlaylist;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerAgregarPlaylist {

    @FXML
    private TextField nombrePlaylist;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void volverPrincipal(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Principal.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void botonAgregar(){
        String nombre = nombrePlaylist.getText();
        String fechaAnadido = java.time.LocalDate.now().toString();
        try {
            DAOPlaylist daoPlaylist = new DAOPlaylistImpl();
            daoPlaylist.agregarPlaylist(nombre, "00:00", fechaAnadido, ControllerLogin.getIdUsuarioIngresado());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}