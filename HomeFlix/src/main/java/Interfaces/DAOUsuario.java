package Interfaces;

import model.Usuario;

import java.util.ArrayList;

public interface DAOUsuario {
    public void agregarUsuario(Usuario usuario) throws Exception;
    public ArrayList<Usuario> listarUsuarios() throws Exception;
    public boolean revisarContrasenia(String contrasenia,String usuario) throws Exception;
    public boolean usuarioExiste(String usuario) throws Exception;
}
