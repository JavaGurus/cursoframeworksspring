package javagurus.curso.frameworks.services;

import java.math.BigDecimal;
import java.util.List;

import javagurus.curso.frameworks.dao.BancoDAO;
import javagurus.curso.frameworks.model.Banco;




public class BancoService {
	
	private BancoDAO bancoDAO = new BancoDAO();
	/**
	 * Obtiene un banco a partir del key.
	 * @param idBanco key de entidad banco.
	 * @return Regresa la entidad.
	 */
	public Banco obtenerBanco(int idBanco) {
		return bancoDAO.get(new BigDecimal(idBanco));
	}
	
	public List<Banco> list() {
		return bancoDAO.list();
	}
	
	
}
