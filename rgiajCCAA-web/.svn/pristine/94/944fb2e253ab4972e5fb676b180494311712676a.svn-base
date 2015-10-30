<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="form-ext" uri="http://www.springframework.org/tags/form-ext" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<script type="text/javascript">
var contextPath = '${pageContext.request.contextPath}';
var buscar = '${volverJugador}';


function prepareFilter() {
  	processRequest();
 }

function doFilter() {
	var dni = document.getElementById("dni").value;
	
	if (dni==""){
    	alert('<spring:message code="page.consultaSVDI.alert.mandatory" />');
	    return;
	}
	

	if (validaDNI(dni)<=0){
    	alert('<spring:message code="page.consultaSVDI.alert.formatDni" />');
	    return;
	}

  	doFilterPending();
}

function doFilterPending() {
	muestraCarga();
  	var optionsPending = { 
          beforeSubmit: prepareRequestPending,
          success: writeResponseConsulta
  	}; 

  	$('#searchForm').ajaxSubmit(optionsPending);
}

function writeResponsePending(responseText, statusText, xhr, $form) {
	ocultaCarga();
	
  	if (!processResponse(responseText)) {
      	return;
  	}
}

function doReset() {
  	limpiaFormulario(document.getElementById("searchForm"));
	document.getElementById("dniSVDI").value = "";
	document.getElementById("nombreSVDI").value = "";
	document.getElementById("apellido1SVDI").value = "";
	document.getElementById("apellido2SVDI").value = "";
	document.getElementById("fechaNacimientoSVDI").value = "";
	document.getElementById("resultadoSVDI").value = "";
  	$.ajax({
	    type: "POST",
	    cache: false,
	    url: contextPath + "/app/jugadorOperador/limpiarBusquedaConsulta"
	});
}

onload = function() {
};

String.prototype.ltrim = function() {
	return this.replace(/^\s+/,"").replace(/&nbsp;/g,"");
}

function prepareRequestPending(formData, jqForm, options) { 
	  return true; 
}

function writeResponseConsulta(responseText, statusText, xhr, $form) {
	ocultaCarga();
	
	if (responseText.indexOf("Error")>=0){
		closeConsultaSVDI();
		alert (responseText);
	} else {
		var campos = responseText.split ("#");
		document.getElementById("dniSVDI").value = campos[0];
		document.getElementById("nombreSVDI").value = campos[1];
		document.getElementById("apellido1SVDI").value = campos[2];
		document.getElementById("apellido2SVDI").value = campos[3];
		document.getElementById("fechaNacimientoSVDI").value = campos[4];
		document.getElementById("resultadoSVDI").value = campos[5];

		capaConsultaSVDI =document.getElementById("resultadoConsultaSVDI");
		capaConsultaSVDI.style.display = "";
	} 
	
		
}

