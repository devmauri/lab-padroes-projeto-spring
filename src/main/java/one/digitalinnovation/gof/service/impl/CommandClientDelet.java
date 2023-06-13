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
public class CommandClientDelet extends Command<ClienteService> {

    public CommandClientDelet(GenericDTO<Long> param, ClienteService worker) {
        super(param, worker);
    }

    @Override
    public GenericDTO<Long> execut() {
        var status = GenericDTO.Status.UNKNOW;
        var temp = (Long)this.getParam().getPayload();
        
        if(temp == null){
            status = GenericDTO.Status.ERROR;
        }
        else {
            this.getWorker().deletar(temp);
            status = GenericDTO.Status.OK;
        }
        
        return new GenericDTO<Long>(status, temp);
    }
    
}
