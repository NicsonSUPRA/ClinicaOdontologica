package programe.io.clinicaodontologica.resources;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.File;
import java.io.FileNotFoundException;
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
    public Response testeBase654(PacienteVO paciente) throws IOException{
        adicionaArquivo(paciente);
        return Response.status(Response.Status.CREATED).entity(paciente).build();
    }
    
    public void adicionaArquivo(PacienteVO paciente) throws IOException{
        System.out.println("entrou aqui");
        System.out.println(paciente.getNome());
        //criando diretorio caso não exista
        File file = new File("/opt/Cerurb/uploads/imagens" + paciente.getNome() + "/");
        file.mkdirs();
        
        byte[]  arquivo = Base64.getDecoder().decode(paciente.getBase64());
        
        String path = "/opt/Cerurb/uploads/imagens/" + paciente.getNome() + ".pdf";
        adicionarArquivoD(arquivo, path);
        
    }
    
    public void adicionarArquivoD(byte[] base64, String path) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(path);
        fos.write(base64);
//        fos.close();
    }

}

