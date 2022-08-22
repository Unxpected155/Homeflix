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
        try{
            this.conectar();
            PreparedStatement prs = this.conexion.prepareStatement("INSERT INTO playlist (nombre, duracion, fechaCreacion, usuario_idusuario) VALUES(?,?,?,?) ");
            prs.setString(1, nombre);
            prs.setString(2, duracion);
            prs.setString(3, fechaCreacion);
            prs.setInt(4, idUsuario);
            prs.executeUpdate();
        } catch(Exception e){
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void agregarVideoPlaylist(String path, String nombrePlaylist) throws Exception {

    }
}
