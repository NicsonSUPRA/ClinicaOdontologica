/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programe.io.vo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author nicsondev
 */
public class ConsultaVO implements Serializable {
    private long id;
    private String paciente;
    private String pacienteConvenio;
    private String dentista;
    private int dataConsulta;

    public ConsultaVO() {
    }

    public ConsultaVO(long id, String paciente, String pacienteConvenio, String dentista, int dataConsulta) {
        this.id = id;
        this.paciente = paciente;
        this.pacienteConvenio = pacienteConvenio;
        this.dentista = dentista;
        this.dataConsulta = dataConsulta;
    }

    

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getPacienteConvenio() {
        return pacienteConvenio;
    }

    public void setPacienteConvenio(String pacienteConvenio) {
        this.pacienteConvenio = pacienteConvenio;
    }

    public String getDentista() {
        return dentista;
    }

    public void setDentista(String dentista) {
        this.dentista = dentista;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(int dataConsulta) {
        this.dataConsulta = dataConsulta;
    }



    
    
}
