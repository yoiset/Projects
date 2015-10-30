function validaFechaParametro(fechaParametro){
	if (fechaParametro.length!=8){
		return false;
	}
	var dia = fechaParametro.substring(0, 2);
	var mes = fechaParametro.substring(2, 4);
	var ano = fechaParametro.substring(4);
	var fecha = dia + '/' + mes + '/' + ano;

	if (!validaFechaDDMMAAAA(fecha)){
		return false;
	}
	
	return true;
}

function validaFechaYHora(fechahora){
	if (!validaFechaDDMMAAAA(fechahora.substring(0, 10))){
		return false;
	}
	if (!validaHoraHHMM(fechahora.substring(11,16))){
		return false;
	}
	return true;
}

function validaHoraHHMM(hora) {
    var arrHora = hora.split(":");
    if (arrHora.length!=2) {
        return false;
    }

    if (parseInt(arrHora[0])<0 || parseInt(arrHora[0])>23) {
        return false;
    }

    if (parseInt(arrHora[1])<0 || parseInt(arrHora[1])>59) {
        return false;
    }

    return true;
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

function validaFecha1900(fecha){
	var dtCh= "/";
	var minYear=1900;
	var maxYear=2100;

	function isDate(dtStr){
		var pos1=dtStr.indexOf(dtCh);
		var pos2=dtStr.indexOf(dtCh,pos1+1);
		var strYear=dtStr.substring(pos2+1);
		strYr=strYear;
		for (var i = 1; i <= 3; i++) {
			if (strYr.charAt(0)=="0" && strYr.length>1) strYr=strYr.substring(1);
		}
		year=parseInt(strYr);

		if (strYear.length != 4 || year==0 || year<minYear || year>maxYear){
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

//Retorna: 1 = NIF ok, 2 = NIE ok, -1 = NIF error, -2 = NIE error, 0 = ??? error
function validaDNI( a )
{
	var temp = a.toUpperCase();
	var cadenadni = "TRWAGMYFPDXBNJZSQVHLCKE";
 
	if( temp!= '' )
	{
		//si no tiene un formato valido devuelve error
		if( ( !/^[A-Z]{1}[0-9]{7}[A-Z0-9]{1}$/.test( temp ) && !/^[T]{1}[A-Z0-9]{8}$/.test( temp ) ) && !/^[0-9]{8}[A-Z]{1}$/.test( temp ) )
		{
			return 0;
		}
 
		//comprobacion de NIFs estandar
		if( /^[0-9]{8}[A-Z]{1}$/.test( temp ) )
		{
			posicion = a.substring( 8,0 ) % 23;
			letra = cadenadni.charAt( posicion );
			var letradni = temp.charAt( 8 );
			if( letra == letradni )
			{
				return 1;
			}
			else
			{
				return -1;
			}
		}
 
 		//comprobacion de NIEs
		if( /^[XYZ]{1}/.test( temp ) )
		{
			temp = temp.replace( 'X','0' );
			temp = temp.replace( 'Y','1' );
			temp = temp.replace( 'Z','2' );
			pos = temp.substring(0, 8) % 23;
 
			if( a.toUpperCase().charAt( 8 ) == cadenadni.substring( pos, pos + 1 ) )
			{
				return 2;
			}
			else
			{
				return -2;
			}
		}
	}
 
	return 0;
}

function validaEntero(numero) {
	if (numero==""){
		return true;
	}
	if (!/^([0-9])*$/.test(numero)) {
        return false;
    }
    return true;
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


//----------------------------------------------------------------
//Función: limpiaFormulario
//
//Descripción:
//	Vacía los campos del formulario pasado por parametro.
//----------------------------------------------------------------
function limpiaFormulario(ele) {

  $(ele).find(':input').each(function() {
      switch(this.type) {
          case 'password':
          case 'select-multiple':
          case 'select-one':
          case 'text':
          case 'textarea':
              $(this).val('');
              break;
          case 'checkbox':
          case 'radio':
              this.checked = false;
      }
  });

}
