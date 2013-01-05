package javagurus.curso.frameworks.dao;

import java.math.BigDecimal;
import java.util.List;

import javagurus.curso.frameworks.model.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, BigDecimal> {
	
	public List<Cliente> buscarClientesPorNombre(String texto) {
		String hql = "FROM Cliente WHERE nombre like '" + texto + "%'";
		return (List<Cliente>) getHibernateTemplate().find(hql);
	}
}
