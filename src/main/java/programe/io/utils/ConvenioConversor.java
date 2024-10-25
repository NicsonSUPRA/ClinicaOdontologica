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
import programe.io.models.Convenio;
import programe.io.services.ConvenioService;

@Named
@ApplicationScoped
//pra utilizar a injecao de dependencia, nesse caso o convenioService foi preciso
//adicionar o managed = true, se não, não irá executar o findByLong(id)
@FacesConverter(value = "convenioConverter", managed = true)
public class ConvenioConversor implements Converter<Convenio> {

    @Inject
    private ConvenioService convenioService;

    @Override
    public Convenio getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.trim().isEmpty()) {
            try {
                long id = Long.parseLong(value);
                System.out.println(id);
                return convenioService.findById(id);
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Convênio Inválido", "Selecione o tipo de Convenio para o usuário"));
            }
        } else {
            return new Convenio();
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Convenio value) {
        if (value != null) {
            return String.valueOf(value.getId());
        } else {
            return "";
        }
    }
}
