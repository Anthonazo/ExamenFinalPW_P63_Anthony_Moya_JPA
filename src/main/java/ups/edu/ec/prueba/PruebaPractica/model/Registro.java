package ups.edu.ec.prueba.PruebaPractica.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Registro {

	@Id
	@GeneratedValue
	private int id;
	private int monto;
	private Date fecha;

	public Registro() {}
	
	
	public Registro( int monto, Date fecha) {
		this.monto = monto;
		this.fecha = fecha;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	



	public int getMonto() {
		return monto;
	}


	public void setMonto(int monto) {
		this.monto = monto;
	}


	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	@Override
	public String toString() {
		return "Registro [id=" + id + ", monto=" + monto + ", fecha=" + fecha + "]";
	}

	
	

	

	
	
	
	
}
