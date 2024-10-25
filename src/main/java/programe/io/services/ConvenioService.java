/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programe.io.services;

import jakarta.ejb.Stateless;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;
import programe.io.generics.ServicoGenerico;
import programe.io.models.Convenio;

/**
 *
 * @author nicsondev
 */
@Stateless
public class ConvenioService extends ServicoGenerico<Convenio>{
    
    public ConvenioService() {
        super(Convenio.class);
    }
    
    public List<Convenio> findByName(Convenio convenio){
        String sql = "SELECT c FROM Convenio c WHERE ";
        if(convenio.getNome() != null && !convenio.getNome().equals("")){
            sql += "lower(c.nome) like lower(:nome) AND ";
        }
        
        sql += "c.active = true";
        Query query = getEntityManager().createQuery(sql);
        if(convenio.getNome() != null && !convenio.getNome().equals("")){
            query.setParameter("nome", "%"+convenio.getNome()+"%");
        }
        
        return query.getResultList();
    }
    
    public List<Convenio> findByNameAutocomplete(String nome){
        String sql = "select c from Convenio c where ";
        
        if(!nome.isBlank() && !nome.equals("")){
            sql += "c.nome like :nome and ";
        }
        
        sql += "c.active = true";
        
        Query query = getEntityManager().createQuery(sql);
        
        if(!nome.isBlank() && !nome.equals("")){
            query.setParameter("nome", "%" + nome + "%");
        }
        
        return query.getResultList();
        
    }
}
