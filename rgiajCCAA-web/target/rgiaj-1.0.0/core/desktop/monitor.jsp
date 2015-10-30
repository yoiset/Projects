<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags" %>       

<div id="formulcuad">  

		<div class="listado">
			<div class="encabezado">
		 			<label for="usuario">  					
					<span class="label">
							<spring:message code="page.app.monitor.status"/>										
					</span>
					</label>  								
			</div>		
		</div>

       	<fieldset>
       	
       		<h2>
       	  		${applicationName}&nbsp;&nbsp;&nbsp;&nbsp;
       	  		&nbsp;&nbsp;&nbsp;&nbsp;${applicationVersion}
            </h2>
           
           <legend><spring:message code="page.app.monitor.service"/></legend>
           
           	<c:forEach items="${listMonitor}" var="monitor">
	           	<label for="id" class="linea-medio">
	       	  		<span class="label">${monitor.name}</span>
	             	<c:if test="${monitor.status == 'RUNNING'}">
	             		<img src="../../core/static/images/true.gif" alt="Correcto" />
	             	</c:if>
	             	<c:if test="${monitor.status == 'WARNING'}">
	             		<img src="../../core/static/images/warning.gif" alt="Warning" />
	             	</c:if>
	             	<c:if test="${monitor.status == 'ERROR'}">
	             		<img src="../../core/static/images/false.gif" alt="Error" />
	             	</c:if>
	             	<p><spring:message code="page.app.monitor.time"/> ${monitor.time}</p>
	           </label>
           	</c:forEach>
           	<label class="linea-medio">
           		<p><spring:message code="page.app.monitor.maxTime"/> ${responseTime} <spring:message code="page.app.monitor.unit"/></p>
           	</label>
           	
       	  
           
        </fieldset>
        
</div>
