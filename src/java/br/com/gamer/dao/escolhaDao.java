package br.com.gamer.dao;

import br.com.gamer.classes.Escolha;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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

        } catch (SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        return c;

    }

    public boolean definirPrincipal(int escolha, int pergunta) {

        try {

            this.conectar();
            String query = "UPDATE pergunta SET correta = ? WHERE id = ?";

            this.stmt = (PreparedStatement) this.conn.prepareStatement(query);
            this.stmt.setString(1, String.valueOf(escolha));
            this.stmt.setInt(2, pergunta);
            this.stmt.execute();

            return true;

        } catch (SQLException ex) {

            Logger.getLogger(perguntaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }

    }

    public Escolha buscarEscolha(int id) {

        Escolha c = new Escolha();

        String query = "SELECT * FROM `escolha` WHERE id = '" + id + "'";
        this.conectar();

        try {

            this.stmt = (PreparedStatement) this.conn.prepareStatement(query);
            ResultSet rs = this.stmt.executeQuery(query);

            while (rs.next()) {

                c.setId(rs.getInt("id"));
                c.setDescricao(rs.getString("descricao"));
                c.setPergunta_id(rs.getInt("pergunta_id"));

            }

        } catch (SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        return c;

    }
    
    public boolean criar(Escolha escolha) {

        try {

            this.conectar();
            String query = "INSERT INTO escolha (pergunta_id, descricao) VALUES (?, ?)";

            this.stmt = (PreparedStatement) this.conn.prepareStatement(query);
            this.stmt.setInt(1, escolha.getPergunta_id());
            this.stmt.setString(2, escolha.getDescricao());
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
            String query = "DELETE FROM escolha WHERE id = ?";

            this.stmt = (PreparedStatement) this.conn.prepareStatement(query);
            this.stmt.setInt(1, id);
            this.stmt.execute();

            return true;

        } catch (Exception ex) {

            Logger.getLogger(perguntaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }

    }
    
    public boolean salvar(Escolha escolha) {

        try {

            this.conectar();

            String query;

                query = "UPDATE escolha SET descricao = ? WHERE id = ?";
                this.stmt = (PreparedStatement) this.conn.prepareStatement(query);
                this.stmt.setString(1, escolha.getDescricao());
                this.stmt.setInt(2, escolha.getId());
                this.stmt.execute();

            return true;

        } catch (SQLException ex) {

            Logger.getLogger(perguntaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }

    }

}
