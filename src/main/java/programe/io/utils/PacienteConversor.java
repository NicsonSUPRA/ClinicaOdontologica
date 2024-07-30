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
import programe.io.models.Paciente;
import programe.io.services.PacienteService;

/**
 *
 * @author nicsondev
 */
@Named
@ApplicationScoped
@FacesConverter(value = "pacienteConverter")
public class PacienteConversor implements Converter<Paciente>{

    @Inject
    private PacienteService pacienteService;

    @Override
    public Paciente getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && !value.trim().isEmpty()){
            try {
                long id = Long.parseLong(value);
                return pacienteService.findById(id);
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid convenio ID."));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Paciente value) {
        if (value != null) {
            return String.valueOf(value.getId());
        } else {
            return null;
        }
    }
    
    
    
}
