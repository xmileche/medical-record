/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import entidades.Paciente;
import entidades.Remedio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import entidades.ficha;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import entidades.Consulta;

/**
 * CRUD
 * @author Gustavo
 */
public class FichaMedicaDAO {
    private Connection con = null;

    public FichaMedicaDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public Paciente buscaDados(ficha f) {
        Paciente p = new Paciente();
        String sql1 = "select * from paciente where cpf_cliente = ? AND nome = ?";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql1);
            stmt.setString(1, f.getCpf());
            stmt.setString(2, f.getNomePaciente().getNomePaciente());
            stmt.execute();
            ResultSet result = stmt.getResultSet();
            System.out.println(result);
            result.next();
            p.setId_paciente((Integer) result.getObject("id_paciente"));
            p.setId_carteira((Integer) result.getObject("id_carteira"));
        
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return p;
        }
    }
    public boolean create(ficha f) {
        Paciente res = buscaDados(f);
        if(res == null)
            return false;
        System.out.println(res);
        String sql = "INSERT INTO ficha_medica (datas, id_paciente, cpf_cliente, id_carteira) VALUES (?,?,?,?) ";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, f.getData());
            stmt.setInt(2, res.getId_paciente());
            stmt.setString(3, f.getCpf());
            stmt.setInt(4, res.getId_carteira());
            stmt.executeUpdate();
      
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
            return true;
        }
    }
    
    public ArrayList <Paciente> visualizar() {
        ArrayList <Paciente> pList = new ArrayList<>();
        String sql1 = "select nome, cpf_cliente from paciente";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql1);
            stmt.execute();
            ResultSet result = stmt.getResultSet();
            System.out.println(result);
            while(result.next()){
                String nome = (String) result.getObject("nome");
                String cpf = (String) result.getObject("cpf_cliente");
                pList.add(new Paciente(nome, cpf));
               
            }
            pList.forEach((e)->{
                System.out.println(e.getNomePaciente());
            });
        
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return pList;
        }
    }
    
    public ficha busca(ficha ficha) {
        String sql1 = "SELECT id_ficha, datas, ficha_medica.cpf_cliente, ficha_medica.id_carteira, nome, idade, raca, especie FROM ficha_medica INNER JOIN Paciente ON ficha_medica.id_paciente=paciente.id_paciente where ficha_medica.cpf_cliente = (?) AND paciente.nome LIKE ?";
        PreparedStatement stmt = null;
        ficha f = new ficha();
        Paciente p = new Paciente();
        
        try {
            stmt = con.prepareStatement(sql1);
            stmt.setString(1, ficha.getCpf());
            stmt.setString(2, ficha.getNomePaciente().getNomePaciente());
            stmt.execute();
            ResultSet result = stmt.getResultSet();
            System.out.println(result);
            result.next();
            f.setCodCarteiraVacina((Integer)result.getObject("id_carteira"));
            f.setCodigo((Integer) result.getObject("id_ficha"));
            f.setData((String) result.getObject("datas"));
            f.setCpf((String) result.getObject("cpf_cliente"));
            p.setNomePaciente((String) result.getObject("nome"));
            p.setIdade((Integer) result.getObject("idade"));
            p.setEspecie((String) result.getObject("especie"));
            p.setRaca((String) result.getObject("raca"));
            f.setNomePaciente(p);
       
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return f;
        }
    }
    
    public ArrayList <Remedio> visualizarMedicamentos(Integer codigo) {
        ArrayList <Remedio> pList = new ArrayList<>();
        String sql1 = "SELECT remedio.id_remedio, remedio.data, nome, dose FROM remedio INNER JOIN ficha_remedio ON remedio.id_remedio = ficha_remedio.id_remedio where ficha_remedio.id_ficha = ?";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql1);
            stmt.setInt(1, codigo);
            stmt.execute();
            ResultSet result = stmt.getResultSet();
            System.out.println(result);
            while(result.next()){
                Integer id_remedio = (Integer) result.getObject("id_remedio");
                String nome = (String) result.getObject("nome");
                String dose = (String) result.getObject("dose");
                String data = (String) result.getObject("data");
                pList.add(new Remedio(id_remedio, nome, dose, data));
               
            }
            pList.forEach((e)->{
                System.out.println(e.getNome());
            });
        
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return pList;
        }
    }
    
    public ArrayList <Consulta> datasConsultas(Integer codigo) {
        ArrayList <Consulta> pList = new ArrayList<>();
        String sql1 = "select datas from consulta where id_ficha = ?";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql1);
            stmt.setInt(1, codigo);
            stmt.execute();
            ResultSet result = stmt.getResultSet();
            System.out.println(result);
            while(result.next()){
                String data = (String) result.getObject("datas");
                pList.add(new Consulta(data));
            }
            pList.forEach((e)->{
                System.out.println(e.getData());
            });
        
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return pList;
        }
    }
    
    public Consulta visualizaConsulta(String data, Integer id){
        String sql1 = "select * from consulta where id_ficha = ? AND datas = ?";
        PreparedStatement stmt = null;
        Consulta c = new Consulta();
        
        try {
            stmt = con.prepareStatement(sql1);
            stmt.setInt(1, id);
            stmt.setString(2, data);
            stmt.execute();
            ResultSet result = stmt.getResultSet();
            result.next();
            c.setComentario((String) result.getObject("comentario"));
            c.setData((String) result.getObject("datas"));
        
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return c;
        }
    }
    
    
}
