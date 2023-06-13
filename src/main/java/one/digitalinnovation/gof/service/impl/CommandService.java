/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package one.digitalinnovation.gof.service.impl;

import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.model.GenericDTO;
import one.digitalinnovation.gof.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *Service que irá criar os comandos adequados  vinculando seus parametros com
 * o seu executor para posteriormente chamar sua excecução.
 * Implementa a mesma interface utilizada para não ser necessario 
 * alterar a classe controller e manter a coerencia com o codigo já existente
 * @author mauri
 */
@Service("CommandService")
public class CommandService implements ClienteService {
    
    @Autowired
    @Qualifier("ClienteServiceImpl")
    ClienteService cs;
    
    @Autowired
    CommandInvoker ci;

    @Override
    public Iterable<Cliente> buscarTodos() {
        var cFindAll = new CommandClientFindAll(cs);
        return cFindAll.execut().getPayload();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        var cFindById = new CommandClientFindById(new GenericDTO(id),cs);
        return cFindById.execut().getPayload();
    }

    @Override
    public void inserir(Cliente cliente) {
       var cInserir = new CommanClientdInsert(new GenericDTO(cliente),cs);
       ci.setAndExecuteCommand(cInserir);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        var cUpdate = new CommandClientUpdate(new GenericDTO (new Object[]{id,cliente}), cs);
        cUpdate.execut();
    }

    @Override
    public void deletar(Long id) {
        var cDelete = new CommandClientDelet(new GenericDTO(id), cs);
        cDelete.execut();
    }
   
    
}
