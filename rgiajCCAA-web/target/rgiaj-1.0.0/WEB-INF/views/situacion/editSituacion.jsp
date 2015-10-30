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
	if (!confirm('<spring:message code="page.situacion.confirm.goback"/>')) {
		  return;
	}

	location.href = contextPath + "/app/situacion/startSituacion";
}

function send_form(){ 

	var codigo = document.getElementById("codigo").value;
	var descripcion = document.getElementById("descripcion").value;

	if (codigo==""){
    	alert('<spring:message code="page.situacion.alert.mandatoryCodigo" />');
	    return;
	}

	if (descripcion==""){
    	alert('<spring:message code="page.situacion.alert.mandatoryDescripcion" />');
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
              <form:form id="saveForm" action="${pageContext.request.contextPath}/app/situacion/saveEditSituacion"
              	modelAttribute="${modelAttribute}">
                    
                    <!-- BREADCRUM    -->
					<div class="breadcrumb">
					  <span class="left"></span>
					  <ul class="breadcrumb">
						<li><a href="${pageContext.request.contextPath}"><spring:message code="page.breadcrumb.home"/></a></li>
					    <li><a href="${pageContext.request.contextPath}/app/situacion/startSituacion"><spring:message code="page.breadcrumb.situacion"/></a></li>
					    <li><a href="#" class="active"><spring:message code="page.situacion.li.edit.title"/></a></li>
					  </ul>
					  <span class="right"></span>
					</div>
					<!-- FIN BREADCRUM -->

					<div class="listado">
						<div class="encabezado">
				  			<label for="usuario">  					
								<span class="label">
				 					<spring:message code="page.breadcrumb.editSituacion"/>										
								</span>
				 			</label>  								
						</div>		
					</div>

                  	<fieldset>

                      <label for="codigo" class="linea-medio">
                   		<span class="label_col1"><spring:message code="page.situacion.form.codigo.label"/><span class="obligatorio" title='${msg["page.common.obligatorio"]}'>*</span></span>
                        <form:input id="codigo" path="codigo" maxlength="255" title='${msg["page.situacion.form.codigo.title"]}'/>
                   		<form:errors path="codigo" class="error-summary"/>
                   		<form:hidden id="id" path="id"></form:hidden>            
                   		<form:hidden id="error" path="error"></form:hidden>                   		
                      </label>

                      <label for="descripcion" class="linea-medio">
               	  		<span class="label_col1"><spring:message code="page.situacion.form.descripcion.label"/><span class="obligatorio" title='${msg["page.common.obligatorio"]}'>*</span></span>
                       	<form:textarea id="descripcion" path="descripcion" class="areatexto" maxlength="255"
                       	alt='${msg["page.situacion.form.descripcion.title"]}' 
                       	title='${msg["page.situacion.form.descripcion.title"]}'></form:textarea>  
                      </label>

                      <label for="activo" class="linea-medio">    
                   		<span class="label_col1"><spring:message code="page.situacion.form.activo.label"/></span>
						<form:checkbox class="checkbox" path="activo" id="activo"/>
                      </label>
                      
                       <label for="tipoSituacion" class="linea-medio">
                    	<span class="label_col1"><spring:message code="page.situacion.form.tipoSituacion.label"/></span>
                       	<form:select id="tipoSituacion" path="tipoSituacion" title='${msg["page.situacion.form.tipoSituacion.title"]}'>
							<form:option value="" label=""></form:option>
							<form:options items="${tiposSituacionList}" itemValue="code" itemLabel="description" />
                       	</form:select>                      	
                      </label>

                      <label for="situacionMaq" class="linea-medio">
                    	<span class="label_col1"><spring:message code="page.situacion.form.situacionMaq.label"/></span>
                       	<form:select id="situacionMaq" path="situacionMaq" title='${msg["page.situacion.form.situacionMaq.title"]}'>
							<form:option value="" label=""></form:option>
							<form:options items="${situacionValoresList}" itemValue="code" itemLabel="description" />
                       	</form:select>                      	
                      </label>

                      <label for="situacionEmp" class="linea-medio">
                    	<span class="label_col1"><spring:message code="page.situacion.form.situacionEmp.label"/></span>
                       	<form:select id="situacionEmp" path="situacionEmp" title='${msg["page.situacion.form.situacionEmp.title"]}'>
							<form:option value="" label=""></form:option>
							<form:options items="${situacionValoresList}" itemValue="code" itemLabel="description" />
                       	</form:select>                      	
                      </label>

                      <label for="situacionLocal" class="linea-medio">
                    	<span class="label_col1"><spring:message code="page.situacion.form.situacionLocal.label"/></span>
                       	<form:select id="situacionLocal" path="situacionLocal" title='${msg["page.situacion.form.situacionLocal.title"]}'>
							<form:option value="" label=""></form:option>
							<form:options items="${situacionValoresList}" itemValue="code" itemLabel="description" />
                       	</form:select>                      	
                      </label>

                      <label for="situacionPersona" class="linea-medio">
                    	<span class="label_col1"><spring:message code="page.situacion.form.situacionPersona.label"/></span>
                       	<form:select id="situacionPersona" path="situacionPersona" title='${msg["page.situacion.form.situacionPersona.title"]}'>
							<form:option value="" label=""></form:option>
							<form:options items="${situacionValoresList}" itemValue="code" itemLabel="description" />
                       	</form:select>                      	
                      </label>

                      <label for="situacionModelo" class="linea-medio">
                    	<span class="label_col1"><spring:message code="page.situacion.form.situacionModelo.label"/></span>
                       	<form:select id="situacionModelo" path="situacionModelo" title='${msg["page.situacion.form.situacionModelo.title"]}'>
							<form:option value="" label=""></form:option>
							<form:options items="${situacionValoresList}" itemValue="code" itemLabel="description" />
                       	</form:select>                      	
                      </label>
                      
                      <br/>
					  
					  <div class="listado-acciones-centrado">
                        <input type="button" id="cancel" 
                          alt='${msg["page.situacion.form.cancel.title"]}' 
                          title='${msg["page.situacion.form.cancel.title"]}' 
                          value='${msg["page.situacion.form.cancel.value"]}' 
                          class="medio"
                          onclick="doReset()"/>
                      	<input type="button" id="save" 
                          alt='${msg["page.situacion.form.create.title"]}' 
                          title='${msg["page.situacion.form.create.title"]}' 
                          value='${msg["page.situacion.form.create.value"]}' 
                          class="medio"
                          onclick="send_form()"/>
                      </div>
                  </fieldset>
               </form:form>
              <!--  END SEARCH FORM FILTER -->
           </div>