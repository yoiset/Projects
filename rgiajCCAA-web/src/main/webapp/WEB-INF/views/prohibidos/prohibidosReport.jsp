<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="form-ext" uri="http://www.springframework.org/tags/form-ext" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<script type="text/javascript">

var contextPath = '${pageContext.request.contextPath}';


	function startReport() {
        var codComunidad=null;
        var exportType="PDF";

        if(document.getElementById("comunidadSelected"))
        	codComunidad=codComunidad=document.getElementById("comunidadSelected").value;

//         alert("Cod Comunidad: " + codComunidad) ;
        
//         if(document.getElementById("XLS").checked)
//         	exportType="XLS";  

        if(document.getElementById("DOC").checked)
        	exportType="docx"; 

//     	alert("Tipo: " + exportType) ;
//     	alert("Cod Comunidad: " + codComunidad) ;
		
		var form = document.getElementById("downloadForm");		
		form.setAttribute('action', contextPath		+ '/app/prohibidos/export?' +"codComunidad=" + codComunidad  + "&exportType=" + exportType);
		form.submit();

	}

	onload = function() {
		   document.getElementById("PDF").checked=true;
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
              <form:form id="downloadForm" action="${pageContext.request.contextPath}/app/prohibidos/export"
                    modelAttribute="${modelAttribute}" >
                  
                    <!-- BREADCRUM    -->
					<div class="breadcrumb">
					  <span class="left"></span>
					  <ul class="breadcrumb">
					    <li><a href="${pageContext.request.contextPath}"><spring:message code="page.breadcrumb.home"/></a></li>
<%-- 					    <li><a href="#"><spring:message code="page.breadcrumb.consultas"/></a></li> --%>
					    <li><a href="${pageContext.request.contextPath}/app/prohibidos/report" class="active"><spring:message code="page.breadcrumb.prohibidos.report"/></a></li>
					  </ul>
					  <span class="right"></span>
					</div>
					<!-- FIN BREADCRUM -->

					<div class="listado">
						<div class="encabezado">
				  			<label for="usuario">  					
								<span class="label">
				 					<spring:message code="page.breadcrumb.prohibidos.report"/>										
								</span>
				 			</label>  								
						</div>		
					</div>
 
                  	<fieldset>
                  	
            
<%--             </c:if>      	 --%>
			<div style="font-size: 12px;">
				<ul>
				  <li style="padding-left: 100px; float: left;">
						<h2>
							<spring:message		code="page.prohibidos.report.message.comunidad" />
						</h2>
						<ul>
						    <li style="padding-top: 10px;">
						     
						      <select id="comunidadSelected" onchange="doFilterPending()">
<!-- 	                     	    <option value=""> << Todas >> </option>   	                     	     -->
	                     	    <c:forEach items="${listComunidad}" var="item">
	                     	      <option value="${item.codigo}">${item.descripcion}</option>
	                     	    </c:forEach>
	                     	   </select>    
						    
						    </li>
						    <li> &nbsp;</li>
						    <li> &nbsp;</li>
						    <li>
						      	 <div class="listado-acciones-centrado">
			<!--                     <div> -->
			                        <input type="button" id="descargar" 
			                          alt='${msg["page.prohibidos.report.button.title"]}' 
			                          title='${msg["page.prohibidos.report.button.title"]}' 
			                          value='${msg["page.prohibidos.report.button.title"]}' 
			                          class="boton"    
			                          onclick="startReport()"/>
			                          
                     			 </div>
						    </li>
							
							
						</ul>
					</li>
					<li style="padding-left: 100px; float: left;">
					 <h2><spring:message code="page.prohibidos.report.message.format"/></h2>
						<ul>
							<li style="padding-top: 10px;"> <form:radiobutton id="PDF" path="fileFormat" value="PDF" />PDF<br></li>
<%-- 							<li style="padding-top: 10px;"> <form:radiobutton id="XLS" path="fileFormat" value="XLS" />XLS</li> --%>
							<li style="padding-top: 10px;"> <form:radiobutton id="DOC" path="fileFormat" value="DOC" />DOC</li>
						</ul>
					</li>

				</ul>
			</div>
           <div></br></br></div>

		  
                  </fieldset>
              </form:form>
              
              </br>
              
        </div>     
