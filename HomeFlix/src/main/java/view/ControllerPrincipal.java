package view;

import Threads.ProcesoServidor;
import com.almasb.fxgl.entity.action.Action;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;
import java.io.*;
import java.net.*;

import java.io.IOException;

public class ControllerPrincipal {
    @FXML
    private TreeView ultimosVideos;

    @FXML
    private TreeView listasVideos;

    @FXML
    private Button startHost;

    @FXML
    private Button joinServer;
    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Cambia la pantalla actual por la pantalla de busqueda
     * @author Gabriel Porras Brenes
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

    /**
     * funcion para volver a la pantalla de Login
     * @author Gabriel Porras Brenes
     * @param event un evento representando un tipo de action
     * @throws IOException signo de que algun tipo de excepcion ha ocurrido
     */
    public void botonVolver(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * funcion que cambia la pantalla actual a la pantalla agregar video
     * @author Gabriel Porras Brenes
     * @param event un evento representando un tipo de action
     * @throws IOException signo de que algun tipo de excepcion ha ocurrido
     */
    public void botonAgregarVideo(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("AgregarVideo.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void botonAgregarPlaylist(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("AgregarPlaylist.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void botonJoinServer(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ConectarCliente.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void botonStartHost(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("IniciarHost.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void iniciarServidor(){

        ProcesoServidor levantarServidor = new ProcesoServidor();

        levantarServidor.start();

    }
}
