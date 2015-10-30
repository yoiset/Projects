<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="form-ext" uri="http://www.springframework.org/tags/form-ext" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<script type="text/javascript">
var arrayList = ["expedProhibicion","tipoDocIdent","numDocIdent","nombre","apellido1","apellido2"];
var contextPath = '${pageContext.request.contextPath}';
var buscar = '${buscarPersona}';

///////////////////////////////////////////////////////////////////////////////
//my pending

//ListGrid with my pending search results
var pendingGrid;

//Paginator control for my pending search results
var pendingPaginator;

function initPending() {

  var grid = defineGrid('myPendingGridId');
  
  pendingGrid = grid.createGrid();

  pendingGrid.hdr.style.height = "40px";
  pendingGrid.setImagePath(contextPath + "/core/static/images/dhtmlx/");
  pendingGrid.setSkin("evr");
  pendingGrid.attachEvent("onSelectStateChanged", doOnSelectStateChangedPending);
  pendingGrid.attachEvent("onBeforeSorting", doOnbeforeSorting);  
  pendingGrid.setEditable(false); 
  pendingGrid.enableMultiselect(false);
  pendingGrid.init(); 

  pendingPaginator = new Paginator('myPendingPaginatorId',{varName:"pendingPaginator", 
      maxResults:10, 
      labelFirst:'<spring:message code="page.common.paginator.first"/>',
      labelPrevious:'<spring:message code="page.common.paginator.previous"/>',
      labelNext:'<spring:message code="page.common.paginator.next"/>',
      labelLast:'<spring:message code="page.common.paginator.last"/>',
      sortingFlag: true,
      fieldName:"lastUpdate",
      fieldColum:0,
      order:'<spring:message code="page.common.paginator.order"/>'
  });
  
  pendingPaginator.onchange=doFilterPending;
  
}

function doOnSelectStateChangedPending(rowID) {
	selectedPersonaId = rowID;
  	updateLinks();
}

function doOnbeforeSorting(ind,type,direction) {
	pendingPaginator.setSorting(arrayList[ind], direction, ind);
	doFilterPending();
}


function doExport() {
	if (pendingGrid.getRowsNum()==0){
		alert('<spring:message code="page.persona.alert.consultaExportPDF" />');
	    return;
	}

	if (pendingPaginator.totalResults>10000){
		alert('<spring:message code="page.common.export.limite" />');
	}
	
	var queryString = $('#searchForm').formSerialize();
	location.href = contextPath + "/app/persona/exportPersonas?"+ queryString + "&sortingFlag=" + pendingPaginator.sortingFlag + "&fieldName=" + pendingPaginator.fieldName + "&order=" + pendingPaginator.order;
	document.getElementById("viewExportId").value = "Exportar";
}

///////////////////////////////////////////////////////////////////////////////
//common

function defineGrid(id) {
  var grid = new Listgrid(id);

  grid.addCol({header:'<spring:message code="page.persona.grid.label.expediente" />', width:90, sorting:"str"});
  grid.addCol({header:'<spring:message code="page.persona.grid.label.tipoDocIdent" />', width:220, sorting:"str"});
  grid.addCol({header:'<spring:message code="page.persona.grid.label.numDocIdent" />', width:95, sorting:"str"});
  grid.addCol({header:'<spring:message code="page.persona.grid.label.nombre" />', width:150, sorting:"str"});
  grid.addCol({header:'<spring:message code="page.persona.grid.label.apellido1" />', width:150, sorting:"str"});
  grid.addCol({header:'<spring:message code="page.persona.grid.label.apellido2" />', width:150, sorting:"str"});
      
  return grid;
}

var selectedPersonaId = "";

function updateLinks() {
    
}

function prepareFilter() {
  	processRequest();
  	pendingPaginator.reset();
}

