<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="form-ext" uri="http://www.springframework.org/tags/form-ext" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<script type="text/javascript">

var contextPath = '${pageContext.request.contextPath}';

function doReset() {
	document.getElementById("saveForm").reset();
	location.href = contextPath + "/app/persona/startPersona";
}

function doExport() {
	var queryString = $('#saveForm').formSerialize();
	location.href = contextPath + "/app/persona/exportPersona?" + queryString ;
	document.getElementById("viewExportId").value = "Exportar";
}

function doEtiqueta() {
	var queryString = $('#saveForm').formSerialize();
	location.href = contextPath + "/app/persona/etiquetaPersona?" + queryString ;
}

///////////////////////////////////////////////////////////////////////////////
//Grid de prohibiciones

var prohibicionesGrid;
var selectedProhibicionId = "";

function initProhibiciones() {
	var grid = new Listgrid('prohibicionesId');
	grid.addCol({header:'<spring:message code="page.persona.form.tipoProhibicion.label" />', width:150});
	grid.addCol({header:'<spring:message code="page.persona.form.tipoInscripcion.label" />', width:150});
	grid.addCol({header:'<spring:message code="page.persona.form.fechaProhibicion.label" />',width:104});	
	grid.addCol({header:'<spring:message code="page.persona.form.situacion.label" />', width:90});
	grid.addCol({header:'<spring:message code="page.persona.form.fechaSituacion.label" />',width:100});	
	grid.addCol({header:'<spring:message code="page.persona.form.fechaUltimaModificacion.label" />', width:140});
	grid.addCol({header:'<spring:message code="page.persona.form.modificadoPor.label" />', width:99});
	grid.addCol({header:'', width:100});
	grid.addCol({header:'', width:100});
	grid.addCol({header:'', width:100});
	grid.addCol({header:'', width:100});
	grid.addCol({header:'', width:100});
	grid.addCol({header:'', width:100});
	grid.addCol({header:'', width:100});
	grid.addCol({header:'', width:100});
	grid.addCol({header:'', width:100});

	prohibicionesGrid = grid.createGrid();
	prohibicionesGrid.hdr.style.height = "40px";
	prohibicionesGrid.setImagePath(contextPath + "/static/js/codebase/imgs/");
	prohibicionesGrid.setSkin("evr");
	prohibicionesGrid.attachEvent("onSelectStateChanged", doOnSelectStateChangedProhibicion);
	prohibicionesGrid.setEditable(false); 
	prohibicionesGrid.enableMultiselect(false);
	prohibicionesGrid.init();

	//Ocultando columna 3 (se inicia a la cuenta desde 0);
	prohibicionesGrid.setColumnHidden(7,true);
	prohibicionesGrid.setColumnHidden(8,true);
	prohibicionesGrid.setColumnHidden(9,true);
	prohibicionesGrid.setColumnHidden(10,true);
	prohibicionesGrid.setColumnHidden(11,true);
	prohibicionesGrid.setColumnHidden(12,true);
	prohibicionesGrid.setColumnHidden(13,true);
	prohibicionesGrid.setColumnHidden(14,true);
	prohibicionesGrid.setColumnHidden(15,true);
}

function doOnSelectStateChangedProhibicion(rowID) {
	selectedProhibicionId = rowID;
}

function writeResponseProhibicion(responseText) {
	if (responseText.substring(0,5) == "ERROR" ) {
		alert (responseText.substring(5));
		return;
	} else if (!processResponse(responseText)) {
	    return;
	}

	addGridRows(prohibicionesGrid, responseText, null);

	limpiarFormularioProhibicion();
	ocultarVerProhibicion();	 
}

function limpiarFormularioProhibicion(){
	document.getElementById("fechaProhibicion").value = "";
	document.getElementById("tipoProhibicion").value = "";
	document.getElementById("situacion").value = "";
}

