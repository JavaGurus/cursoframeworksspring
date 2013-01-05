package javagurus.curso.frameworks.dto;

import java.math.BigDecimal;

import javagurus.curso.frameworks.model.Tipocuenta;

public class CuentaDTO {
	private BigDecimal idcuenta;
	private String tipo;
	public BigDecimal getIdcuenta() {
		return idcuenta;
	}
	public void setIdcuenta(BigDecimal idcuenta) {
		this.idcuenta = idcuenta;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
