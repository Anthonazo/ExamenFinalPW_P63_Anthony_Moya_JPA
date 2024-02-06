package ups.edu.ec.prueba.PruebaPractica.dao;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.edu.ec.prueba.PruebaPractica.model.Registro;

@Stateless
public class RegistroDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void agregarMovimiento(Registro r) {
		em.persist(r);
	}
	
	public Registro buscarRegistro(int id) {
		return em.find(Registro.class, id);
	}
	
	public List<Registro> getAll(){
		String jpql = "SELECT c FROM Registro c";
		Query q = em.createQuery(jpql, Registro.class);
		return q.getResultList();
	}

}
