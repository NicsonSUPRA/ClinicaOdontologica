/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programe.io.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import java.util.Objects;
import programe.io.generics.EntidadeGenerica;

/**
 *
 * @author nicsondev
 */
@Entity
public class Paciente extends EntidadeGenerica{
    @Id
    @SequenceGenerator(name = "seq_paciente", sequenceName = "seq_paciente", initialValue = 1)
    @GeneratedValue(generator = "seq_paciente", strategy = GenerationType.SEQUENCE)
    private long id;
    private String nome;
    @Column(length = 11)
    private String cpf;
    @OneToOne(cascade = CascadeType.ALL)
    private Convenio convenio;

    public Paciente() {
    }

    public Paciente(long id, String nome, String cpf, Convenio convenio) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.convenio = convenio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 23 * hash + Objects.hashCode(this.nome);
        hash = 23 * hash + Objects.hashCode(this.cpf);
        hash = 23 * hash + Objects.hashCode(this.convenio);
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
        final Paciente other = (Paciente) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        return Objects.equals(this.convenio, other.convenio);
    }

    

    @Override
    public String toString() {
        return "Paciente{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + '}';
    }
    
    
}
