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
    
    private Long codigo;
    private String nomePaciente;
    private String nomeCliente;
    private Long codCarteiraVacina;
    String Data;

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }
    private String funcionario;
    private Long cpf;
    
    public ficha(Long codigo, 
            String nomeP, 
            String nomeC, 
            Long cpf, 
            Long codCarteiraVacina, 
            String Data, 
            String funcionario) {
        this.codigo = codigo;
        this.nomePaciente = nomeP;
        this.nomeCliente = nomeC;
        this.codCarteiraVacina = codCarteiraVacina;
        this.Data = Data;
        this.funcionario = funcionario;
        this.cpf = cpf;
    }
    
       
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Long getCodCarteiraVacina() {
        return codCarteiraVacina;
    }

    public void setCodCarteiraVacina(Long codCarteiraVacina) {
        this.codCarteiraVacina = codCarteiraVacina;
    }


    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    
}
