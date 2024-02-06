package ups.edu.ec.prueba.PruebaPractica.business;

import java.util.Date;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import ups.edu.ec.prueba.PruebaPractica.dao.UsuarioDao;
import ups.edu.ec.prueba.PruebaPractica.model.Registro;
import ups.edu.ec.prueba.PruebaPractica.model.Usuario;

@Singleton
@Startup
public class GestionDatos {

	@Inject 
	private UsuarioDao usuarioDao;
	
	@PostConstruct
	public void Init() {
		

		Usuario p = new Usuario("Anthony","0998653983", 0, "Movistar");
		
		Usuario p2 = new Usuario("Patricio","0983495675", 0, "Claro");
		
		Registro rg = new Registro(10, new Date());
		
		p.setSaldo(rg.getMonto());
		
		p.getRegistro().add(rg);
		
		Registro rg2 = new Registro(10, new Date());
		
		p2.setSaldo(rg2.getMonto());
		
		p2.getRegistro().add(rg2);
		
		usuarioDao.agregarCuenta(p);
		usuarioDao.agregarCuenta(p2);

		
		
		



		
		List<Usuario> x = usuarioDao.getAllUsuarios();
		for(Usuario cu: x) {
			System.out.println(cu.toString());
		}
	}
	
	
}
