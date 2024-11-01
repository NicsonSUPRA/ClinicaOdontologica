/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programe.io.services;

import jakarta.ejb.Stateless;
import jakarta.persistence.Query;
import java.util.Date;
import java.util.List;
import programe.io.generics.ServicoGenerico;
import programe.io.models.Consulta;
import programe.io.utils.DateUtil;
import programe.io.vo.ConsultaVO;

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
        String sql = "SELECT c FROM Consulta c WHERE ";
        
        if(consulta.getDataConsulta() != null){
            sql += "c.dataConsulta BETWEEN :inicioDia AND :fimDia AND ";
        }
        
        sql += "c.active = true";
        Query query = getEntityManager().createQuery(sql);
        
        if(consulta.getDataConsulta() != null){
            
//            query.setParameter("inicioDia", DateUtil.getCurrentDateAtMidnight());
//            query.setParameter("fimDia", DateUtil.getTomorowDateAtMidnight());
            query.setParameter("inicioDia", DateUtil.getDateAtMidnight(consulta.getDataConsulta()));
            query.setParameter("fimDia", DateUtil.getTomorrowDateAtMidnight(consulta.getDataConsulta()));
        }

        System.out.println(query);
        return query.getResultList();
    }
    
    public List<Consulta> findConsultaToSchedule(Consulta consulta){
        String sql = "SELECT c FROM Consulta c WHERE ";
        if(consulta.getDataConsulta() != null) {
            sql += "c.dataConsulta = :inicioDia AND c.duracao = :fimDia AND ";
        }
        sql += "c.active = true";
        Query query = getEntityManager().createQuery(sql);
        if(consulta.getDataConsulta() != null) {
            query.setParameter("inicioDia", consulta.getDataConsulta());
            query.setParameter("fimDia", consulta.getDuracao());   
        }
        

        System.out.println(query);
        return query.getResultList();
        
    }
    
    public List<ConsultaVO> findConsultasParaPesquisa() {
        String sql = "SELECT new programe.io.vo.ConsultaVO(c.id, p.nome, c.paciente.convenio.nome , d.nome, cast(extract(day from c.dataConsulta) as integer)) "
                + "from Consulta c "
                + "JOIN Paciente p "
                + "JOIN Dentista d"
                + "where c.active = true ";
        Query query = getEntityManager().createQuery(sql);
        
        return query.getResultList();
    }
    
}
