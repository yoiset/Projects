<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="form-ext" uri="http://www.springframework.org/tags/form-ext" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/core/static/js/ajax-fileupload.js"></script> 
<script type="text/javascript">

var contextPath = '${pageContext.request.contextPath}';
var idComunidad =  '${beanSession.idComunidad}';
var firtTime=true;
var userGrid=false;

function doReset() {
	if (!confirm('<spring:message code="page.comunidad.confirm.goback"/>')) {
		  return;
	}

// 	location.href = contextPath + "/app/operador/startOperadorJuego";
}

onload = function() {
	initCalendars();
	initCertificados();
	initUsers();
	 if(document.getElementById("comunidadSelected") && firtTime){
// 	    var idComunidadSelected=document.getElementById("comunidadSelected").value;
// 		 alert('idComunidadSelected exist');
		 initComunidad();
		 firtTime=false;		
	 }
	

	var strCertificados = '<%=(session.getAttribute("listaCertificados")==null)?"":session.getAttribute("listaCertificados")%>';
	if (strCertificados!=""){
		writeResponseCertificado(strCertificados);
	}
	
	var strUsers = '<%=(session.getAttribute("listaUsers")==null)?"":session.getAttribute("listaUsers")%>';
	if (strUsers!=""){
		writeResponseUser(strUsers);
	}
	

// 	var strDetalleCertificados = document.getElementById("detalleCertificados").value;
// 	if (strDetalleCertificados!=""){
// 		writeResponseCertificado(strDetalleCertificados);
// 	}
// 	var strDetalleUsers = document.getElementById("detalleUsers").value;
// 	if (strDetalleUsers!=""){
// 		writeResponseUser(strDetalleUsers);
// 	}
	
// 	var strError = document.getElementById("error").value;
// 	if (strError!=""){
// 		alert(strError);
// 	}


};

///////////////////////////////////////////////////////////////////////////////
// Validaciones
function esUser(valor){
    // Patron para la User
    var patronUser=new RegExp("^([0-9]{1,3}).([0-9]{1,3}).([0-9]{1,3}).([0-9]{1,3})$");
    // Si la User consta de 4 pares de números de máximo 3 dígitos
    if(valor.search(patronUser)==0)
    {
        // Validamos si los números no son superiores al valor 255
        valores=valor.split(".");
        if(valores[0]<=255 && valores[1]<=255 && valores[2]<=255 && valores[3]<=255)
        {
            //User correcta
            return true;
        }
    }
	return false;
}

function esEmail(email) {
    var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    if(reg.test(email) == false) {
       return false;
    } else { 
	   return true;
    }
}


function initComunidad(){
	var idComunidad=null;
    if(document.getElementById("comunidadSelected"))
	   idComunidad=document.getElementById("comunidadSelected").value;
	var datos = {
			"idComunidad":idComunidad,
			"userGrid": userGrid,
			 maxResults:10, 
			 firstResult: 0
		     
    	}

     $.ajax({
		    type: "POST",
		    cache: false,
		    url: contextPath + "/app/comunidadAjax/start",
		    data: datos,
		    success: function(msg){
			    
		      if(userGrid==false){
			    	writeResponseCertificado(msg);
			    	limpiarFormularioCertificado();
			    	ocultarFormularioCertificado();
					}else {
// 						alert("Message from Controller: " + msg);
					writeResponseUser(msg);
			    	limpiarFormularioUser();
			    	ocultarFormularioUser();
			    	}	    
			    

		    }
		  });
  
	
}

function changeComunidad(){
	var id=document.getElementById("comunidadSelected").value;

	 
	
	var datos = {
			"idComunidad":id,
			"userGrid": userGrid,
			 maxResults:10, 
			 firstResult: 0
		     
    	}
	 $.ajax({
		    type: "POST",
		    cache: false,
		    url: contextPath + "/app/comunidadAjax/start",
		    data: datos,
		    success: function(msg){

			    if(userGrid==false){
			    	writeResponseCertificado(msg);
			    	limpiarFormularioCertificado();
			    	ocultarFormularioCertificado();
					}else {
					writeResponseUser(msg);
			    	limpiarFormularioUser();
			    	ocultarFormularioUser();
			    	}	    
		    	
		    }
		  });
}

function doTabUser(){
	userGrid=true;
	initComunidad();
}

function doTabCertificate(){
	userGrid=false;
	initComunidad();
}

///////////////////////////////////////////////////////////////////////////////
// Grid de certificados

var certificadosGrid;
var selectedCertificadoId = "";

function initCertificados() {
	var grid = new Listgrid('certificadosId');
	grid.addCol({header:'<spring:message code="page.comunidad.form.activo.label" />', width:50});
	grid.addCol({header:'<spring:message code="page.comunidad.form.fechaDesde.label" />', width:90});
	grid.addCol({header:'<spring:message code="page.comunidad.form.fechaHasta.label" />', width:90});
	grid.addCol({header:'<spring:message code="page.comunidad.form.fechaCarga.label" />', width:90});
	grid.addCol({header:'<spring:message code="page.comunidad.form.hash.label" />', width:200});
	grid.addCol({header:'<spring:message code="page.comunidad.form.sha1.label" />', width:120});
	grid.addCol({header:'<spring:message code="page.comunidad.form.certificado.label" />', width:270});
	grid.addCol({header:' ', width:150, sorting:"na"});
	grid.addCol({header:' ', width:150, sorting:"na"});

	certificadosGrid = grid.createGrid();
	certificadosGrid.hdr.style.height = "40px";
	certificadosGrid.setImagePath(contextPath + "/static/js/codebase/imgs/");
	certificadosGrid.setSkin("evr");
	certificadosGrid.attachEvent("onSelectStateChanged", doOnSelectStateChangedCertificado);
	certificadosGrid.attachEvent("onRowDblClicked", doOnRowDblClicked);
	certificadosGrid.setEditable(false); 
	certificadosGrid.enableMultiselect(false);
	certificadosGrid.setColumnHidden(7,true);
	certificadosGrid.setColumnHidden(8,true);
	certificadosGrid.init(); 
}

