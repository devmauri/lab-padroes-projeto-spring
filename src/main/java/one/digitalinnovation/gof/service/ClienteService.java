package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Cliente;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio de cliente. Com
 * isso, se necessário, podemos ter multiplas implementações dessa mesma
 * interface.
 * 
 * -Modificação: retirado corpo e colocado na interface CRUDt que
 * utiliza generics.
 * 
 * @author falvojr & devmauri
 */
public interface ClienteService extends CRUDt<Cliente> {
}
