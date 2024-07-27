/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programe.io.models;

import java.util.Objects;

/**
 *
 * @author nicsondev
 */
public class Dentista {
    private long id;
    private String nome;
    private String crm;

    public Dentista() {
    }

    public Dentista(long id, String nome, String crm) {
        this.id = id;
        this.nome = nome;
        this.crm = crm;
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

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 71 * hash + Objects.hashCode(this.crm);
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
        final Dentista other = (Dentista) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.crm, other.crm);
    }

    @Override
    public String toString() {
        return "Dentista{" + "id=" + id + ", nome=" + nome + ", crm=" + crm + '}';
    }
    
    
}
