package br.com.gamer.dao;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class loginDao extends Dao {

    public int logar(String email, String senha) {

        try {

            this.conectar();
            String query = "SELECT id, email, senha FROM usuario WHERE email = '" + email + "' AND senha = '" + senha + "'";

            this.stmt = (PreparedStatement) this.conn.prepareStatement(query);
            ResultSet rs = this.stmt.executeQuery(query);

            if (rs.next()) {

                return rs.getInt("id");

            }

            return 0;

        } catch (SQLException ex) {

            Logger.getLogger(loginDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;

        }

    }

    public boolean checarLogado(HttpServletRequest request) {

        HttpSession session = request.getSession();

        return "1".equals(session.getAttribute("usrLogado"));

    }

}
