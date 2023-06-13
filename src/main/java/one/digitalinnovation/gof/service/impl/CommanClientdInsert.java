/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package one.digitalinnovation.gof.service.impl;

import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.model.GenericDTO;
import one.digitalinnovation.gof.service.ClienteService;
import one.digitalinnovation.gof.service.Command;

/**
 *Essa é a implementação do comando para inserir usuarios.
 * Em sua criação deve ser passado todos os parametros necessarios e deve possui
 * pelo menos o metrodo execute tornando assim um objeto independente 
 * @author devmauri
 */
public class CommanClientdInsert extends Command<ClienteService>{
    
    public CommanClientdInsert(GenericDTO<Cliente> param, ClienteService worker){
        super (param,worker);
    }
    
    @Override
    public GenericDTO execut() {
        var status = GenericDTO.Status.UNKNOW;
        var temp = (Cliente)this.getParam().getPayload();
        
        if(temp == null){
            status = GenericDTO.Status.ERROR;
        }
        else {
            this.getWorker().inserir(temp);
            status = GenericDTO.Status.OK;
        }
        
        return new GenericDTO<Cliente>(status, temp);
    }
}