function doFilter() {

	var fechaNacimientoDesde = document.getElementById("fechaNacimientoDesde").value;
	var fechaNacimientoHasta = document.getElementById("fechaNacimientoHasta").value;

	var fechaProhibicionDesde = document.getElementById("fechaProhibicionDesde").value;
	var fechaProhibicionHasta = document.getElementById("fechaProhibicionHasta").value;

	var fechaSituacionDesde = document.getElementById("fechaSituacionDesde").value;
	var fechaSituacionHasta = document.getElementById("fechaSituacionHasta").value;


	var durAnos = document.getElementById("durAnos").value;
	var durMeses = document.getElementById("durMeses").value;

	/* Comprobar los campos duración */
	if (durAnos != "" && (!validaEntero(durAnos) || (durAnos.length != 2))){
    	alert('<spring:message code="page.persona.alert.formatDurAnos" />');
	    return;
    }

	if (durMeses != "" && (!validaEntero(durMeses) || (durMeses.length != 2))){
    	alert('<spring:message code="page.persona.alert.formatDurMeses" />');
	    return;
    }

	/* Comprobar que las fechas tengan formato correcto */
	if ((fechaNacimientoDesde != "" ) && !validaFechaDDMMAAAA(fechaNacimientoDesde)){
    	alert('<spring:message code="page.persona.alert.formatFecha" />');
	    return;
	}
	
	if ((fechaNacimientoHasta != "" ) && !validaFechaDDMMAAAA(fechaNacimientoHasta)){
    	alert('<spring:message code="page.persona.alert.formatFecha" />');
	    return;
	}

	if ((fechaProhibicionDesde != "" ) && !validaFechaDDMMAAAA(fechaProhibicionDesde)){
    	alert('<spring:message code="page.persona.alert.formatFecha" />');
	    return;
	}

	if ((fechaProhibicionHasta != "" ) && !validaFechaDDMMAAAA(fechaProhibicionHasta)){
    	alert('<spring:message code="page.persona.alert.formatFecha" />');
	    return;
	}


	if ((fechaSituacionDesde != "" ) && !validaFechaDDMMAAAA(fechaSituacionDesde)){
    	alert('<spring:message code="page.persona.alert.formatFecha" />');
	    return;
	}


	if ((fechaSituacionHasta != "" ) && !validaFechaDDMMAAAA(fechaSituacionHasta)){
    	alert('<spring:message code="page.persona.alert.formatFecha" />');
	    return;
	}

	/* Comprobar que existan las fechas desde y hasta si viene alguna */
    if (((fechaNacimientoDesde != "") && (fechaNacimientoHasta == "")) || ((fechaNacimientoDesde == "") && (fechaNacimientoHasta != ""))){
    	alert('<spring:message code="page.persona.alert.formatFechaNacimiento" />');
	    return;
    }

    if (((fechaProhibicionDesde != "") && (fechaProhibicionHasta == "")) || ((fechaProhibicionDesde == "") && (fechaProhibicionHasta != ""))){
    	alert('<spring:message code="page.persona.alert.formatFechaProhibicion" />');
	    return;
    }

    if (((fechaSituacionDesde != "") && (fechaSituacionHasta == "")) || ((fechaSituacionDesde == "") && (fechaSituacionHasta != ""))){
    	alert('<spring:message code="page.persona.alert.formatFechaSituacion" />');
	    return;
    }
    
  	/* Comprobar que si vienen la fecha desde sea menor o igual que la fecha hasta */
	if ((fechaNacimientoDesde != "" ) && (fechaNacimientoHasta != "") && !esFechaValida(fechaNacimientoDesde, fechaNacimientoHasta)){
    	alert('<spring:message code="page.persona.alert.formatFechaMenor" />');
	    return;
    }

	if ((fechaProhibicionDesde != "" ) && (fechaProhibicionHasta != "") && !esFechaValida(fechaProhibicionDesde, fechaProhibicionHasta)){
    	alert('<spring:message code="page.persona.alert.formatFechaMenor" />');
	    return;
    }

	if ((fechaSituacionDesde != "" ) && (fechaSituacionHasta != "") && !esFechaValida(fechaSituacionDesde, fechaSituacionHasta)){
    	alert('<spring:message code="page.persona.alert.formatFechaMenor" />');
	    return;
    }
	
	doFilterPending();
}

function doFilterPending() {
	muestraCarga();
  	var optionsPending = { 
          beforeSubmit:  prepareRequestPending,
          success: writeResponsePending
  	}; 

  	$('#searchForm').ajaxSubmit(optionsPending);
}

