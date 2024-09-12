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
import programe.io.models.Dentista;
import programe.io.services.DentistaService;
import programe.io.utils.UtilCrm;

/**
 *
 * @author nicsondev
 */
@Named
@ViewScoped
public class ManagerDentista implements Serializable{
    
    @EJB
    private DentistaService dentistaService;
    
    private Dentista dentista;
    private List<Dentista> dentistas;
    
    @PostConstruct
    public void instanciar(){
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String vizualizar = params.get("vizualizar");
        String editar = params.get("editar");
        if(vizualizar != null){
            System.out.println("passou em vizualizar");
            dentista = dentistaService.findById(Long.parseLong(vizualizar));
        } else if(editar != null){
            dentista = dentistaService.findById(Long.parseLong(editar));
        } else {
            System.out.println("nao passou em vizualiza");
            this.dentista = new Dentista();
        }

    }
    
    public void salvar(){
        dentista.setCrm(dentista.getCrm().replace("-", "").replace(" ", ""));
        if(dentista != null){
            dentistaService.atualizar(dentista);
        } else {
            dentistaService.salvar(dentista);
        }
       dentista = new Dentista();
    }
    
    public void pesquisar(){
        dentistas = dentistaService.findByInstance(dentista);
    }
    
    public String getCrmFormatado(){
        return UtilCrm.formatCrm(dentista.getCrm());
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    public List<Dentista> getDentistas() {
        return dentistas;
    }

    public void setDentistas(List<Dentista> dentistas) {
        this.dentistas = dentistas;
    }
    
    
}
