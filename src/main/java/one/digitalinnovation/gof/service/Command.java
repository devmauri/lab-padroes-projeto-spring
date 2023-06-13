/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.GenericDTO;

/**
 *Classe abstrada que serpa a interface padrão para executar os comandos.
 * Aqui assim como em CRUDt será utilizado generics para extender a
 * todos os tipos de classes.
 * As classes que a implementarem não necessitam conter toda a regra de negocio,
 * o intuito é de transformar a requisição em um objeto independete para ser
 * executado quando ou quantas vezes forem necessarias. 
 * @author mauri
 * 
 */
public abstract class Command <T> {
    private GenericDTO param;
    private T worker;
    
    public Command(GenericDTO param, T worker){
        this.param = param;
        this.worker = worker;
    }
    
    public GenericDTO getParam() {
        return param;
    }

    public T getWorker() {
        return worker;
    }
    public abstract GenericDTO execut();
}
