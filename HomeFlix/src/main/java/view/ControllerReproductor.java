package view;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.ValueAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;

public class ControllerReproductor implements Initializable {

    @FXML
    private MediaView mvVideo;

    @FXML
    private VBox vBoxParent;

    private  MediaPlayer mpVideo;

    private  Media mediaVideo;

    @FXML
    private HBox hboxControls;

    @FXML
    private  HBox hboxVolume;

    @FXML
    private Button buttonPPR;

    @FXML
    private  Label labelCurrentTime;

    @FXML
    private Label labelTotalTime;

    @FXML
    private  Label labelSpeed;

    @FXML
    private Label labelVolume;

    @FXML
    private Slider sliderVolume;

    @FXML
    private Slider sliderTime;

    private boolean atEndOfVideo = false;

    private  boolean isPlaying = true;

    private boolean isMuted = true;

    private  ImageView ivPlay;

    private  ImageView ivPause;

    private  ImageView ivRestart;

    private  ImageView ivVolume;

    private  ImageView ivFullScreen;

    private  ImageView ivMute;

    private  ImageView ivExit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        mediaVideo = new Media(new File("D:\\Fotos & videos\\Jre-legacy\\Chang_gritando.mp4").toURI().toString());
        mpVideo = new MediaPlayer(mediaVideo);
        mvVideo.setMediaPlayer(mpVideo);

        final  int ivTamano = 25;

        Image imagePlay = new Image(new File("").toURI().toString());
        ivPlay = new ImageView(imagePlay);
        ivPlay.setFitHeight(ivTamano);
        ivPlay.setFitWidth(ivTamano);

        Image imageStop = new Image(new File("").toURI().toString());
        ivPause = new ImageView(imagePlay);
        ivPause.setFitHeight(ivTamano);
        ivPause.setFitWidth(ivTamano);

        Image imageRestart = new Image(new File("").toURI().toString());
        ivRestart = new ImageView(imagePlay);
        ivRestart.setFitHeight(ivTamano);
        ivRestart.setFitWidth(ivTamano);

        Image imageVol = new Image(new File("").toURI().toString());
        ivVolume = new ImageView(imagePlay);
        ivVolume.setFitHeight(ivTamano);
        ivVolume.setFitWidth(ivTamano);

        Image imageFull = new Image(new File("").toURI().toString());
        ivFullScreen = new ImageView(imagePlay);
        ivFullScreen.setFitHeight(ivTamano);
        ivFullScreen.setFitWidth(ivTamano);

        Image imageMute = new Image(new File("").toURI().toString());
        ivMute = new ImageView(imagePlay);
        ivMute.setFitHeight(ivTamano);
        ivMute.setFitWidth(ivTamano);

        Image imageExit = new Image(new File("").toURI().toString());
        ivExit = new ImageView(imagePlay);
        ivExit.setFitHeight(ivTamano);
        ivExit.setFitWidth(ivTamano);

        buttonPPR.setGraphic(ivPause);
        labelVolume.setGraphic(ivMute);
        labelSpeed.setText("1X");

        hboxVolume.getChildren().remove(sliderVolume);
        mpVideo.volumeProperty().bindBidirectional(sliderVolume.valueProperty());

    }

//    public void bindCurrentTimeLabel(){
//
//        labelCurrentTime.textProperty().bind(Bindings.createStringBinding(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                return getTime(mpVideo.getCurrentTime() + " / ");
//            }
//        }, mpVideo.currentTimeProperty()));
//
//    }

//    public String getTime(Duration time){
//
//        int hours = (int) time.toHours();
//        int minutes = (int) time.toMinutes();
//        int seconds = (int) time.toSeconds();
//
//        if (seconds > 59) {
//
//            minutes = seconds % 60;
//        }
//
//
//
//    }
}