function doOnSelectStateChangedCertificado(rowID) {
	selectedCertificadoId = rowID;
}

function doOnRowDblClicked(rowID) {
	selectedCertificadoId = rowID;
	rellenarFormularioCertificado();
}

function writeResponseCertificado(responseText) {

	if (responseText.substring(0,5) == "ERROR" ) {
			alert (responseText.substring(5));
			return;
		}else if (!processResponse(responseText)) {
		    return;
	 }
	 addGridRows(certificadosGrid, responseText, null);     
	
}


function writeResponseCertificado(responseText, type) {
	if (responseText.substring(0,5) == "ERROR" ) {
			alert (responseText.substring(5));
			return;
		}
	if (responseText.substring(0,6) == "NOTIFY" ) {
		var r = confirm(responseText);
         if(r == true){
        	 if(type == 'edit')
                 doEditCertificado(true);
        	 if(type == 'add')
                 doAddCertificado(true);
             }
             
         
		return;
		
	} else if (!processResponse(responseText)) {
		    return;
	 }
	 addGridRows(certificadosGrid, responseText, null); 
     
	
}

function limpiarFormularioCertificado(){
	document.getElementById("certificado").value = "";
	document.getElementById("indActivo").checked = false;
	document.getElementById("fechaCargaCert").value = "";
	document.getElementById("fechaDesdeCert").value = "";
	document.getElementById("fechaHastaCert").value = "";
}

function rellenarFormularioCertificado(){
	var registro =  certificadosGrid.getRowById(selectedCertificadoId);
		
	/* Rellenar campos con los valores adecuados */
	if (registro.cells[0].innerHTML.ltrim()=='1'){
		document.getElementById("indActivo").checked=true;
	} else {
		document.getElementById("indActivo").checked=false;
	}
	document.getElementById("fechaDesdeCert").value = registro.cells[1].innerHTML.ltrim();
	document.getElementById("fechaHastaCert").value = registro.cells[2].innerHTML.ltrim();
	document.getElementById("fechaCargaCert").value = registro.cells[3].innerHTML.ltrim();
	document.getElementById("certificado").value = registro.cells[6].innerHTML.ltrim();
	document.getElementById("hashCert").value = registro.cells[4].innerHTML.ltrim();

	document.getElementById("fingerCompleto").value = registro.cells[7].innerHTML.ltrim();
	document.getElementById("certificadoCompleto").value = registro.cells[8].innerHTML.ltrim();
	document.getElementById("hashCompleto").value =  registro.cells[4].innerHTML.ltrim();
	
	
}

function mostrarAltaCertificado(){
	campoFechaDesde =document.getElementById("fechaDesdeCert");
	campoFechaDesde.disabled="true";
	campoFechaHasta =document.getElementById("fechaHastaCert");
	campoFechaHasta.disabled="true";	
	
	campoCertificado =document.getElementById("certificadoLabel");
	campoCertificado.style.display = "block";	
	
	campoCertificado =document.getElementById("certificado");
	campoCertificado.style.display = "block";	
	campoCertificado.disabled="";

	capaNuevoCertificado =document.getElementById("nuevoCertificado");
	capaNuevoCertificado.style.display = "";
	botonesNuevoCertificado =document.getElementById("addCertificadoButtons");
	botonesNuevoCertificado.style.display = "";
	botonesEditarCertificado =document.getElementById("editCertificadoButtons");
	botonesEditarCertificado.style.display = "none";	
	 document.getElementById("fileToUpload").style.visibility = 'visible';

	 campoCertificadoCompleto =document.getElementById("certificadoCompletoLabel");
	 campoCertificadoCompleto.style.display = "none";	

     fingerCompleto =document.getElementById("fingerCompletoLabel");
	 fingerCompleto.style.display = "none";

	 hashCompletoLabel =document.getElementById("hashCompletoLabel");
	 hashCompletoLabel.style.display = "none";		

	 fechaCargaCert =document.getElementById("fechaCargaCert");
     fechaCargaCert.disabled="";

	indActivo =document.getElementById("indActivo");
	indActivo.disabled="";

}

function mostrarEditarCertificado(){
	campoFechaDesde =document.getElementById("fechaDesdeCert");
	campoFechaDesde.disabled="true";
	campoFechaHasta =document.getElementById("fechaHastaCert");
	campoFechaHasta.disabled="true";

	campoCertificado =document.getElementById("certificadoLabel");
	campoCertificado.style.display = "block";	
	
	campoCertificado =document.getElementById("certificado");
	campoCertificado.style.display = "block";	
	campoCertificado.disabled="true";
	capaNuevoCertificado =document.getElementById("nuevoCertificado");
	capaNuevoCertificado.style.display = "";
	botonesNuevoCertificado =document.getElementById("addCertificadoButtons");
	botonesNuevoCertificado.style.display = "none";
	botonesEditarCertificado =document.getElementById("editCertificadoButtons");
	botonesEditarCertificado.style.display = "";	
    document.getElementById("fileToUpload").style.visibility = 'hidden';

    campoCertificadoCompleto =document.getElementById("certificadoCompletoLabel");
	campoCertificadoCompleto.style.display = "none";	

	fingerCompleto =document.getElementById("fingerCompletoLabel");
	fingerCompleto.style.display = "none";

	hashCompletoLabel =document.getElementById("hashCompletoLabel");
	 hashCompletoLabel.style.display = "none";		

	fechaCargaCert =document.getElementById("fechaCargaCert");
	fechaCargaCert.disabled="";

	indActivo =document.getElementById("indActivo");
	indActivo.disabled="";

}

