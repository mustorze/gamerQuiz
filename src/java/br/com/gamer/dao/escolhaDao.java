package br.com.gamer.dao;

import br.com.gamer.classes.Escolha;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class escolhaDao extends Dao {
    
    public ArrayList<Escolha> getEscolhas(int id) {

        String query = "SELECT * FROM `escolha` WHERE pergunta_id = '" + id + "'";
        this.conectar();

        ArrayList<Escolha> c = new ArrayList<>();

        try {

            this.stmt = (PreparedStatement) this.conn.prepareStatement(query);
            ResultSet rs = this.stmt.executeQuery(query);

            while (rs.next()) {

                Escolha l = new Escolha();
                
                l.setId(rs.getInt("id"));
                l.setDescricao(rs.getString("descricao"));
                l.setPergunta_id(id);

                c.add(l);

            }

        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        return c;

    }
    
}
