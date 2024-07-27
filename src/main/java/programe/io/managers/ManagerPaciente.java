/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programe.io.managers;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import programe.io.models.Paciente;
import programe.io.services.PacienteService;

/**
 *
 * @author nicsondev
 */
@Named
@ViewScoped
public class ManagerPaciente implements Serializable{

    @EJB
    private PacienteService pacienteService;
    private Paciente paciente;
    private List<Paciente> pacientes;
    
    @PostConstruct
    public void instanciar(){
        this.paciente = new Paciente();
    }
    
    public void salvar(){
        pacienteService.salvar(paciente);
        this.paciente = new Paciente();
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
    
    
}
