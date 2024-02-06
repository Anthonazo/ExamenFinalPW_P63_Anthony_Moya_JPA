package ups.edu.ec.prueba.PruebaPractica.dao;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.edu.ec.prueba.PruebaPractica.model.Usuario;

@Stateless
public class UsuarioDao {

	@PersistenceContext
	private EntityManager em;

	public void agregarCuenta(Usuario u) {
		em.persist(u);
	}

	public void actualizarCuenta(Usuario u) {
		em.merge(u);
	}

	public Usuario buscarCuenta(int id) {
		return em.find(Usuario.class, id);
	}

	public List<Usuario> getAllUsuarios() {
		String jpql = "SELECT c FROM Usuario c";
		Query q = em.createQuery(jpql, Usuario.class);
		return q.getResultList();
	}

	public Usuario buscarUsuarioporNumero(String numeroCelular) {
		String jpql = "SELECT c FROM Usuario c WHERE c.numCelular = : numeroCelular";
		Query q = em.createQuery(jpql, Usuario.class);
		q.setParameter("numeroCelular", numeroCelular);
		List<Usuario> x = q.getResultList();
		if(x.size() > 0) 
			return x.get(0);
		return null;
	}

	// BUSCAR CUENTA POR CEDULA SI SIRVE
//	public Cuenta getCuentaCedula(String cedu) {
//		String jpql = "SELECT c FROM Cuenta c WHERE c.persona.cedula = : cedu";
//		Query q = em.createQuery(jpql, Cuenta.class);
//		q.setParameter("cedu", cedu);
//		List<Cuenta> cuenta = q.getResultList();
//		if (cuenta.size() > 0)
//			return cuenta.get(0);
//		return null;
//	}

}
