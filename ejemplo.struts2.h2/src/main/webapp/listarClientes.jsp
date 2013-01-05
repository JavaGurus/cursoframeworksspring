<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>    
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<sj:head jqueryui="true" jquerytheme="sunny" />
<script>
function isError(text) {
	if(text.indexOf('ERROR') >= 0) { 
		return [false, text]; 
	}
	
	return [true,''];
}
</script>
</head>
<body>

<s:url id="consultaClientesURL" action="consultarClientes"/>
<s:url id="selectbancourl" action="listaBancos"/>
<s:url id="guardarClienteURL" action="guardarCliente"/>
<s:url id="cuentasUrl" action="consultaCuentas"/>

<sjg:grid 
	id="gridclientes"
	caption="Lista de clientes"
	dataType="json"
	autowidth="true"
	href="%{consultaClientesURL}"
	onSelectRowTopics="rowselect"
    pager="true"
    
    gridModel="gridModel"
    rowList="20,40,60,80"
    rowNum="20"
    rownumbers="true"
    navigator="true"
    navigatorSearch="true"
    editurl="%{guardarClienteURL}"
    navigatorAddOptions="{
    		height:400,
    		reloadAfterSubmit:true,
			afterSubmit:function(response, postdata) {
							return isError(response.responseText);
            }
	}"
	>
	<sjg:grid
			id="cuentas"
			subGridUrl="%{cuentasUrl}"
			gridModel="gridModel"
			rowNum="-1"
			footerrow="true"
			userDataOnFooter="true"
		>
		<sjg:gridColumn name="idcuenta" key="true" title="Id Cuenta" width="50"/>
		<sjg:gridColumn name="tipo" title="Tipo Cuenta" width="200"/>
	
	</sjg:grid>
	<sjg:gridColumn name="idcliente" index="idcliente" title="ID" key="true" searchoptions="{sopt:['eq','lt','gt']}">
	</sjg:gridColumn>
	
	<sjg:gridColumn name="nombre" index="nombre" title="Nombre" editable="true"	edittype="text" sortable="true" />
    <sjg:gridColumn name="apaterno" index="apaterno"  editable="true"	edittype="text" title="Paterno" sortable="true"/>
    <sjg:gridColumn name="amaterno" index="amaterno"  editable="true"	edittype="text" title="Materno" sortable="true"/>
    <sjg:gridColumn name="edad" index="edad"  editable="true"	edittype="text" title="Edad" sortable="true"/>
	<sjg:gridColumn name="banco.nombre" index="banco.nombre" editable="true" edittype="select"
					searchoptions="{sopt:['eq','ne','bw','cn'], dataUrl: '%{selectbancourl}'}"
					searchtype="select"
					dataType="html"
					surl="%{selectbancourl}"
					title="Banco"
					sortable="true" />
	
	</sjg:grid>
</body>
</html>