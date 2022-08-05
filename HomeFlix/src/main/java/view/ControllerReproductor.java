package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerReproductor implements Initializable {
    @FXML
    private Button pauseButton;

    @FXML
    private Button playButton;

    @FXML
    private Button resetButton;

    @FXML
    private MediaView mediaView;

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        file = new File("D:\\Videos\\clip.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
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


}
