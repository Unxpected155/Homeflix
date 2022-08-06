package Interfaces;


import model.Video;

import java.util.ArrayList;

public interface DAOVideo {
    public void agregarVideos(Video video) throws Exception;
    public ArrayList<Video> listarVideos() throws Exception;
}