function ocultarFormularioCertificado(){
	capaNuevoParametro =document.getElementById("nuevoCertificado");
	capaNuevoParametro.style.display = "none";
	botonesNuevoParametro =document.getElementById("addCertificadoButtons");
	botonesNuevoParametro.style.display = "none";
	botonesEditarParametro =document.getElementById("editCertificadoButtons");
	botonesEditarParametro.style.display = "none";	

	botonesEditarParametro =document.getElementById("verCertificadoButtons");
	botonesEditarParametro.style.display = "none";	
}


function mostrarVerCertificado(){
	campoFechaDesde =document.getElementById("fechaDesdeCert");
	campoFechaDesde.disabled="true";
	campoFechaHasta =document.getElementById("fechaHastaCert");
	campoFechaHasta.disabled="true";
	
	campoCertificado =document.getElementById("certificadoLabel");
	campoCertificado.style.display = "none";	

	campoCertificadoCompleto =document.getElementById("certificadoCompletoLabel");
	campoCertificadoCompleto.style.display = "block";	
// 	campoCertificadoCompleto.disabled="true";

	fingerCompleto =document.getElementById("fingerCompletoLabel");
	fingerCompleto.style.display = "block";	

	hashCompletoLabel =document.getElementById("hashCompletoLabel");
	 hashCompletoLabel.style.display = "block";
	
// 	fingerCompleto.disabled="true";
	
	capaNuevoCertificado =document.getElementById("nuevoCertificado");
	capaNuevoCertificado.style.display = "";
	botonesNuevoCertificado =document.getElementById("addCertificadoButtons");
	botonesNuevoCertificado.style.display = "none";
	botonesEditarCertificado =document.getElementById("editCertificadoButtons");
	botonesEditarCertificado.style.display = "none";	
    document.getElementById("fileToUpload").style.visibility = 'hidden';

    verButton =document.getElementById("verCertificadoButtons");
    verButton.style.display = "block";	

	fechaCargaCert =document.getElementById("fechaCargaCert");
	fechaCargaCert.disabled="true";

	indActivo =document.getElementById("indActivo");
	indActivo.disabled="true"; 
    
}

function openAddCertificado(){
	/* Mostrar y ocultar capas */
// 	alert('dentro');
	ocultarFormularioCertificado();
	limpiarFormularioCertificado();
	mostrarAltaCertificado();
}

function openVerCertificado(){
	if (selectedCertificadoId == "") {  
	    alert('Debe seleccionar un Certificado');
	    return;
	} 
	ocultarFormularioCertificado();
	limpiarFormularioCertificado();
	rellenarFormularioCertificado();
	mostrarVerCertificado();
}

function openEditCertificado(){
	if (selectedCertificadoId == "") {  
	    alert('Debe seleccionar un Certificado');
	    return;
	} 

	ocultarFormularioCertificado();
	rellenarFormularioCertificado();
	mostrarEditarCertificado();
}

function cancelAddCertificado(){
	ocultarFormularioCertificado();
}

function cancelVerCertificado(){
	ocultarFormularioCertificado();
}

function doAddCertificado(notify) {
	var idComunidad = document.getElementById("comunidadSelected").value;
	if (idComunidad == "" || idComunidad==null) {
	    alert('ID Comunidad Null');
	    return;
	} 

	
	var certificado = document.getElementById("certificado").value;

	if (certificado == "") {
	    alert('<spring:message code="page.comunidad.certificado.alert.mandatoryCertificado" />');
	    return;
	}
	if (certificado.substring(0, 27)!="-----BEGIN CERTIFICATE-----"){
		alert("El certificado debe comenzar por -----BEGIN CERTIFICATE-----");
		return;
	}


	var fechaCargaCert = document.getElementById("fechaCargaCert").value;

	var indActivo = document.getElementById("indActivo").checked;

	var idComunidadEdit =idComunidad; 
	if(document.getElementById("comunidadSelected")){
		idComunidadEdit = document.getElementById("comunidadSelected").value;
	}

    var datosCertificado = {
    		"idComunidad":idComunidadEdit,
    		"certificado":certificado,
    		"indActivo":indActivo,
    	    "fechaCargaCert":fechaCargaCert,
    	    "notify" :notify,
    	    "userGrid": false,
    	     maxResults:10, 
			 firstResult: 0
    	    
    	}


	
	$.ajax({
		    type: "POST",
		    cache: false,
		    url: contextPath + "/app/comunidadAjax/newCertificate",
		    data: datosCertificado,
		    success: function(msg){
		    	writeResponseCertificado(msg,'add');
		    	limpiarFormularioCertificado();
		    	ocultarFormularioCertificado();
		    }
		  });
}

