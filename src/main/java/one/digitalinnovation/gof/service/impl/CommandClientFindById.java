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
public class CommandClientFindById extends Command<ClienteService> {

    public CommandClientFindById(GenericDTO<Long> param, ClienteService worker) {
        super(param, worker);
    }

    @Override
    public GenericDTO<Cliente> execut() {
        var status = GenericDTO.Status.UNKNOW;
        Cliente payload = null;
        var temp = (Long)this.getParam().getPayload();
        
        if(temp == null){
            status = GenericDTO.Status.ERROR;
        }
        else {
            payload = this.getWorker().buscarPorId(temp);
            status = GenericDTO.Status.OK;
        }
        
        return new GenericDTO<Cliente>(status, payload);
    }
    
}
