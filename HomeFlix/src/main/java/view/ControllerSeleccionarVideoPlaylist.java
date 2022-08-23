package view;

import DBConexion.DAOVideoImpl;
import Interfaces.DAOVideo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Playlist;
import model.Video;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerSeleccionarVideoPlaylist implements Initializable {

    @FXML
    private TableView<Video> tblVideos;

    @FXML
    private TableColumn<Video, String> nombreCO;

    @FXML
    private TableColumn<Video, String> categoriaCO;

    @FXML
    private TableColumn<Video, String> localizacionCO;

    @FXML
    private TableColumn<Video, String> duracionCO;

    @FXML
    private Label namePlaylist;

    private ObservableList<Video> videosList;

    public static String nombrePlaylist;

    public static String getNombrePlaylist() {
        return nombrePlaylist;
    }

    public static void setNombrePlaylist(String nombrePlaylist) {
        ControllerSeleccionarVideoPlaylist.nombrePlaylist = nombrePlaylist;
    }
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
    public void seleccionarVideo(ActionEvent event) throws IOException {
        ObservableList<Video> videoSeleccionado;
        videoSeleccionado = tblVideos.getSelectionModel().getSelectedItems();
        String path = videoSeleccionado.get(0).getLocalizacion();
        ControllerReproductor.setPath(path);

        root = FXMLLoader.load(getClass().getResource("Reproductor.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        namePlaylist.setText("Playlist " + nombrePlaylist);
        DAOVideo daoVideo = new DAOVideoImpl();
        videosList = FXCollections.observableArrayList();
        ArrayList<Video> videosPlaylist;
        try {
            videosPlaylist = daoVideo.listarVideoPlaylist(ControllerSeleccionarVideoPlaylist.getNombrePlaylist());
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        videosList.setAll(videosPlaylist);
        this.nombreCO.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.categoriaCO.setCellValueFactory(new PropertyValueFactory<>("category"));
        this.duracionCO.setCellValueFactory(new PropertyValueFactory<>("duracion"));
        this.localizacionCO.setCellValueFactory(new PropertyValueFactory<>("localizacion"));

        tblVideos.setItems(videosList);
    }
}
