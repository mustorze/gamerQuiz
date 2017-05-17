package br.com.gamer.dao;

import br.com.gamer.classes.Categoria;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class categoriaDao extends Dao {
    
    public boolean criar(Categoria categoria) {

        try {

            this.conectar();
            String query = "INSERT INTO categoria (nome) VALUES (?)";

            this.stmt = (PreparedStatement) this.conn.prepareStatement(query);
            this.stmt.setString(1, categoria.getNome());
            this.stmt.execute();

            return true;

        } catch (SQLException ex) {

            Logger.getLogger(categoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }

    }
    
    public boolean salvar(Categoria categoria) {

        try {

            this.conectar();
            String query = "UPDATE categoria SET nome = ? WHERE id = ?";

            this.stmt = (PreparedStatement) this.conn.prepareStatement(query);
            this.stmt.setString(1, categoria.getNome());
            this.stmt.setInt(2, categoria.getId());
            this.stmt.execute();

            return true;

        } catch (SQLException ex) {

            Logger.getLogger(categoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }

    }
    
    public boolean excluir(int id) {

        try {

            this.conectar();
            String query = "DELETE FROM categoria WHERE id = ?";

            this.stmt = (PreparedStatement) this.conn.prepareStatement(query);
            this.stmt.setInt(1, id);
            this.stmt.execute();

            return true;

        } catch (Exception ex) {

            Logger.getLogger(categoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }

    }

    public ArrayList<Categoria> categorias() {

        String query = "SELECT * FROM `categoria`";
        this.conectar();

        ArrayList<Categoria> c = new ArrayList<>();

        try {

            this.stmt = (PreparedStatement) this.conn.prepareStatement(query);
            ResultSet rs = this.stmt.executeQuery(query);

            while (rs.next()) {

                Categoria l = new Categoria();

                l.setId(rs.getInt("id"));
                l.setNome(rs.getString("nome"));

                c.add(l);

            }

        } catch (SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        return c;

    }
    
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
