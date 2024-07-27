/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programe.io.generics;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author nicsondev
 */
public class ServicoGenerico<T> {
    private Class<T> entidade;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public ServicoGenerico(Class<T> entidade){
        this.entidade = entidade;
    }
    
    public void salvar(T entidade){
        entityManager.persist(entidade);
    }
    
    public void atualizar(T entidade){
        entityManager.merge(entidade);
    }
    
    public T findById(long id){
        T obj = entityManager.find(entidade, id);
        entityManager.refresh(obj);
        return obj;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
}
