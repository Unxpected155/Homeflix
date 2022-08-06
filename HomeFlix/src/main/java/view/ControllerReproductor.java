package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.ValueAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerReproductor implements Initializable {
    @FXML
    private Button pauseButton;

    private ImageView ivFullsScreen;

    private ImageView ivExit;

    @FXML
    private Button playButton;

    @FXML
    private Button resetButton;

    @FXML
    private MediaView mediaView;

    @FXML
    private Slider progressBar;

    @FXML
    private Button botonFullScreen;

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        file = new File("D:\\Fotos & videos\\Rocket League\\Carritos.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);

        mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observableValue, Duration oldValue, Duration newValue) {

                progressBar.setValue(newValue.toSeconds());
            }
        });

        progressBar.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                mediaPlayer.seek(Duration.seconds(progressBar.getValue()));
            }
        });

        progressBar.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                mediaPlayer.seek(Duration.seconds(progressBar.getValue()));
            }
        });
    }

    public void playVideo() {
        mediaPlayer.play();
    }

    public void pauseVideo() {
        mediaPlayer.pause();
    }

    public void resetVideo() {
        mediaPlayer.seek(Duration.seconds(0.0));
    }

    public void fullScreen(){

        Stage stage = (Stage) botonFullScreen.getScene().getWindow();

        if (stage.isFullScreen()) {

            stage.setFullScreen(false);
            botonFullScreen.setGraphic(ivFullsScreen);

        }else {

            stage.setFullScreen(true);
            botonFullScreen.setGraphic(ivExit);

        }

    }
}
