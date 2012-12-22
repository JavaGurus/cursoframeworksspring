package javagurus.curso.frameworks.dao;

import java.util.List;

import javagurus.curso.frameworks.model.Banco;
import javagurus.curso.frameworks.model.Cuenta;
import javagurus.curso.frameworks.model.Tipocuenta;
import javagurus.curso.frameworks.util.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class TipoCuentaDao {
	public static List<Tipocuenta> listar() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			List<Tipocuenta> tiposDecuenta = session.createQuery("from Tipocuenta").list();
			return tiposDecuenta;
		} catch (HibernateException he) {
			System.out.println("Error : " + he.getMessage());
		} finally {
			session.close();
		}
		return null;
	}	
}
