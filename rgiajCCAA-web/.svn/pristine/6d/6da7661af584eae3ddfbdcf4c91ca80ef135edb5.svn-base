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
	if (!confirm('<spring:message code="page.tipoDocIdentidad.confirm.goback"/>')) {
		  return;
	}

	location.href = contextPath + "/app/tipoDocIdentidad/startTipoDocIdentidad";
}

function send_form(){ 

	var codigo = document.getElementById("codigo").value;
	var descripcion = document.getElementById("descripcion").value;

	if (codigo==""){
    	alert('<spring:message code="page.tipoDocIdentidad.alert.mandatoryCodigo" />');
	    return;
	}

	if (descripcion==""){
    	alert('<spring:message code="page.tipoDocIdentidad.alert.mandatoryDescripcion" />');
	    return;
	}

	document.getElementById("saveForm").submit();
} 

onload = function() {
	var strError = document.getElementById("error").value;
	if (strError!=""){
		alert(strError);
	}
};


String.prototype.ltrim = function() {
	return this.replace(/^\s+/,"").replace(/&nbsp;/g,"");
}


</script>

 <div id="formulcuad">  
              <!-- BEGIN SEARCH FORM FILTER -->
              <form:form id="saveForm" action="${pageContext.request.contextPath}/app/tipoDocIdentidad/saveEditTipoDocIdentidad"
              	modelAttribute="${modelAttribute}">
                    
                    <!-- BREADCRUM    -->
					<div class="breadcrumb">
					  <span class="left"></span>
					  <ul class="breadcrumb">
						<li><a href="${pageContext.request.contextPath}"><spring:message code="page.breadcrumb.home"/></a></li>
					    <li><a href="${pageContext.request.contextPath}/app/tipoDocIdentidad/startTipoDocIdentidad"><spring:message code="page.breadcrumb.tipoDocIdentidad"/></a></li>
					    <li><a href="#" class="active"><spring:message code="page.tipoDocIdentidad.li.edit.title"/></a></li>
					  </ul>
					  <span class="right"></span>
					</div>
					<!-- FIN BREADCRUM -->

					<div class="listado">
						<div class="encabezado">
				  			<label for="usuario">  					
								<span class="label">
				 					<spring:message code="page.breadcrumb.editTipoDocIdentidad"/>										
								</span>
				 			</label>  								
						</div>		
					</div>

                  	<fieldset>

                      <label for="codigo" class="linea-medio">
                   		<span class="label_col1"><spring:message code="page.tipoDocIdentidad.form.codigo.label"/><span class="obligatorio" title='${msg["page.common.obligatorio"]}'>*</span></span>
                        <form:input id="codigo" path="codigo" maxlength="255" title='${msg["page.tipoDocIdentidad.form.codigo.title"]}'/>
                   		<form:errors path="codigo" class="error-summary"/>
                   		<form:hidden id="id" path="id"></form:hidden>            
                   		<form:hidden id="error" path="error"></form:hidden>                   		
                      </label>

                      <label for="descripcion" class="linea-medio">
               	  		<span class="label_col1"><spring:message code="page.tipoDocIdentidad.form.descripcion.label"/><span class="obligatorio" title='${msg["page.common.obligatorio"]}'>*</span></span>
                       	<form:textarea id="descripcion" path="descripcion" class="areatexto" maxlength="255"
                       	alt='${msg["page.tipoDocIdentidad.form.descripcion.title"]}' 
                       	title='${msg["page.tipoDocIdentidad.form.descripcion.title"]}'></form:textarea>  
                      </label>

                      <label for="activo" class="linea-medio">    
                   		<span class="label_col1"><spring:message code="page.tipoDocIdentidad.form.activo.label"/></span>
						<form:checkbox class="checkbox" path="activo" id="activo"/>
                      </label>
                      
                      <br/>
					  
					  <div class="listado-acciones-centrado">
                        <input type="button" id="cancel" 
                          alt='${msg["page.tipoDocIdentidad.form.cancel.title"]}' 
                          title='${msg["page.tipoDocIdentidad.form.cancel.title"]}' 
                          value='${msg["page.tipoDocIdentidad.form.cancel.value"]}' 
                          class="medio"
                          onclick="doReset()"/>
                      	<input type="button" id="save" 
                          alt='${msg["page.tipoDocIdentidad.form.create.title"]}' 
                          title='${msg["page.tipoDocIdentidad.form.create.title"]}' 
                          value='${msg["page.tipoDocIdentidad.form.create.value"]}' 
                          class="medio"
                          onclick="send_form()"/>
                      </div>
                  </fieldset>
               </form:form>
              <!--  END SEARCH FORM FILTER -->
           </div>