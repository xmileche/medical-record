/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import entidades.ficha;
import java.util.ArrayList;

/**
 *
 * @author michele
 */
public class RepositorioManager {
        
    // contador 
    private long contadorProdutos = 1;
    private static RepositorioManager instance;
    private ArrayList<ficha> listaFicha;
    private RepositorioManager(){
        listaFicha = new ArrayList<ficha>();
        
    }
    public static RepositorioManager getInstance(){
        if (instance == null){
            instance = new RepositorioManager();
            
        }
        
        return instance;
    }
    
    public ArrayList<ficha> obterListaFicha() {
        
        return listaFicha;
    }
    
    public void cadastrarFicha(ficha f){
        listaFicha.add(f);
        System.out.println(f);
    }
    
    public void inserirFicha(ficha f) {
        
        listaFicha.add(f);
        
        contadorProdutos++; // atualizar contador de produtos
        
    }
    
}
