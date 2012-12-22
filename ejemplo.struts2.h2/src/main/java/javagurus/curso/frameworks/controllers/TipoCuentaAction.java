package javagurus.curso.frameworks.controllers;

import java.util.List;

import javagurus.curso.frameworks.dao.TipoCuentaDao;
import javagurus.curso.frameworks.model.Tipocuenta;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "ejemplosjquery")
public class TipoCuentaAction extends ActionSupport {
	private List<Tipocuenta> tiposDeCuenta;
	private TipoCuentaDao tipoCuentaDao = new TipoCuentaDao();

	@Action(value = "/listaTiposCuenta", results = { @Result(name = "success", type = "json") })
	public String listaTiposCuenta() {
		tiposDeCuenta = tipoCuentaDao.listar();
		return SUCCESS;
	}
	// Getters y setters

	public List<Tipocuenta> getTiposDeCuenta() {
		return tiposDeCuenta;
	}

	public void setTiposDeCuenta(List<Tipocuenta> tiposDeCuenta) {
		this.tiposDeCuenta = tiposDeCuenta;
	}
	
}
