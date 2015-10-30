<%-- 
  Basic Template
  Formed by a header, main content and footer

  @param title Page title
  @param header Page header
  @param body Main content
  @param footer Page footer
--%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<!--[if IE 7 ]> <html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es" dir="ltr" class="ie7"> <![endif]-->
<!--[if IE 8 ]> <html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es" dir="ltr" class="ie8"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es" dir="ltr"> <!--<![endif]-->
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
    <meta http-equiv='pragma' content='no-cache'/>
    <meta http-equiv='cache-control' content='no-cache'/>
    <meta http-equiv='expires' content='0'/>
    <meta name="author" content="dgoj"/>
    <meta name="description" content="Direcci�n General de Ordenaci�n del Juego"/>    
    <meta name="keywords" content="dgoj"/>
  		
    <title>Error de la aplicacion</title>
	
    <!-- DGOJ CSS -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/core/static/css/estilo-intranet.css" media="screen" type="text/css"  />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/core/static/css/estilo-intranet-print.css" media="print" type="text/css"  />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/core/static/css/lightbox.css" media="screen,projection" type="text/css" /> 
    
    <!-- DHTMLX Calendar CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/core/static/css/dhtmlx/dhtmlxcalendar.css" type="text/css" /> 
    <link rel="stylesheet" href="${pageContext.request.contextPath}/core/static/css/skins/dhtmlxcalendar_dgoj.css" type="text/css" /> 
    
    <!-- DHTMLX Grid CSS -->    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/core/static/css/skins/dhtmlxgrid_dgoj.css" type="text/css" /> 
   
  </head>

    <body class='${environment}'>
  
  	<div id="contenido">     
        <!-- BEGIN HEADER -->
        <div>
        <!-- CABECERA PRINCIPAL -->       
        <header class="cabecera">
        	<div class="arriba">
	        	<h2 class="hide"><spring:message code="msg.header.cabecera"/></h2>          
	 			<div class="escudo">
					<a title="Direcci�n General de Ordenaci�n del Juego">
						<img src="${pageContext.request.contextPath}/core/static/images/escudo-dgoj.png" alt="Direcci�n General de Ordenaci�n del Juego" />
					</a>
				</div>
			</div>
		</header>
		
		
                    
        
        </div>
        <!-- END HEADER -->

        <!-- BEGIN MAIN CONTENT -->
       	<div id="interior" class='${environment}'>	
			
			<div id="central">	
				<div id="error">
					<ul id="ulError">
						<li><span class="errorMessage"><spring:message code="page.error.404"/></span></li>

					</ul>
				</div>
				<br/>
				<!-- EMPIEZA EL CONTENIDO DE LA PAGINA -->
				<p>
					<spring:message code="page.error.access"/>
				</p>	
				<div id="bot-acceso">
					<a href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
						<spring:message code="page.access.msgAccess"/>
					</a> 
				</div>
        	</div>
        </div>
        <!-- END MAIN CONTENT -->

        <!-- BEGIN FOOTER -->
        <div>
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
        </div>
        <!-- END FOOTER -->
    </div>
    
  </body>
</html>