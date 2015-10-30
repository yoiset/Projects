//Utility functions to facilitate use of dhtmlXGridObject
function Listgrid(parentId) {
	
	this.parentId = parentId;
	
	this.cols = [];
	
	this.addCol = function(args) {
		var header = grid_getArg(args, "header", "No header");
		var width = grid_getArg(args, "width", 50);
		var align = grid_getArg(args, "align", "left");
		var sorting = grid_getArg(args, "sorting", "str");
		this.cols[this.cols.length] = new ListgridCol(header, width, align, sorting);
	};

	this.createGrid = function() {

		var grid = new dhtmlXGridObject(this.parentId);
		var strHeaders = "";
		var strWidths = "";
		var strAligns = "";
		var strSortings = "";		
		for ( var i = 0; i < this.cols.length; i++) {
			var sep = (i>0) ? "," : "";
			strHeaders += sep + this.cols[i].header;
			strWidths += sep + this.cols[i].width;
			strAligns += sep + this.cols[i].align;
			strSortings += sep + this.cols[i].sorting;
		}
		
		grid.setHeader(strHeaders);
		grid.setInitWidths(strWidths);
		grid.setColAlign(strAligns);
		grid.setColSorting(strSortings);
		
		return grid;
	};
}

function grid_getArg(args, name, defaultValue) {
	return (args[name]) ? args[name] : defaultValue;
}

function ListgridCol(header, width, align, sorting) {
	this.header = header;
	this.width = width;
	this.align = align;
	this.sorting = sorting;
	
}

//Agrega a la grilla grid con el id las filas de valores
function addPaginatedGridRows(grid, paginator, totalValues, emptyMessage) {
	//Use attributes of GridBean and GridRowBean
	var gridBean = JSON.parse(totalValues);
	var totalResults = gridBean["totalResults"];
	
	if (totalResults > 0) {
		paginator.setTotalResults(totalResults);
	} else {
		paginator.reset();
	}
	
	var rows = gridBean["rows"];
	doAddGridRows(grid, rows, emptyMessage);
	if (paginator.sortingFlag) {
		grid.setSortImgState(true, paginator.fieldColum, paginator.order);
	}
}

//Agrega a la grilla grid con el id las filas de valores
function addGridRows(grid, values, emptyMessage) {

	//Use attributes of GridBean and GridRowBean
	var gridBean = JSON.parse(values);
	var rows = gridBean["rows"];
	doAddGridRows(grid, rows, emptyMessage);
}

function doAddGridRows(grid, rows, emptyMessage) {
	
	grid.clearAll();
	
	if (rows.length > 0) {
		for(var j=0; j<rows.length; j++) {
			var id = rows[j]["id"];
			var fields = rows[j]["cells"];
			if (j < rows.length - 1) {
				grid._addRow(id, fields, grid.getRowsNum()); //First parameter is ID. Don't repaint.
			} else {
				grid.addRow(id, fields, grid.getRowsNum()); //First parameter is ID. It's the last row, and then repaints.
			}
		}
	} else {
		// Si se va a crear un grid sin filas, se crea una fila vacia con ID "" para identificar en la jsp.
		grid.addRow("", "", grid.getRowsNum());
		if (emptyMessage != null) {
			alert(emptyMessage); 
		}
	}
}

		