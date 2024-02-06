package ups.edu.ec.prueba.PruebaPractica.services;


import java.util.List;


import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ups.edu.ec.prueba.PruebaPractica.business.GestionUsuario;
import ups.edu.ec.prueba.PruebaPractica.model.Recarga;
import ups.edu.ec.prueba.PruebaPractica.model.Usuario;

@Path("recarga")
public class RecargaService {

	@Inject
	GestionUsuario gUsuario;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response movTransferencia(Recarga recarga) {
		try {
			gUsuario.verificarUsuario(recarga);
			ErrorMessage error = new ErrorMessage(1, "OK");
			return Response.status(Response.Status.CREATED).entity(error).build();			
		} catch (Exception e) {
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getCuenta() {
		List<Usuario> cuentas = gUsuario.getAll();
		if(cuentas.size()>0)
			return Response.ok(cuentas).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran clientes");
		return Response.status(Response.Status.NOT_FOUND).entity(error).build();
	}
	

}
