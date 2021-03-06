<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="form-ext" uri="http://www.springframework.org/tags/form-ext" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<script type="text/javascript">
var arrayList = ["id","codigo","decripcion","activo"];
var contextPath = '${pageContext.request.contextPath}';

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
      fieldName:arrayList[0],
      fieldColum:0,
      order:'<spring:message code="page.common.paginator.order"/>'
  });
  
  pendingPaginator.onchange=doFilterPending;
  
}

function doOnSelectStateChangedPending(rowID) {
	selectedComunidadAutonomaId = rowID;
  	updateLinks();
}

function doOnbeforeSorting(ind,type,direction) {
	pendingPaginator.setSorting(arrayList[ind], direction, ind);
	doFilterPending();
}

///////////////////////////////////////////////////////////////////////////////
//common

function defineGrid(id) {
  var grid = new Listgrid(id);

  grid.addCol({header:'<spring:message code="page.comunidadAutonoma.grid.label.codigo" />', width:250, sorting:"str"});
  grid.addCol({header:'<spring:message code="page.comunidadAutonoma.grid.label.descripcion" />', width:539, sorting:"na"});
  grid.addCol({header:'<spring:message code="page.comunidadAutonoma.grid.label.activo" />', width:70, sorting:"na"});
  
  return grid;
}

var selectedComunidadAutonomaId = "";

function updateLinks() {
    
}

function prepareFilter() {
  	processRequest();
  	pendingPaginator.reset();
}

function doFilter() {

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
  	selectedComunidadAutonomaId = "";
  	updateLinks();
  	document.getElementById("numRegistrosTotales").innerHTML="";
  	$.ajax({
	    type: "POST",
	    cache: false,
	    url: contextPath + "/app/comunidadAutonoma/limpiarBusqueda"
	});
}

function doEdit() {
	  if (selectedComunidadAutonomaId == "") {
	    alert('<spring:message code="page.comunidadAutonoma.alert.selectRegistro" />');
	    return;
	  }

	  document.getElementById("editComunidadAutonoma").href = contextPath + "/app/comunidadAutonoma/startEditComunidadAutonoma?id=" + selectedComunidadAutonomaId;
	  document.getElementById("editComunidadAutonoma").click();
}

function doDelete() {
	if (selectedComunidadAutonomaId == "") {
		  alert('<spring:message code="page.comunidadAutonoma.alert.selectRegistro"/>');
		  return;
	}
	
	if (!confirm('<spring:message code="page.comunidadAutonoma.confirm.deleteRegistro"/>')) {
	  return;
	}

	 $.ajax({
		    type: "POST",
		    cache: false,
		    url: contextPath + "/app/comunidadAutonoma/deleteComunidadAutonoma",
		    data: "id=" + selectedComunidadAutonomaId,
		    success: function(msg){
		    	doFilterPending();
		    	if (msg.substring(0,5) == "ERROR" ) {
		    		alert (msg.substring(5));
		    		return;
		    	}
		    }
		  });
}

onload = function() {
	initPending();

	//lanza la consulta al entrar en la p�gina
    doFilter();
};

String.prototype.ltrim = function() {
	return this.replace(/^\s+/,"").replace(/&nbsp;/g,"");
}

</script>

          <div id="formulcuad">  
              <!-- BEGIN SEARCH FORM FILTER -->
              <form:form id="searchForm" action="${pageContext.request.contextPath}/app/comunidadAutonoma/searchComunidadAutonoma"
                    modelAttribute="${modelAttribute}" >
                    
                    <!-- BREADCRUM    -->
					<div class="breadcrumb">
					  <span class="left"></span>
					  <ul class="breadcrumb">
					    <li><a href="${pageContext.request.contextPath}"><spring:message code="page.breadcrumb.home"/></a></li>
					    <li><a href="${pageContext.request.contextPath}/app/comunidadAutonoma/startComunidadAutonoma" class="active"><spring:message code="page.breadcrumb.comunidadAutonoma"/></a></li>
					  </ul>
					  <span class="right"></span>
					</div>
					<!-- FIN BREADCRUM -->

					<div class="listado">
						<div class="encabezado">
				  			<label for="usuario">  					
								<span class="label">
				 					<spring:message code="page.breadcrumb.comunidadAutonoma"/>										
								</span>
				 			</label>  								
						</div>		
					</div>
 
                  	<fieldset>
                  		
                      <legend><spring:message code="page.comunidadAutonoma.header.filter"/></legend>
                      
                  	  <label class="linea-medio">
               	  		<span class="label_col1"><spring:message code="page.comunidadAutonoma.form.codigo.label"/></span>
                     	<form:input type="text" id="codigo" name="codigo" path="codigo" 
                       	alt='${msg["page.comunidadAutonoma.form.codigo.title"]}' 
                       	title='${msg["page.comunidadAutonoma.form.codigo.title"]}'></form:input>    
                      </label>
                      
                      <div class="listado-acciones-centrado">
                        <input type="button" id="clear" 
                          alt='${msg["page.comunidadAutonoma.form.clear.title"]}' 
                          title='${msg["page.comunidadAutonoma.form.clear.title"]}' 
                          value='${msg["page.comunidadAutonoma.form.clear.value"]}' 
                          class="medio"
                          onclick="doReset()"/>
                        <input type="button" id="filter" 
                          alt='${msg["page.comunidadAutonoma.form.filter.title"]}' 
                          title='${msg["page.comunidadAutonoma.form.filter.title"]}' 
                          value='${msg["page.comunidadAutonoma.form.filter.value"]}' 
                          class="medio" 
                          onclick="prepareFilter();doFilter()"/>
                      </div>
                  </fieldset>
              </form:form>
              <!-- END SEARCH FORM FILTER -->
           
                        
	            <!-- M�DULO DE PESTA�AS -->
	            <fieldset>
		            <div class="mod-pestanas modulo">
		              <!-- BEGIN ACTIONS TOOLBAR -->
		              <div class="listado-acciones-derecha">
		              
			            <sec:authorize ifAllGranted="MANT-BAS_NUEVA">
		                    <a href="${pageContext.request.contextPath}/app/comunidadAutonoma/startNewComunidadAutonoma" 
				                      title='${msg["page.comunidadAutonoma.actions.new.title"]}' 
				                      class="medio"><spring:message code="page.comunidadAutonoma.actions.new.label"/></a>
						</sec:authorize>
				              
						<sec:authorize ifAllGranted="MANT-BAS_MODIFICAR">
		                    <a id="editComunidadAutonoma" title='${msg["page.comunidadAutonoma.actions.edit.title"]}'  
		                          class="medio" onclick="doEdit()"><spring:message code="page.comunidadAutonoma.actions.edit.label"/></a>   
						</sec:authorize>
						
						<sec:authorize ifAllGranted="MANT-BAS_BORRAR">	
			                <a id="deleteComunidadAutonoma" title='${msg["page.comunidadAutonoma.actions.delete.title"]}' 
	   	                       class="medio" onclick="doDelete()"><spring:message code="page.comunidadAutonoma.actions.delete.label"/></a>
	   	                </sec:authorize>
							          
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
	            <!-- FIN DE M�DULO PESTA�AS -->   
	         </div>     
