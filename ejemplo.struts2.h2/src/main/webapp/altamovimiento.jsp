<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
  <head>
    <sj:head jqueryui="true"/>
    
        <!-- This files are needed for AJAX Validation of XHTML Forms -->
        <script language="JavaScript" src="${pageContext.request.contextPath}/struts/utils.js" type="text/javascript"></script>
        <script language="JavaScript" src="${pageContext.request.contextPath}/struts/xhtml/validation.js" type="text/javascript"></script>
  </head>
  <body>
        <div id="result">Submit form bellow.</div>

    <s:form id="formValidate" action="nuevoMovimiento" theme="xhtml">
    <s:textfield 
                id="loginuser" 
                name="loginuser" 
                label="User" 
                required="true"
        />
        <s:textfield 
                id="loginpassword" 
                name="loginpassword" 
                label="Password (test)" 
                required="true"
        />
        <s:textfield 
                id="fecha" 
                name="fecha" 
                label="Fecha" 
                required="true"
        />
        <s:textfield 
                id="monto" 
                name="monto" 
                label="Monto" 
                required="true"
        />
        <s:textfield 
                id="tipoMovimiento" 
                name="tipoMovimiento" 
                label="Tipo de movimiento" 
                required="true"
        />
        <s:textfield 
                id="cuenta" 
                name="cuenta" 
                label="Cuenta" 
                required="true"
        />
        <sj:submit 
                targets="result" 
                button="true" 
                validate="true" 
                value="Submit" 
                indicator="indicator"
                />
    </s:form>
  </body>
</html>