</script>

          <div id="formulcuad">  
              <!-- BEGIN SEARCH FORM FILTER -->
              <form:form id="searchForm" action="${pageContext.request.contextPath}/app/consultaSVDI/searchConsultaSVDI"
                    modelAttribute="${modelAttribute}" >
                    
                    <!-- BREADCRUM    -->
					<div class="breadcrumb">
					  <span class="left"></span>
					  <ul class="breadcrumb">
					    <li><a href="${pageContext.request.contextPath}"><spring:message code="page.breadcrumb.home"/></a></li>
					    <li><a href="#"><spring:message code="page.breadcrumb.consultas"/></a></li>
					    <li><a href="${pageContext.request.contextPath}/app/consultaSVDI/startConsultaSVDI" class="active"><spring:message code="page.breadcrumb.consultaSVDI"/></a></li>
					  </ul>
					  <span class="right"></span>
					</div>
					<!-- FIN BREADCRUM -->

					<div class="listado">
						<div class="encabezado">
				  			<label for="usuario">  					
								<span class="label">
				 					<spring:message code="page.breadcrumb.consultaSVDI"/>										
								</span>
				 			</label>  								
						</div>		
					</div>
 
                  	<fieldset>
                  		
                      <legend><spring:message code="page.consultaSVDI.header.filter"/></legend>

                  	  <label class="linea-medio">
               	  		<span class="label_col1"><spring:message code="page.consultaSVDI.form.dni.label"/></span>
                     	<form:input type="text" id="dni" name="dni" path="dni" 
                       	alt='${msg["page.consultaSVDI.form.dni.title"]}' 
                       	title='${msg["page.consultaSVDI.form.dni.title"]}'></form:input>    
                      </label>

                      <div class="listado-acciones-centrado">
                        <input type="button" id="clear" 
                          alt='${msg["page.consultaSVDI.form.clear.title"]}' 
                          title='${msg["page.consultaSVDI.form.clear.title"]}' 
                          value='${msg["page.consultaSVDI.form.clear.value"]}' 
                          class="medio"
                          onclick="doReset()"/>
                        <input type="button" id="filter" 
                          alt='${msg["page.consultaSVDI.form.filter.title"]}' 
                          title='${msg["page.consultaSVDI.form.filter.title"]}' 
                          value='${msg["page.consultaSVDI.form.filter.value"]}' 
                          class="medio" 
                          onclick="prepareFilter();doFilter()"/>
                      </div>
                  </fieldset>
              </form:form>
              <!-- END SEARCH FORM FILTER -->
           
           
                        
	            <!-- MÓDULO DE PESTAÑAS -->
	            <fieldset>
		            <div class="mod-pestanas modulo">
		                                
		              <!-- END ACTIONS TOOLBAR -->
		              <div id="animacionCarga" style="display:none;"></div>
		     		  <div id="resultadoConsultaSVDI" class="_capaOperacionTab">
							 <label class="linea-medio">
		               	  		<span class="label_col1"><spring:message code="page.consultaSVDI.resultado.label.dni"/></span>
		                     	<input type="text" id="dniSVDI" name="dniSVDI" disabled="disabled"
		                       	alt='${msg["page.consultaSVDI.resultado.title.dni"]}' 
		                       	title='${msg["page.consultaSVDI.resultado.title.dni"]}'></input>    
		                      </label>
		                      
		                  	  <label class="linea-medio ">                      
		               	  		<span class="label_col1"><spring:message code="page.consultaSVDI.resultado.label.nombre"/></span>
		                     	<input type="text" id="nombreSVDI" name="nombreSVDI"  class="campoMedio" disabled="disabled"
		                       	alt='${msg["page.consultaSVDI.resultado.title.nombre"]}' 
		                       	title='${msg["page.consultaSVDI.resultado.title.nombre"]}'></input>  
		                      </label>
		                      
		                      <label  class="linea-medio">
		               	  		<span class="label_col1"><spring:message code="page.consultaSVDI.resultado.label.apellido1"/></span>
		                     	<input type="text" id="apellido1SVDI" name="apellido1SVDI" class="campoMedio" disabled="disabled"
		                       	alt='${msg["page.consultaSVDI.resultado.title.apellido1"]}' 
		                       	title='${msg["page.consultaSVDI.resultado.title.apellido1"]}'></input>   
		                      </label>
		                      
		                  	  <label class="linea-medio ">
		               	  		<span class="label_col1"><spring:message code="page.consultaSVDI.resultado.label.apellido2"/></span>
		                     	<input type="text" id="apellido2SVDI" name="apellido2SVDI" class="campoMedio" disabled="disabled"
		                       	alt='${msg["page.consultaSVDI.resultado.title.apellido2"]}' 
		                       	title='${msg["page.consultaSVDI.resultado.title.apellido2"]}'></input>   
		                      </label>
		                      
		                      <label for="fechaNacimiento" class="linea-medio"> 
		                      	<span class="label_col1"><spring:message code="page.consultaSVDI.resultado.label.fechaNacimiento"/></span>
		                         <input id="fechaNacimientoSVDI" disabled="disabled"
		                            alt='${msg["page.consultaSVDI.resultado.title.fechaNacimiento"]}' 
		                            title='${msg["page.consultaSVDI.resultado.title.fechaNacimiento"]}'></input>
		                      </label>
		                      
		                      <label  class="linea-medio">
		               	  		<span class="label_col1"><spring:message code="page.consultaSVDI.resultado.label.resultado"/></span>
		                     	<textarea id="resultadoSVDI" class="areatexto" disabled="disabled" title='${msg["page.consultaSVDI.resultado.title.resultado"]}' rows="4"></textarea>                      		
		                      </label>
		                      
					  </div>
				  </div>
		        </fieldset>
	            <!-- FIN DE MÓDULO PESTAÑAS -->   
	         </div>     
