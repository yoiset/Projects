<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="form-ext" uri="http://www.springframework.org/tags/form-ext" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<script type="text/javascript">

var contextPath = '${pageContext.request.contextPath}';
var showPending= '${showPending}';

  if (showPending == 'true') {
		var r = confirm("La última descarga está pendiente de Confirmar. Si de desea confirmarla pulse Aceptar sino Cancelar");
		if (r == true) {
			var req = new XMLHttpRequest();
			req.open('POST', contextPath + '/app/prohibidos/updatePendiente',true);
			req.send(null);
		}
	}

	// $("#descargar").click( function() {
	// 	 $("#downloadForm").submit();	
	// }

	function startDownload() {
		// 	alert(contextPath + '/app/prohibidos/startDonwload');
		var form = document.getElementById("downloadForm");		
		form.setAttribute('action', contextPath		+ '/app/prohibidos/startDonwload');
		document.getElementById("confirmar").disabled = false;
		form.submit();

	}

	function updateHistorico() {
		var form = document.getElementById("downloadForm");
		form.setAttribute('action', contextPath	+ '/app/prohibidos/updateHistorico');
		form.submit();
		document.getElementById("confirmar").disabled = true;
	}

	function confirmPending() {
		var form = document.getElementById("downloadForm");
		form.setAttribute('action', contextPath
				+ '/app/prohibidos/updatePendiente');
		form.submit();
	}

	function enablePuntual(){
		var div=document.getElementById("puntual");
		var span=document.getElementById("spanCheck");
		
        div.style.display = "block";
        span.style.visibility='visible';
// 		text.innerHTML = "hide";		
		}

	function disablePuntual(){
		var div=document.getElementById("puntual");
		div.style.display = "none";
		}

	function enablePuntualSelect(){
		var div=document.getElementById("puntualSelect");
		var checkbok=document.getElementById("checkboxSelect");
		if(checkbok.checked)
		  div.style.display = "block";
		else  div.style.display = "none";
		}

	function changeCount(){
		if(isNaN(Number(document.getElementById("countReg").value) ))
			  document.getElementById("countReg").value=10;	  
			
		var form = document.getElementById("downloadForm");
		form.setAttribute('action', contextPath	+ '/app/prohibidos/changeCountHistorico');
		form.submit();
	}

	function validateCountReg(countReg){
		 var num=Number(countReg.value);
		 if(isNaN(num)){
			 alert("Solo Valores numéricos")
			 countReg.value='';
			 }
			 
		}

	///////////////////////////////////////////////////////////////////////////////
	//my pending
</script>
          <div class="breadcrumb" id="breadCCAA">
			     <ul class="breadcrumb">
					 <li> <a style="font-size: 12 px;"> Comunidad Autónoma Asignada: </a></li>
					  <li><a class="active">${beanSession.descripcionComunidad} </a>  </li>
			     </ul>        		       
   			</div>
         
          <div id="formulcuad">  
              <!-- BEGIN SEARCH FORM FILTER -->
              <form:form id="downloadForm" action="${pageContext.request.contextPath}/app/prohibidos/startDonwload"
                    modelAttribute="${modelAttribute}" >
                  
                    <!-- BREADCRUM    -->
					<div class="breadcrumb">
					  <span class="left"></span>
					  <ul class="breadcrumb">
					    <li><a href="${pageContext.request.contextPath}"><spring:message code="page.breadcrumb.home"/></a></li>
<%-- 					    <li><a href="#"><spring:message code="page.breadcrumb.consultas"/></a></li> --%>
					    <li><a href="${pageContext.request.contextPath}/app/prohibidos/download" class="active"><spring:message code="page.breadcrumb.prohibidos"/></a></li>
					  </ul>
					  <span class="right"></span>
					</div>
					<!-- FIN BREADCRUM -->

					<div class="listado">
						<div class="encabezado">
				  			<label for="usuario">  					
								<span class="label">
				 					<spring:message code="page.breadcrumb.prohibidos"/>										
								</span>
				 			</label>  								
						</div>		
					</div>
 
                  	<fieldset>
                  	
<%--             <c:if test="${showPending}"> --%>
            
<!--             <div style="font-size: 12px;"> -->
<%--                <h2><spring:message code="page.prohibidos.descargas.message.hasPending"/></h2> --%>
               
<!--                <div class="listado-acciones-centrado"> -->
<!-- <!--                     <div> --> 
<!--                         <input type="button" id="pending"  -->
<%--                           alt='${msg["page.prohibidos.descargas.button.pending.title"]}'  --%>
<%--                           title='${msg["page.prohibidos.descargas.button.pending.title"]}'  --%>
<%--                           value='${msg["page.prohibidos.descargas.button.pending.title"]}'  --%>
<!--                           class="boton"     -->
<!--                           onclick="confirmPending()"/> -->
                          
                       
<!--                       </div> -->
<!--             </div> -->
            