function rellenarFormularioProhibicion(){
	var registro = prohibicionesGrid.getRowById(selectedProhibicionId);
		
	/* Rellenar campos con los valores adecuados */
	document.getElementById("tipoProhibicion").value = registro.cells[0].innerHTML.ltrim();
	document.getElementById("tipoInscripcion").value = registro.cells[1].innerHTML.ltrim();
	document.getElementById("fechaProhibicion").value = registro.cells[2].innerHTML.ltrim();
	document.getElementById("situacion").value = registro.cells[3].innerHTML.ltrim();
	document.getElementById("fechaSituacion").value = registro.cells[4].innerHTML.ltrim();
	document.getElementById("lastUpdate").value = registro.cells[5].innerHTML.ltrim();
	document.getElementById("modifiedBy").value = registro.cells[6].innerHTML.ltrim();

	document.getElementById("causaProhibicion").value = registro.cells[7].innerHTML.ltrim();
	document.getElementById("fechaCarencia").value = registro.cells[8].innerHTML.ltrim();
	document.getElementById("fechaRegistro").value = registro.cells[9].innerHTML.ltrim();
	document.getElementById("durAnos").value = registro.cells[10].innerHTML.ltrim();
	document.getElementById("durMeses").value = registro.cells[11].innerHTML.ltrim();
	document.getElementById("observacionesProhibicion").value = registro.cells[12].innerHTML.ltrim();
	document.getElementById("idSentencia").value = registro.cells[13].innerHTML.ltrim();
	document.getElementById("organoJudicial").value = registro.cells[14].innerHTML.ltrim();
	document.getElementById("fechaSentencia").value = registro.cells[15].innerHTML.ltrim();
}

function mostrarVerProhibicion(){
	capaNuevoProhibicion =document.getElementById("viewProhibicion");
	capaNuevoProhibicion.style.display = "";
}


function ocultarVerProhibicion(){
	capaNuevoProhibicion =document.getElementById("viewProhibicion");
	capaNuevoProhibicion.style.display = "none";
}

function openViewProhibicion(){
	if (selectedProhibicionId == "") {
		alert('<spring:message code="page.persona.alert.selectProhibicion"/>');
		return;
	}

	limpiarFormularioProhibicion();
	rellenarFormularioProhibicion();
	mostrarVerProhibicion();
}

function cancelViewProhibicion(){
	limpiarFormularioProhibicion();
	ocultarVerProhibicion();
}



onload = function() {
	initProhibiciones();

	var strDetalleProhibiciones = document.getElementById("detalleProhibiciones").value;
	if (strDetalleProhibiciones!=""){
		writeResponseProhibicion(strDetalleProhibiciones);
	}

};

