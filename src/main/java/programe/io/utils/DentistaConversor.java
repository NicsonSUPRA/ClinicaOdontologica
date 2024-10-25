/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programe.io.utils;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import programe.io.models.Dentista;
import programe.io.services.DentistaService;

/**
 *
 * @author nicsondev
 */
@Named
@ApplicationScoped
@FacesConverter(value = "dentistaConverter")
public class DentistaConversor implements Converter<Dentista> {
    
    @Inject
    private DentistaService dentistaService;

    @Override
    public Dentista getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && !value.trim().isEmpty()){
            try {
                return dentistaService.findById(Long.parseLong(value));
//            } catch (NumberFormatException e) {
//                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de Conversão", "ID invalido"));
//            }
            } catch(RuntimeException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Dentista value) {
        if(value != null){
            return String.valueOf(value.getNome());
        } else {
            return null;
        }
    }
    
}
