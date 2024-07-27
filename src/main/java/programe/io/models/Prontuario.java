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
class Prontuario {
    private long id;
    private Consulta consulta;
    private String descricao;

    public Prontuario() {
    }

    public Prontuario(long id, Consulta consulta, String descricao) {
        this.id = id;
        this.consulta = consulta;
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 17 * hash + Objects.hashCode(this.consulta);
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
        final Prontuario other = (Prontuario) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.consulta, other.consulta);
    }

    @Override
    public String toString() {
        return "Prontuario{" + "id=" + id + ", consulta=" + consulta.getPaciente().getNome() + '}';
    }
    
    
}
