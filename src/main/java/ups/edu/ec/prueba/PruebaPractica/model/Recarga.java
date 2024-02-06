package ups.edu.ec.prueba.PruebaPractica.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Recarga {
	
	private String numTelefono;
	private String operador;
	private int monto;
	
	
	public String getNumTelefono() {
		return numTelefono;
	}
	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	
	public int getMonto() {
		return monto;
	}
	public void setMonto(int monto) {
		this.monto = monto;
	}
	@Override
	public String toString() {
		return "Recarga [numTelefono=" + numTelefono + ", operador=" + operador + ", monto=" + monto + "]";
	}

	
}
