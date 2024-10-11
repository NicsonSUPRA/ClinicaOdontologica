package programe.io.clinicaodontologica.resources;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Base64;
import programe.io.vo.PacienteVO;
/**
 *
 * @author 
 */
@Path("/teste")
public class JakartaEE10Resource {
    
    @GET
    public Response ping(){
        return Response
                .ok("testando api !!!")
                .build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("base64")
    public Response testeBase654(PacienteVO paciente){
        base64(paciente);
        return Response.status(Response.Status.CREATED).entity(paciente).build();
    }
    
    public void base64(PacienteVO paciente) {
        File file = new File("/opt/Cerurb/uploads/imagens/" + paciente.getNome() + "/");
        if (!file.exists()) {
            file.mkdirs();  // Usa mkdirs() para criar todos os diretórios necessários
        }
        
        String path = file.getAbsolutePath() + "/" + paciente.getCpf() + ".jpeg";
        
        
        byte[] encoded = Base64.getEncoder().encode(paciente.getBase64().getBytes());
//        System.out.println(new String(encoded));   // Outputs "SGVsbG8="

        byte[] decoded = Base64.getDecoder().decode(encoded);
//        System.out.println(new String(decoded));   // Outputs "Hello"

        
        try (FileOutputStream fos = new FileOutputStream(path)) {
            //fos.write(decoded);
            fos.write(decoded);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

