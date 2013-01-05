package javagurus.curso.frameworks.dao;

import java.math.BigDecimal;
import java.util.List;

import javagurus.curso.frameworks.model.Banco;

public class BancoDAO extends GenericDAO<Banco, BigDecimal> {

	
	public List<Banco> list() {
		return (List<Banco>)getHibernateTemplate().find("FROM Banco");
	}
}