function doEditCertificado(notify) {
// 	var idComunidad = document.getElementById("comunidadSelected").value;
	if (selectedCertificadoId == "") {  
	    alert('Debe seleccionar un Certificado');
	    return;
	} 

	var fechaCargaCert = document.getElementById("fechaCargaCert").value;
	var indActivo = document.getElementById("indActivo").checked;
	var hash= document.getElementById("hashCert").value;

	var idComunidadEdit =idComunidad; 
	if(document.getElementById("comunidadSelected")){
		idComunidadEdit = document.getElementById("comunidadSelected").value;
	}
	
	
    var datosCertificado = {
    		"idComunidad":idComunidadEdit,
    		"hash":  hash,
    		"indActivo":indActivo,
    	    "fechaCargaCert":fechaCargaCert,
    	    "notify" :notify,
    	    "userGrid": false,
    	     maxResults:10, 
			 firstResult: 0
    	}
	
	$.ajax({
		    type: "POST",
		    cache: false,
		    url: contextPath + "/app/comunidadAjax/editCertificate",
		    data: datosCertificado,
		    success: function(msg){
		    	writeResponseCertificado(msg, 'edit');
		    	limpiarFormularioCertificado();
		    	ocultarFormularioCertificado();
		    }
		  });
}

function doDeleteCertificado() {
	if (selectedCertificadoId == "") {
	  alert('Debe seleccionar un Certificado');
	  return;
	}
	if (!confirm('<spring:message code="page.comunidad.confirm.deleteCertificado"/>')) {
	  return;
	}
	var hash=  certificadosGrid.getRowById(selectedCertificadoId).cells[4].innerHTML.ltrim();
	var idComunidadEdit =idComunidad; 
	if(document.getElementById("comunidadSelected")){
		idComunidadEdit = document.getElementById("comunidadSelected").value;
	}
	var datosCertificado = {
	    		"idComunidad":idComunidadEdit,
	    		"hash":  hash,
	    		"userGrid": false,
	    	     maxResults:10, 
				 firstResult: 0
	    	}

	 $.ajax({
		    type: "POST",
		    cache: false,
		    url: contextPath + "/app/comunidadAjax/removeCertificate",
		    data: datosCertificado,
		    success: function(msg){
		    	writeResponseCertificado(msg);
		    	limpiarFormularioCertificado();
		    	ocultarFormularioCertificado();	    	
		    }
		  });
}

///////////////////////////////////////////////////////////////////////////////
//Grid de Users

var UsersGrid;
var selectedUserId = "";

function initUsers() {
	var grid = new Listgrid('UsersId');
	grid.addCol({header:'<spring:message code="page.comunidad.form.usuarioActivo.label" />', width:50});
	grid.addCol({header:'<spring:message code="page.comunidad.form.usuario.label" />', width:150});
	grid.addCol({header:'<spring:message code="page.comunidad.form.usuarioDescripcion.label" />', width:600});
	grid.addCol({header:' ', width:150, sorting:"na"});
// 	grid.addHiddenCol({header:'', width:35});
	
	UsersGrid = grid.createGrid();
	UsersGrid.hdr.style.height = "40px";
	UsersGrid.setImagePath(contextPath + "/static/js/codebase/imgs/");
	UsersGrid.setSkin("evr");
	UsersGrid.attachEvent("onSelectStateChanged", doOnSelectStateChangedUser);
	UsersGrid.attachEvent("onRowDblClicked", doOnRowDblClickedUser);
	UsersGrid.setEditable(false); 
	UsersGrid.enableMultiselect(false);
	UsersGrid.setColumnHidden(3,true);
	UsersGrid.init(); 
}


function doOnSelectStateChangedUser(rowID) {
	selectedUserId = rowID;
}

function doOnRowDblClickedUser(rowID) {
	selectedUserId = rowID;
	rellenarFormularioUser();
}

function writeResponseUser(responseText) {
// 	alert('responseText: ' + responseText);
	if (responseText.substring(0,5) == "ERROR" ) {
		alert (responseText.substring(5));
		return;
	} else if (!processResponse(responseText)) {
	    return;
	}
// 	alert("respontext Value: " + responseText);
	addGridRows(UsersGrid, responseText, null); 
}


function limpiarFormularioUser(){
	document.getElementById("userName").value = "";
	document.getElementById("userDescription").value = "";
	document.getElementById("userActivo").checked =false;
}

function rellenarFormularioUser(){
	var registro =  UsersGrid.getRowById(selectedUserId);

	
	/* Rellenar campos con los valores adecuados */
	document.getElementById("userName").value = registro.cells[1].innerHTML.ltrim();
	document.getElementById("userDescription").value = registro.cells[2].innerHTML.ltrim();
	if(registro.cells[0].innerHTML.ltrim()=='1')
		document.getElementById("userActivo").checked =true;
	else document.getElementById("userActivo").checked =false;


// 	alert('selecteduserId '+ selectedUserId );
}

function mostrarAltaUser(){
	campoUser =document.getElementById("userName");
	campoUser.disabled="";
	capaNuevaUser =document.getElementById("nuevaUser");
	capaNuevaUser.style.display = "";
	botonesNuevaUser =document.getElementById("addUserButtons");
	botonesNuevaUser.style.display = "";
	botonesEditarUser =document.getElementById("editUserButtons");
	botonesEditarUser.style.display = "none";	
}

function mostrarEditarUser(){
	campoUser =document.getElementById("userName");
	campoUser.disabled="true";	
	capaNuevaUser =document.getElementById("nuevaUser");
	capaNuevaUser.style.display = "";
	botonesNuevaUser =document.getElementById("addUserButtons");
	botonesNuevaUser.style.display = "none";
	botonesEditarUser =document.getElementById("editUserButtons");
	botonesEditarUser.style.display = "";	
}

function ocultarFormularioUser(){
	capaNuevaUser =document.getElementById("nuevaUser");
	capaNuevaUser.style.display = "none";
	botonesNuevaUser =document.getElementById("addUserButtons");
	botonesNuevaUser.style.display = "none";
	botonesEditarUser =document.getElementById("editUserButtons");
	botonesEditarUser.style.display = "none";	
}

function openAddUser(){
	/* Mostrar y ocultar capas */
	ocultarFormularioUser();
	limpiarFormularioUser();
	mostrarAltaUser();
}

