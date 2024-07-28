/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programe.io.services;

import jakarta.ejb.Stateless;
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
    
}
