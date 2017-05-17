package br.com.gamer.dao;

import br.com.gamer.classes.Escolha;
import br.com.gamer.classes.Pergunta;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public boolean criar(Pergunta pergunta) {

        try {

            this.conectar();
            String query = "INSERT INTO pergunta (categoria_id, descricao, correta) VALUES (?, ?, ?)";

            this.stmt = (PreparedStatement) this.conn.prepareStatement(query);
            this.stmt.setInt(1, pergunta.getCategoria_id());
            this.stmt.setString(2, pergunta.getDescricao());
            this.stmt.setString(3, "0");
            this.stmt.execute();

            return true;

        } catch (SQLException ex) {

            Logger.getLogger(perguntaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }

    }

    public boolean salvar(Pergunta pergunta) {

        try {

            this.conectar();

            String query;

                query = "UPDATE pergunta SET categoria_id = ?, descricao = ? WHERE id = ?";
                this.stmt = (PreparedStatement) this.conn.prepareStatement(query);
                this.stmt.setInt(1, pergunta.getCategoria_id());
                this.stmt.setString(2, pergunta.getDescricao());
                this.stmt.setInt(3, pergunta.getId());
                this.stmt.execute();

            return true;

        } catch (SQLException ex) {

            Logger.getLogger(perguntaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }

    }

    public boolean excluir(int id) {

        try {

            this.conectar();
            String query = "DELETE FROM pergunta WHERE id = ?";

            this.stmt = (PreparedStatement) this.conn.prepareStatement(query);
            this.stmt.setInt(1, id);
            this.stmt.execute();

            return true;

        } catch (SQLException ex) {

            Logger.getLogger(perguntaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }

    }

    public ArrayList<Pergunta> perguntas() {

        String query = "SELECT * FROM `pergunta`";
        this.conectar();

        ArrayList<Pergunta> c = new ArrayList<>();

        try {

            this.stmt = (PreparedStatement) this.conn.prepareStatement(query);
            ResultSet rs = this.stmt.executeQuery(query);

            while (rs.next()) {

                Pergunta l = new Pergunta();

                l.setId(rs.getInt("id"));
                l.setDescricao(rs.getString("descricao"));
                l.setCategoria_id(rs.getInt("categoria_id"));
                l.setCorreta(rs.getString("correta"));

                c.add(l);

            }

        } catch (SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        return c;

    }
    
    public ArrayList<Pergunta> perguntasCat(int id) {

        String query = "SELECT * FROM `pergunta` WHERE categoria_id = '" + id + "'";
        this.conectar();

        ArrayList<Pergunta> c = new ArrayList<>();

        try {

            this.stmt = (PreparedStatement) this.conn.prepareStatement(query);
            ResultSet rs = this.stmt.executeQuery(query);

            while (rs.next()) {

                Pergunta l = new Pergunta();

                l.setId(rs.getInt("id"));
                l.setDescricao(rs.getString("descricao"));
                l.setCategoria_id(rs.getInt("categoria_id"));
                l.setCorreta(rs.getString("correta"));

                c.add(l);

            }

        } catch (SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        return c;

    }

    public Pergunta buscarPergunta(int id) {

        Pergunta c = new Pergunta();

        String query = "SELECT * FROM `pergunta` WHERE id = '" + id + "'";
        this.conectar();

        try {

            this.stmt = (PreparedStatement) this.conn.prepareStatement(query);
            ResultSet rs = this.stmt.executeQuery(query);

            while (rs.next()) {

                c.setId(rs.getInt("id"));
                c.setDescricao(rs.getString("descricao"));
                c.setCategoria_id(rs.getInt("categoria_id"));
                c.setCorreta(rs.getString("correta"));
                
                ArrayList<Escolha> escolhas;
                
                escolhas = this.getEscolhas(c.getId());

                c.setEscolhas(escolhas);

            }

        } catch (SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        return c;

    }

}
