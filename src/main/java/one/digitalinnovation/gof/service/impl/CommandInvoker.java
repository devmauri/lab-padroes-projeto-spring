/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package one.digitalinnovation.gof.service.impl;

import java.util.Stack;
import one.digitalinnovation.gof.model.GenericDTO;
import one.digitalinnovation.gof.service.ClienteService;
import one.digitalinnovation.gof.service.Command;
import org.springframework.stereotype.Component;

/**
 *Classe responsável por receber e executar os comandos de forma desejada.
 * Não possui a implementação da regra de negocio, apenas guarda um 
 * histporico de comandos e delega sua excecução para as classes competentes.
 * @author mauri
 */
@Component
public class CommandInvoker {
    private Stack<Command> history = new Stack<>();
    private Command active;
    private GenericDTO lastRetur;
    
    public void setAndExecuteCommand(Command c){
        this.setCommand(c);
        this.execute();
        
    }
    
    public void setCommand(Command c){
        this.active = c;
    }
    
    public boolean execute(){
        if(this.active == null) {
            return false;
        }
        this.lastRetur = this.active.execut();
        return addHystori();
    }
    
    private boolean addHystori (){
        if(this.lastRetur.getSatus() == GenericDTO.Status.OK){
           
           history.push(this.active);
           return true;
       }
        return false;
    }
}
