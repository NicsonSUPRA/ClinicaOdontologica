/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programe.io.managers;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import programe.io.models.Convenio;
import programe.io.services.ConvenioService;
import programe.io.utils.GrowlUtil;

/**
 *
 * @author nicsondev
 */
@Named
@ViewScoped
public class ManagerConvenio implements Serializable{
    @EJB
    private ConvenioService convenioService;
    private Convenio convenio;
    private Convenio convenioSelecionado;
    private List<Convenio> convenios = new ArrayList<>();
    
    
    @PostConstruct
    private void instanciar(){
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String vizualizar = params.get("vizualizar");
        String editar = params.get("editar");
        if(vizualizar != null){
            convenio = convenioService.findById(Long.parseLong(vizualizar));
        } else if(editar != null){
            convenio = convenioService.findById(Long.parseLong(editar));
        } else {
            this.convenio = new Convenio();
        }
        pesquisar();
    }
    
    public void salvar(){
        if(convenio != null){
            System.out.println("pasou aqui no 1");
            convenioService.atualizar(convenio);
            GrowlUtil.addMessage(FacesMessage.SEVERITY_INFO, "Concluído", "convênio cadastrado com sucesso!");
        } else {
            System.out.println("passou aqui no 2");
            convenioService.salvar(convenio); 
            GrowlUtil.addMessage(FacesMessage.SEVERITY_INFO, "Concluído", "convênio cadastrado com sucesso!");
        }
        
        this.convenio = new Convenio();
        pesquisar();
    }
    
    public void teste(){
        System.out.println(convenioSelecionado);
    }
    
    public void pesquisar(){
        convenios = convenioService.findByName(convenio);
    }
    
    public void excluir(){
        convenioSelecionado.setActive(false);
        convenios.remove(this.convenioSelecionado);
        convenioService.atualizar(convenioSelecionado);
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public List<Convenio> getConvenios() {
        return convenios;
    }

    public void setConvenios(List<Convenio> convenios) {
        this.convenios = convenios;
    }

    public Convenio getConvenioSelecionado() {
        return convenioSelecionado;
    }

    public void setConvenioSelecionado(Convenio convenioSelecionado) {
        this.convenioSelecionado = convenioSelecionado;
    }

    public ConvenioService getConvenioService() {
        return convenioService;
    }

    public void setConvenioService(ConvenioService convenioService) {
        this.convenioService = convenioService;
    }
    
    
    
      
}
