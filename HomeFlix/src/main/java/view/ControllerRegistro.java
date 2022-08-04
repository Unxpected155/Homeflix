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

    public void botonCrear(ActionEvent event) throws IOException {
        String nombre = nombreTF.getText();
        String identificacion = identificacionTF.getText();
        String primerApellido = primerApellidoTF.getText();
        String segundoApellido = segundoApellidoTF.getText();
        String usuario = usuarioTF.getText();
        String contrasena = contrasenaTF.getText();
        String confirmarContrasena = confirmarContrasenaTF.getText();
        PreparedStatement ps;
        Connection connection;
        if(contrasena.equals(confirmarContrasena)){
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx-homeflix", "root", "toor");
                    ps = connection.prepareStatement("INSERT INTO cuentapersona (username, password, nombre, identificacion, primerApellido, segundoApellido) VALUES (?,?,?,?,?,?)");
                    ps.setString(1,usuario);
                    ps.setString(2,contrasena);
                    ps.setString(3,nombre);
                    ps.setString(4,identificacion);
                    ps.setString(5,primerApellido);
                    ps.setString(6,segundoApellido);
                    ps.executeUpdate();
                    root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();


            } catch (SQLException e){
                e.printStackTrace();
            }

        } else {
            System.out.println("La contraseñas no coinciden");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("La contraseñas no coinciden");
            alert.show();
        }

    }

    public void buscarAvatar(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Imagen");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );

        File imgFile = fileChooser.showOpenDialog(null);
        if (imgFile != null){
            avatar.setImage(new Image(imgFile.toURI().toString()));
        }
    }
}
