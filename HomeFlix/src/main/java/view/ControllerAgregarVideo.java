package view;

import DBConexion.DAOVideoImpl;
import Interfaces.DAOVideo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class ControllerAgregarVideo {

    @FXML
    private TextField nombreTF;

    @FXML
    private TextField categoriaTF;

    @FXML
    private TextField descripcionTF;

    @FXML
    private Label videoLB;

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

    public void buscarVideo() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Video");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("MP4", "*.mp4")
        );

        File vidFile = fileChooser.showOpenDialog(null);
        if (vidFile != null) {
            videoLB.setText(vidFile.toString());

        }
    }

    public void botonAgregar() {
        String nombre = nombreTF.getText();
        String categoria = categoriaTF.getText();
        String descripcion = descripcionTF.getText();
        String fechaAnadido = java.time.LocalDate.now().toString();
        String localizacion = videoLB.getText();
        if (nombreTF.getText().isEmpty() || categoriaTF.getText().isEmpty() || descripcionTF.getText().isEmpty() || localizacion.isEmpty()) {
            System.out.println("Hay un espacio sin llenar o no hay video seleccionado");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Hay un espacio sin llenar o no hay video seleccionado");
            alert.show();
        } else {
            try {
                DAOVideo daoVideo = new DAOVideoImpl();
                daoVideo.agregarVideos(nombre, categoria, 13.00, fechaAnadido, descripcion,localizacion );
                System.out.println("El video fue agregado exitosamente");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("El video fue agregado exitosamente");
                alert.show();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
