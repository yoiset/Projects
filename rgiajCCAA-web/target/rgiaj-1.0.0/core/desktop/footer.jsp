<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags" %>       

		<!-- PIE DE PAGINA -->        
        <footer class="pie">
	        <div id="inferior">
				<div id="pie-izquierdo">
					<p><spring:message code="msg.footer.errorMsg"/> <a href="mailto:dgoj.incidencias@minhap.es"><spring:message code="msg.footer.errorMail"/></a></p>
				</div>       
				<div id="pie">
								
					<p><spring:message code="msg.footer.copyrightLine1"/><br /> 
					   <spring:message code="msg.footer.copyrightLine2"/><br /> 
					   <spring:message code="msg.footer.copyrightLine3"/><br /> 
					</p>	
				</div>
			</div>
		 </footer>
		 <!-- FIN PIE DE PAGINA -->