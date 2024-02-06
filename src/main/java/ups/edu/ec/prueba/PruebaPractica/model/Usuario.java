package ups.edu.ec.prueba.PruebaPractica.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private int id;
	private String nombre;
	private String numCelular;
	private int saldo;
	private String operador;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<Registro> registro = new ArrayList<Registro>();
	
	
	public Usuario() {}


	public Usuario(String nombre, String numCelular, int saldo, String operador) {
		this.nombre = nombre;
		this.numCelular = numCelular;
		this.saldo = saldo;
		this.operador = operador;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getNumCelular() {
		return numCelular;
	}


	public void setNumCelular(String numCelular) {
		this.numCelular = numCelular;
	}


	public int getSaldo() {
		return saldo;
	}


	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}


	public String getOperador() {
		return operador;
	}


	public void setOperador(String operador) {
		this.operador = operador;
	}

	public List<Registro> getRegistro() {
		return registro;
	}


	public void setRegistro(List<Registro> registro) {
		this.registro = registro;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", numCelular=" + numCelular + ", saldo=" + saldo
				+ ", operador=" + operador + ", registro=" + registro + "]";
	}
	
	

	
	
	
	
	
	
	

	
	
	
}
