/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programe.io.services;

import jakarta.ejb.Stateless;
import jakarta.persistence.Query;
import java.util.List;
import programe.io.generics.ServicoGenerico;
import programe.io.models.Consulta;
import programe.io.utils.DateUtil;

/**
 *
 * @author nicsondev
 */
@Stateless
public class ConsultaService extends ServicoGenerico<Consulta>{
    
    public ConsultaService() {
        super(Consulta.class);
    }
    
    public List<Consulta> findByDate(Consulta consulta){
        System.out.println(consulta.getDataConsulta());
        String sql = "SELECT c FROM Consulta c WHERE ";
        
        if(consulta.getDataConsulta() != null){
            sql += "c.dataConsulta BETWEEN :inicioDia AND :fimDia AND ";
        }
        
        sql += "c.active = true";
        Query query = getEntityManager().createQuery(sql);
        
        if(consulta.getDataConsulta() != null){
            query.setParameter("inicioDia", DateUtil.getCurrentDateAtMidnight());
            query.setParameter("fimDia", DateUtil.getTomorowDateAtMidnight());
        }
        System.out.println(sql);
        return query.getResultList();
    }
    
}
