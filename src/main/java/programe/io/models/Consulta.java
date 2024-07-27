/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programe.io.models;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author nicsondev
 */
public class Consulta {
    private long id;
    private Dentista dentista;
    private Paciente paciente;
    private Date dataConsulta;
    private Prontuario prontuario;

    public Consulta() {
    }

    public Consulta(long id, Dentista dentista, Paciente paciente, Date dataConsulta, Prontuario prontuario) {
        this.id = id;
        this.dentista = dentista;
        this.paciente = paciente;
        this.dataConsulta = dataConsulta;
        this.prontuario = prontuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 89 * hash + Objects.hashCode(this.dentista);
        hash = 89 * hash + Objects.hashCode(this.paciente);
        hash = 89 * hash + Objects.hashCode(this.dataConsulta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Consulta other = (Consulta) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.dentista, other.dentista)) {
            return false;
        }
        if (!Objects.equals(this.paciente, other.paciente)) {
            return false;
        }
        return Objects.equals(this.dataConsulta, other.dataConsulta);
    }

    @Override
    public String toString() {
        return "Consulta{" + "id=" + id + ", dentista=" + dentista.getNome() + ", paciente=" + paciente.getNome() + ", dataConsulta=" + dataConsulta + '}';
    }
    
    
}
