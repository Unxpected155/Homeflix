package DBConexion;


import Interfaces.DAOVideo;
import model.Usuario;
import model.Video;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOVideoImpl extends DBConexion implements DAOVideo {
    @Override
    public void agregarVideos(Video video) throws Exception {
        boolean bandera = true;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO video (nombre, categoria, duracion, fechaAnadido, descripcion) VALUES (?,?,?,?,?)");
            st.setString(1, video.getName());
            st.setString(2, video.getCategory());
            st.setDouble(3, video.getDuracion());
            st.setString(4, video.getDate());
            st.setString(5, video.getDescripcion());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public ArrayList<Video> listarVideos() throws Exception {
        ArrayList<Video> listarVideos = null;
        try{
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM video");
            listarVideos = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Video video = new Video();
                video.setName(rs.getString("nombre"));
                video.setDuracion(rs.getDouble("duracion"));
                video.setCategory(rs.getString("categoria"));
                video.setDate(rs.getString("fechaAnadido"));
                video.setDescripcion(rs.getString("descripcion"));
                listarVideos.add(video);
            }
            rs.close();
            st.close();
        }catch (Exception e){
            throw e;
        } finally {
            this.cerrar();
        }
        return listarVideos;
    }
}
