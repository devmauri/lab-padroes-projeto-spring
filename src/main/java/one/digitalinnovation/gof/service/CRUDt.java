/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package one.digitalinnovation.gof.service;

/**
 *Utilizando Generics do JAVA podemos extender CRUD para todas as classes
 * @author mauri
 */
public interface CRUDt <T> {
        Iterable<T> buscarTodos();

        T buscarPorId(Long id);

	void inserir(T inserir);

	void atualizar(Long id, T atualizar);

	void deletar(Long id);
}
