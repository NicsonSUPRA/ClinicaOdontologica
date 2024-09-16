/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programe.io.utils;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
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
    
    private List<Consulta> consultas = new ArrayList<>();
    private List<Paciente> pacientes = new ArrayList<>();
    private List<Dentista> dentistas = new ArrayList<>();
       
    private ScheduleModel eventModel;
    private DefaultScheduleEvent<Object> event = new DefaultScheduleEvent<>();
    
    @PostConstruct
    public void init(){
        this.consulta = new Consulta();
        this.paciente = new Paciente();
        this.dentista = new Dentista();
        pesquisarDentista();
        pesquisarPaciente();
        pesquisarConsulta();
        this.eventModel = new DefaultScheduleModel();
        for(Consulta c : consultas) {
            event = DefaultScheduleEvent.builder()
                .editable(false)
                .title(Long.toString(c.getId()))
                .borderColor("green")
                .startDate(LocalDateTime.ofInstant(c.getDataConsulta().toInstant(), ZoneId.systemDefault()))
                .endDate(LocalDateTime.ofInstant(c.getDuracao().toInstant(), ZoneId.systemDefault()))
                .build();
            eventModel.addEvent(event);
        }
        
        
    }
    
    public void onDateSelect(SelectEvent<LocalDateTime> selectEvent) {
        event = DefaultScheduleEvent.builder()
                .editable(false)
                .title("titulo")
                .borderColor("green")
                .startDate(selectEvent.getObject())
                .endDate(selectEvent.getObject().plusHours(1))
                .build();
    }
    
    public void onEventSelect(SelectEvent<ScheduleEvent<?>> selectEvent) {
        event = (DefaultScheduleEvent<Object>) selectEvent.getObject();
        consulta = consultaService.findById(Long.parseLong(event.getTitle()));
        paciente = consulta.getPaciente();
        dentista = consulta.getDentista();
    }
    
    public void addEvent() {
        if (event.getId() == null) {
            consulta.setDataConsulta(Date.from(event.getStartDate().atZone(ZoneId.systemDefault()).toInstant()));
            consulta.setDuracao(Date.from(event.getEndDate().atZone(ZoneId.systemDefault()).toInstant()));
            eventModel.addEvent(event);
            consultaService.atualizar(consulta);
            GrowlUtil.addMessage(FacesMessage.SEVERITY_INFO, "Concluído", "consulta cadastrada");
            System.out.println("passou aqui 1");
            
        }
        else {
            
            eventModel.updateEvent(event);
            System.out.println(consulta.getPaciente() + " " + consulta.getDentista());
            consultaService.atualizar(consulta);
            GrowlUtil.addMessage(FacesMessage.SEVERITY_INFO, "Concluído", "consulta Atualizada");
            System.out.println("passou aqui");

        }
        
        
        event = new DefaultScheduleEvent<>();
        this.paciente = new Paciente();
        this.dentista = new Dentista();
    }
    public void pesquisarDentista() {
        dentistas = dentistaService.findByInstance(dentista);
    }
    
    public void pesquisarPaciente() {
        pacientes = pacienteService.findByName(paciente);
    }
    
    public void pesquisarConsulta() {
        consultas = consultaService.findByDate(consulta);
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