String.prototype.ltrim = function() {
	return this.replace(/^\s+/,"").replace(/&nbsp;/g,"");
}
</script>

 <div id="formulcuad">  
              <!-- BEGIN SEARCH FORM FILTER -->
              <form:form id="saveForm" action="${pageContext.request.contextPath}/app/persona/startPersona"
              	modelAttribute="${modelAttribute}">
                    
                    <!-- BREADCRUM    -->
					<div class="breadcrumb">
					  <span class="left"></span>
					  <ul class="breadcrumb">
						<li><a href="${pageContext.request.contextPath}"><spring:message code="page.breadcrumb.home"/></a></li>
					    <li><a href="${pageContext.request.contextPath}/app/persona/startPersona"><spring:message code="page.breadcrumb.persona"/></a></li>
					    <li><a href="#" class="active"><spring:message code="page.persona.li.view.title"/></a></li>
					  </ul>
					  <span class="right"></span>
					</div>
					<!-- FIN BREADCRUM -->

					<div class="listado">
						<div class="encabezado">
				  			<label for="usuario">  					
								<span class="label">
				 					<spring:message code="page.breadcrumb.viewPersona"/>										
								</span>
				 			</label>  								
						</div>		
					</div>

                  	<fieldset>

                      <label class="linea-medio">
               	  		<span class="label_col1"><spring:message code="page.persona.form.expedProhibicion.label"/></span>
                     	<form:input type="text" id="expedProhibicion" name="expedProhibicion" path="expedProhibicion" readonly="true"
                       	alt='${msg["page.persona.form.expedProhibicion.title"]}' 
                       	title='${msg["page.persona.form.expedProhibicion.title"]}'></form:input>    
                       	<form:hidden id="idPersona" path="idPersona"></form:hidden>  
                       	<form:hidden id="detalleProhibiciones" path="detalleProhibiciones"></form:hidden>
                        <form:hidden id="error" path="error"></form:hidden>  
                      </label>

                      <label for="tipoDocIdent" class="linea-medio">
               	  		<span class="label_col1 "><spring:message code="page.persona.form.tipoDocIdent.label"/></span>
           				<form:input type="text" id="desTipoDocIdent" name="desTipoDocIdent" path="desTipoDocIdent" readonly="true"
                       	alt='${msg["page.persona.form.tipoDocIdent.title"]}' 
                       	title='${msg["page.persona.form.tipoDocIdent.title"]}'></form:input>   
                      </label>                      

                  	  <label class="linea-medio linea-dos">
               	  		<span class="label_col2"><spring:message code="page.persona.form.numDocIdent.label"/></span>
                     	<form:input type="text" id="numDocIdent" name="numDocIdent" path="numDocIdent" readonly="true"
                       	alt='${msg["page.persona.form.numDocIdent.title"]}' 
                       	title='${msg["page.persona.form.numDocIdent.title"]}'></form:input>    
                      </label>
                      
					  <label class="linea-medio">
               	  		<span class="label_col1"><spring:message code="page.persona.form.nombre.label"/></span>
                     	<form:input type="text" id="nombre" name="nombre" path="nombre" readonly="true"
                       	alt='${msg["page.persona.form.nombre.title"]}' 
                       	title='${msg["page.persona.form.nombre.title"]}'></form:input>    
                      </label>      
                                      
                  	  <label class="linea-medio">
               	  		<span class="label_col1"><spring:message code="page.persona.form.apellido1.label"/></span>
                     	<form:input type="text" id="apellido1" name="apellido1" path="apellido1" readonly="true"
                       	alt='${msg["page.persona.form.apellido1.title"]}' 
                       	title='${msg["page.persona.form.apellido1.title"]}'></form:input>    
                      </label> 
                      
                  	  <label class="linea-medio linea-dos">
               	  		<span class="label_col2"><spring:message code="page.persona.form.apellido2.label"/></span>
                     	<form:input type="text" id="apellido2" name="apellido2" path="apellido2" readonly="true"
                       	alt='${msg["page.persona.form.apellido2.title"]}' 
                       	title='${msg["page.persona.form.apellido2.title"]}'></form:input>    
                      </label>   
                    		  
				     <label class="linea-medio">
               	  		<span class="label_col1"><spring:message code="page.persona.form.sexo.label"/></span>
                     	<form:input type="text" id="sexo" name="sexo" path="sexo" readonly="true"
                       	alt='${msg["page.persona.form.sexo.title"]}' 
                       	title='${msg["page.persona.form.sexo.title"]}'></form:input>    
                      </label> 
                      
                  	  <label class="linea-medio linea-dos">
               	  		<span class="label_col2"><spring:message code="page.persona.form.telefono.label"/></span>
                     	<form:input type="text" id="telefono" name="telefono" path="telefono" readonly="true"
                       	alt='${msg["page.persona.form.telefono.title"]}' 
                       	title='${msg["page.persona.form.telefono.title"]}'></form:input>    
                      </label>   
                      
                      <label class="linea-medio">
               	  		<span class="label_col1"><spring:message code="page.persona.form.fechaNacimiento.label"/></span>
                     	<form:input type="text" id="fechaNacimiento" name="fechaNacimiento" path="fechaNacimiento" readonly="true"
                       	alt='${msg["page.persona.form.fechaNacimiento.title"]}' 
                       	title='${msg["page.persona.form.fechaNacimiento.title"]}'></form:input>    
                      </label> 
                      
                      <label class="linea-medio">
               	  		<span class="label_col1"><spring:message code="page.persona.form.provincia.label"/></span>
               	  		<form:input type="text" id="desProvincia" name="desProvincia" path="desProvincia" readonly="true"
                       	alt='${msg["page.persona.form.provincia.title"]}' 
                       	title='${msg["page.persona.form.provincia.title"]}'></form:input>    
         			  </label>	               	  		
                     
                      <label class="linea-medio linea-dos">
               	  		<span class="label_col2"><spring:message code="page.persona.form.comunidadAutonoma.label"/></span>
               	  		<form:input type="text" id="desComunidad" name="desComunidad" path="desComunidad" readonly="true"
                       	alt='${msg["page.persona.form.comunidadAutonoma.title"]}' 
                       	title='${msg["page.persona.form.comunidadAutonoma.title"]}'></form:input>    		                       	
                      </label>
                      
                      <label class="linea-medio">
               	  		<span class="label_col1"><spring:message code="page.persona.form.codPostal.label"/></span>
                     	<form:input type="text" id="codPostal" name="codPostal" path="codPostal" readonly="true"
                       	alt='${msg["page.persona.form.codPostal.title"]}' 
                       	title='${msg["page.persona.form.codPostal.title"]}'></form:input>    
                      </label> 
                      
                      <label class="linea-medio">
               	  		<span class="label_col1"><spring:message code="page.persona.form.domicilio.label"/></span>
                     	<form:input type="text" id="domicilio" name="domicilio" path="domicilio" class="campoLargo" readonly="true"
                       	alt='${msg["page.persona.form.domicilio.title"]}' 
                       	title='${msg["page.persona.form.domicilio.title"]}'></form:input>    
                      </label> 
                           
                      <label class="linea-medio">
               	  		<span class="label_col1"><spring:message code="page.persona.form.observaciones.label"/></span>
                       	<form:textarea readonly="true" id="observaciones" name="observaciones" path="observaciones"
                       		class="areatextogrande"
                       		title='${msg["page.persona.form.observaciones.title"]}'></form:textarea>
                      </label> 
		                       
			                  <div class="listado-acciones-derecha exportar-persona">
 									<select id="viewExportId" name="exportType" title='<spring:message code="page.persona.actions.exportpdf.title"/>' class="export" onchange="doExport()">
                          					<option value="Exportar"><spring:message code="page.persona.actions.exportpdf.title"/></option>
                           					<!-- <option value="XLS">Excel</option> -->
                           					<option value="PDF">PDF</option>
                           					<option value="DOCX">DOC</option>
                        			</select>	 
                        			<sec:authorize ifAllGranted="ETIQUETAS_LISTADO">        
               						<a id="etiqueta" href="javascript:doEtiqueta()"
									   title='${msg["page.persona.button.etiqueta.title"]}'
									   class="medio">
										<spring:message code="page.persona.button.etiqueta.label" />
									</a>    
									</sec:authorize>
	                    	  </div>
                      <br/>
					  <fieldset>        
					  	<legend><spring:message code="page.persona.header.moreInformation"/></legend>              
	                      <!-- MÓDULO DE PESTAÑAS -->
			              <div class="mod-pestanas modulo">
			                  <ul class="pestanas">
			                    <li class="item_tab seleccionado">
			                      <span>
			                          <a href="javascript:void(0);" class="lnk_mod_tabs act" 
			                            title='${msg["page.persona.tab.prohibiciones.title"]}'><spring:message code="page.persona.tab.prohibiciones.label"/></a>
			                      </span>
			                    </li>
			                    			                    
			                  </ul>
	                     
			                  <!-- MÓDULO CON PESTAÑAS -->
						      <div class="tabs">
									<ul>
										<li class="tab">
											<div class="listado-acciones-derecha acciones-tab">
												<a	id="viewProhibicionId" href="javascript:openViewProhibicion()"
													title='${msg["page.persona.prohibicion.li.view.title"]}'
													class="medio"><spring:message code="page.persona.prohibicion.li.view.label" /></a> 
											</div>
																					
											<div id="prohibicionesId" style="width: 850px; height: 180px;">
												<!-- ListGrid prohibiciones -->
											</div>
			
											<div id="viewProhibicion" style="display: none;" class="capaOperacionTab">
												<fieldset>
													<label  class="linea-medio"> 
														<span class="label_col1b"><spring:message code="page.persona.form.tipoProhibicion.label" /></span>
														<input id="tipoProhibicion" type="text" class="campoMedio" readonly="true" maxlength="255" title='${msg["page.persona.form.tipoProhibicion.title"]}'></input>
													</label>
													<label  class="linea-medio"> 
														<span class="label_col1b"><spring:message code="page.persona.form.tipoInscripcion.label" /></span>
														<input id="tipoInscripcion" type="text" class="campoMedio" readonly="true" maxlength="255" title='${msg["page.persona.form.tipoInscripcion.title"]}' ></input>
													</label>

													<label class="linea-medio"> 
														<span class="label_col1b"><spring:message code="page.persona.form.causaProhibicion.label" /></span>
														<input id="causaProhibicion" type="text" readonly="true" maxlength="255" title='${msg["page.persona.form.causaProhibicion.title"]}' ></input>
													</label> 
													<label  class="linea-medio linea-dos"> 
														<span class="label_col2b"><spring:message code="page.persona.form.fechaProhibicion.label" /></span>
														<input id="fechaProhibicion" type="text" readonly="true" maxlength="255" title='${msg["page.persona.form.fechaProhibicion.title"]}'></input>
													</label>
													<label class="linea-medio"> 
														<span class="label_col1b"><spring:message code="page.persona.form.situacion.label" /></span>
														<input id="situacion" type="text"  readonly="true" maxlength="255" title='${msg["page.persona.form.situacion.title"]}'></input>
													</label>
													<label class="linea-medio linea-dos"> 
														<span class="label_col2b"><spring:message code="page.persona.form.fechaSituacion.label" /></span>
														<input id="fechaSituacion" type="text" readonly="true" maxlength="255" title='${msg["page.persona.form.fechaSituacion.title"]}'></input>
													</label>

													<label class="linea-medio"> 
														<span class="label_col1b"><spring:message code="page.persona.form.fechaUltimaModificacion.label" /></span>
														<input id="lastUpdate" type="text"  readonly="true" maxlength="255" title='${msg["page.persona.form.fechaUltimaModificacion.title"]}'></input>
													</label>
													<label class="linea-medio linea-dos"> 
														<span class="label_col2b"><spring:message code="page.persona.form.modificadoPor.label" /></span>
														<input id="modifiedBy" type="text" readonly="true" maxlength="255" title='${msg["page.persona.form.modificadoPor.title"]}'></input>
													</label>
													
													<label class="linea-medio"> 
														<span class="label_col1b"><spring:message code="page.persona.form.fechaCarencia.label" /></span>
														<input id="fechaCarencia" type="text"  readonly="true" maxlength="255" title='${msg["page.persona.form.fechaCarencia.title"]}'></input>
													</label>
													<label class="linea-medio linea-dos"> 
														<span class="label_col2b"><spring:message code="page.persona.form.fechaRegistro.label" /></span>
														<input id="fechaRegistro" type="text" readonly="true" maxlength="255" title='${msg["page.persona.form.fechaRegistro.title"]}'></input>
													</label>
																										
													<label class="linea-medio"> 
														<span class="label_col1b"><spring:message code="page.persona.form.durAnos.label" /></span>
														<input id="durAnos" type="text"  readonly="true" maxlength="255" title='${msg["page.persona.form.durAnos.title"]}'></input>
													</label>
													<label class="linea-medio linea-dos"> 
														<span class="label_col2b"><spring:message code="page.persona.form.durMeses.label" /></span>
														<input id="durMeses" type="text" readonly="true" maxlength="255" title='${msg["page.persona.form.durMeses.title"]}'></input>
													</label>

													<label class="linea-medio"> 
														<span class="label_col1b"><spring:message code="page.persona.form.idSentencia.label" /></span>
														<input id="idSentencia" type="text"  readonly="true" maxlength="255" title='${msg["page.persona.form.idSentencia.title"]}'></input>
													</label>

													<label class="linea-medio linea-dos"> 
														<span class="label_col2b"><spring:message code="page.persona.form.fechaSentencia.label" /></span>
														<input id="fechaSentencia" type="text" readonly="true" maxlength="255" title='${msg["page.persona.form.fechaSentencia.title"]}'></input>
													</label>

													<label class="linea-medio"> 
														<span class="label_col1b"><spring:message code="page.persona.form.organoJudicial.label" /></span>
														<input id="organoJudicial" type="text"  readonly="true" maxlength="255" title='${msg["page.persona.form.organoJudicial.title"]}'></input>
													</label>
													
								                    <label class="linea-medio">
								               	  		<span class="label_col1b"><spring:message code="page.persona.form.observaciones.label"/></span>
								                       	<textarea readonly="true" id="observacionesProhibicion" class="areatexto"
								                       		title='${msg["page.persona.form.observaciones.title"]}'></textarea>
								                    </label>
													
													<div class="listado-acciones-derecha"
														id="viewProhibicionButtons">
														<a id="cancelProhibicion" href="javascript:cancelViewProhibicion()"
															title='${msg["page.persona.form.close.title"]}'
															class="medio">
															<spring:message code="page.persona.form.close.label" /></a>
													</div>
												</fieldset>
											</div>
			

										</li>
									</ul>
								</div>
                      		</div>
                      </fieldset>
					  <div class="listado-acciones-centrado">
                        <input type="button" id="cancel" 
                          alt='${msg["page.common.button.back"]}' 
                          title='${msg["page.common.button.back"]}' 
                          value='${msg["page.common.button.back"]}' 
                          class="medio"
                          onclick="doReset()"/>
                      	
                      </div>
                  </fieldset>
               </form:form>
              <!--  END SEARCH FORM FILTER -->
           </div>