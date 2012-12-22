package javagurus.curso.frameworks.controllers;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "ejemplosjquery")
public class AjaxExamples extends ActionSupport {

	private Map<String, String> mapa;

	//@Actions({ @Action(value = "/obtenermapa", results = { @Result(name = "success", type = "json") }) })
	@Actions({ @Action(value = "/mapa", results = { @Result(name = "success", location = "/jquery.jsp") }) })
	public String obtenermapa() {
		mapa = new HashMap<String, String>();
		mapa.put(
				"Section 1",
				"Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.");
		mapa.put(
				"Section 2",
				"Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In suscipit faucibus urna.");
		mapa.put(
				"Section 3",
				"Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis. Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.");
		mapa.put(
				"Section 4",
				"Cras dictum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia mauris vel est. Suspendisse eu nisl. Nullam ut libero. Integer dignissim consequat lectus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.");

		return SUCCESS;
	}
	
	@Actions({ @Action(value = "/ajax1", results = { @Result(name = "success", location = "/ejemplo.jsp") }) })	
	public String obtenerPagina(){
		return SUCCESS;		
	}
	
	@Actions({ @Action(value = "/ajax4", results = { @Result(name = "success", location = "/ejemplo.jsp") }) })	
	public String obtenerPagina2(){
		return SUCCESS;		
	}

	public Map<String, String> getMapa() {
		return mapa;
	}
}
