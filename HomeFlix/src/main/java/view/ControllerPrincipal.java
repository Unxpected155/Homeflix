package view;

import DBConexion.DAOPlaylistImpl;
import Interfaces.DAOPlaylist;
import Threads.ProcesoServidor;
import com.almasb.fxgl.entity.action.Action;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Playlist;

import java.io.*;
import java.net.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerPrincipal implements Initializable {

    @FXML
    private TableView<Playlist> tblPlaylist;

    @FXML
    private TableColumn<Playlist, String> nombreCO;

    @FXML
    private TableColumn<Playlist, String> fechaCO;

    @FXML
    private Label usuario;

    @FXML
    private Button startHost;

    @FXML
    private Button joinServer;

    private ObservableList<Playlist> playlistList;

    public static String username;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        ControllerPrincipal.username = username;
    }
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usuario.setText("Bienvenido " + username);
        DAOPlaylist daoPlaylist = new DAOPlaylistImpl();
        playlistList = FXCollections.observableArrayList();
        ArrayList<Playlist> playlistUsuario = null;
        try {
            playlistUsuario = daoPlaylist.listarPlaylists(ControllerLogin.getIdUsuarioIngresado());
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        playlistList.setAll(playlistUsuario);
        this.nombreCO.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.fechaCO.setCellValueFactory(new PropertyValueFactory<>("fechaCreacion"));

        tblPlaylist.setItems(playlistList);
    }
}
