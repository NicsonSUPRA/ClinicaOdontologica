/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programe.io.services;

import jakarta.ejb.Stateless;
import jakarta.persistence.Query;
import java.util.List;
import programe.io.generics.ServicoGenerico;
import programe.io.models.Dentista;

/**
 *
 * @author nicsondev
 */
@Stateless
public class DentistaService extends ServicoGenerico<Dentista> {
    
    public DentistaService() {
        super(Dentista.class);
    }
    
    public List<Dentista> findByInstance(Dentista dentista){
        String sql = "SELECT d FROM Dentista d WHERE ";
        
        if(dentista.getNome() != null && !dentista.getNome().equals("")){
            sql += "lower(d.nome) like lower(:nome) AND ";
        }
        
        sql += "d.active = true";
        Query query = getEntityManager().createQuery(sql);
        if(dentista.getNome() != null && !dentista.getNome().equals("")){
            query.setParameter("nome", "%"+dentista.getNome()+"%");
        }
        
        return query.getResultList();
    }
    
}