function openEditUser(){
	if (selectedUserId == "") {
		alert('Debe seleccionar un Usuario'); 
		return;
	}

	ocultarFormularioUser();
	rellenarFormularioUser();
	mostrarEditarUser();
}

function cancelAddUser(){
	ocultarFormularioUser();
}

function doAddUser() {
	var idComunidad = document.getElementById("comunidadSelected").value;
	var userName = document.getElementById("userName").value;
	if (userName == "") {
	    alert('Debe poner el usuario');
	    return;
	}
	
	var userDescription = document.getElementById("userDescription").value;
	if (userDescription == "") {
		 alert('Debe poner una Descripción');
	    return;
	}
	var userActivo = document.getElementById("userActivo").checked;

    var datosUser = {
    	    "idComunidad":idComunidad, 
    		"userName":userName,
    	    "userDescription":userDescription,
    	    "indActivo":userActivo,
    	    "userGrid": true,
    	     maxResults:10, 
			 firstResult: 0
    	}


	
	$.ajax({
		    type: "POST",
		    cache: false,
		    url: contextPath + "/app/comunidadAjax/newUser",
		    data: datosUser,
		    success: function(msg){
		    	writeResponseUser(msg);
		    	limpiarFormularioUser();
		    	ocultarFormularioUser();
		    }
		  });
} 

function doEditUser() { 
	if (selectedUserId == "") {
		alert('Debe seleccionar un Usuario'); 
		return;
	}
	
	var userDescription = document.getElementById("userDescription").value;
	if (userDescription == "") {
	    alert('Debe poner una Descripción');
	    return;
	}
	var idComunidad = document.getElementById("comunidadSelected").value;
	var userActivo = document.getElementById("userActivo").checked;    
	var userName = document.getElementById("userName").value;	
    var datosUser = {
    		 "idComunidad":idComunidad, 
    	    "id":selectedUserId,
    		"userName":userName,
    		"userDescription":userDescription,
    	    "indActivo":userActivo,
    	    "userGrid": true,
    	    maxResults:10, 
			 firstResult: 0
    	}
	
	$.ajax({
		    type: "POST",
		    cache: false,
		    url: contextPath + "/app/comunidadAjax/editUser",
		    data: datosUser,
		    success: function(msg){
		    	writeResponseUser(msg);
		    	limpiarFormularioUser();
		    	ocultarFormularioUser();
		    }
		  });
}

function doDeleteUser() {
	if (selectedUserId == "") {
	  alert('Debe seleccionar un Usuario');
	  return;
	}
	if (!confirm('<spring:message code="page.comunidad.confirm.deleteUser"/>')) {
	  return;
	}
	var idComunidad = document.getElementById("comunidadSelected").value;
	var datosUser = {
			"idComunidad":idComunidad, 
    	    "id":selectedUserId,
    		"userGrid": true,
    		 maxResults:10, 
			 firstResult: 0
    	}

	 $.ajax({
		    type: "POST",
		    cache: false,
		    url: contextPath + "/app/comunidadAjax/removeUser",
		    data: datosUser,
		    success: function(msg){
		    	writeResponseUser(msg);
		    	limpiarFormularioUser();
		    	ocultarFormularioUser();
		    }
		  });
}



function initCalendars() {
	  var calendars1 = new dhtmlXCalendarObject(["fechaInscripcion","fechaDesdeCert","fechaHastaCert"]);
	  calendars1.setSkin("evr");
	  calendars1.setDateFormat('<spring:message code="common.dateFormat"/>'.replace("dd","%d").replace("MM","%m").replace("yyyy","%Y"));
	  calendars1.loadUserLanguage("${userLang}");
	  calendars1.setWeekStartDay(<spring:message code="common.weekStartDate"/>);
	  /*calendars.setSensitiveRange(null, "${sensitiveRangeMax}");*/
	  calendars1.setSensitiveRange(null, null);
	  calendars1.hideTime();

	  var calendars2 = new dhtmlXCalendarObject(["fechaCargaCert"]); 
	  calendars2.setSkin("evr");
	  calendars2.setDateFormat('<spring:message code="common.dateTimeFormat"/>'.replace("dd","%d").replace("MM","%m").replace("yyyy","%Y").replace("HH","%H").replace("mm","%i"));
//       calendars2.setDateFormat('<spring:message code="common.dateFormat"/>'.replace("dd","%d").replace("MM","%m").replace("yyyy","%Y"));
	  calendars2.loadUserLanguage("${userLang}");
	  calendars2.setWeekStartDay('<spring:message code="common.weekStartDate"/>');
// 	  calendars2.setSensitiveRange("${sensitiveRangeMax}",null);  
	  calendars2.showTime();

}

String.prototype.ltrim = function() {
	return this.replace(/^\s+/,"").replace(/&nbsp;/g,"");
}

function esFechaValida(fechaDesde, fechaHasta){
	var firstValue = fechaDesde.split('/');
	var dia = firstValue[0];
	var mes = firstValue[1] - 1;
	var anioAux = firstValue[2].split(' ');
	var anio = anioAux[0];
	var firstDate=new Date();
	firstDate.setFullYear(anio,mes,dia);
	 
	var secondValue = fechaHasta.split('/');
	var dia = secondValue[0];
	var mes = secondValue[1] - 1;
	var anioAux = secondValue[2].split(' ');
	var anio = anioAux[0];
	var secondDate=new Date();
	
	secondDate.setFullYear(anio,mes,dia);     

	if (firstDate > secondDate)
	{
		return false;
	}
	else
	{
		return true;
	}
}


