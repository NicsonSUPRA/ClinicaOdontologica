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
import java.util.List;
import programe.io.models.Consulta;
import programe.io.models.Dentista;
import programe.io.models.Paciente;
import programe.io.services.ConsultaService;
import programe.io.services.DentistaService;
import programe.io.services.PacienteService;

/**
 *
 * @author nicsondev
 */
@Named
@ViewScoped
public class ManagerConsulta implements Serializable{
    
    @EJB
    private ConsultaService consultaService;
    
    @EJB
    private PacienteService pacienteService;
    
    @EJB
    private DentistaService dentistaService;
    
    private Consulta consulta;
    private Paciente paciente;
    private Dentista dentista;
    
    private List<Consulta> consultas;
    private List<Paciente> pacientes;
    private List<Dentista> dentistas;
    
    @PostConstruct
    public void instanciar(){
        this.consulta = new Consulta();
        this.paciente = new Paciente();
        this.dentista = new Dentista();
        pesquisarPaciente();
        pesquisarDentista();
    }
    
    public void salvar(){
        if(!consulta.equals(null)){
            consultaService.atualizar(consulta);
        } else {
            consultaService.salvar(consulta);
        }
        consulta = new Consulta();
    }
    
    public void pesquisar(){
        System.out.println(consultas);          
        consultas = consultaService.findByDate(consulta);
    }
    
    public void pesquisarPaciente(){
        pacientes = pacienteService.findByName(paciente);
    }
    
    public void pesquisarDentista(){
        dentistas = dentistaService.findByName(dentista);
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public List<Dentista> getDentistas() {
        return dentistas;
    }

    public void setDentistas(List<Dentista> dentistas) {
        this.dentistas = dentistas;
    }
    
    
    
}
