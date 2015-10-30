<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="form-ext" uri="http://www.springframework.org/tags/form-ext" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<script type="text/javascript">

var contextPath = '${pageContext.request.contextPath}';
var codComunidad =  '${beanSession.codComunidad}';
var arrayList = ["jugComunidad.descripcion","fechaDescarga", "completa", "confirmada", "ultimo"];
///////////////////////////////////////////////////////////////////////////////
//my pending

//ListGrid with my pending search results
var pendingGrid;

//Paginator control for my pending search results
var pendingPaginator;

var selectedParametroId = "";

function initPending() {

var grid = defineGrid('myHistoryGridId');

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
    fieldName:arrayList[1], 
    fieldColum:0,
    order:'<spring:message code="page.common.paginator.order"/>'
    });
pendingPaginator.onchange=doFilterPending;

}

function doOnSelectStateChangedPending(rowID) {
	selectedParametroId = rowID;
}

function doOnbeforeSorting(ind,type,direction) {
	pendingPaginator.setSorting(arrayList[ind], direction, ind);
	doFilterPending();
}

function doOnRowDblClicked(rowID) {

	
}

///////////////////////////////////////////////////////////////////////////////
//common

function defineGrid(id) {
  var grid = new Listgrid(id);
  
//   grid.addCol({header:'<spring:message code="page.historico.grid.label.idHistoricoDescarga" />', width:75, sorting:"na"});
  grid.addCol({header:'<spring:message code="page.historico.grid.label.comunidad" />', width:190, sorting:"na"});
  grid.addCol({header:'<spring:message code="page.historico.grid.label.fechaDescarga" />', width:230, sorting:"date"});
  grid.addCol({header:'<spring:message code="page.historico.grid.label.tipo" />', width:100, sorting:"na"});
  grid.addCol({header:'<spring:message code="page.historico.grid.label.confirmada" />', width:100, sorting:"na"});
  grid.addCol({header:'<spring:message code="page.historico.grid.label.ultimo" />', width:155, sorting:"int"});  
  grid.addCol({header:'<spring:message code="page.historico.grid.label.procedencia" />', width:100, sorting:"na"});

  return grid;
}

function doFilter() {
// 	alert("Code Comunidad: " + codComunidad);
	if (codComunidad==null || codComunidad==''){
// 		alert("Code Comunidad: " + codComunidad);
	    return;
    }

   if(invalidFechasFilter())
		return;
	
  	doFilterPending();
}

function invalidFechasFilter(){
	 var fechaDesde= document.getElementById('fechaDesde').value;
     var fechaHasta= document.getElementById('fechaHasta').value;

     if ((fechaDesde != "") && (!validaFechaDDMMAAAA(fechaDesde))){
 	    alert('La fecha desde del filtro es incorrecta');
 		return true;
 	} 
     if ((fechaHasta != "") && (!validaFechaDDMMAAAA(fechaHasta))){
  	    alert('La fecha hasta del filto es incorrecta');
  		return true;
  	} 

    if(fechaDesde!="" && fechaHasta!="") {
    	 if(!esFechaValida(fechaDesde,fechaHasta)){
    		alert('La fechas desde y hasta del filtro son incorrectas');
    		return true; 
    	 }
        }
	

	return false;
}

function doFilterPending() {
	muestraCarga();
  	var optionsPending = { 
          beforeSubmit:  prepareRequestPending,
          success: writeResponsePending
  	}; 

  	$('#historyForm').ajaxSubmit(optionsPending);
}

