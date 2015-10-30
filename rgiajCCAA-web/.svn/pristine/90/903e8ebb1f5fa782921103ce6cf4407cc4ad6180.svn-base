function setOptions(selectId, content) {

	//First reset current options, and then add new options
    removeOptions(selectId);

    addOptions(selectId, content);
}

function removeOptions(selectId) {

    var selObj = document.getElementById(selectId);

    //Resets select, except first option
    while (selObj.options.length > 1) {
    	selObj.options[1] = null;
    }
}

function addOptions(selectId, content) {

    var selObj = document.getElementById(selectId);
    
    //Use SelectOptionsBean attributes
    var selBean = JSON.parse(content);
    
    //Writes options in select object
    var options = selBean["options"];
    for ( var j = 0; j < options.length; j++) {
		var value = options[j]["value"];
		var text = options[j]["text"];
		var opt = new Option(text, value);
		selObj.options[selObj.options.length] = opt;
	}
}

//(es)Pre-procesa la peticion, limpiando el mensaje de una peticion anterior.
function processRequest() {
	
	// Borramos errores
	var doc = document.getElementById('MenssageErrorAjax');
	doc.innerHTML = '';
	
	// Borramos validaciones
	var elements = document.getElementsByTagName('span');
	for (var i=0; i<elements.length; i++){
		var objElements = elements[i];
		var text = objElements.id;
		if (text != null && text != "" && text.indexOf("msgErrors") != -1) {
			objElements.innerHTML = '';
			objElements.style.visibility="hidden";
		}		
	}
	return true;
}

//(es)Pre-procesa el resultado de un ajax request. Retorna true si no trae error
function processResponse(response) {
	if (response.length > 0) {
		// Comprobacion de error
		var len = "error:".length;
		if (response.length > len && response.substring(0, len) == "error:") {
			var doc = document.getElementById('MenssageErrorAjax');
			doc.innerHTML = '<div id="error"><ul id="ulError"><li><span id="textMessage" class="errorMessage">' + response.substring(len, response.length) + '</span></li></ul></div>';
			return false;
		} 
		// Comprobacion de validaciones
		var lenVal = "Validate:".length;
		if (response.length > lenVal && response.substring(0, lenVal) == "Validate:") {
			var errors = JSON.parse(response.substring(lenVal, response.length));
			for(var j=0; j<errors.length; j++) {
				var name = errors[j]["name"];
				var value = errors[j]["value"];
				var divId = document.getElementById(name);
				if (divId == null) { // Mensaje zona superior
					var doc = document.getElementById('MenssageErrorAjax');
					doc.innerHTML = '<div id="error"><ul id="ulError"><li><span id="textMessage" class="errorMessage">' + value + '</span></li></ul></div>';
				} else { // Mensaje zona campo
					divId.innerHTML = value;
					divId.style.visibility="visible";
				}
			}
			return false;
		}
	}

	return true;
}

function errorValidate(xhr, ajaxOptions, thrownError) {
	capaAnimacionCarga =document.getElementById("animacionCarga");
	capaAnimacionGuardando =document.getElementById("animacionGuardando");
	if (xhr.status == 400) {
		if(capaAnimacionCarga != null) {
			ocultaCarga();
		}
		if(capaAnimacionGuardando != null) {
			ocultaGuardando();
		}
		var doc = document.getElementById('MenssageErrorAjax');
		doc.innerHTML = '<div id="error"><ul id="ulError"><li><span id="textMessage" class="errorMessage">' 
			+ "La informaci&oacute;n enviada no es correcta. Por favor, contacte con el administrador." + '</span></li></ul></div>';
		return false;
	} 
}

function muestraDiv(id){
	if (document.getElementById){ //se obtiene el id
		var el = document.getElementById(id); //se define la variable "el" igual a nuestro div
		el.style.display = 'block'; //damos un atributo display:block que muestra el div
	}
}

function ocultaDiv(id){
	if (document.getElementById){ //se obtiene el id
		var el = document.getElementById(id); //se define la variable "el" igual a nuestro div
		el.style.display = 'none'; //damos un atributo display:none que oculta el div
	}
}

