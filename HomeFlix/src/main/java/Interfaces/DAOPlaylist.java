package Interfaces;

import model.Playlist;
import java.util.ArrayList;

public interface DAOPlaylist {
    /**
     *
     * @param idUsuario recibe un parametro de tipo integer para poder identificar cual es el usuario ingresado
     * @return retorna una ArrayList de tipo playlist para poder ver cuales son los playlists del usuario ingresaod
     * @throws Exception En caso de que el query tenga un error
     */
    public ArrayList<Playlist> listarPlaylists(int idUsuario) throws Exception;

    public void agregarPlaylist(String nombre, String duracion, String fechaCreacion, int idUsuario) throws Exception;

    public void agregarVideoPlaylist(int idPlaylist, int idVideo) throws Exception;

}