function doAttachCertificado(){
	$.ajaxFileUpload({
		url: contextPath + "/app/comunidadAjax/addFicheroCertificado",
		secureuri:false,
		fileElementId:'fileToUpload',
		dataType: 'json',
		success: function (data, status){
			if (data!="") {
// 				  alert("Value data: " + data); 
				  var bean = JSON.parse(data);
// 				  alert("JSOn Bean: " + bean); 
				document.getElementById("certificado").value =  bean["certificado"];
				document.getElementById("fechaDesdeCert").value = bean["fechaIni"];
				document.getElementById("fechaHastaCert").value = bean["fechaFin"];
	    	}
		},
		error: function (data, status, e){
			if (data!="") {
				alert("Error al adjuntar archivo de certificado, inserte el texto del certificado manualmente");
			} 
		}
	});
}

function resetID(){
	selectedUserId="";
	selectedCertificadoId="";
}


function doExport(exportType) {
// 	alert("Report Type: " + exportType);
	var queryString = $('#saveForm').formSerialize();
	location.href = contextPath + "/app/comunidad/exportComunidad?" + "exportType=" + exportType;//+ queryString + "&sortingFlag=" + pendingPaginator.sortingFlag + "&fieldName=" + pendingPaginator.fieldName + "&order=" + pendingPaginator.order;
	document.getElementById("viewExportId").value = "Exportar";
}

///////////////////////////////////////////////////////////////////////////////

</script>

 <div class="breadcrumb" id="breadCCAA">
			     <ul class="breadcrumb">
					 <li> <a style="font-size: 12 px;"> Comunidad Autónoma Asignada: </a></li>
					  <li><a class="active">${beanSession.descripcionComunidad} </a>  </li>
			     </ul>        		       
 </div>

 <div id="formulcuad">  
              <!-- BEGIN SEARCH FORM FILTER -->
              
		      
              <form:form id="saveForm" action="${pageContext.request.contextPath}/app/comunidad/start"
              	modelAttribute="${modelAttribute}">
                    
                    <!-- BREADCRUM    -->
					<div class="breadcrumb">
					  <span class="left"></span>
					  <ul class="breadcrumb">
						<li><a href="${pageContext.request.contextPath}"><spring:message code="page.breadcrumb.home"/></a></li>
					    <li><a href="${pageContext.request.contextPath}/app/comunidad/start" class="active"><spring:message code="page.breadcrumb.comunidadJuego"/></a></li>
<%-- 					    <li><a href="#" class="active"><spring:message code="page.comunidad.li.edit.title"/></a></li> --%>
					  </ul>
					  <span class="right"></span>
					</div>
					<!-- FIN BREADCRUM -->

					<div class="listado">
						<div class="encabezado">
				  			<label for="usuario">  					
								<span class="label">
				 					<spring:message code="page.breadcrumb.editComunidad"/>										
								</span>
				 			</label>  								
						</div>		
					</div>

                  	<fieldset>
<%--                         <sec:authorize  ifAnyGranted="ESTA-GEST_MENU">  --%>
                        <c:if test="${beanSession.nac == true}">

	                      <label for="comunidadSelected" class="linea-medio">
	                    	<span class="label_col1"><spring:message code="page.historico.seleccion.comunidad"/></span>
	                       	<form:select id="comunidadSelected" path="comunidadCode" title='${msg["page.comunidad.form.list.title"]}' onchange="changeComunidad()">
								<form:options items="${listComunidad}" itemValue="idComunidad" itemLabel="descripcion" />
	                       	</form:select>                      	
	                      </label>
	                       <br/>
<%--                       </sec:authorize> --%>
                      </c:if>
                      
                      <c:if test="${beanSession.nac == false}">
                            <input type="hidden" id="comunidadSelected" value="${idComunidad}"/>
                      </c:if>
                      
                        <div class="listado-acciones-derecha">
<!-- 		                      <label for="viewExportId" class="linea-medio linea-dosExport">  -->
			                      <select id="viewExportId" name="exportType"
			                          		title='<spring:message code="page.actions.exportxls.title"/>' class="export" 
			                          		onchange="doExport(this.value)"><option value="Exportar"><spring:message code="page.actions.exportxls.title"/></option>
			                           			<option value="XLS">Excel</option>
			                           			<option value="PDF">PDF</option>
			                           			<option value="DOCX">DOC</option>
			                       </select>	
<!-- 			                   </label>   -->
			                   
			            </div>    
					  <fieldset>        
<%-- 					  	<legend><spring:message code="page.comunidad.header.moreInformation"/></legend>               --%>
	                      <!-- MÓDULO DE PESTAÑAS -->
			              <div class="mod-pestanas modulo">
			                  <ul class="pestanas">
			                    <li class="item_tab seleccionado" onclick="doTabCertificate()">
			                      <span>
			                          <a href="javascript:resetID();" class="lnk_mod_tabs act" 
			                            title='${msg["page.comunidad.tab.certificado.label"]}'><spring:message code="page.comunidad.tab.certificado.label"/></a>
			                      </span>
			                    </li>
			                    <li class="item_tab" onclick="doTabUser()">
			                      <span>
			                          <a href="javascript:resetID();" class="lnk_mod_tabs dir" 
			                            title='${msg["page.comunidad.tab.usuario.label"]}'><spring:message code="page.comunidad.tab.usuario.label"/></a>
			                      </span>
			                    </li>
