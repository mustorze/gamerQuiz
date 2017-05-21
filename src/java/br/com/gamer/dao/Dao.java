package br.com.gamer.dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dao {

    private String servidor;
    private String banco;
    private String usuario;
    private String senha;

    protected PreparedStatement stmt;
    protected Connection conn;

    public Dao() {

        this.servidor = "localhost";
        this.banco = "gamerquiz";
        this.usuario = "root";
        this.senha = "";

    }

    public void conectar() {

        String url = "jdbc:mysql://" + servidor + ":3306/" + banco;

        try {

            Class.forName("org.gjt.mm.mysql.Driver");

            conn = (Connection) DriverManager.getConnection(url, usuario, senha);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
