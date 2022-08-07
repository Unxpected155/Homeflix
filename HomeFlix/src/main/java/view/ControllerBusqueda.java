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
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Video;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerBusqueda implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField nombreVideoTF;
    @FXML
    private TextField categoriaTF;
    @FXML
    private TableColumn<Video, String> nombreCO;

    @FXML
    private TableColumn<Video, String> categoriaCO;

    @FXML
    private TableColumn<Video, Double> duracionCO;
    @FXML
    private TableColumn<Video, Double> locaizacionCO;

    @FXML
    private TableView<Video> tblVideos;

    private ObservableList<Video> videosList;

    public void volverPrincipal(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Principal.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void buscarVideo(){
        DAOVideo daoVideo = new DAOVideoImpl();
        videosList = FXCollections.observableArrayList();
        ArrayList<Video> videosSeleccionados = null;
        String nombre = nombreVideoTF.getText();
        String categoria = categoriaTF.getText();
        try {
            videosSeleccionados = daoVideo.listarVideoNC(nombre,categoria);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        videosList.setAll(videosSeleccionados);
        this.nombreCO.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.categoriaCO.setCellValueFactory(new PropertyValueFactory<>("category"));
        this.duracionCO.setCellValueFactory(new PropertyValueFactory<>("duracion"));
        this.locaizacionCO.setCellValueFactory(new PropertyValueFactory<>("localizacion"));
        tblVideos.setItems(videosList);
        if(videosList.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No hay ningun video que coincida con la informacion ingresada. Intente de nuevo");
            alert.show();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DAOVideo daoVideo = new DAOVideoImpl();
        videosList = FXCollections.observableArrayList();
        ArrayList<Video> videosSeleccionados = null;
        try {
            videosSeleccionados = daoVideo.listarVideos();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        videosList.setAll(videosSeleccionados);
        this.nombreCO.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.categoriaCO.setCellValueFactory(new PropertyValueFactory<>("category"));
        this.duracionCO.setCellValueFactory(new PropertyValueFactory<>("duracion"));
        this.locaizacionCO.setCellValueFactory(new PropertyValueFactory<>("localizacion"));

        tblVideos.setItems(videosList);

    }
}
