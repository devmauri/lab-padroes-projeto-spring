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
 *
 * @author mauri
 */
public class CommandClientUpdate extends Command<ClienteService>{

    public CommandClientUpdate(GenericDTO<Object[]> param, ClienteService worker) {
        super(param, worker);
    }

    @Override
    public GenericDTO<Boolean> execut() {
        var status = GenericDTO.Status.UNKNOW;
        var params = (Object[])this.getParam().getPayload();
        var id = (Long) params[0];
        var atualizar = (Cliente)params[1];
        var temp = false;
        
        if(id == null || atualizar == null){
            status = GenericDTO.Status.ERROR;
        }
        else {
            this.getWorker().atualizar(id,atualizar);
            status = GenericDTO.Status.OK;
            temp = true;
        }
        
        return new GenericDTO <Boolean>(status, temp);
    }
     
}
