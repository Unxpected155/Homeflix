package Interfaces;


import model.Video;

import java.util.ArrayList;

public interface DAOVideo {
    public void agregarVideos(String nombre, String categoria, String duracion, String dia, String descripcion, String localizacion) throws Exception;
    public ArrayList<Video> listarVideos() throws Exception;
    public ArrayList<Video> listarVideoNC(String nombre, String categoria) throws Exception;
}
