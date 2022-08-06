package Interfaces;


import model.Video;

import java.util.ArrayList;

public interface DAOVideo {
    public void agregarVideos(String nombre, String categoria, double duracion, String dia, String descripcion) throws Exception;
    public ArrayList<Video> listarVideos() throws Exception;
}
