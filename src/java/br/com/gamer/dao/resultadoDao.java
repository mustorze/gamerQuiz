package br.com.gamer.dao;

import br.com.gamer.classes.Resultado;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
    public ArrayList<Resultado> resultados() {
        
        String query = "SELECT resultado.pontuacao, resultado.usuario_id, usuario.id, usuario.nome " +
              "FROM resultado JOIN usuario ON resultado.usuario_id = usuario.id ORDER BY resultado.pontuacao DESC";
        this.conectar();

        ArrayList<Resultado> c = new ArrayList<>();

        try {

            this.stmt = (PreparedStatement) this.conn.prepareStatement(query);
            ResultSet rs = this.stmt.executeQuery(query);

            while (rs.next()) {

                Resultado l = new Resultado();
                
                l.setPontuacao(rs.getInt(1));
                l.setUsuario_nome(rs.getString(4));

                c.add(l);

            }

        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        return c;
        
    }

}
