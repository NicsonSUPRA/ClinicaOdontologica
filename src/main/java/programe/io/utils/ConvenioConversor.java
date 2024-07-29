package programe.io.utils;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.component.UIComponent;
import java.util.List;
import programe.io.models.Convenio;
import programe.io.generics.ServicoGenerico;
import java.util.Map;
import programe.io.services.ConvenioService;

@Named
@ApplicationScoped
@FacesConverter(value = "convenioConverter")
public class ConvenioConversor implements Converter<Convenio> {

    @Inject
    private ConvenioService convenioService;

    @Override
    public Convenio getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.trim().isEmpty()) {
            try {
                long id = Long.parseLong(value);
                // Recuperar o Convenio pelo ID
                return convenioService.findById(id);
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid convenio ID."));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Convenio value) {
        if (value != null) {
            return String.valueOf(value.getId());
        } else {
            return null;
        }
    }
}
