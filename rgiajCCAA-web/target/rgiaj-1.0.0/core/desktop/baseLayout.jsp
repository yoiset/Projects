<%-- 
  Basic Template
  Formed by a header, main content and footer

  @param title Page title
  @param header Page header
  @param body Main content
  @param footer Page footer
--%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<!--[if IE 7 ]> <html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es" dir="ltr" class="ie7"> <![endif]-->
<!--[if IE 8 ]> <html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es" dir="ltr" class="ie8"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es" dir="ltr"> <!--<![endif]-->
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
    <meta http-equiv='pragma' content='no-cache'/>
    <meta http-equiv='cache-control' content='no-cache'/>
    <meta http-equiv='expires' content='0'/>
    <meta name="author" content="everis"/>
    <meta name="description" content="Gestión del RGIAJ, Dirección General del Juego"/>    
    <meta name="keywords" content="piloto, dgoj"/>
  		
    <title>RGIAJ - Aplicación del Registro General de Interdicciones de Acceso al Juego</title>
    
    <!-- DGOJ CSS -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/core/static/css/estilo-intranet.css" media="screen" type="text/css"  />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/core/static/css/estilo-intranet-print.css" media="print" type="text/css"  />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/core/static/css/lightbox.css" media="screen,projection" type="text/css" /> 
	<link rel="stylesheet" href="${pageContext.request.contextPath}/core/static/css/estilo-rgiaj.css" media="screen" type="text/css"  />
    
    <!-- DHTMLX Calendar CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/core/static/css/dhtmlx/dhtmlxcalendar.css" type="text/css" /> 
    <link rel="stylesheet" href="${pageContext.request.contextPath}/core/static/css/skins/dhtmlxcalendar_dgoj.css" type="text/css" /> 
    
    <!-- DHTMLX Grid CSS -->    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/core/static/css/skins/dhtmlxgrid_dgoj.css" type="text/css" /> 
   

    <!-- JAVASCRIPT -->
    
    <!-- jQuery libraries -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/core/static/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/core/static/js/jquery.form.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/core/static/js/jquery.autocomplete.js"></script>

    <!-- Main menu and navigation style -->
    <script type = "text/javascript" src="${pageContext.request.contextPath}/core/static/js/navegacion.js"></script>
    
    <!-- Tabs management -->    
    <script type = "text/javascript" src="${pageContext.request.contextPath}/core/static/js/tabs.js"></script>

    <!-- DHTMLX Common library -->    
    <script type="text/javascript" src="${pageContext.request.contextPath}/core/static/js/codebase/dhtmlxcommon.js"></script>
        
    <!-- DHTMLX Grid libraries -->    
    <script type="text/javascript" src="${pageContext.request.contextPath}/core/static/js/codebase/dhtmlxgrid.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/core/static/js/codebase/dhtmlxgridcell.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/core/static/js/dhtmlxgridutils.js"></script>

    <!-- DHTMLX Calendar library -->    
    <script type="text/javascript" src="${pageContext.request.contextPath}/core/static/js/codebase/dhtmlxcalendar.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/core/static/js/codebase/dhtmlxcalendar-i18n.js"></script>

    <!-- Ajax libraries -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/core/static/js/ajax-utils.js"></script>

    <!-- Paginator library -->    
    <script type="text/javascript" src="${pageContext.request.contextPath}/core/static/js/ajax-paginator.js"></script>

    <!-- RGIAJ libraries -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/core/static/js/rgiaj-utils.js"></script>

  </head>

     <body class='${environment}'>
  
  	<div id="contenido">     
        <!-- BEGIN HEADER -->
        <div>
          <tiles:insertAttribute name="header" />
        </div>
        <!-- END HEADER -->

        <!-- BEGIN MAIN CONTENT -->
       	<div id="interior" class='${environment}'>	
	       	<div>
				<tiles:insertAttribute name="menu" />
			</div>
			
			<div id="central">	
				<!-- ERROR DIV FOR AJAX REQUEST    -->
				<div id="MenssageErrorAjax">
				</div>
				<!-- FIN ERROR DIV FOR AJAX REQUEST    -->

         		<tiles:insertAttribute name="main" />
        	</div>
        </div>
        <!-- END MAIN CONTENT -->

        <!-- BEGIN FOOTER -->
        <div>
          <tiles:insertAttribute name="footer" />
        </div>
        <!-- END FOOTER -->
    </div>
    
  </body>
</html>