function prepareRequestPending(formData, jqForm, options) { 
  formData[formData.length] = { name: 'firstResult', value: pendingPaginator.firstResult };
  formData[formData.length] = { name: 'maxResults', value: pendingPaginator.maxResults };

  formData[formData.length] = { name: 'fieldName', value: pendingPaginator.fieldName };
  formData[formData.length] = { name: 'order', value: pendingPaginator.order };
  formData[formData.length] = { name: 'sortingFlag', value: pendingPaginator.sortingFlag };
  formData[formData.length] = { name: 'searchParam', value: 'MY_PENDING' };


  if(document.getElementById("comunidadSelected")){
	 var codComunidad= document.getElementById("comunidadSelected").value;
// 	  alert('Valor code: '+codComunidad );
	  if(codComunidad!=null && codComunidad!='')	 
		  formData[formData.length] = { name: 'codComunidad', value: codComunidad };
  }
	 var fechaDesde= document.getElementById('fechaDesde').value;
     var fechaHasta= document.getElementById('fechaHasta').value;
     if(fechaDesde!=null && fechaDesde!='')
    	 formData[formData.length] = { name: 'fechaDesde', value: fechaDesde };
     if(fechaHasta!=null && fechaHasta!='')
    	 formData[formData.length] = { name: 'fechaHasta', value: fechaHasta };


//      var isConfirm= document.getElementById('checkConfirmada').checked;
//      alert('checkConfirmada: ' + isConfirm);
     if(document.getElementById('checkConfirmada').checked==true)
           formData[formData.length] = { name: 'confirmada', value: true };
     if(document.getElementById('checkNoConfirmada').checked==true)
         formData[formData.length] = { name: 'confirmada', value: false };

     if(document.getElementById('procedenciaSelected').value!='')
         formData[formData.length] = { name: 'procedencia', value: document.getElementById('procedenciaSelected').value };
     
	
   
  
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

onload = function() {
	  initPending();
	 
	  //lanza la consulta al entrar en la página
	  doFilter();
	  initCalendars();
	};

function initCalendars() {
		  var calendars1 = new dhtmlXCalendarObject(["fechaInscripcion","fechaDesde","fechaHasta"]);
		  calendars1.setSkin("evr");
		  calendars1.setDateFormat('<spring:message code="common.dateFormat"/>'.replace("dd","%d").replace("MM","%m").replace("yyyy","%Y"));
		  calendars1.loadUserLanguage("${userLang}");
		  calendars1.setWeekStartDay(<spring:message code="common.weekStartDate"/>);
		  /*calendars.setSensitiveRange(null, "${sensitiveRangeMax}");*/
		  calendars1.setSensitiveRange(null, null);
		  calendars1.hideTime();

		
	}


function doReset(){
	if(document.getElementById('comunidadSelected'))
	  document.getElementById('comunidadSelected').value=""; 
	  
	document.getElementById('fechaHasta').value='';
	document.getElementById('fechaDesde').value='';
	document.getElementById('checkConfirmada').checked=false;
    document.getElementById('checkNoConfirmada').checked=false;
}

function viewConfirmada(element){
	var now= element.checked;
	document.getElementById('checkConfirmada').checked=false;
    document.getElementById('checkNoConfirmada').checked=false;
    if(now)
      element.checked=true;
    else element.checked=false;
		
// 	else document.getElementById('gConfirmada').style.visibility = 'hidden';
}


function esFechaValida(fechaDesde, fechaHasta){
	var firstValue = fechaDesde.split('/');
	var dia = firstValue[0];
	var mes = firstValue[1] - 1;
	var anioAux = firstValue[2].split(' ');
	var anio = anioAux[0];
	var firstDate=new Date();
	firstDate.setFullYear(anio,mes,dia);
	 
	var secondValue = fechaHasta.split('/');
	var dia = secondValue[0];
	var mes = secondValue[1] - 1;
	var anioAux = secondValue[2].split(' ');
	var anio = anioAux[0];
	var secondDate=new Date();
	
	secondDate.setFullYear(anio,mes,dia);     

	if (firstDate > secondDate)
	{
		return false;
	}
	else
	{
		return true;
	}
}


function doExport(exportType) {
// 	alert("Report Type: " + exportType);
	var queryString = $('#historyForm').formSerialize();
	location.href = contextPath + "/app/historico/export?" + "exportType=" + exportType;//+ queryString + "&sortingFlag=" + pendingPaginator.sortingFlag + "&fieldName=" + pendingPaginator.fieldName + "&order=" + pendingPaginator.order;
	document.getElementById("viewExportId").value = "Exportar";
}



</script>
            <div class="breadcrumb" id="breadCCAA">
			     <ul class="breadcrumb">
					 <li> <a style="font-size: 12 px;"> Comunidad Autónoma Asignada: </a></li>
					  <li><a class="active">${beanSession.descripcionComunidad} </a>  </li>
			     </ul>        		       
 		 </div>

          <div id="formulcuad">  
              <!-- BEGIN SEARCH FORM FILTER -->
              <form:form id="historyForm" action="${pageContext.request.contextPath}/app/historicoAjax/start"     modelAttribute="${modelAttribute}" >
                  
                    <!-- BREADCRUM    -->
					<div class="breadcrumb">
					  <span class="left"></span>
					  <ul class="breadcrumb">
					    <li><a href="${pageContext.request.contextPath}"><spring:message code="page.breadcrumb.home"/></a></li>
<%-- 					    <li><a href="#"><spring:message code="page.breadcrumb.consultas"/></a></li> --%>
					    <li><a href="${pageContext.request.contextPath}/app/historico/start" class="active"><spring:message code="page.breadcrumb.historico"/></a></li>
					  </ul>
					  <span class="right"></span>
					</div>
					<!-- FIN BREADCRUM -->

					<div class="listado">
						<div class="encabezado">
				  			<label for="usuario">  					
								<span class="label">
				 					<spring:message code="page.breadcrumb.consultaHistorico"/>										
								</span>
				 			</label>  								
						</div>		
					</div>
 
               	<fieldset>
                  		
                      <legend><spring:message code="page.historico.header.filter"/></legend>
                  	 
                  	 
                  	 <c:if test="${beanSession.nac == true}">
<!-- 		                <div class="encabezado"> -->
		                
		                
		                  
	                  	  <label for="comunidadSelected" class="linea-medio">
	               	  		<span class="label_col1"><spring:message code="page.historico.consulta.comunida"/> </span>
<%-- 	                     	<form:select path="codComunidad" multiple="false" id="comunidadSelected"> --%>
	                     	   <select id="comunidadSelected" onchange="doFilterPending()">
	                     	    <option value=""> << Seleccione Comunidad >> </option>   	                     	    
	                     	    <c:forEach items="${listComunidad}" var="item">
	                     	      <option value="${item.codigo}">${item.descripcion}</option>
	                     	    </c:forEach>
	                     	   </select>
	                     	  
	                      </label>  
<!-- 	                      </div> -->
<!-- 	                      <br>    -->
		              </c:if>   
                  	 
                  	 
                  	 
                  	  <label for="fechaDesde" class="linea-medio">
                   		<span class="label_col1"><spring:message code="page.historico.form.from.label"/></span>
                        <input type="datetime" id="fechaDesde" title='${msg["page.historico.form.from.title"]}'></input>
                   		<form:errors path="fechaDesde" class="error-summary"/>
                      </label>
                      
                      <label for="fechaHasta" class="linea-medio linea-dos"> 
               	  		<span class="label_col2"><spring:message code="page.historico.form.to.label"/></span>
                     	<input type="datetime" id="fechaHasta"	alt='${msg["page.historico.form.to.title"]}'               	title='${msg["page.historico.form.to.title"]}'/>  
                      </label>
                      
                      <label for="checkConfirmada" class="linea-medio">
               	  		<span class="label_col1"><spring:message code="page.historico.form.confirmada.label"/></span>
               	  		<input type="checkbox" id="checkConfirmada" class="checkbox" onclick="viewConfirmada(this)"/>
               	  		
                      </label>
                      
                       <label for="checkNoConfirmada" class="linea-medio">
               	  		<span class="label_col1"><spring:message code="page.historico.form.Noconfirmada.label"/></span>
               	  		<input type="checkbox" id="checkNoConfirmada" class="checkbox" onclick="viewConfirmada(this)"/>
                      </label>
                      
                       <label for="procedenciaSelected"  class="linea-medio linea-dos"> 
	               	  		<span id="procedencia" class="label_col2"><spring:message code="page.historico.consulta.procedencia"/> </span>
	                     	   <select id="procedenciaSelected">
	                     	      <option value=""> -- </option>   	                     	    
	                     	      <option value="WS">WS</option>
	                     	      <option value="APP">APP</option>
	                     	   </select>
	                     	  
	                    </label>  
                      
                                                                                                                                   					
                      <div class="listado-acciones-centrado">
                        <input type="button" id="clear" 
                          alt='${msg["page.historico.form.clear.title"]}' 
                          title='${msg["page.historico.form.clear.title"]}' 
                          value='${msg["page.historico.form.clear.value"]}' 
                          class="medio"
                          onclick="doReset()"/>
                        <input type="button" id="filter" 
                          alt='${msg["page.historico.form.filter.title"]}' 
                          title='${msg["page.historico.form.filter.title"]}' 
                          value='${msg["page.historico.form.filter.value"]}' 
                          class="medio" 
                          onclick="doFilter()"/>
                      </div>
                      
                      

                  </fieldset>     
              
              
               <fieldset>
<%--                <form:hidden path="${beanSession.codComunidad}" id="codComunidad"/> --%>
		            <div class="mod-pestanas modulo">
		            
		             <div class="listado-acciones-derecha">
		              
	                    				
 							 <select id="viewExportId" name="exportType"
	                          		title='<spring:message code="page.actions.exportxls.title"/>' class="export" 
	                          		onchange="doExport(this.value)"><option value="Exportar"><spring:message code="page.actions.exportxls.title"/></option>
	                           			<option value="XLS">Excel</option>
	                           			<option value="PDF">PDF</option>
	                           			<option value="DOCX">DOC</option>
	                        </select>	                      			
	                   
                      </div>
		              
			                
			            <!-- TABLA DE RESULTADOS -->
			            <table summary="My pending approvals" class="tabla propiedadCSS3">
	                          <tr>
	                            <td>
	                              <div id="animacionCarga" style="display:none;"></div>
	                              <div id="myHistoryGridId" style="width: 875px; height: 217px;">
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
		         </form:form>
              </br>
              
             
              <!-- END SEARCH FORM FILTER -->
           
              
	         </div>     