<!-- 			                    <li class="item_tab"> -->
<!-- 			                      <span> -->
<!-- 			                          <a href="javascript:void(0);" class="lnk_mod_tabs dir"  -->
<%-- 			                            title='${msg["page.operadorJuego.tab.email.title"]}'><spring:message code="page.operadorJuego.tab.email.label"/></a> --%>
<!-- 			                      </span> -->
<!-- 			                    </li> -->
			                  </ul>
			                  
			                  <!-- MÓDULO CON PESTAÑAS -->
						      <div class="tabs">
									<ul>
										<li class="tab">
											<div class="listado-acciones-derecha  acciones-tab">
											
											  <a id="verCertificadoId" href="javascript:openVerCertificado()"
													title='${msg["page.comunidad.certificado.ver.title"]}'
													class="medio"><spring:message
														code="page.comunidad.certificado.ver.title" /></a>
														
												<a id="addCertificadoId" href="javascript:openAddCertificado()"
													title='${msg["page.comunidad.certificado.add.title"]}'
													class="medio"><spring:message
														code="page.comunidad.certificado.add.title" /></a> <a
													id="editCertificadoId" href="javascript:openEditCertificado()"
													title='${msg["page.comunidad.certificado.edit.title"]}'
													class="medio"><spring:message
														code="page.comunidad.certificado.edit.title" /></a> <a
													id="deleteCertificadoId"
													href="javascript:doDeleteCertificado()"
													title='${msg["page.comunidad.certificado.delete.title"]}'
													class="medio"><spring:message
														code="page.comunidad.certificado.delete.title" /></a>
											</div>

											<div id="certificadosId" style="width: 850px; height: 180px;">
												<!-- ListGrid certificados -->
											</div>

											<div id="nuevoCertificado" style="display: none;"  class="capaOperacionTab">
												<fieldset>
												<input type="hidden" id="hashCert"/>
												
												 <label id="certificadoLabel" for="certificado" class="linea-largo">
														<span class="label_col1"><spring:message code="page.comunidad.form.certificado.label" /><span class="obligatorio" title='${msg["page.common.obligatorio"]}'>&nbsp;&nbsp;*</span>
														</span> 
														<input id="fileToUpload" class="ficheroCertificado" type="file" size="45" name="fileToUpload" onchange="javascript:doAttachCertificado()">
														<textarea id="certificado" cssClass="areatexto"	title='${msg["page.comunidad.form.certificado.label"]}'  style="width: 711px; height: 62px;"></textarea>
												 </label>
												 
												  <label id="certificadoCompletoLabel" for="certificadoCompleto" class="linea-largo">   
													 <span class="label_col1"><spring:message code="page.comunidad.form.certificado.label" />	</span> 
													 <textarea id="certificadoCompleto" cssClass="areatexto"	title='${msg["page.comunidad.form.certificado.label"]}'  style="width: 711px; height: 320px; display: block;" readonly="readonly"></textarea>
												 </label>
												 
												 <label id="fingerCompletoLabel" for="fingerCompleto" class="linea-medio">
												   <span class="label_col1"><spring:message code="page.comunidad.form.sha1.label" />	</span> 
												   <textarea id="fingerCompleto" cssClass="areatexto"	title='${msg["page.comunidad.form.sha1.label"]}'  style="width: 411px; height: 32px; display: block;" readonly="readonly"></textarea>
												 </label>
												 
												 <label id="hashCompletoLabel" for="hashCompleto" class="linea-medio">
												   <span class="label_col1"><spring:message code="page.comunidad.form.hash.label" />	</span> 
												   <textarea id="hashCompleto" cssClass="areatexto"	title='${msg["page.comunidad.form.hash.label"]}'  style="width: 311px; height: 32px; display: block;" readonly="readonly"></textarea>
												 </label>
												
