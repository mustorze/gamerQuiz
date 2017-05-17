package br.com.gamer.dao;

import br.com.gamer.classes.Escolha;
import br.com.gamer.classes.Pergunta;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class perguntaDao extends escolhaDao {

    public Pergunta getRNDPergunta() {

        String query = "SELECT * FROM `pergunta` ORDER BY RAND() LIMIT 1";
        this.conectar();

        Pergunta c = new Pergunta();

        try {

            this.stmt = (PreparedStatement) this.conn.prepareStatement(query);
            ResultSet rs = this.stmt.executeQuery(query);

            while (rs.next()) {

                c.setId(rs.getInt("id"));

                ArrayList<Escolha> escolhas = new ArrayList();

                escolhas = this.getEscolhas(c.getId());

                c.setEscolhas(escolhas);
                c.setCorreta(rs.getString("correta"));
                c.setDescricao(rs.getString("descricao"));
                c.setCategoria_id(rs.getInt("categoria_id"));

            }

        } catch (SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        return c;

    }
    
    public Pergunta getRNDPerguntaPorCategoria(int id) {

        String query = "SELECT * FROM `pergunta` WHERE categoria_id = '" + id + "' ORDER BY RAND() LIMIT 1";
        this.conectar();

        Pergunta c = new Pergunta();

        try {

            this.stmt = (PreparedStatement) this.conn.prepareStatement(query);
            ResultSet rs = this.stmt.executeQuery(query);

            while (rs.next()) {

                c.setId(rs.getInt("id"));

                ArrayList<Escolha> escolhas = new ArrayList();

                escolhas = this.getEscolhas(c.getId());

                c.setEscolhas(escolhas);
                c.setCorreta(rs.getString("correta"));
                c.setDescricao(rs.getString("descricao"));
                c.setCategoria_id(rs.getInt("categoria_id"));

            }

        } catch (SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        return c;

    }

}
