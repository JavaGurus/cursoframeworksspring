package javagurus.curso.frameworks.services;

import java.math.BigDecimal;
import java.util.List;

import javagurus.curso.frameworks.dao.ClienteDAO;
import javagurus.curso.frameworks.model.Cliente;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;

public class ClienteService {

	private ClienteDAO clienteDAO = new ClienteDAO();

	public Cliente consultarCliente(int idCliente) {
		return clienteDAO.get(new BigDecimal(idCliente));
	}

	public void insertarCliente(Cliente cliente) {
		clienteDAO.save(cliente);
	}

	public void eliminarCliente(int idCliente) {
		Cliente cliente = consultarCliente(idCliente);
		clienteDAO.delete(cliente);
	}

	public List<Cliente> buscarClientesPorNombre(String texto) {
		return clienteDAO.buscarClientesPorNombre(texto);
	}

	public List<Cliente> findByCriteria(DetachedCriteria dc, int from, int size) {
		Criteria criteria = dc.getExecutableCriteria(clienteDAO
				.getSessionFactory().getCurrentSession());
		criteria.setFirstResult(from);
		criteria.setMaxResults(size);
		return criteria.list();
	}

	public int countByCriteria(DetachedCriteria dc) {
		Session session = clienteDAO.getSessionFactory().getCurrentSession();
		Transaction t = session.beginTransaction();
		Criteria criteria = dc.getExecutableCriteria(session);
		criteria.setProjection(Projections.rowCount());
		int count = ((Long) criteria.list().get(0)).intValue();
		return count;
	}

}
