/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programe.io.utils;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;
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
public class ScheduleConsulta implements Serializable {
    
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
       
    private ScheduleModel eventModel;
    private DefaultScheduleEvent<Object> event = new DefaultScheduleEvent<>();
    
    @PostConstruct
    public void init(){
        this.paciente = new Paciente();
        this.dentista = new Dentista();
        pesquisarDentista();
        pesquisarPaciente();
        this.eventModel = new DefaultScheduleModel();
    }
    
    public void onDateSelect(SelectEvent<LocalDateTime> selectEvent) {
        event = DefaultScheduleEvent.builder()
                .editable(false)
                .title("titulo")
                .borderColor("orange")
                .startDate(selectEvent.getObject())
                .endDate(selectEvent.getObject().plusHours(1))
                .build();
    }
    
    public void addEvent() {
//        System.out.println(event.getId());
//        eventModel.addEvent(event);
        System.out.println("passou aquiisiqxbuqwybxuwgvxywgveywvgxywex");
        if (event.getId() == null) {
            eventModel.addEvent(event);
        }
        else {
            eventModel.updateEvent(event);
        }
        
        event = new DefaultScheduleEvent<>();
    }
    public void pesquisarDentista() {
        dentistas = dentistaService.findByInstance(dentista);
    }
    
    public void pesquisarPaciente() {
        pacientes = pacienteService.findByName(paciente);
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    public DefaultScheduleEvent<Object> getEvent() {
        return event;
    }

    public void setEvent(DefaultScheduleEvent<Object> event) {
        this.event = event;
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
