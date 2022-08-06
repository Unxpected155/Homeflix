package Interfaces;

import model.Usuario;

import java.util.ArrayList;

public interface DAOUsuario {
    public void agregarUsuario(Usuario usuario) throws Exception;
    public ArrayList<Usuario> listarUsuarios() throws Exception;
}