<%--             </c:if>      	 --%>
			<div style="font-size: 12px;">
				<ul>
					<li style="float: left;">
					 <h2><spring:message code="page.prohibidos.descargas.message.formatoDescarga"/></h2>
						<ul>
							<li style="padding-top: 10px;"> <form:radiobutton id="text" path="fileFormat" value="TXT" />Formato TXT<br></li>
							<li style="padding-top: 10px;"> <form:radiobutton id="xml" path="fileFormat" value="XML" />Formato XML</li>
							<li style="padding-top: 10px;"> <form:radiobutton id="ambos" path="fileFormat" value="Ambos" />Ambos: XML y TXT</li>
						</ul>
					</li>

					<li style="padding-left: 100px; float: left;">
						<h2>
							<spring:message		code="page.prohibidos.descargas.message.tipoDescarga" />
						</h2>
						<ul>
						    <li style="padding-top: 10px;"><form:radiobutton id="completa" path="downloadType" value="Completa" onclick="disablePuntual()"/> <spring:message	code="page.prohibidos.descargas.message.tipoDescarga.global" /></li>
							<li style="padding-top: 10px;"><form:radiobutton id="incremental" path="downloadType" value="Incremental" onclick="enablePuntual()" /> <spring:message	code="page.prohibidos.descargas.message.tipoDescarga.ultimo" /></li>
							<div id="puntual" style="display: block;">							
								<li style="padding-top: 10px;">
								    <ul style="padding-left: 20px;">
								         <span id="spanCheck" style="visibility: ${showCheck} ">
								          <form:checkbox id="checkboxSelect" path="selectDesde" title="Realizar Descarga Puntual" onclick="enablePuntualSelect()" label=" Descarga Desde: " />
                					      </span>  
									     <li>
									         <div id="puntualSelect" <c:if test="${stylePuntualSelect == null }">style="display: none" </c:if><c:if test="${stylePuntualSelect != null}"> ${stylePuntualSelect}</c:if>  >
										       <form:select id="selectPuntual"	path="puntual"	title='Seleccione una descrga puntual' multiple="false">
<%-- 												<form:option value="" label=""></form:option> --%>
												<form:options items="${listUltimasDescargas}" />
			<%-- 									<form:options items="${listUltimasDescargas}" itemValue="code"	itemLabel="description" /> --%>
											  </form:select>
											 							 
<%-- 						                       <form:input path="countReg"   maxlength="2" size="2" cssStyle="padding-left: 20px; border: 2px" onkeyup="validateCountReg(this)"/> --%>
						                       
						                       <form:select id="countReg"	path="countReg"	title='Seleccione cantidad de descarga' multiple="false" onchange="changeCount()">
							                        <form:option value="10" label="10"/>
							                        <form:option value="20" label="20" />
							                        <form:option value="30" label="30" />
							                        <form:option value="40" label="40" />
						                       </form:select>
						                      
<!-- 						                       <input type="button" id=changeCountButton"  -->
<!-- 											      alt='Cambiar cantidad de histórotico'  -->
<!-- 						                          title='Cambiar cantidad de histórotico'  -->
<!-- 						                          value='Cantida histórotico'  -->
<!-- 						                          class="boton" -->
<!-- 						                          onclick="changeCount()"/> -->
						                       
											  </div>
											  
										 </li>
								    </ul>
								</li>
							</div>
							
						</ul>
					</li>
				</ul>
			</div>
           <div></br></br></div>

			<div class="listado-acciones-centrado">
<!--                     <div> -->
                        <input type="button" id="descargar" 
                          alt='${msg["page.prohibidos.descargas.button.descarga.title"]}' 
                          title='${msg["page.prohibidos.descargas.button.descarga.title"]}' 
                          value='${msg["page.prohibidos.descargas.button.descarga.title"]}' 
                          class="boton"    
                          onclick="startDownload()"/>
                          
                        <input type="button" id="confirmar" 
                          alt='${msg["page.prohibidos.descargas.button.confirmar.title"]}' 
                          title='${msg["page.prohibidos.descargas.button.confirmar.title"]}' 
                          value='${msg["page.prohibidos.descargas.button.confirmar.title"]}' 
                          class="boton"
                          disabled="true"
                          onclick="updateHistorico()"/>
                      </div>
                  </fieldset>
              </form:form>
              
              </br>
              
             <legend style="font-size: 12px; font-weight: bold;"> <spring:message code="page.prohibidos.descargas.info.atencion"/></legend> 
              <!-- END SEARCH FORM FILTER -->
           
                        
	            <!-- MÓDULO DE PESTAÑAS -->
<!-- 	            <fieldset> -->
<!-- 		            <div class="mod-pestanas modulo"> -->
		                                
<!-- 		              BEGIN ACTIONS TOOLBAR -->
<!-- 		              <div class="listado-acciones-derecha"> -->
		              
<%-- 						<sec:authorize ifAllGranted="CONS-JUG_EXPORTAR">		               --%>
<!-- 	                        <input type="button" id="viewExportId"  -->
<%-- 	                          alt='${msg["page.jugadorOperador.actions.exportxls.title"]}'  --%>
<%-- 	                          title='${msg["page.jugadorOperador.actions.exportxls.title"]}'  --%>
<%-- 	                          value='${msg["page.jugadorOperador.actions.exportxls.value"]}'  --%>
<!-- 	                          class="medio"  -->
<!-- 	                          onclick="doExport()"/> -->
<%--                         </sec:authorize>                           --%>
<!--                       </div> -->
<!-- 		              END ACTIONS TOOLBAR -->
		                
<!-- 		              TABLA DE RESULTADOS -->
<!-- 		              <table summary="My pending approvals" class="tabla propiedadCSS3"> -->
<!--                           <tr> -->
<!--                             <td> -->
<!--                               <div id="animacionCarga" style="display:none;"></div> -->
<!--                               <div id="myPendingGridId" style="width: 875px; height: 217px;"> -->
<!--                       			ListGrid my pending -->
<!--                               </div> -->

<!--                             </td> -->
<!--                           </tr> -->
<!--                           <tr> -->
<!--                             <td> -->
<!--                               <div id="myPendingPaginatorId" style="width: 875px; height: 20px;"> -->
<!--                                 Paginator my pending -->
<!--                               </div> -->
<!--                             </td> -->
<!--                           </tr> -->
<!--                         </table> -->
		                          
<!-- 		            </div> -->
<!-- 		        </fieldset> -->
	            <!-- FIN DE MÓDULO PESTAÑAS -->   
	         </div>     
