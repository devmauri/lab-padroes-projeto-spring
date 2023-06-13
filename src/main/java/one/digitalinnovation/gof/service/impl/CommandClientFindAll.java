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
public class CommandClientFindAll extends Command<ClienteService> {

    public CommandClientFindAll(ClienteService worker) {
        super(new GenericDTO<Iterable<Cliente>>(null), worker);
    }

    @Override
    public GenericDTO<Iterable<Cliente>> execut() {
        var status = GenericDTO.Status.UNKNOW;
        Iterable<Cliente> payload = null;
        var temp = this.getParam().getPayload();
        
        if(this.getWorker() == null){
            status = GenericDTO.Status.ERROR;
        }
        else {
            payload = this.getWorker().buscarTodos();
            status = GenericDTO.Status.OK;
        }
        
        return new GenericDTO<Iterable<Cliente>>(status, payload);
        
        
    }
    
}
