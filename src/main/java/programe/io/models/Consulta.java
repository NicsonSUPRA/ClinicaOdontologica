/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programe.io.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.Objects;
import programe.io.generics.EntidadeGenerica;

/**
 *
 * @author nicsondev
 */
@Entity
public class Consulta extends EntidadeGenerica{
    @Id
    @SequenceGenerator(name = "seq_consulta", sequenceName = "seq_consulta")
    @GeneratedValue(generator = "seq_consulta", strategy = GenerationType.SEQUENCE)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Dentista dentista;
    @OneToOne(cascade = CascadeType.ALL)
    private Paciente paciente;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataConsulta;
    @Temporal(TemporalType.TIME)
    private Date duracao;

    public Consulta() {
    }

    public Consulta(long id, Dentista dentista, Paciente paciente, Date dataConsulta, Date duracao) {
        this.id = id;
        this.dentista = dentista;
        this.paciente = paciente;
        this.dataConsulta = dataConsulta;
        this.duracao = duracao;
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

    public Date getDuracao() {
        return duracao;
    }

    public void setDuracao(Date duracao) {
        this.duracao = duracao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + Objects.hashCode(this.dentista);
        hash = 97 * hash + Objects.hashCode(this.paciente);
        hash = 97 * hash + Objects.hashCode(this.dataConsulta);
        hash = 97 * hash + Objects.hashCode(this.duracao);
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
        if (!Objects.equals(this.dataConsulta, other.dataConsulta)) {
            return false;
        }
        return Objects.equals(this.duracao, other.duracao);
    }

    
    @Override
    public String toString() {
        return "Consulta{" + "id=" + id + ", dentista=" + dentista.getNome() + ", paciente=" + paciente.getNome() + ", dataConsulta=" + dataConsulta + '}';
    }

    
}
