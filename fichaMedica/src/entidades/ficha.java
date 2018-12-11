/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;
import java.text.SimpleDateFormat;
import javafx.scene.chart.PieChart.Data;

/**
 *
 * @author michele
 */
public class ficha {

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    
    private Integer codigo;

    public Paciente getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(Paciente nomePaciente) {
        this.nomePaciente = nomePaciente;
    }
    private Paciente nomePaciente;
    private String nomeCliente;
    private Integer codCarteiraVacina;
    String Data;

    public ficha() {
        //To change body of generated methods, choose Tools | Templates.
        
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }
    private String funcionario;
    private String cpf;
    
    public ficha(Integer codigo, 
            Paciente nomeP,  
            String cpf) {
        this.codigo = codigo;
        this.nomePaciente = nomeP;
        this.cpf = cpf;
    }
    public ficha(Integer codigo, 
            Paciente nomeP,  
            String cpf,  
            String Data) {
        this.codigo = codigo;
        this.nomePaciente = nomeP;
        this.Data = Data;
        this.cpf = cpf;
    }
    
    public ficha(Long codigo, String cpf){
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
   

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Integer getCodCarteiraVacina() {
        return codCarteiraVacina;
    }

    public void setCodCarteiraVacina(Integer codCarteiraVacina) {
        this.codCarteiraVacina = codCarteiraVacina;
    }

    @Override
    public String toString() {
        return "ficha{" + "codigo=" + codigo + ", nomePaciente=" + nomePaciente + ", nomeCliente=" + nomeCliente + ", codCarteiraVacina=" + codCarteiraVacina + ", Data=" + Data + ", funcionario=" + funcionario + ", cpf=" + cpf + '}';
    }


    
    
}
