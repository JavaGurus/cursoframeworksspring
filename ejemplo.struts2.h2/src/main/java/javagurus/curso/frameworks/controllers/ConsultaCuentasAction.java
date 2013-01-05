package javagurus.curso.frameworks.controllers;

import java.util.List;

import javagurus.curso.frameworks.dto.CuentaDTO;
import javagurus.curso.frameworks.model.Cuenta;
import javagurus.curso.frameworks.services.CuentaService;

import com.opensymphony.xwork2.ActionSupport;

public class ConsultaCuentasAction extends ActionSupport {
	private Integer id;

	// Your result List
	private List<CuentaDTO> gridModel;

	// get how many rows we want to have into the grid - rowNum attribute in the
	// grid
	private Integer rows = 0;

	// Get the requested page. By default grid sets this to 1.
	private Integer page = 0;

	// sorting order - asc or desc
	private String sord = "asc";

	// get index row - i.e. user click to sort.
	private String sidx;

	// Your Total Pages
	private Integer total = 0;

	// All Records
	private Integer records = 0;

	private CuentaService cuentaService = new CuentaService();

	public String execute() {

		// Calcalate until rows ware selected
		int to = (rows * page);

		// Criteria to Build SQL

		if (id != null)
			gridModel = cuentaService.findByIdCliente(id);

		records = gridModel.size();

		// Set to = max rows
		if (to > records)
			to = records;

		// Calculate total Pages
		total = (int) Math.ceil((double) records / (double) rows);

		return SUCCESS;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<CuentaDTO> getGridModel() {
		return gridModel;
	}

	public void setGridModel(List<CuentaDTO> gridModel) {
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

	public CuentaService getCuentaService() {
		return cuentaService;
	}

	public void setCuentaService(CuentaService cuentaService) {
		this.cuentaService = cuentaService;
	}

}
