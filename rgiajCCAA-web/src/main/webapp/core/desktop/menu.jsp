<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="spring" 	uri="http://www.springframework.org/tags" %>   
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    

		<!-- MENU -->     
		<div id="menu" class='${environment}'>    
	        <ul>
			  <sec:authorize ifAllGranted="MANT-BAS_MENU">
			  <li class="has-sub"><a href="#"><span><spring:message code="page.menu1"/></span></a>
				<ul>
							<li><a href="${pageContext.request.contextPath}/app/tipoProhibicion/startTipoProhibicion"><span><spring:message code="page.menu1.submenu1"/></span></a></li>
							<li><a href="${pageContext.request.contextPath}/app/cargo/startCargo"><span><spring:message code="page.menu1.submenu2"/></span></a></li>
							<li><a href="${pageContext.request.contextPath}/app/comunidadAutonoma/startComunidadAutonoma"><span><spring:message code="page.menu1.submenu3"/></span></a></li>
							<li><a href="${pageContext.request.contextPath}/app/causaProhibicion/startCausaProhibicion"><span><spring:message code="page.menu1.submenu4"/></span></a></li>
							<li><a href="${pageContext.request.contextPath}/app/tipoFirma/startTipoFirma"><span><spring:message code="page.menu1.submenu5"/></span></a></li>
							<li><a href="${pageContext.request.contextPath}/app/tipoDocIdentidad/startTipoDocIdentidad"><span><spring:message code="page.menu1.submenu6"/></span></a></li>
							<li><a href="${pageContext.request.contextPath}/app/situacion/startSituacion"><span><spring:message code="page.menu1.submenu7"/></span></a></li>
							<li><a href="${pageContext.request.contextPath}/app/carta/startCarta"><span><spring:message code="page.menu1.submenu8"/></span></a></li>
				</ul>
			  </li>
			  </sec:authorize>

			  <sec:authorize ifAnyGranted="PERSONA_LISTADO,NAC_CONSULTAR,COM_CONSULTAR">
			  <li class="has-sub"><a href="#"><span><spring:message code="page.menu2"/></span></a>
				<ul>
				    <sec:authorize ifAllGranted="PERSONA_LISTADO">
					<li><a href="${pageContext.request.contextPath}/app/persona/startPersona"><span><spring:message code="page.menu2.submenu1"/></span></a></li>
					</sec:authorize>
				    <sec:authorize ifAllGranted="ETIQUETAS_LISTADO">
					<li><a href="${pageContext.request.contextPath}/app/persona/etiquetasPendientes"><span><spring:message code="page.menu2.submenu2"/></span></a></li>
					</sec:authorize>
				    <sec:authorize ifAllGranted="CONS-SVDI_LISTADO">
					<li><a href="${pageContext.request.contextPath}/app/consultaSVDI/startConsultaSVDI"><span><spring:message code="page.menu2.submenu3"/></span></a></li>
					</sec:authorize>
				    <sec:authorize ifAnyGranted="PERSONA_LISTADO,NAC_CONSULTAR,COM_CONSULTAR">
					<li><a href="${pageContext.request.contextPath}/app/prohibidos/report"><span><spring:message code="page.menu2.submenu4"/></span></a></li>
					</sec:authorize>
				</ul>
			  </li>
			  </sec:authorize>			  		
			  
			  <sec:authorize ifAnyGranted="NAC_CONSULTAR,COM_CONSULTAR">
			  <li class="has-sub"><a href="#"><span><spring:message code="page.menu3"/></span></a>
				<ul>
				  <li><a href="${pageContext.request.contextPath}/app/prohibidos/download"><span><spring:message code="page.menu3.submenu1"/></span></a></li>
				  <li><a href="${pageContext.request.contextPath}/app/historico/start"><span><spring:message code="page.menu3.submenu2" arguments="'firstResult=0', 'maxResults=10' "/></span></a></li>
		          <li><a href="${pageContext.request.contextPath}/app/comunidad/start"><span><spring:message code="page.menu3.submenu3"/></span></a></li>
				</ul>
			  </li>
			  </sec:authorize>
			  
			  <sec:authorize ifAnyGranted="PERSONA_LISTADO,NAC_CONSULTAR,COM_CONSULTAR">
			  <li><a href="${pageContext.request.contextPath}/doc/Manual_de_Usuario-V1.0.doc" target="_blank"><span><spring:message code="page.menu4"/></span></a></li>
  			  </sec:authorize> 	
			  		  
			</ul>
			<p id='NombreApp' onclick="href='${pageContext.request.contextPath}/app/prohibidos/start'"><spring:message code="page.menu.app"/></p>
			
		</div>
		    
			<div class="opciones-datos">
				<h3 class="usuario"><label id="">
				<sec:authentication property="principal.username"/>
				</label>              
			     <span class="salir">
					<a href="${pageContext.request.contextPath}/app/logout" 
			                      title='<spring:message code="page.menu.logout"/>' 
			                      class="medio"><spring:message code="page.menu.logout"/></a>
	             </span>     
	              </h3>      
			</div>
		
		
