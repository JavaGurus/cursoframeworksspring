package javagurus.curso.frameworks.dao;

import java.math.BigDecimal;
import java.util.List;

import javagurus.curso.frameworks.dto.CuentaDTO;
import javagurus.curso.frameworks.model.Cuenta;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;


public class CuentaDAO extends GenericDAO<Cuenta, Integer> {
	public List<CuentaDTO> findByIdCliente(int idCliente) {
		DetachedCriteria dc  = DetachedCriteria.forClass(Cuenta.class);
		Session session = getSessionFactory().getCurrentSession();
		Transaction t = session.beginTransaction();
		Criteria criteria = dc.getExecutableCriteria(session)
				.createAlias("cliente", "c")
				.createAlias("tipocuenta", "t")
				.add(Restrictions.eq("c.idcliente", new BigDecimal(idCliente)))
				.setProjection( Projections.projectionList()
        	      .add( Projections.property("idcuenta"), "idcuenta" )
        	      .add( Projections.property("t.nombre"), "tipo" )
        	    )
        	    .setResultTransformer(Transformers.aliasToBean(CuentaDTO.class));
    	
        List<CuentaDTO> cuentas = criteria.list();
        
        t.commit();
        return cuentas;
	}
}
