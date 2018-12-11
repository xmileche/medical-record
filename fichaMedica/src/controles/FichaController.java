/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import entidades.ficha;
import model.dao.FichaMedicaDAO;
/**
 *
 * @author michele
 */
public class FichaController {
        public boolean cadastrarFicha(ficha f){
            boolean result = false;

            if(f != null && f.getCpf().length() > 0){
                result = true;
                
                RepositorioManager.getInstance().cadastrarFicha(f);
                
            }

            FichaMedicaDAO fDAO = new FichaMedicaDAO();
            fDAO.create(f);
            return result;
    }
        
    public ficha procurarFicha(ficha f){
        boolean result = false;
        
        if(f != null && f.getCpf().length() > 0){
            FichaMedicaDAO fDAO = new FichaMedicaDAO();
            ficha ficha = fDAO.busca(f);
            return ficha;
       
        } else {
            return null;
        }
    }
           
}
