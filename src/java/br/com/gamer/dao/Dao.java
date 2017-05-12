/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gamer.dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Projeto integrado
 */
public class Dao {

    private String servidor;
    private String banco;
    private String usuario;
    private String senha;

    protected PreparedStatement stmt;
    protected Connection conn;

    public Dao() {

        this.servidor = "localhost";
        this.banco = "gamerQuiz";
        this.usuario = "root";
        this.senha = "";

    }

    public void conectar() {

        String url = "jdbc:mysql://" + servidor + ":3306/" + banco;

        try {

            Class.forName("org.gjt.mm.mysql.Driver");

            conn = (Connection) DriverManager.getConnection(url, usuario, senha);

        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
