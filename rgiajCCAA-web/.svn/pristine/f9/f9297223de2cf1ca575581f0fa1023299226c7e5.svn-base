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
	if (!confirm('<spring:message code="page.carta.confirm.goback"/>')) {
		  return;
	}

	location.href = contextPath + "/app/carta/startCarta";
}

function send_form(){ 

	var codigo = document.getElementById("id").value;
	var descripcion = document.getElementById("descripcion").value;

	if (codigo==""){
    	alert('<spring:message code="page.carta.alert.mandatoryId" />');
	    return;
	}

	if (isNaN(codigo)){
    	alert('<spring:message code="page.carta.alert.formatId" />');
	    return;
	
	}
		
	if (descripcion==""){
    	alert('<spring:message code="page.carta.alert.mandatoryDescripcion" />');
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
              <form:form id="saveForm" action="${pageContext.request.contextPath}/app/carta/saveEditCarta"
              	modelAttribute="${modelAttribute}">
                    
                    <!-- BREADCRUM    -->
					<div class="breadcrumb">
					  <span class="left"></span>
					  <ul class="breadcrumb">
						<li><a href="${pageContext.request.contextPath}"><spring:message code="page.breadcrumb.home"/></a></li>
					    <li><a href="${pageContext.request.contextPath}/app/carta/startCarta"><spring:message code="page.breadcrumb.carta"/></a></li>
					    <li><a href="#" class="active"><spring:message code="page.carta.li.edit.title"/></a></li>
					  </ul>
					  <span class="right"></span>
					</div>
					<!-- FIN BREADCRUM -->

					<div class="listado">
						<div class="encabezado">
				  			<label for="usuario">  					
								<span class="label">
				 					<spring:message code="page.breadcrumb.editCarta"/>										
								</span>
				 			</label>  								
						</div>		
					</div>

                  	<fieldset>

                      <label for="id" class="linea-medio">
                   		<span class="label_col1"><spring:message code="page.carta.form.codigo.label"/><span class="obligatorio" title='${msg["page.common.obligatorio"]}'>*</span></span>
                        <form:input readonly="true" id="id" path="id" maxlength="255" title='${msg["page.carta.form.codigo.title"]}'/>
                   		<form:errors path="id" class="error-summary"/>
                   		<form:hidden id="error" path="error"></form:hidden>                   		
                      </label>

                      <label for="descripcion" class="linea-medio">
               	  		<span class="label_col1"><spring:message code="page.carta.form.descripcion.label"/><span class="obligatorio" title='${msg["page.common.obligatorio"]}'>*</span></span>
                       	<form:textarea id="descripcion" path="descripcion" class="areatextogrande" maxlength="255"
                       	alt='${msg["page.carta.form.descripcion.title"]}' 
                       	title='${msg["page.carta.form.descripcion.title"]}'></form:textarea>  
                      </label>

                      <label for="activo" class="linea-medio">    
                   		<span class="label_col1"><spring:message code="page.carta.form.texto.label"/></span>
						<form:textarea id="texto" path="texto" class="areatextogrande" maxlength="4000"
                       		alt='${msg["page.carta.form.texto.title"]}' 
                       		title='${msg["page.carta.form.texto.title"]}'></form:textarea>  
                      </label>

                      <label for="defecto" class="linea-medio">    
                   		<span class="label_col1"><spring:message code="page.carta.form.pie.label"/></span>
						<form:textarea id="pie" path="pie" class="areatextogrande" maxlength="4000"
                       		alt='${msg["page.carta.form.pie.title"]}' 
                       		title='${msg["page.carta.form.pie.title"]}'></form:textarea>  
                      </label>
                      
                      <label for="cargo" class="linea-medio">
                   		<span class="label_col1"><spring:message code="page.carta.form.cargo.label"/><span class="obligatorio" title='${msg["page.common.obligatorio"]}'>*</span></span>
               	  		<form:select id="cargo" path="cargo" title='${msg["page.carta.form.cargo.title"]}'>
							<form:options items="${cargosList}" itemValue="code" itemLabel="description" />                       		
           				</form:select>                           
                      </label>
                          
                      <label for="responsable" class="linea-medio">
                   	     <span class="label_col1"><spring:message code="page.carta.form.responsable.label"/><span class="obligatorio" title='${msg["page.common.obligatorio"]}'>*</span></span>
               	  		<form:select id="responsable" path="responsable" title='${msg["page.carta.form.responsable.title"]}'>
							<form:options items="${firmasList}" itemValue="code" itemLabel="description" />                       		
           				</form:select>                       
           			  </label>                          
                                            
                      <br/>
					  
					  <div class="listado-acciones-centrado">
                        <input type="button" id="cancel" 
                          alt='${msg["page.carta.form.cancel.title"]}' 
                          title='${msg["page.carta.form.cancel.title"]}' 
                          value='${msg["page.carta.form.cancel.value"]}' 
                          class="medio"
                          onclick="doReset()"/>
                      	<input type="button" id="save" 
                          alt='${msg["page.carta.form.create.title"]}' 
                          title='${msg["page.carta.form.create.title"]}' 
                          value='${msg["page.carta.form.create.value"]}' 
                          class="medio"
                          onclick="send_form()"/>
                      </div>
                  </fieldset>
               </form:form>
              <!--  END SEARCH FORM FILTER -->
           </div>