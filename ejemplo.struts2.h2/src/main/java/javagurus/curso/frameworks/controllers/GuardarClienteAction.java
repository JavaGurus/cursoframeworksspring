package javagurus.curso.frameworks.controllers;

import com.opensymphony.xwork2.ActionSupport;

public class GuardarClienteAction extends ActionSupport {
	private String idcliente;
	private String nombre;
	private String apaterno;
	private String oper; //edit,add,del
	
	public String execute() {
		System.out.println("OPERACION" + oper);
		System.out.println("Nombre" + nombre);
		System.out.println("Apaterno" + apaterno);
		return SUCCESS;
	}

	public String getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(String idcliente) {
		this.idcliente = idcliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApaterno() {
		return apaterno;
	}

	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}
	
	
	
}



