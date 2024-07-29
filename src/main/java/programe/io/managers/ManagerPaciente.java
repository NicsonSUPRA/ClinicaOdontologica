/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programe.io.managers;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
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
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String editar = params.get("editar");
        String vizualizar = params.get("vizualizar");
        
        if(editar != null){
            paciente = pacienteService.findById(Long.parseLong(editar));
        } else if(vizualizar != null){
            paciente = pacienteService.findById(Long.parseLong(vizualizar));
        } else{
            this.paciente = new Paciente();
        }
        pesquisarConvenio();
    }
    
    public void salvar(){
        paciente.setCpf(paciente.getCpf().replace(".", "").replace("-", ""));
        if(!paciente.equals(null)){
            pacienteService.atualizar(paciente);
        } else {
            pacienteService.salvar(paciente);
        }
        this.paciente = new Paciente();

    }
    
    public void pesquisar(){
        pacientes = pacienteService.findByName(paciente);
        System.out.println(pacientes);
    }
    
    public void pesquisarConvenio(){
        convenios = convenioService.findByName(new Convenio());
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
