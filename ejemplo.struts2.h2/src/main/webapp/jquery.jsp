<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
<head>
<sj:head jqueryui="true" jquerytheme="redmond" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ejemplos jQuery Struts</title>
</head>
<body>


	<s:url var="urlajax1" action="ajax1" />
	<s:url var="urlajax4" action="ajax4" />

	<sj:accordion id="accordion" animated="false">
		<sj:accordionItem title="Titulo 1">
                Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In suscipit faucibus urna.
        </sj:accordionItem>
		<sj:accordionItem title="Titulo 2">
                Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis. Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.
        </sj:accordionItem>
		<sj:accordionItem title="Mauris mauris ante">
			<sj:div id="divInAccrodionItem1" href="%{urlajax1}" />
		</sj:accordionItem>
		<sj:accordionItem title="Cras dictum" onClickTopics="loadAccordionDiv">
			<sj:div id="divInAccrodionItem4" href="%{urlajax4}"
				listenTopics="loadAccordionDiv" deferredLoading="true" />
		</sj:accordionItem>
	</sj:accordion>
	
	
	<sj:accordion list="mapa"/>
	
	
	<sj:a id="ajaxlink" 
                href="%{urlajax4}" 
                targets="espacio"
                indicator="indicator" 
                button="true" 
                buttonIcon="ui-icon-refresh"
        >
                Carga datos en "espacio"
        </sj:a>
        
        <div id="espacio"></div>
        <s:form id="form" theme="xhtml">
		<!-- Diferentes formatos para mostrar -->
		<sj:datepicker id="date0" name="date0" label="With Button Panel"
			showButtonPanel="true" />
		<sj:datepicker id="date1" name="date1" label="Change Month and Year"
			changeMonth="true" changeYear="true" />
		<sj:datepicker id="date2" name="date2" label="Custom Button Text"
			showOn="both" buttonText="Select a Date" />
		<sj:datepicker id="date3" name="date3"
			label="Show only on Button Click" showOn="button" />
		<sj:datepicker id="date4" name="date4" label="Text after selection"
			appendText=" (dd.MM.yy)" displayFormat="dd.MM.yy" />
		<sj:datepicker id="date5" name="date5"
			label="With fast slideDown Animation" showAnim="slideDown"
			duration="fast" />
		<sj:datepicker id="date6" name="date6"
			label="With slow fadeIn Animation" showAnim="fadeIn"
			showOptions="{direction: 'up' }" duration="slow" />
		<sj:datepicker id="date7" name="date7" label="Show 3 Months"
			numberOfMonths="3" />
		<sj:datepicker id="date8" name="date8" label="Show Month Array"
			numberOfMonths="[2,3]" />
		<sj:datepicker id="date9" name="date9"
			label="Show Years only from 2008 until 2012" yearRange="2008:2012"
			changeYear="true" />
		<sj:datepicker id="date10" name="date10" label="Button Only"
			buttonImageOnly="true" />
		<sj:datepicker id="date11" name="date11" label="Without Button"
			showOn="focus" />
		<sj:datepicker id="date12" name="date12" label="With Close Event"
			onClose="onClose" />
		<!-- Cargando diferentes valores para la fecha -->
		<sj:datepicker id="date13" label="Select a Date" />
		<sj:datepicker value="%{dateValue}" id="date14" name="date1"
			label="Date Value from Action" />
		<sj:datepicker id="date15" name="nameValue" label="Date Value by Name" />
		<sj:datepicker value="today" id="date16" name="date3"
			displayFormat="dd.mm.yy" label="Today" />
		<sj:datepicker value="yesterday" id="date17" name="date4"
			displayFormat="mm/dd/yy" label="Yesterday" />
		<sj:datepicker value="tomorrow" id="date18" name="date5"
			displayFormat="DD, d MM yy" label="Tomorrow" />
		<sj:datepicker value="2004-08-14" id="date19" name="date6"
			displayFormat="d M, yy" label="String Value" />

		<!-- Con el addon TimePicker para mostrar la hora-->
		<sj:datepicker id="time0" label="Select a Date/Time"
			value="%{new java.util.Date()}" timepicker="true" />
		<sj:datepicker id="time1" label="Select a Time"
			value="%{new java.util.Date()}" timepicker="true"
			timepickerOnly="true" />
		<sj:datepicker id="time2" label="With AM/PM" timepicker="true"
			timepickerAmPm="true" />
		<sj:datepicker id="time3" label="Show Seconds" timepicker="true"
			timepickerShowSecond="true" timepickerFormat="hh:mm:ss" />
		<sj:datepicker id="time4" label="With Steps" timepicker="true"
			timepickerShowSecond="true" timepickerFormat="h:m:s"
			timepickerStepHour="2" timepickerStepMinute="10"
			timepickerStepSecond="15" />
		<sj:datepicker id="time5" label="With Seperator" timepicker="true"
			timepickerSeparator=" at " />
		<sj:datepicker id="time6" label="With Grid" timepicker="true"
			timepickerOnly="true" timepickerGridHour="4"
			timepickerGridMinute="10" timepickerStepMinute="10" />

	</s:form>
        
        

</body>
</html>