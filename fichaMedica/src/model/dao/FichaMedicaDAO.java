/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import model.bean.Cliente;

/**
 * CRUD
 * @author Gustavo
 */
public class FichaMedicaDAO {
    private Connection con = null;

    public FichaMedicaDAO() {
        con = ConnectionFactory.getConnection();
    }
    
  /*  public boolean create(FichaMedica ficha) {
        
        String sql = "INSERT INTO ficha medica (nome) VALUES (?)";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }*/
    
    
}
