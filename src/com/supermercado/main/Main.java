package com.supermercado.main;

import com.supermercado.dao.UsuarioDAO;
import com.supermercado.models.Usuario;

public class Main {
    public static void main(String[] args) {
        // INSERTAR UN NUEVO USUARIO
        Usuario nuevoUsuario = new Usuario(0, "Carlos", "carlos@email.com", "1234");
        UsuarioDAO.insertarUsuario(nuevoUsuario);

        // MOSTRAR TODOS LOS USUARIOS
        UsuarioDAO.mostrarUsuarios();

        // ACTUALIZAR USUARIO (Cambia el ID según los datos de tu BD)
        UsuarioDAO.actualizarUsuario(1, "Carlos Pérez", "carlosperez@email.com");

        // ELIMINAR USUARIO (Cambia el ID según los datos de tu BD)
        UsuarioDAO.eliminarUsuario(2);

        // MOSTRAR USUARIOS NUEVAMENTE PARA VER LOS CAMBIOS
        UsuarioDAO.mostrarUsuarios();
    }
}