function prepareRequestPending(formData, jqForm, options) { 
	  formData[formData.length] = { name: 'firstResult', value: pendingPaginator.firstResult };
	  formData[formData.length] = { name: 'maxResults', value: pendingPaginator.maxResults };
	  formData[formData.length] = { name: 'fieldName', value: pendingPaginator.fieldName };
	  formData[formData.length] = { name: 'order', value: pendingPaginator.order };
	  formData[formData.length] = { name: 'sortingFlag', value: pendingPaginator.sortingFlag };
	  formData[formData.length] = { name: 'searchParam', value: 'MY_PENDING' };
	  return true; 
} 

function writeResponsePending(responseText, statusText, xhr, $form) {
	ocultaCarga();
	
  	if (!processResponse(responseText)) {
      	return;
  	}

  	addPaginatedGridRows(pendingGrid, pendingPaginator, responseText, null); 
	if (pendingPaginator.totalResults>0){
	  	document.getElementById("numRegistrosTotales").innerHTML='<spring:message code="page.common.paginator.total" />'+ pendingPaginator.totalResults;
	} else {
	  	document.getElementById("numRegistrosTotales").innerHTML='<spring:message code="page.common.paginator.sinResultados" />';
	}
  	
}

function doReset() {
  	limpiaFormulario(document.getElementById("searchForm"));
  	pendingPaginator.reset();
  	pendingGrid.clearAll();
  	selectedPersonaId = "";
  	updateLinks();
  	document.getElementById("numRegistrosTotales").innerHTML="";
  	$.ajax({
	    type: "POST",
	    cache: false,
	    url: contextPath + "/app/persona/limpiarBusqueda"
	});
}

function doView() {
	  if (selectedPersonaId == "") {
	    alert('<spring:message code="page.persona.alert.selectRegistro" />');
	    return;
	  }

	  document.getElementById("viewPersona").href = contextPath + "/app/persona/startViewPersona?idPersona=" + selectedPersonaId;
	  document.getElementById("viewPersona").click();
}

function openFExtra(){
	document.getElementById("openFiltrosExtra").style.display="none";
	document.getElementById("closeFiltrosExtra").style.display="";
	document.getElementById("filtrosExtra").style.display="";
}

function closeFExtra(){
	document.getElementById("openFiltrosExtra").style.display="";
	document.getElementById("closeFiltrosExtra").style.display="none";
	document.getElementById("filtrosExtra").style.display="none";
}

function openBProhibicion(){
	document.getElementById("openBusquedaProhibicion").style.display="none";
	document.getElementById("closeBusquedaProhibicion").style.display="";
	document.getElementById("filtrosProhibicion").style.display="";
}

function closeBProhibicion(){
	document.getElementById("openBusquedaProhibicion").style.display="";
	document.getElementById("closeBusquedaProhibicion").style.display="none";
	document.getElementById("filtrosProhibicion").style.display="none";
}

onload = function() {
	initPending();
	initCalendars();
	closeFExtra();
	closeBProhibicion();

	if (buscar=='1'){
	   doFilter();
	}
};

///////////////////////////////////////////////////////////////////////////////

function initCalendars() {
	  var calendars1 = new dhtmlXCalendarObject(["fechaNacimientoDesde","fechaNacimientoHasta","fechaProhibicionDesde","fechaProhibicionHasta","fechaSituacionDesde","fechaSituacionHasta"]);
	  calendars1.setSkin("evr");
	  calendars1.setDateFormat('<spring:message code="common.dateFormat"/>'.replace("dd","%d").replace("MM","%m").replace("yyyy","%Y"));
	  calendars1.loadUserLanguage("${userLang}");
	  calendars1.setWeekStartDay(<spring:message code="common.weekStartDate"/>);
	  /*calendars.setSensitiveRange(null, "${sensitiveRangeMax}");*/
	  calendars1.setSensitiveRange(null, null);
	  calendars1.hideTime();
}

