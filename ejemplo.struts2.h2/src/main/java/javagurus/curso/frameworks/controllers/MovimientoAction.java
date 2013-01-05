package javagurus.curso.frameworks.controllers;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.ExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@ParentPackage(value = "ejemplosjquery")
@InterceptorRef("jsonValidationWorkflowStack")
@Validations(requiredStrings = {
		@RequiredStringValidator(fieldName = "loginuser", type = ValidatorType.FIELD, message = "Login User is required"),
		@RequiredStringValidator(fieldName = "loginpassword", 
		type = ValidatorType.FIELD, message = "Password is required") }, 
		expressions = { 
		@ExpressionValidator(
				expression = "loginpassword.trim().equals('test') == true", 
				message = "Password must be test."), })
public class MovimientoAction extends ActionSupport {

	private static final long serialVersionUID = 7968544374444173511L;

	private String loginuser;
	private String loginpassword;
	private String echo;

	@Action(value = "/nuevoMovimiento", results = { @Result(location = "simpleecho.jsp", name = "success") })
	public String execute() throws Exception {
		echo = "Welcome " + loginuser;

		return SUCCESS;
	}
}