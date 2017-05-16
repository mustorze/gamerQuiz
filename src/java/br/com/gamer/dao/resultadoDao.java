package br.com.gamer.dao;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class resultadoDao extends Dao {

    public boolean gravaResultado(int id, int pontos) {

        try {

            this.conectar();
            String query = "INSERT INTO resultado (usuario_id, pontuacao) VALUES (?, ?)";

            this.stmt = (PreparedStatement) this.conn.prepareStatement(query);
            this.stmt.setInt(1, id);
            this.stmt.setInt(2, pontos);
            this.stmt.execute();

            return true;

        } catch (SQLException ex) {

            Logger.getLogger(resultadoDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }

    }

}
