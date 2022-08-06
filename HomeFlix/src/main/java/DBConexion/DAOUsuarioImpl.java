package DBConexion;

import Interfaces.DAOUsuario;
import javafx.scene.control.Alert;
import model.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOUsuarioImpl extends DBConexion implements DAOUsuario {
    @Override
    public void agregarUsuario(Usuario usuario) throws Exception {
        boolean bandera = true;
        try{
            this.conectar();
            PreparedStatement prs = this.conexion.prepareStatement("SELECT nombreUsuario from usuario");
            ResultSet resultSet = prs.executeQuery();
            while (resultSet.next()) {
                String retrievedUsername = resultSet.getString("nombreUsuario");
                if (retrievedUsername.equals(usuario.getNombreUsuario())) {
                    System.out.println("Usuario ya existe");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Usuario ya existe");
                    alert.show();
                    bandera = false;
                    break;
                }
            } if(bandera){
                PreparedStatement st = this.conexion.prepareStatement("INSERT INTO usuario (nombreUsuario, contrasena, nombre, identificacion, primerApellido, segundoApellido, avatar) VALUES (?,?,?,?,?,?,?)");
                st.setString(1,usuario.getNombreUsuario());
                st.setString(2,usuario.getContrasena());
                st.setString(3,usuario.getNombre());
                st.setString(4,usuario.getIdentifiacion());
                st.setString(5,usuario.getPrimerApellido());
                st.setString(6,usuario.getSegundoApellido());
                st.setString(7, usuario.getAvatar());
                st.executeUpdate();
            }

        }catch (Exception e){
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public ArrayList<Usuario> listarUsuarios() throws Exception {
        ArrayList<Usuario> listaUsuario = null;
        try{
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM usuario");
            listaUsuario = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setNombre(rs.getString("nombre"));
                usuario.setPrimerApellido(rs.getString("primerApellido"));
                usuario.setSegundoApellido(rs.getString("segundoApellido"));
                usuario.setIdentifiacion(rs.getString("identificacion"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setAvatar(rs.getString("avatar"));
                listaUsuario.add(usuario);
            }
            rs.close();
            st.close();
        }catch (Exception e){
            throw e;
        } finally {
            this.cerrar();
        }
        return listaUsuario;
    }
}
