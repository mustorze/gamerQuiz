package br.com.gamer.dao;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class loginDao extends Dao {
    
    public boolean logar(String email, String senha) {

        try {

            this.conectar();
            String query = "SELECT email, senha FROM usuario WHERE email = '" + email + "' AND senha = '" + senha + "'";

            this.stmt = (PreparedStatement) this.conn.prepareStatement(query);
            ResultSet rs = this.stmt.executeQuery(query);

            return rs.next();

        } catch (SQLException ex) {

            Logger.getLogger(loginDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }

    }

    public boolean checarLogado(HttpServletRequest request) {

        HttpSession session = request.getSession();

        return "1".equals(session.getAttribute("usrLogado"));

    }
    
}