<!-- 													<label id="certificadoLabel" for="certificado" class="linea-largo"> -->
<%-- 														<span class="label_col1"><spring:message code="page.comunidad.form.certificado.label" /><span class="obligatorio" title='${msg["page.common.obligatorio"]}'>&nbsp;&nbsp;*</span></span>  --%>
<%-- 														<textarea id="certificado" cssClass="areatexto"	title='${msg["page.comunidad.form.certificado.label"]}'  style="width: 711px; height: 62px;"></textarea> --%>
<!-- 													</label>  -->
													
                                                    <label id="fechaDesdeCertLabel" for="fechaDesdeCert" class="linea-medio"> 
														<span class="label_col1"><spring:message code="page.comunidad.form.fechaDesde.label" /></span> 
														<input type="text" contenteditable="false" id="fechaDesdeCert" title='${msg["page.comunidad.form.fechaDesde.label"]}'></input>
													</label>
													<label for="fechaHastaCert" class="linea-medio"> 
														<span class="label_col1"><spring:message code="page.comunidad.form.fechaHasta.label" /></span> 
														<input type="text" contenteditable="false" id="fechaHastaCert" title='${msg["page.comunidad.form.fechaHasta.label"]}'></input>
													</label>
													
													<label id="fechaCargaCertLabel" for="fechaCargaCert" class="linea-medio"> 
														<span class="label_col1"><spring:message code="page.comunidad.form.fechaCarga.label" /></span> 
														<input type="text" id="fechaCargaCert" title='${msg["page.comunidad.form.fechaCarga.label"]}'></input>
													</label>
													
                      								<label id="indActivoLabel"  for="indActivo" class="linea-medio">
                   										<span class="label_col1"><spring:message code="page.comunidad.form.activo.label"/><span class="obligatorio" title='${msg["page.common.obligatorio"]}'></span></span>
														<input type="checkbox" id="indActivo" title='${msg["page.comunidad.form.activo.label"]}'  class="checkbox"/>
                      								</label>													
													<div class="listado-acciones-derecha"
														id="addCertificadoButtons" style="display: none;">

														<a id="cancelCertificado"
															href="javascript:cancelAddCertificado()"
															title='${msg["page.comunidad.form.cancel.title"]}'
															class="medio"><spring:message
																code="page.comunidad.form.cancel.value" /></a>
														<a id="saveCertificado" href="javascript:doAddCertificado(false)"
															title='${msg["page.comunidad.form.create.title"]}'
															class="medio"><spring:message
																code="page.comunidad.form.create.value" /></a> 
													</div>
													<div class="listado-acciones-derecha"  
														id="editCertificadoButtons" style="display: none;">
														<a id="cancelCertificado"
															href="javascript:cancelAddCertificado()"
															title='${msg["page.comunidad.form.cancel.title"]}'
															class="medio"><spring:message
																code="page.comunidad.form.cancel.value" /></a>
														<a id="saveCertificado" href="javascript:doEditCertificado(false)"
															title='${msg["page.comunidad.form.create.title"]}'
															class="medio"><spring:message
																code="page.comunidad.form.create.value" /></a> 
													</div>
													
													<div class="listado-acciones-derecha"  
														id="verCertificadoButtons" style="display: none;">
														<a id="cancelCertificado"
															href="javascript:cancelVerCertificado()"
															title='${msg["page.comunidad.form.cancel.title"]}'
															class="medio"><spring:message
																code="page.comunidad.form.cancel.value" /></a>
													</div>
												</fieldset>
											</div>
										</li>
										<li class="tab">
											<div class="listado-acciones-derecha acciones-tab">
												 <a id="addUserId" href="javascript:openAddUser()"
												    title='${msg["page.comunidad.usuario.add.title"]}' class="medio">
												    <spring:message code="page.comunidad.usuario.add.title" /></a>
												 <a id="editUserId" href="javascript:openEditUser()"
												    title='${msg["page.comunidad.usuario.edit.title"]}' class="medio">
												    <spring:message code="page.comunidad.usuario.edit.title" /></a> 
												 <a id="deleteUserId" href="javascript:doDeleteUser()"
												    title='${msg["page.comunidad.usuario.delete.title"]}' class="medio">
												    <spring:message code="page.comunidad.usuario.delete.title" /></a>
											</div>

											<div id="UsersId" style="width: 850px; height: 180px;">
												<!-- ListGrid Users -->
											</div>

											<div id="nuevaUser" style="display: none;" class="capaOperacionTab">
												<fieldset>
			
													<label id="UserLabel" for="userName" class="linea-medio"> <span
														class="label_col1"><spring:message
																code="page.comunidad.form.usuario.label" /><span class="obligatorio" title='${msg["page.common.obligatorio"]}'>*</span></span> 
														
														<input type="text" id="userName" maxlength="20"	title='${msg["page.comunidad.form.usuario.label"]}'></input>
													</label>
													 
													<label for="userDescription" class="linea-medio"> <span
														class="label_col1"><spring:message
																code="page.comunidad.form.usuarioDescripcion.label" /><span class="obligatorio" title='${msg["page.common.obligatorio"]}'>*</span></span> 
																<textarea type="text" id="userDescription" cssClass="areatexto" style="width: 340px;height: 50px;"
														title='${msg["page.comunidad.form.usuarioDescripcion.label"]}'></textarea>
													</label> 
													
													
													<label for="userActivo" class="linea-medio"> 
														<span class="label_col1"><spring:message code="page.comunidad.form.usuarioActivo.label" /></span>
														<input type="checkbox" id="userActivo" class="checkbox" title='${msg["page.comunidad.form.usuarioActivo.label"]}'/>
													</label>
													<input type="hidden" id="userId"/>

													<div class="listado-acciones-derecha" id="addUserButtons" style="display: none;">
														<a id="cancelUser" href="javascript:cancelAddUser()"
															title='${msg["page.comunidad.form.cancel.title"]}' class="medio">
															<spring:message code="page.comunidad.form.cancel.value" /></a>
														<a id="saveUser" href="javascript:doAddUser()"
															title='${msg["page.comunidad.form.create.title"]}' class="medio">
															<spring:message code="page.comunidad.form.create.value" /></a> 
													</div>
			
													<div class="listado-acciones-derecha" id="editUserButtons" style="display: none;">
														<a id="cancelUser" href="javascript:cancelAddUser()"
															title='${msg["page.comunidad.form.cancel.title"]}'
															class="medio">
															<spring:message code="page.comunidad.form.cancel.value" /></a>
														<a id="saveUser" href="javascript:doEditUser()"
															title='${msg["page.comunidad.form.create.title"]}'
															class="medio">
															<spring:message code="page.comunidad.form.create.value" /></a> 
													</div>
												</fieldset>
											</div>
										</li>
										
									</ul>
								</div>
                      		</div>
                      </fieldset>
<!-- 					  <div class="listado-acciones-centrado"> -->
<!--                         <input type="button" id="cancel"  -->
<%--                           alt='${msg["page.comunidad.form.cancel.title"]}'  --%>
<%--                           title='${msg["page.comunidad.form.cancel.title"]}'  --%>
<%--                           value='${msg["page.comunidad.form.cancel.value"]}'  --%>
<!--                           class="medio" -->
<!--                           onclick="doReset()"/> -->
<!--                       	<input type="button" id="save"  -->
<%--                           alt='${msg["page.comunidad.form.create.title"]}'  --%>
<%--                           title='${msg["page.comunidad.form.create.title"]}'  --%>
<%--                           value='${msg["page.comunidad.form.create.value"]}'  --%>
<!--                           class="medio" -->
<!--                           onclick="send_form()"/> -->
<!--                       </div> -->
                  </fieldset>
               </form:form>
              <!--  END SEARCH FORM FILTER -->
           </div>