//----------------------------------------------------------------
//LIBRERÍA DE FUNCIONES JAVASCRIPT                             
//                                                           
//Funciones:                                                   
//campoObligatorio(strFormulario, strCampo, strNombreDesc)   
//----------------------------------------------------------------

//----------------------------------------------------------------
//Función: trim
//Argumentos:
//	- str: String
//
//Descripción
//Elimina los espacios en blanco de un objeto string.
//
//Nota de implementación:
//La función se ha construido como método de la clase String.
//----------------------------------------------------------------
String.prototype.trim = function() {
	a = this.replace(/^\s+/, '');
	return a.replace(/\s+$/, '');
};

//----------------------------------------------------------------
//Función: campoObligatorio
//Argumentos:
//	- strCampo: 'name' del campo de texto / combo, etc.
//	- strFormulario: Nombre del formulario que contiene ese campo.
//	- strNombreDesc: Nombre descriptivo del campo
//
//Descripción:
//	Verifica si un campo está vacio.
//----------------------------------------------------------------
function campoObligatorio(str, campo) {
if (str == null || str.trim() == "") {    
 return "El campo "+ campo + " es obligatorio.";
}
return "";
}

//----------------------------------------------------------------
//Función: imprimeError
//Argumentos:
//	- str: Cadena de error
//
//Descripción:
//	Imprime por pantalla el error en la capa destinada para ello.
//----------------------------------------------------------------
function imprimeError(str) {
	document.getElementById("ulError").innerHTML=str;
	document.getElementById("error").style.display = "block";
}

//----------------------------------------------------------------
//Función: cierraError
//
//Descripción:
//	Cierra la capa de error.
//----------------------------------------------------------------
function cierraError(){
	document.getElementById("error").style.display = "none";
}

//----------------------------------------------------------------
//Función: cierraMensaje
//
//Descripción:
//	Cierra la capa de mensajes.
//----------------------------------------------------------------
function cierraMensajes(){
	document.getElementById("mensajes").style.display = "none";
}

//----------------------------------------------------------------
//Función: ponerReadOnly
//
//Descripción:
//	Recorre el formulario activo deshabilitando las cajas de texto.
//----------------------------------------------------------------
function ponerReadOnly()
{
for(var i=0;i < document.forms.length; i++){
    for(var j=0;j < document.forms[i].elements.length;j++){  
      var formObj=document.forms[i].elements[j];
      if((formObj!=null && formObj.type!=null)  && 
         (formObj.type.toLowerCase()!= "hidden" && formObj.type.toLowerCase()!= "submit" &&
          formObj.className.substring(formObj.className.length - 8, formObj.className.length)!= "Readonly")){
          formObj.className = formObj.className+"Readonly";
          formObj.style.backgroundColor="LIGHTGREY";
          formObj.readOnly = true;
          formObj.disabled = true;
      }
    }
}
}


//----------------------------------------------------------------
//Función: cierraExcepcion
//
//Descripción:
//	Cierra la capa de excepciones.
//----------------------------------------------------------------
function cierraExcepcion(){
	document.getElementById("detalle-tecnico").style.display = "block";
	document.getElementById("error-tecnico").style.display = "none";
}


//----------------------------------------------------------------
//Función: muestraExcepcion
//
//Descripción:
//	Muestra la capa de excepciones.
//----------------------------------------------------------------
function muestraExcepcion(){
	document.getElementById("detalle-tecnico").style.display = "none";
	document.getElementById("error-tecnico").style.display = "block";
}

//----------------------------------------------------------------
//Función: muestraCarga
//
//Descripción:
//	Muestra el gif de cargando en peticiones Ajax dentro del Grid.
//----------------------------------------------------------------
function muestraCarga(){
    capaAnimacionCarga =document.getElementById("animacionCarga");
    capaAnimacionCarga.style.display = "";
}

//----------------------------------------------------------------
//Función: ocultaCarga
//
//Descripción:
//	Oculta el gif de cargando en peticiones Ajax dentro del Grid.
//----------------------------------------------------------------
function ocultaCarga(){
    capaAnimacionCarga =document.getElementById("animacionCarga");
    capaAnimacionCarga.style.display = "none";
}

