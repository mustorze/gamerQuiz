package br.com.gamer.dao;

import br.com.gamer.classes.Categoria;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class categoriaDao extends Dao {
    
    public Categoria buscar(int id) {

        String query = "SELECT * FROM `categoria` WHERE id = '" + id + "'";
        this.conectar();

        Categoria c = new Categoria();

        try {

            this.stmt = (PreparedStatement) this.conn.prepareStatement(query);
            ResultSet rs = this.stmt.executeQuery(query);

            while (rs.next()) {
                
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));

            }
            
            return c;

        } catch (SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
            return null;
        }

    }
    
}
