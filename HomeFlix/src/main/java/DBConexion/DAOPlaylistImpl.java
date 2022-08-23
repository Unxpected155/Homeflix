package DBConexion;

import Interfaces.DAOPlaylist;
import model.Playlist;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOPlaylistImpl extends DBConexion implements DAOPlaylist {
    @Override
    public ArrayList<Playlist> listarPlaylists(int idUsuario) throws Exception {
        ArrayList<Playlist> listarPlaylists;
        try{
            this.conectar();
            PreparedStatement prs = this.conexion.prepareStatement("SELECT * FROM playlist WHERE usuario_idusuario = ?");
            prs.setInt(1, idUsuario);
            listarPlaylists = new ArrayList<>();
            ResultSet rs = prs.executeQuery();
            while(rs.next()) {
                Playlist playlist = new Playlist();
                String retrievedNombre = rs.getString("nombre");
                String retrievedFechaCreacion = rs.getString("fechaCreacion");
                playlist.setNombre(retrievedNombre);
                playlist.setFechaCreacion(retrievedFechaCreacion);
                listarPlaylists.add(playlist);
            }
        } catch (Exception e){
            throw e;
        } finally {
            this.cerrar();
        }
        return listarPlaylists;
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
    public void agregarVideoPlaylist(int idPlaylist, int idVideo) throws Exception {

    try{
        this.conectar();
        PreparedStatement prs = this.conexion.prepareStatement("INSERT INTO playlist_has_video (playlist_idplaylist, video_idvideo) VALUES (?,?)");
        prs.setInt(1, idPlaylist);
        prs.setInt(2,idVideo);
    } catch (Exception e){
        throw e;
    } finally {
        this.cerrar();
    }
    }
}