// Variable para ocultar el gif de guardando.
var peticion = 0;
//----------------------------------------------------------------
//Función: muestraGuardando
//
//Descripción:
//	Muestra el gif de guardando en peticiones Ajax dentro del Grid,
//  Si se indica tiempo, se ejecuta como minimo ese tiempo o lo que dure la petición.
//  Si se envia vacio o 0 segundos se mostrará hasta que finalice la petición.
//   (Si la peticion es muy rapida, practicamente no se vera el icono)
//----------------------------------------------------------------
function muestraGuardando(segundos){
  capaAnimacionGuardando =document.getElementById("animacionGuardando");
  capaAnimacionGuardando.style.display = "";
  if (segundos != null && segundos != 0){
	  peticion = 1;
	  setTimeout("finTiempoGuardando();", segundos);
  }
}

//----------------------------------------------------------------
//Función: ocultaGuardando
//
//Descripción:
//	Oculta el gif de guardando en peticiones Ajax dentro del Grid.
//----------------------------------------------------------------
function ocultaGuardando(){
  capaAnimacionGuardando =document.getElementById("animacionGuardando");
  capaAnimacionGuardando.style.display = "none";
}

//----------------------------------------------------------------
//Función: finEjecucionGuardando
//
//Descripción:
//	Confirma que la peticiones ha terminado.
//----------------------------------------------------------------
function finEjecucionGuardando(){
  if (peticion == 0) {
	  ocultaGuardando();
  } else {
	  peticion = 0;
  }
}

//----------------------------------------------------------------
//Función: finTiempoGuardando
//
//Descripción:
//	Confirma que el tiempo ha terminado.
//----------------------------------------------------------------
function finTiempoGuardando(){
	if (peticion == 0) {
		  ocultaGuardando();
	} else {
		  peticion = 0;
	}
}

function validaFechaDDMMAAAA(fecha){
	var dtCh= "/";
	var minYear=1900;
	var maxYear=2100;
	function isInteger(s){
		var i;
		for (i = 0; i < s.length; i++){
			var c = s.charAt(i);
			if (((c < "0") || (c > "9"))) return false;
		}
		return true;
	}
	function stripCharsInBag(s, bag){
		var i;
		var returnString = "";
		for (i = 0; i < s.length; i++){
			var c = s.charAt(i);
			if (bag.indexOf(c) == -1) returnString += c;
		}
		return returnString;
	}
	function daysInFebruary (year){
		return (((year % 4 == 0) && ( (!(year % 100 == 0)) || (year % 400 == 0))) ? 29 : 28 );
	}
	function DaysArray(n) {
		for (var i = 1; i <= n; i++) {
			this[i] = 31;
			if (i==4 || i==6 || i==9 || i==11) {
				this[i] = 30;
			};
			if (i==2) {
				this[i] = 29;
			};
		}
		return this;
	}
	function isDate(dtStr){
		var daysInMonth = DaysArray(12);
		var pos1=dtStr.indexOf(dtCh);
		var pos2=dtStr.indexOf(dtCh,pos1+1);
		var strDay=dtStr.substring(0,pos1);
		var strMonth=dtStr.substring(pos1+1,pos2);
		var strYear=dtStr.substring(pos2+1);
		strYr=strYear;
		if (strDay.charAt(0)=="0" && strDay.length>1) strDay=strDay.substring(1);
		if (strMonth.charAt(0)=="0" && strMonth.length>1) strMonth=strMonth.substring(1);
		for (var i = 1; i <= 3; i++) {
			if (strYr.charAt(0)=="0" && strYr.length>1) strYr=strYr.substring(1);
		}
		month=parseInt(strMonth);
		day=parseInt(strDay);
		year=parseInt(strYr);
		if (pos1==-1 || pos2==-1){
			return false;
		}
		if (strMonth.length<1 || month<1 || month>12){
			return false;
		}
		if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month]){
			return false;
		}
		if (strYear.length != 4 || year==0 || year<minYear || year>maxYear){
			return false;
		}
		if (dtStr.indexOf(dtCh,pos2+1)!=-1 || isInteger(stripCharsInBag(dtStr, dtCh))==false){
			return false;
		}
		return true;
	}
	if(isDate(fecha)){
		return true;
	}else{
		return false;
	}
}
