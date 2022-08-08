package view;

import com.almasb.fxgl.entity.action.Action;
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

    /**
     * Cambia la pantalla actual por la pantalla de busqueda
     * @param event un evento representando un tipo de action
     * @throws IOException signo de que algun tipo de excepcion ha ocurrido
     */
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
    public void botonAgregarVideo(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("AgregarVideo.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
