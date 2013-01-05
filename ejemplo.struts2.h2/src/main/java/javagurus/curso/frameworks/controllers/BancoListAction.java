package javagurus.curso.frameworks.controllers;

import java.util.ArrayList;
import java.util.List;

import javagurus.curso.frameworks.model.Banco;
import javagurus.curso.frameworks.services.BancoService;

import com.opensymphony.xwork2.ActionSupport;

public class BancoListAction extends ActionSupport {
	private BancoService bancoService = new BancoService();
	private List<String> bancos = new ArrayList<String>();
	
	public String execute() {
		
		List<Banco> listaBancos = bancoService.list();
		for(Banco banco : listaBancos) {
			bancos.add(banco.getNombre());
		}
		return SUCCESS;
	}
	
	
	public List<String> getBancos() {
		return bancos;
	}
	public void setBancos(List<String> bancos) {
		this.bancos = bancos;
	}
	
	
	
}