String.prototype.ltrim = function() {
	return this.replace(/^\s+/,"").replace(/&nbsp;/g,"");
}
</script>

          <div id="formulcuad">  
              <!-- BEGIN SEARCH FORM FILTER -->
              <form:form id="searchForm" action="${pageContext.request.contextPath}/app/persona/searchPersona"
                    modelAttribute="${modelAttribute}" >
                    
                    <!-- BREADCRUM    -->
					<div class="breadcrumb">
					  <span class="left"></span>
					  <ul class="breadcrumb">
					    <li><a href="${pageContext.request.contextPath}"><spring:message code="page.breadcrumb.home"/></a></li>
					    <li><a href="${pageContext.request.contextPath}/app/persona/startPersona" class="active"><spring:message code="page.breadcrumb.persona"/></a></li>
					  </ul>
					  <span class="right"></span>
					</div>
					<!-- FIN BREADCRUM -->

					<div class="listado">
						<div class="encabezado">
				  			<label for="usuario">  					
								<span class="label">
				 					<spring:message code="page.breadcrumb.persona"/>										
								</span>
				 			</label>  								
						</div>		
					</div>
 
                  	<fieldset>
                  		
                      <legend><spring:message code="page.persona.header.filter"/></legend>
                      
                  	  <label class="linea-medio">
               	  		<span class="label_col1"><spring:message code="page.persona.form.expedProhibicion.label"/></span>
                     	<form:input type="text" id="expedProhibicion" name="expedProhibicion" path="expedProhibicion" maxlength="255"
                       	alt='${msg["page.persona.form.expedProhibicion.title"]}' 
                       	title='${msg["page.persona.form.expedProhibicion.title"]}'></form:input>    
                      </label>

                      <label for="tipoDocIdent" class="linea-medio">
               	  		<span class="label_col1 "><spring:message code="page.persona.form.tipoDocIdent.label"/></span>
               	  		<form:select id="tipoDocIdent" path="tipoDocIdent" title='${msg["page.persona.form.tipoDocIdent.title"]}'>
							<form:option value="" label=""></form:option>
							<form:options items="${tiposDocList}" itemValue="code" itemLabel="description" />                       		
           				</form:select>   
                      </label>                      

                  	  <label class="linea-medio linea-dos">
               	  		<span class="label_col2"><spring:message code="page.persona.form.numDocIdent.label"/></span>
                     	<form:input type="text" id="numDocIdent" name="numDocIdent" path="numDocIdent" maxlength="255"
                       	alt='${msg["page.persona.form.numDocIdent.title"]}' 
                       	title='${msg["page.persona.form.numDocIdent.title"]}'></form:input>    
                      </label>
                      
					  <label class="linea-medio">
               	  		<span class="label_col1"><spring:message code="page.persona.form.nombre.label"/></span>
                     	<form:input type="text" id="nombre" name="nombre" path="nombre" maxlength="255"
                       	alt='${msg["page.persona.form.nombre.title"]}' 
                       	title='${msg["page.persona.form.nombre.title"]}'></form:input>    
                      </label>      
                                      
                  	  <label class="linea-medio">
               	  		<span class="label_col1"><spring:message code="page.persona.form.apellido1.label"/></span>
                     	<form:input type="text" id="apellido1" name="apellido1" path="apellido1" maxlength="255"
                       	alt='${msg["page.persona.form.apellido1.title"]}' 
                       	title='${msg["page.persona.form.apellido1.title"]}'></form:input>    
                      </label> 
                      
                  	  <label class="linea-medio linea-dos">
               	  		<span class="label_col2"><spring:message code="page.persona.form.apellido2.label"/></span>
                     	<form:input type="text" id="apellido2" name="apellido2" path="apellido2" maxlength="255"
                       	alt='${msg["page.persona.form.apellido2.title"]}' 
                       	title='${msg["page.persona.form.apellido2.title"]}'></form:input>    
                      </label>   
                    		  
					  <div id="filtrosExtra">
					     <fieldset>
					     <hr/>
						     <label class="linea-medio">
		               	  		<span class="label_col1"><spring:message code="page.persona.form.sexo.label"/></span> 
		                       	<form:select id="sexo" path="sexo" title='${msg["page.persona.form.sexo.title"]}'>
		                       		<form:option value="" label=""></form:option>
									<form:options items="${sexosList}" itemValue="code" itemLabel="description" />                       		
           						</form:select>    
		                      </label> 
		                      
		                  	  <label class="linea-medio linea-dos">
		               	  		<span class="label_col2"><spring:message code="page.persona.form.telefono.label"/></span>
		                     	<form:input type="text" id="telefono" name="telefono" path="telefono" maxlength="255"
		                       	alt='${msg["page.persona.form.telefono.title"]}' 
		                       	title='${msg["page.persona.form.telefono.title"]}'></form:input>    
		                      </label>   
		                      
		                      <label class="linea-medio">
		               	  		<span class="label_col1"><spring:message code="page.persona.form.fechaNacimientoDesde.label"/></span>
		                     	<form:input type="text" id="fechaNacimientoDesde" name="fechaNacimientoDesde" path="fechaNacimientoDesde" 
		                       	alt='${msg["page.persona.form.fechaNacimientoDesde.title"]}' 
		                       	title='${msg["page.persona.form.fechaNacimientoDesde.title"]}'></form:input>    
		                      </label> 
		                      
		                  	  <label class="linea-medio linea-dos">
		               	  		<span class="label_col2"><spring:message code="page.persona.form.fechaNacimientoHasta.label"/></span>
		                     	<form:input type="text" id="fechaNacimientoHasta" name="fechaNacimientoHasta" path="fechaNacimientoHasta" 
		                       	alt='${msg["page.persona.form.fechaNacimientoHasta.title"]}' 
		                       	title='${msg["page.persona.form.fechaNacimientoHasta.title"]}'></form:input>    
		                      </label>   
		                      
		                      <label class="linea-medio">
		               	  		<span class="label_col1"><spring:message code="page.persona.form.provincia.label"/></span>
		               	  		<form:select id="idProvincia" path="idProvincia" title='${msg["page.persona.form.provincia.title"]}'>
									<form:option value="" label=""></form:option>
									<form:options items="${provinciasList}" itemValue="code" itemLabel="description" />                       		
		           				</form:select>   	
           					  </label>	               	  		
		                     
		                      <label class="linea-medio linea-dos">
		               	  		<span class="label_col2"><spring:message code="page.persona.form.comunidadAutonoma.label"/></span>
		               	  		<form:select id="idComunidad" path="idComunidad" title='${msg["page.persona.form.comunidadAutonoma.title"]}'>
									<form:option value="" label=""></form:option>
									<form:options items="${comunidadesList}" itemValue="code" itemLabel="description" />                       		
		           				</form:select>   		                       	
		                      </label>
		                      
		                      <label class="linea-medio">
		               	  		<span class="label_col1"><spring:message code="page.persona.form.codPostal.label"/></span>
		                     	<form:input type="text" id="codPostal" name="codPostal" path="codPostal" maxlength="10"
		                       	alt='${msg["page.persona.form.codPostal.title"]}' 
		                       	title='${msg["page.persona.form.codPostal.title"]}'></form:input>    
		                      </label> 
		                                  
		                      <label class="linea-medio">
		               	  		<span class="label_col1"><spring:message code="page.persona.form.domicilio.label"/></span>
		                     	<form:input type="text" id="domicilio" name="domicilio" path="domicilio" class="campoLargo" maxlength="255"
		                       	alt='${msg["page.persona.form.domicilio.title"]}' 
		                       	title='${msg["page.persona.form.domicilio.title"]}'></form:input>    
		                      </label> 
		                           
		                      <label class="linea-medio">
		               	  		<span class="label_col1"><spring:message code="page.persona.form.observaciones.label"/></span>
		                     	<form:input type="text" id="observaciones" name="observaciones" path="observaciones" class="campoLargo" maxlength="255"
		                       	alt='${msg["page.persona.form.observaciones.title"]}' 
		                       	title='${msg["page.persona.form.observaciones.title"]}'></form:input>    
		                      </label> 
		                       
					     </fieldset>
					  </div>
					  
					  <div id="filtrosProhibicion">
					     <fieldset>
					     <hr/>
						      <label class="linea-medio">
		               	  		<span class="label_col1"><spring:message code="page.persona.form.tipoProhibicion.label"/></span>
		               	  		<form:select id="idTipoProhibicion" path="idTipoProhibicion" title='${msg["page.persona.form.tipoProhibicion.title"]}'>
									<form:option value="" label=""></form:option>
									<form:options items="${tiposProhibicionList}" itemValue="code" itemLabel="description" />                       		
		           				</form:select>  
		                      </label> 
		                      
		                      <label class="linea-medio">
		               	  		<span class="label_col1"><spring:message code="page.persona.form.fechaProhibicionDesde.label"/></span>
		                     	<form:input type="text" id="fechaProhibicionDesde" name="fechaProhibicionDesde" path="fechaProhibicionDesde" 
		                       		alt='${msg["page.persona.form.fechaProhibicionDesde.title"]}' 
		                       		title='${msg["page.persona.form.fechaProhibicionDesde.title"]}'></form:input>    
		                      </label> 
		                      
		                  	  <label class="linea-medio linea-dos">
		               	  		<span class="label_col2"><spring:message code="page.persona.form.fechaProhibicionHasta.label"/></span>
		                     	<form:input type="text" id="fechaProhibicionHasta" name="fechaProhibicionHasta" path="fechaProhibicionHasta" 
		                       		alt='${msg["page.persona.form.fechaProhibicionHasta.title"]}' 
		                       		title='${msg["page.persona.form.fechaProhibicionHasta.title"]}'></form:input>    
		                      </label>   
		                      
		                      <label class="linea-medio">
		               	  		<span class="label_col1"><spring:message code="page.persona.form.situacion.label"/></span>
		               	  		<form:select id="idSituacion" path="idSituacion" title='${msg["page.persona.form.situacion.title"]}'>
									<form:option value="" label=""></form:option>
									<form:options items="${situacionesList}" itemValue="code" itemLabel="description" />                       		
		           				</form:select>  		                       	
		                      </label> 
		                      
		                      <label class="linea-medio">
		               	  		<span class="label_col1"><spring:message code="page.persona.form.fechaSituacionDesde.label"/></span>
		                     	<form:input type="text" id="fechaSituacionDesde" name="fechaSituacionDesde" path="fechaSituacionDesde" 
		                       		alt='${msg["page.persona.form.fechaSituacionDesde.title"]}' 
		                       		title='${msg["page.persona.form.fechaSituacionDesde.title"]}'></form:input>    
		                      </label> 
		                      
		                  	  <label class="linea-medio linea-dos">
		               	  		<span class="label_col2"><spring:message code="page.persona.form.fechaSituacionHasta.label"/></span>
		                     	<form:input type="text" id="fechaSituacionHasta" name="fechaSituacionHasta" path="fechaSituacionHasta" 
		                       	alt='${msg["page.persona.form.fechaSituacionHasta.title"]}' 
		                       	title='${msg["page.persona.form.fechaSituacionHasta.title"]}'></form:input>    
		                      </label>  
		                      
		                      <label class="linea-medio">
		               	  		<span class="label_col1"><spring:message code="page.persona.form.causaProhibicion.label"/></span>
		               	  		<form:select id="idCausaProhibicion" path="idCausaProhibicion" title='${msg["page.persona.form.causaProhibicion.title"]}'>
									<form:option value="" label=""></form:option>
									<form:options items="${causasProhibicionList}" itemValue="code" itemLabel="description" />                       		
		           				</form:select>  
		                      </label> 

		                  	  <label class="linea-medio">
		               	  		<span class="label_col1"><spring:message code="page.persona.form.durAnos.label"/></span>
		                     	<form:input type="text" id="durAnos" name="durAnos" path="durAnos" maxlength="2"
		                       	alt='${msg["page.persona.form.durAnos.title"]}' 
		                       	title='${msg["page.persona.form.durAnos.title"]}'></form:input>    
		                      </label>
		                      		                      
		                      <label class="linea-medio linea-dos">
		               	  		<span class="label_col2"><spring:message code="page.persona.form.durMeses.label"/></span>
		                     	<form:input type="text" id="durMeses" name="durMeses" path="durMeses" maxlength="2"
		                       		alt='${msg["page.persona.form.durMeses.title"]}' 
		                       		title='${msg["page.persona.form.durMeses.title"]}'></form:input>    
		                      </label> 
		                      

		                                       
		                      <label class="linea-medio">
		               	  		<span class="label_col1"><spring:message code="page.persona.form.observacionesProhibicion.label"/></span>
		                     	<form:input type="text" id="obsProhibicion" name="obsProhibicion" path="obsProhibicion" class="campoLargo" maxlength="255"
		                       	alt='${msg["page.persona.form.observacionesProhibicion.title"]}' 
		                       	title='${msg["page.persona.form.observacionesProhibicion.title"]}'></form:input>    
		                      </label> 
		                       
					     </fieldset>
					  </div>
                                                              
                      <div class="listado-acciones-centrado">
                        <input type="button" id="closeFiltrosExtra" alt='${msg["page.persona.button.closeFiltrosExtra"]}' title='${msg["page.persona.button.closeFiltrosExtra"]}' value='${msg["page.persona.button.closeFiltrosExtra"]}' class="medio"
                          onclick="closeFExtra()"/>
                        <input type="button" id="openFiltrosExtra" alt='${msg["page.persona.button.openFiltrosExtra"]}' title='${msg["page.persona.button.openFiltrosExtra"]}' value='${msg["page.persona.button.openFiltrosExtra"]}' class="medio"
                          onclick="openFExtra()"/>
                        <input type="button" id="closeBusquedaProhibicion" alt='${msg["page.persona.button.closeFiltrosProhibicion"]}' title='${msg["page.persona.button.closeFiltrosProhibicion"]}' value='${msg["page.persona.button.closeFiltrosProhibicion"]}' class="medio"
                          onclick="closeBProhibicion()"/>
                        <input type="button" id="openBusquedaProhibicion" alt='${msg["page.persona.button.openFiltrosProhibicion"]}' title='${msg["page.persona.button.openFiltrosProhibicion"]}' value='${msg["page.persona.button.openFiltrosProhibicion"]}' class="medio"
                          onclick="openBProhibicion()"/>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
                        <input type="button" id="clear" alt='${msg["page.persona.form.clear.title"]}' title='${msg["page.persona.form.clear.title"]}' value='${msg["page.persona.form.clear.value"]}' class="medio"
                          onclick="doReset()"/>
                        <input type="button" id="filter" alt='${msg["page.persona.form.filter.title"]}' title='${msg["page.persona.form.filter.title"]}' value='${msg["page.persona.form.filter.value"]}' class="medio" 
                          onclick="prepareFilter();doFilter()"/>
                      </div>
                  </fieldset>
                        
	            <!-- MÓDULO DE PESTAÑAS -->
	            <fieldset>
		            <div class="mod-pestanas modulo">
		              <!-- BEGIN ACTIONS TOOLBAR -->
		              <div class="listado-acciones-derecha">
		              
	                    	<a id="viewPersona" title='${msg["page.persona.actions.view.title"]}'  
		                          class="medio" onclick="doView()"><spring:message code="page.persona.actions.view.label"/></a>   
						
 							<select id="viewExportId" name="exportType" title='<spring:message code="page.persona.actions.exportpdf.title"/>' class="export" onchange="doExport()">
                          		<option value="Exportar"><spring:message code="page.persona.actions.exportpdf.title"/></option>
                           		<!-- <option value="XLS">Excel</option> -->
                           		<option value="PDF">PDF</option>
                           		<option value="DOCX">DOC</option>
                        	</select>	                           			
	                   
                      </div>
		              <!-- END ACTIONS TOOLBAR -->
		                
		              <!-- TABLA DE RESULTADOS -->
		              <table summary="My pending approvals" class="tabla propiedadCSS3">
                          <tr>
                            <td>
                              <div id="animacionCarga" style="display:none;"></div>
                              <div id="myPendingGridId" style="width: 875px; height: 217px;">
                      			<!-- ListGrid my pending -->
                              </div>

                            </td>
                          </tr>
                          <tr>
                            <td>
                              <div id="myPendingPaginatorId" style="width: 875px; height: 20px;">
                                <!-- Paginator my pending -->
                              </div>
                            </td>
                          </tr>
                        </table>
		              <div id="numRegistrosTotales"></div> 
		            </div>
		        </fieldset>
	            <!-- FIN DE MÓDULO PESTAÑAS -->   

              </form:form>
              <!-- END SEARCH FORM FILTER -->

	         </div>     
	         