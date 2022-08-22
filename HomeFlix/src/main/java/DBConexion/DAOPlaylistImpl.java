package DBConexion;

import Interfaces.DAOPlaylist;
import model.Playlist;

import java.sql.PreparedStatement;
import java.util.ArrayList;

public class DAOPlaylistImpl extends DBConexion implements DAOPlaylist {
    @Override
    public ArrayList<Playlist> listarPlaylists() throws Exception {
        return null;
    }

    @Override
    public void agregarPlaylist(String nombre, String duracion, String fechaCreacion, int idUsuario) throws Exception {

    }

    @Override
    public void agregarVideoPlaylist(String path, String nombrePlaylist) throws Exception {

    }
}
