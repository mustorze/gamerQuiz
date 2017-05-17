package br.com.gamer.dao;

import br.com.gamer.classes.Usuario;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class cadastroDao extends Dao {
    
    public boolean cadastrar(Usuario usr) {

        try {

            this.conectar();
            String query = "INSERT INTO usuario (email, senha, nome) VALUES (?, ?, ?)";

            this.stmt = (PreparedStatement) this.conn.prepareStatement(query);
            this.stmt.setString(1, usr.getEmail());
            this.stmt.setString(2, usr.getSenha());
            this.stmt.setString(3, usr.getNome());
            this.stmt.execute();
            
            return true;

        } catch (SQLException ex) {

            Logger.getLogger(loginDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }

    }
    
}
