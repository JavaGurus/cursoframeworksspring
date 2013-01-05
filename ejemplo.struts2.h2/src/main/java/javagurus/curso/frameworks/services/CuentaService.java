package javagurus.curso.frameworks.services;

import java.util.List;

import javagurus.curso.frameworks.dao.CuentaDAO;
import javagurus.curso.frameworks.dto.CuentaDTO;


public class CuentaService {
	
	CuentaDAO cuentaDAO = new CuentaDAO();
	
	public List<CuentaDTO> findByIdCliente(int idCliente) {
		return cuentaDAO.findByIdCliente(idCliente);
	}
	
}
