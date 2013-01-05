package javagurus.curso.frameworks.controllers;

import java.math.BigDecimal;
import java.util.List;

import javagurus.curso.frameworks.model.Cliente;
import javagurus.curso.frameworks.services.ClienteService;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;

public class ConsultarClientesAction extends ActionSupport {
	private ClienteService clienteService = new ClienteService();
	
	private List<Cliente> gridModel;
		
	private Integer rows = 0;
	
	private Integer page = 0;
	/**
	 * ASC o DESC
	 */
	private String sord;
	/**
	 * Atributo por el que estas ordenando
	 */
	private String sidx;
	
	private String searchField;
	
	private String searchString;
	
	//['eq','ne','lt','gt','ge', etc]
	private String searchOper;
	
	//Total de paginas
	private Integer total = 0;
	
	//Total de registros
	private Integer records = 0;
	
	public String execute() {
		int to = rows * page;
		int from = to - rows;
		DetachedCriteria criteria = DetachedCriteria.forClass(Cliente.class);
		
		//Si el campo de busqueda es diferente de nulo
		if(searchField != null) {
			if(searchField.equals("idcliente")) {
				if(searchOper.equals("eq")) {
					BigDecimal searchValue = new BigDecimal(searchString);
					criteria.add(Restrictions.eq("idcliente", searchValue));
				} else if(searchOper.equals("lt")) {
					BigDecimal searchValue = new BigDecimal(searchString);
					criteria.add(Restrictions.lt("idcliente", searchValue));
	
				}  else if(searchOper.equals("gt")) {
					BigDecimal searchValue = new BigDecimal(searchString);
					criteria.add(Restrictions.gt("idcliente",  searchValue ));
				}
			}
			else if (searchField.equals("nombre")) {
				//contains
				if (searchOper.equals("cn")) {
					criteria.add(Restrictions.like("nombre", "%" +searchString+ "%"));
				}
			} else if (searchField.equals("banco.nombre")) {
				criteria.createAlias("banco", "b");
				if(searchOper.equals("eq")) {
					criteria.add(Restrictions.eq("b.nombre", searchString));
				}
			}
		}
		
		
		// Count Customers
	    records = clienteService.countByCriteria(criteria);

	    // Reset count Projection
	    criteria.setProjection(null);
	    criteria.setResultTransformer(Criteria.ROOT_ENTITY);
	    
	    if(sidx != null && !sidx.equals("")) {
	    	if(sord.equals("asc")) {
	    		criteria.addOrder(Order.asc(sidx));
	    	} else {
	    		criteria.addOrder(Order.desc(sidx));
	    	}
	    }
	    
		gridModel = clienteService.findByCriteria(criteria, from, rows);
		
		if(to > records) to = records;
		
		total = (int) Math.ceil((double) records / (double) rows);
		
		return "success";
	}
	
	public List<Cliente> getGridModel() {
		return gridModel;
	}

	public void setGridModel(List<Cliente> gridModel) {
		this.gridModel = gridModel;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public String getSearchOper() {
		return searchOper;
	}

	public void setSearchOper(String searchOper) {
		this.searchOper = searchOper;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getRecords() {
		return records;
	}

	public void setRecords(Integer records) {
		this.records = records;
	}	
}
