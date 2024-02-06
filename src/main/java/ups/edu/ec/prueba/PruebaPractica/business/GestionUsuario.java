package ups.edu.ec.prueba.PruebaPractica.business;

import java.util.Date;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.prueba.PruebaPractica.dao.UsuarioDao;
import ups.edu.ec.prueba.PruebaPractica.model.Recarga;
import ups.edu.ec.prueba.PruebaPractica.model.Registro;
import ups.edu.ec.prueba.PruebaPractica.model.Usuario;

@Stateless
public class GestionUsuario {

	@Inject
	UsuarioDao usuarioDao;
	
	Usuario usuario;
	Registro registro;

	public void verificarUsuario(Recarga recarga) throws Exception {
		this.usuario = usuarioDao.buscarUsuarioporNumero(recarga.getNumTelefono());
		if((this.usuario != null) && (this.usuario.getOperador().equalsIgnoreCase(recarga.getOperador()))) {
			int aux = usuario.getSaldo()+recarga.getMonto();
			usuario.setSaldo(aux);
			registro = new Registro(recarga.getMonto(), new Date());
			this.usuario.getRegistro().add(registro);
			usuarioDao.actualizarCuenta(usuario);
		} else {
            throw new Exception("Usuario u Operadora no encontrada para el número de teléfono: " + recarga.getNumTelefono());
		}
	}
	
	


	

	public List<Usuario> getAll() {
		return usuarioDao.getAllUsuarios();
	}

}
