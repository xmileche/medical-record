/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author michele
 */
public class Remedio {
     public Remedio(Integer id_remedio, String nome, String dose, String data) {
       //To change body of generated methods, choose Tools | Templates
       this.data = data;
       this.id_remedio = id_remedio;
       this.nome = nome;
       this.dose = dose;
    }

    public Integer getId_remedio() {
        return id_remedio;
    }

    public void setId_remedio(Integer id_remedio) {
        this.id_remedio = id_remedio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }
    private Integer id_remedio;
    private String nome;
    private String dose;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    private String data;
}
