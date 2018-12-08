/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import entidades.ficha;

/**
 *
 * @author michele
 */
public class FichaController {
        public boolean cadastrarFicha(ficha f){
        boolean result = false;
        
        if(f != null && f.getNomePaciente().length() > 0 && f.getNomeCliente().length() > 0 && f.getFuncionario().length() > 0 && f.getCodCarteiraVacina() != 0 && f.getCpf() != 0)
            result = true;
        
        return result;
    }
           
}
