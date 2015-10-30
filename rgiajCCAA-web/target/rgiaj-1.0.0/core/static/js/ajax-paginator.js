// Paginador para AJAX
// Created by FMG
// ago-2010

function Paginator(id, args) {

	this.parentId = id; // id del elemento HTML que lo contiene

	//Variable javascript del objeto paginador
	this.varName = pag_getArg(args, "varName", "paginator"); 
	
	this.imgPath = pag_getArg(args, "imgPath", "../../static/images");

	this.labelFirst = pag_getArg(args, "labelFirst", "first");
	this.labelPrevious = pag_getArg(args, "labelPrevious", "previous");
	this.labelNext = pag_getArg(args, "labelNext", "next");
	this.labelLast = pag_getArg(args, "labelLast", "last");
	
	this.firstResult = 0; // Posicion inicial de la busqueda
	this.maxResults = Number(pag_getArg(args, "maxResults", 20)); // Tamano de
															// la pagina
	this.sortingFlag=pag_getArg(args, "sortingFlag", false);  // Bandera de ordenacion - false por defecto.
	this.fieldName=pag_getArg(args, "fieldName", "");  // Nombre del campo a ordenar	
	this.order=pag_getArg(args, "order", "asc");   // Tipo de ordenacion
	this.fieldColum=Number(pag_getArg(args, "fiedlCol", 0));   // Tipo de ordenacion
	
	this.useTotals = pag_getArg(args, "useTotals", true); // Si utiliza
																// totales o
															// incremento

	this.currentPage = 1; // Pagina actual de busqueda

	this.totalResults = -1; // Numero total de registros de la busqueda
	this.totalPages = -1; // Numero total de paginas de la busqueda
	this.pageResults = -1; // Numero de resultados por pagina

	this.hasNext = false; // Indica si hay mas paginas en la busqueda, cuando
							// no se usan totales

//	this.form = pag_getArg(args, "form", null);

	// Agrega en runtime los campos de paginacion al formulario, si este es
	// especificado
//	if (this.form) {
//		this.form.innerHTML += '<input type="hidden" name="firstResult" value="' + this.firstResult + '" />' +
//		                       '<input type="hidden" name="maxResults" value="' + this.maxResults + '" />';
//	}

	this.redraw = function() {
		document.getElementById(this.parentId).innerHTML = this.toHtml();
	};

	this.toHtml = function() {
		var text = '<div class="mod_pagination"><ul> \n'
		+ '<li class="nav_first"><div class="button_bl"><div class="button_br"><div class="button_bk">'
		+ '<a id="_idPaginatorFirst_' + this.varName + '" onclick="' + this.varName + '.doChange(this, \'first\')">' + this.labelFirst + '</a></div></div></div></li> \n'
		+ '<li class="nav_ant"><div class="button_bl"><div class="button_br"><div class="button_bk">'
		+ '<a id="_idPaginatorPrev_' + this.varName + '" onclick="' + this.varName + '.doChange(this, \'prev\')">' + this.labelPrevious + '</a></div></div></div></li> \n'
		+ '<li class="nav_info"><div class="button_bl"><div class="button_br"><div class="button_bk">'
		+ '<input type="text" id="_idPaginatorInfoCurrentPage_' + this.varName + '" style="width:35px;text-align:center;background-color:transparent" readonly="readonly"';
		if (this.totalPages >= 0) {
			text += ' value="' + this.currentPage + '"';
		}
		text += '> \n';
		if (this.useTotals) {
			text += '/'
				+ '<input type="text" id="_idPaginatorInfoTotalPages_' + this.varName + '" style="width:35px;text-align:center;background-color:transparent" readonly="readonly"';
			if (this.totalPages >= 0) {
				text += ' value="' + this.totalPages + '"';
			}
			text += '></div></div></div></li> \n';
		}
		text += '<li class="nav_sig"><div class="button_bl"><div class="button_br"><div class="button_bk">'
			+ '<a id="_idPaginatorNext_' + this.varName + '" onclick="' + this.varName + '.doChange(this, \'next\')">' + this.labelNext + '</a></div></div></div></li> \n';

		if (this.useTotals) {
			text += '<li class="nav_last"><div class="button_bl"><div class="button_br"><div class="button_bk">'
				+ '<a id="_idPaginatorLast_' + this.varName + '" onclick="' + this.varName + '.doChange(this, \'last\')">' + this.labelLast + '</a></div></div></div></li> \n';
		}
		text += '</ul></div> \n';

		return text;
	};

	// Detecta el objeto paginator en el que está contenido el botón
	this.doChange=function(p_button, p_option) {
	  
	  eval("var p = " + this.varName);

	  p.updatePages();
	  if (p.totalResults >= 0 || !p.useTotals) {
		  if (p_option == "first") {
		  	p.doFirst();
		  } else if (p_option == "prev") {
		  	p.doPrev();
		  } else if (p_option == "next") {
		  	p.doNext();
		  } else if (p.useTotals && p_option == "last") {
		  	p.doLast();
		  }
	  }
	  
	  p.enableButtons();
	  
	  // Colocando valores en los campos del formulario
//	  p.form.firstResult.value = p.firstResult;
//	  p.form.maxResults.value = p.maxResults;
	  
	  //TODO: ejecutar onchange sólo si hay cambio de página
	  p.onchange();
	  p.updateInfo();
	  
	};

	this.doFirst=function(){
	  this.firstResult=0;
	};

	this.doPrev=function(){
	  this.firstResult = Math.max(this.firstResult - this.maxResults, 0);
	};

	this.doNext=function(){
	  if (this.useTotals) {
		  if (this.firstResult + this.maxResults < this.totalResults) {
			  this.firstResult = this.firstResult + this.maxResults;
		  }
	  } else {
	    this.firstResult += this.maxResults;
	  }
	};

	this.doLast=function(){
	  if (this.useTotals) {
		  this.firstResult = (this.totalPages-1)*this.maxResults;
	  }
	};

	this.enableButtons=function(){
	  var isFirstPage = (this.totalResults == 0 || this.firstResult == 0);
	  var isLastPage = (this.useTotals) ? 
	                        (this.totalResults == 0 || this.firstResult == (this.totalPages-1)*this.maxResults) :
	                        !this.hasNext;
	  document.getElementById("_idPaginatorFirst_" + this.varName).disabled = isFirstPage;
	  document.getElementById("_idPaginatorPrev_" + this.varName).disabled = isFirstPage;
	  document.getElementById("_idPaginatorNext_" + this.varName).disabled = isLastPage;
	  if (this.useTotals) {
		  document.getElementById("_idPaginatorLast_" + this.varName).disabled = isLastPage;
	  }
	};

	// Recalcula el número de páginas en función del registro inicial y el número
	// total de registros
	this.updatePages=function() {

	  this.currentPage = Math.floor(this.firstResult / this.maxResults) + 1;

	  if (this.totalResults >= 0) {
		  
		  // Sólo se puede calcular el número de páginas después de la primera búsqueda
		  this.totalPages = Math.floor((this.totalResults - 1) / this.maxResults) + 1;
	  }

	};

	this.setTotalResults=function(p_totalResults) {
		this.totalResults = p_totalResults;
		this.updatePages();
		this.updateInfo();
		this.enableButtons();
	};
	
	this.setSorting=function(name,ordertype,colum) {
		this.fieldName=name;
		this.order=ordertype;
		this.fieldColum=colum;
	};
	
	this.setPageResults=function(p_pageResults) {
		this.pageResults = p_pageResults;
	};
	
	this.getPageResults=function() {
		return this.pageResults;
	};

	// En el caso que no se utilice número total de páginas, se le indica al control que existen más registros
	this.setHasNext=function(p_hasNext) {
		this.hasNext = p_hasNext;
		this.updatePages();
		this.updateInfo();
		this.enableButtons();
	};

	this.updateInfo=function() {
		document.getElementById("_idPaginatorInfoCurrentPage_" + this.varName).value = this.currentPage;
		if (this.useTotals) {
			document.getElementById("_idPaginatorInfoTotalPages_" + this.varName).value = this.totalPages;
		}
	};
	
	this.queryString=function() {
		return "firstResult=" + this.firstResult + "&maxResults=" + this.maxResults;
	};
	
	this.reset=function() {
		this.totalResults=-1; 
	  	this.currentPage=1;
		this.totalPages=-1;
		this.firstResult=0;
		this.hasNext=false;
//		this.form.firstResult.value = this.firstResult;
		this.resetInfo();
	};
	
	this.redraw();

	this.onchange = function() {
	};
	
	this.resetInfo=function() {
		document.getElementById("_idPaginatorInfoCurrentPage_" + this.varName).value = "";
		document.getElementById("_idPaginatorInfoTotalPages_" + this.varName).value = "";
	};

}

function pag_getArg(args, name, defaultValue) {
	return (args[name]) ? args[name] : defaultValue;
}
