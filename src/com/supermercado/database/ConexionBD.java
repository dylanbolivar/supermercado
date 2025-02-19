package com.supermercado.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:sqlite:db/supermercado.db"; // Ruta a la BD

    public static Connection conectar() {
        Connection conn = null;
        try {
            // Cargar el driver de SQLite
            Class.forName("org.sqlite.JDBC");

            conn = DriverManager.getConnection(URL);
            System.out.println("✅ Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Error: No se encontró el driver JDBC.");
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar: " + e.getMessage());
        }
        return conn;
    }
}
