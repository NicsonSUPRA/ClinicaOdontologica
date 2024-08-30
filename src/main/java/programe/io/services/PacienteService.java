/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programe.io.services;

import jakarta.ejb.Stateless;
import jakarta.persistence.Query;
import java.util.List;
import programe.io.generics.ServicoGenerico;
import programe.io.models.Paciente;

/**
 *
 * @author nicsondev
 */
@Stateless
public class PacienteService extends ServicoGenerico<Paciente>{
    
    public PacienteService() {
        super(Paciente.class);
    }
    
        public List<Paciente> findByName(Paciente paciente){
        String sql = "SELECT p FROM Paciente p WHERE ";
        if(paciente.getNome() != null && !paciente.getNome().equals("")){
            sql += "lower(p.nome) like lower(:nome) AND ";
        }
        
        if(paciente.getCpf() != null && !paciente.getCpf().equals("")){
            sql += "p.cpf like :cpf AND ";
        }
        
        sql += "p.active = true";
        Query query = getEntityManager().createQuery(sql);
        if(paciente.getNome() != null && !paciente.getNome().equals("")){
            query.setParameter("nome", "%"+paciente.getNome()+"%");
        } else if(paciente.getCpf() != null && !paciente.getCpf().equals("")) {
            query.setParameter("cpf", paciente.getCpf().replace("-", "").replace(".", ""));
        }
        
        return query.getResultList();
    }
    
}
