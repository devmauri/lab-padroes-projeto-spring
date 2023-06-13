/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package one.digitalinnovation.gof.model;

/**
 * Classe utilizada para trafegar dados/mensageria entre objetos dentro 
 * da aplicação.
 * Poderá ser migrado criando endpoints em paralelo e comunicar os clientes.
 *Utilizado Generics prevento que sistema creça, dessa forma poderá suportar
 * n tipos de payload.
 * @author devmauri
 */
public class GenericDTO <T>{

    private T payload;
    private Status status;

    public GenericDTO(T payload){
        this(Status.UNKNOW,payload);
    }
    public GenericDTO(Status result, T payload) {
        this.payload = payload;
        this.status = result;
    }

    public T getPayload() {
        return payload;
    }

    public Status getSatus() {
        return status;
    }

    public void setPayload(T p) {
        this.payload = p;
    }

    public void setStatus(Status r) {
        this.status = r;
    }
    
    

    public enum Status {
        OK, ERROR, UNKNOW, NOTFOUND
    }
}
