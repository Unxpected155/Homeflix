package Interfaces;

import model.Playlist;
import java.util.ArrayList;

public interface DAOPlaylist {
    public ArrayList<Playlist> listarPlaylists() throws Exception;

    public void agregarPlaylist(String nombre, String duracion, String fechaCreacion, int idUsuario) throws Exception;

    public void agregarVideoPlaylist(String path, String nombrePlaylist) throws Exception;

}
