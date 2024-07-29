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
import programe.io.models.Convenio;
import programe.io.models.Paciente;
import programe.io.services.ConvenioService;
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
    
    @EJB ConvenioService convenioService;
    
    private Paciente paciente;
    private List<Paciente> pacientes;
    
    private Convenio convenioSelecionado;
    private List<Convenio> convenios;
    
    @PostConstruct
    public void instanciar(){
        this.paciente = new Paciente();
        pesquisarConvenio();
    }
    
    public void salvar(){
//        paciente.setCpf(paciente.getCpf().replace(".", "").replace("-", ""));
//        pacienteService.salvar(paciente);
//        System.out.println(paciente);
//        teste();
//        this.paciente = new Paciente();
        paciente.setCpf(paciente.getCpf().replace(".", "").replace("-", ""));
        if(!paciente.equals(null)){
            pacienteService.atualizar(paciente);
        } else {
            pacienteService.salvar(paciente);
        }
        this.paciente = new Paciente();

    }
    
    public void pesquisarConvenio(){
        convenios = convenioService.findByName(new Convenio());
    }
    
    public void teste(){
        System.out.println("----------------------------------------------------------");
        System.out.println(paciente);
        System.out.println(paciente.getConvenio());
        System.out.println("----------------------------------------------------------");
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

    public Convenio getConvenioSelecionado() {
        return convenioSelecionado;
    }

    public void setConvenioSelecionado(Convenio convenioSelecionado) {
        this.convenioSelecionado = convenioSelecionado;
    }

    public List<Convenio> getConvenios() {
        return convenios;
    }

    public void setConvenios(List<Convenio> convenios) {
        this.convenios = convenios;
    }
    
    
}
