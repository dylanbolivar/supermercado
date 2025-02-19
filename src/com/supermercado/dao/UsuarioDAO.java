package com.supermercado.dao;

import com.supermercado.database.ConexionBD;
import com.supermercado.models.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    
    // INSERTAR USUARIO
    public static void insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, correo, contraseña) VALUES (?, ?, ?)";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getCorreo());
            stmt.setString(3, usuario.getContraseña());
            stmt.executeUpdate();
            System.out.println("✅ Usuario registrado.");
        } catch (SQLException e) {
            System.out.println("❌ Error al insertar: " + e.getMessage());
        }
    }

    // CONSULTAR TODOS LOS USUARIOS
    public static void mostrarUsuarios() {
        String sql = "SELECT * FROM usuarios";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Nombre: " + rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al consultar: " + e.getMessage());
        }
    }

    // ACTUALIZAR USUARIO
    public static void actualizarUsuario(int id, String nuevoNombre, String nuevoCorreo) {
        String sql = "UPDATE usuarios SET nombre = ?, correo = ? WHERE id = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nuevoNombre);
            stmt.setString(2, nuevoCorreo);
            stmt.setInt(3, id);
            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("✅ Usuario actualizado.");
            } else {
                System.out.println("⚠️ No se encontró el usuario con ID " + id);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar: " + e.getMessage());
        }
    }

    // ELIMINAR USUARIO
    public static void eliminarUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("✅ Usuario eliminado.");
            } else {
                System.out.println("⚠️ No se encontró el usuario con ID " + id);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar: " + e.getMessage());
        }
    }
}
